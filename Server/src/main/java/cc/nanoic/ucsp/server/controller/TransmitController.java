package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Transmit;
import cc.nanoic.ucsp.server.entity.entityRequest.Post_home;
import cc.nanoic.ucsp.server.entity.entityRequest.Transmit_post;
import cc.nanoic.ucsp.server.service.TransmitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TransmitController {
    /**
     * 帖子类型
     * share_post
     * study_post
     * post
     * */

    @Resource
    TransmitService TransmitService;
    //请求最新帖子输出（1次10条，传入请求次数，首次为0）
    // 传入:帖子类型 和 次数
    @AuthAccess
    @PostMapping("/transmit/time")
    public Result transmit_time(@RequestBody Transmit transmit){
        String type=transmit.getType();
        Integer number=transmit.getNum();
        try {
            if (type!=null&&number!=null) {
                return Result.success(TransmitService.get_post(type,number));
            }
            return Result.error("数据不全");
        } catch (Exception e) {
            return Result.error("服务器错误");
        }
    }

    //学习区,分享区按类型输出帖子
    // 传入:帖子类型 , 次数,科目
    @AuthAccess
    @PostMapping("/transmit/type")
    public Result transmit_type(@RequestBody Transmit transmit){
        String type=transmit.getType();
        Integer number=transmit.getNum();
        String subjects=transmit.getSubjects();
        try {
            if (type!=null&&number!=null) {
                ArrayList<Post_home> array= TransmitService.type(type, number,subjects);
                if (array.size()==0){
                    return Result.error("数据为空");
                }
                return Result.success(array);
            }
            return Result.error("数据不全");
        } catch (Exception e) {
            return Result.error("服务器内部错误");
        }
    }

    //请求一个帖子
    @AuthAccess
    @PostMapping("/post/get")
    public Result post_get(@RequestBody Transmit_post transmit){
        String type=transmit.getType();
        Integer id=transmit.getPost_id();
        try {
            if (type!=null&&id!=null) {
                return Result.success(TransmitService.post_select(type, id));
            }
            return Result.error("数据不全");
        } catch (Exception e) {

            return Result.error("服务器错误");
        }
    }

}
