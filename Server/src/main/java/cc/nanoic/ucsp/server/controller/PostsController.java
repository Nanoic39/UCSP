package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Posts;
import cc.nanoic.ucsp.server.service.PostsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {
    @Resource
    PostsService postsService;

    //发帖
    @AuthAccess
    @PostMapping("/postsinsert")
    public Result insert(String posts_content, String posts_title, Byte posts_image){//正文，标题，图片
        try {
            if (posts_content!=null&&posts_title!=null){
                Posts posts=new Posts();

                posts.setPosts_content(posts_content);
                posts.setPosts_title(posts_title);
                posts.setPosts_image(posts_image);

                postsService.inserPosts(posts);
                return Result.success("发帖成功");
            }
            return Result.error("发帖失败");
        } catch (Exception e) {
            return Result.error("服务器内部错误");
        }
    }

    //删帖
    @AuthAccess
    @PostMapping("/postsdelete")
    public Result delete(Integer posts_id){//帖子ID
        try {
            if (posts_id!=null){
                Posts posts=new Posts();
                posts.setPosts_id(posts_id);
                postsService.delete(posts);
                return Result.success("删帖成功");
            }
            return Result.error("删帖失败");
        } catch (Exception e) {
            return Result.error("服务器内部错误");
        }
    }

    @AuthAccess
    @PostMapping("/postsupdate") //正文，标题，图片，帖子Id
    public Result update(String  posts_content,String posts_title,Byte posts_image,Integer posts_id){
        try {
            if (posts_id!=null&&posts_content!=null&&posts_title!=null){
                Posts posts=new Posts();

                posts.setPosts_id(posts_id);
                posts.setPosts_content(posts_content);
                posts.setPosts_title(posts_title);
                posts.setPosts_image(posts_image);

                postsService.update(posts);

                return Result.success("更新帖成功");
            }
            return Result.error("更新帖失败");
        } catch (Exception e) {
            return Result.error("服务器内部错误");
        }
    }
    }
