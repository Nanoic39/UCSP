package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Comments_get;
import cc.nanoic.ucsp.server.entity.entityRequest.Comments;
import cc.nanoic.ucsp.server.entity.entityRequest.Num;
import cc.nanoic.ucsp.server.entity.entityRequest.Post_id;
import cc.nanoic.ucsp.server.entity.entityRequest.Reply;
import cc.nanoic.ucsp.server.service.CommentsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @FileName CommentsController
 * @Description
 * @Author fazhu
 * @date 2024-05-24
 **/
@RestController
public class CommentsController {

    @Resource
    CommentsService commentsService;

    //增加评论
    @AuthAccess
    @PostMapping("/post/comments/insert")
    public Result post_comments_insert(@RequestBody Comments comments){
        try {
            commentsService.post_comments_insert(comments);
            return  Result.success("成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


      //扩展回复
    @AuthAccess
    @PostMapping("/post/reply/post")
    public Result post_reply_post(@RequestBody Post_id id){
        ArrayList<Reply> reply= commentsService.post_reply_get(id.getPost_id(),id.getNum());
//            if (reply.size()!=5){
//                return  Result.success("数据不足",reply);
//            }
        return Result.success(reply);
    };

    //请求评论输出
    @AuthAccess
    @PostMapping("/post/comments/get")
    public Result post_comments_get(@RequestBody Post_id id){
        ArrayList<Comments_get> reply=commentsService.post_comments_get(id.getPost_id(),id.getNum());
//        if(id.getNum()==0){
//            if (reply.size()<2){
//                return  Result.success("数据不足",reply);
//            }
//        }else{
//            if (reply.size()<5){
//                return  Result.success("数据不足",reply);
//            }
//        }
        return Result.success(reply);
    }
}
