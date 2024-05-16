package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.service.TransmitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Result transmit_time(@RequestParam("type") String type,
                                @RequestParam("number") Integer number){
        try {
            if (type!=null&&number!=null) {
                return Result.success(TransmitService.time(type, number));
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
    public Result transmit_type(@RequestParam("type") String type,
                                @RequestParam("number") Integer number,
                                @RequestParam("subjects") String subjects){
        try {
            if (type!=null&&number!=null) {
                return Result.success(TransmitService.type(type, number,subjects));
            }
            return Result.error("数据不全");
        } catch (Exception e) {
            return Result.error("服务器错误");
        }
    }

}
