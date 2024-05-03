package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.entity.Post_Study;
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
    public Result postInsert(
            String title,
            Integer author_id,
            String intro,
            String content,
            Integer status,
            String post_cover,
            Integer auth,
            Date create_time,
            Date update_time,
            Integer like_num,
            Integer comment_num,
            Integer collection_num) {
        try {
            if (title != null && content != null && author_id != null) {
                create_time = new Date();
                Post postContent = new Post();
                postContent.setTitle(title);
                postContent.setAuthor_id(author_id);
                postContent.setIntro(intro);
                postContent.setContent(content);
                postContent.setStatus(status);
                postContent.setPost_cover(post_cover);
                postContent.setAuth(auth);
                postContent.setCreate_time(create_time);
                postContent.setUpdate_time(update_time);
                postContent.setLike_num(like_num);
                postContent.setComment_num(comment_num);
                postContent.setCollection_num(collection_num);

                postService.insertPost(postContent);
                return Result.success("发帖成功");
            }
            return Result.error("发帖失败");
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
            return Result.error("服务器内部错误");
        }
    }

    //学习区发帖
    @AuthAccess
    @PostMapping("/study/postinsert")
    public Result insert(@RequestParam("postContent") Post_Study postContent) {
        try {
            if (postContent.getTitle() != null && postContent.getAuthor_id() != null) {

                postService.insertPost_study(postContent);
                return Result.success("发帖成功");
            }
            return Result.error("发帖失败");
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    @AuthAccess//更新帖
    @PostMapping("/postupdate") //正文，标题，图片，帖子Id
    public Result update(String title, String intro, String content, String post_cover, Integer id) {
        try {
            if (title != null && content != null && id != null) {
                Post post = new Post();

                post.setTitle(title);
                post.setIntro(intro);
                post.setContent(content);
                post.setPost_cover(post_cover);
                post.setId(id);

                //通过util下的Date包实现
                Date date = new Date();
                post.setUpdate_time(date);
                postService.update(post);

                return Result.success("更新帖成功");
            }
            return Result.error("更新帖失败");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("服务器内部错误");
        }
    }
}
