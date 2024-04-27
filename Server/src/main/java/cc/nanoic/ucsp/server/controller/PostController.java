package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.service.PostService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PostController {
    @Resource
    PostService postService;

    //发帖
    @AuthAccess
    @PostMapping("/postinsert")
    public Result insert(String title, Integer author_id, String intro, String content, String post_cover, Date create_time,Date update_time,Integer like_num){//正文，标题，图片
        try {
            if (title!=null&&author_id!=null&&content!=null&&create_time!=null){
                Post post =new Post();

                post.setTitle(title);
                post.setAuthor_id(author_id);
                post.setIntro(intro);
                post.setContent(content);
                post.setPost_cover(post_cover);
                post.setCreate_time(create_time);
                post.setUpdate_time(update_time);
                post.setLike_num(like_num);

                postService.inserPost(post);
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
    public Result delete(Integer id){//帖子ID
        try {
            if (id!=null){
                Post post =new Post();
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
    public Result update(String  title,String intro,String content,String post_cover,Date update_time,Integer id){
        try {
            if (title!=null&&content!=null&&update_time!=null&&id!=null){
                Post post =new Post();

                post.setTitle(title);
                post.setIntro(intro);
                post.setContent(content);
                post.setPost_cover(post_cover);
                post.setUpdate_time(update_time);
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
