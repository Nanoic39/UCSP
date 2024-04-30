package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.service.PostService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PostController {
    @Resource
    PostService postService;

    //发帖
    @AuthAccess
    @PostMapping("/postinsert")
    public Result insert(@RequestParam Post postContent) {//正文，标题，图片
        try {
            if (postContent.getTitle() != null && postContent.getAuthor_id() != null) {

                postService.inserPost(postContent);

                return Result.success("发帖成功");
            }
            return Result.error("发帖失败");
        } catch (Exception e) {
            return Result.error("服务器内部错误");
        }
    }

    //删帖
    @AuthAccess
    @PostMapping("/postdelete")
    public Result delete(Integer id) {//帖子ID
        try {
            if (id != null) {
                Post post = new Post();
                post.setId(id);
                postService.delete(post);
                return Result.success("删帖成功");
            }
            return Result.error("删帖失败");
        } catch (Exception e) {
            return Result.error("服务器内部错误");
        }
    }

    @AuthAccess
    @PostMapping("/postupdate") //正文，标题，图片，帖子Id
    public Result update(String  title,String intro,String content,String post_cover,Integer id){
        try {
            if (title!=null&&content!=null&&id!=null){
                Post post =new Post();
                post.setTitle(title);
                post.setIntro(intro);
                post.setContent(content);
                post.setPost_cover(post_cover);

                post.setId(id);

                postService.update(post);

                return Result.success("更新帖成功");
            }
            return Result.error("更新帖失败");
        } catch (Exception e) {
            return Result.error("服务器内部错误");
        }
    }
}
