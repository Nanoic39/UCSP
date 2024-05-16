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

/**
 * @FileName PostController
 * @Description 签到
 * @Author fazhu
 * @date 2024-04-20
 **/
@RestController
public class PostController {
    @Resource
    PostService postService;

    /**
     * 发帖
     *
     * @param title
     * @param content
     * @param author_id
     */
    @AuthAccess
    @PostMapping("/postinsert")
    public Result postInsert(@RequestParam("title") String title,//主题
                             @RequestParam("content") String content,//内容
                             @RequestParam("author_id") Integer author_id,//作者ID
                             @RequestParam("intro") String intro,//摘要
                             @RequestParam("post_cover") String post_cover//封面
    ) {
        try {
            if (title != null && content != null && author_id != null) {

                Post postContent = new Post();
                postContent.setTitle(title);
                postContent.setAuthor_id(author_id);
                postContent.setIntro(intro);
                postContent.setContent(content);
                postContent.setPost_cover(post_cover);

                Date date = new Date();
                postContent.setCreate_time(date);
                postContent.setUpdate_time(date);

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
    public Result studyInsert(@RequestParam("title") String title,//主题
                              @RequestParam("content") String content,//内容
                              @RequestParam("author_id") Integer author_id,//作者ID
                              @RequestParam("intro") String intro,//摘要
                              @RequestParam("post_cover") String post_cover,//封面
                              @RequestParam("tag") String tag//标签

    ) {
        try {
            if (title != null && content != null && author_id != null) {
                Post_Study postContent = new Post_Study();
                postContent.setTitle(title);
                postContent.setAuthor_id(author_id);
                postContent.setIntro(intro);
                postContent.setContent(content);
                postContent.setPost_cover(post_cover);
                postContent.setTag(tag);

                Date date = new Date();
                postContent.setCreate_time(date);
                postContent.setUpdate_time(date);

                postService.insertPost_study(postContent);
                return Result.success("发帖成功");
            }
            return Result.error("发帖失败");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("服务器内部错误");
        }
    }

    //分享区发帖
    @AuthAccess
    @PostMapping("/share/postinsert")
    public Result shareInsert(@RequestParam("title") String title,//主题
                              @RequestParam("content") String content,//内容
                              @RequestParam("author_id") Integer author_id,//作者ID
                              @RequestParam("intro") String intro,//摘要
                              @RequestParam("post_cover") String post_cover,//封面
                              @RequestParam("tag") String tag//标签
    ) {
        try {
            if (title != null && content != null && author_id != null) {
                Post_Study postContent = new Post_Study();
                postContent.setTitle(title);
                postContent.setAuthor_id(author_id);
                postContent.setIntro(intro);
                postContent.setContent(content);
                postContent.setPost_cover(post_cover);
                postContent.setTag(tag);

                Date date = new Date();
                postContent.setCreate_time(date);
                postContent.setUpdate_time(date);
                System.out.println(postContent);

                postService.insertPost_share(postContent);

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
    public Result delete(@RequestParam("id") Integer id) {//帖子ID
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

    //删学习帖
    @AuthAccess
    @PostMapping("/study/postdelete")
    public Result studyDelete(@RequestParam("id") Integer id) {//帖子ID
        try {
            if (id != null) {
                Post post = new Post();
                post.setId(id);
                postService.studyDelete(post);
                return Result.success("删帖成功");
            }
            return Result.error("删帖失败");
        } catch (Exception e) {
            return Result.error("服务器内部错误");
        }
    }

    //删分享帖
    @AuthAccess
    @PostMapping("/share/postdelete")
    public Result shareDelete(@RequestParam("id") Integer id) {//帖子ID
        try {
            if (id != null) {
                Post post = new Post();
                post.setId(id);
                postService.shareDelete(post);
                return Result.success("删帖成功");
            }
            return Result.error("删帖失败");
        } catch (Exception e) {
            return Result.error("服务器内部错误");
        }
    }

    @AuthAccess//更新帖
    @PostMapping("/postupdate") //正文，标题，图片，帖子Id
    public Result update(@RequestParam("id") Integer id,//文章id
                         @RequestParam("title") String title,//主题
                         @RequestParam("content") String content,//内容
                         @RequestParam("intro") String intro,//摘要
                         @RequestParam("post_cover") String post_cover//封面
    ) {
        try {
            if (title != null && content != null && id != null) {
                Post post = new Post();
                System.out.println(post);

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

    @AuthAccess//更新学习帖
    @PostMapping("/study/postupdate") //正文，标题，图片，帖子Id
    public Result update(@RequestParam("id") Integer id,//文章id
                         @RequestParam("title") String title,//主题
                         @RequestParam("content") String content,//内容
                         @RequestParam("intro") String intro,//摘要
                         @RequestParam("post_cover") String post_cover,//封面
                         @RequestParam("tag") String tag//标签
    ) {
        try {
            if (title != null && content != null && id != null) {
                Post_Study post = new Post_Study();

                post.setTitle(title);
                post.setIntro(intro);
                post.setContent(content);
                post.setPost_cover(post_cover);
                post.setId(id);
                post.setTag(tag);

                //通过util下的Date包实现
                Date date = new Date();
                post.setUpdate_time(date);
                postService.updatePost_study(post);

                return Result.success("更新帖成功");
            }
            return Result.error("更新帖失败");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("服务器内部错误");
        }
    }

    @AuthAccess//更新分享帖
    @PostMapping("/share/postupdate") //正文，标题，图片，帖子Id
    public Result shareUpdate(@RequestParam("id") Integer id,//文章id
                              @RequestParam("title") String title,//主题
                              @RequestParam("content") String content,//内容
                              @RequestParam("intro") String intro,//摘要
                              @RequestParam("post_cover") String post_cover,//封面
                              @RequestParam("tag") String tag//标签
    ) {
        try {
            if (title != null && content != null && id != null) {
                Post_Study post = new Post_Study();

                post.setTitle(title);
                post.setIntro(intro);
                post.setContent(content);
                post.setPost_cover(post_cover);
                post.setId(id);
                post.setTag(tag);
                //通过util下的Date包实现
                Date date = new Date();
                post.setUpdate_time(date);
                postService.updatePost_share(post);

                return Result.success("更新帖成功");
            }
            return Result.error("更新帖失败");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("服务器内部错误");
        }
    }
}
