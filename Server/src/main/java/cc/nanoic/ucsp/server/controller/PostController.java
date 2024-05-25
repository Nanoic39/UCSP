package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.entity.Post_Study;
import cc.nanoic.ucsp.server.entity.entityRequest.ReqUser_Id;
import cc.nanoic.ucsp.server.service.PostService;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     * @param: title
     * @param: content
     * @param: author_id
     */
    @AuthAccess
    @PostMapping("/postinsert")
    public Result postInsert(@RequestBody Post post) {
        String title = post.getTitle();//标题
        String content = post.getContent();//内容
        Integer author_id = TokenUtils.getCurrentUser().getId();//作者ID
        String intro = post.getIntro();//摘要
        String post_cover = post.getPost_cover();//封面

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
    public Result studyInsert(@RequestBody Post_Study post) {
        String title = post.getTitle();//主题
        String content = post.getContent();//内容
        Integer author_id = TokenUtils.getCurrentUser().getId();//作者ID
        String intro = post.getIntro();//摘要
        String post_cover = post.getPost_cover();//封面
        String tag = post.getTag();//标签
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
    public Result shareInsert(@RequestBody Post_Study post) {
        String title = post.getTitle();//主题
        String content = post.getContent();//内容
        Integer author_id = TokenUtils.getCurrentUser().getId();//作者ID
        String intro = post.getIntro();//摘要
        String post_cover = post.getPost_cover();//封面
        String tag = post.getTag();//标签

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
    public Result delete(@RequestBody ReqUser_Id user) {
        Integer id = user.getId();//帖子ID
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
    public Result studyDelete(@RequestBody ReqUser_Id user) {
        Integer id = user.getId();//帖子ID
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
    public Result shareDelete(@RequestBody ReqUser_Id user) {
        Integer id = user.getId();//帖子ID
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
    public Result update(@RequestBody Post post_0) {
        Integer id = post_0.getId();
        String title = post_0.getTitle();//主题
        String content = post_0.getContent();//内容
        String intro = post_0.getIntro();//摘要
        String post_cover = post_0.getPost_cover();//封面
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
    public Result update(@RequestBody Post_Study post_study) {
        Integer id = post_study.getId();
        String title = post_study.getTitle();//主题
        String content = post_study.getContent();//内容
        String intro = post_study.getIntro();//摘要
        String post_cover = post_study.getPost_cover();//封面
        String tag = post_study.getTag();//标签
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
    public Result shareUpdate(@RequestBody Post_Study post_study) {
        Integer id = post_study.getId();
        String title = post_study.getTitle();//主题
        String content = post_study.getContent();//内容
        String intro = post_study.getIntro();//摘要
        String post_cover = post_study.getPost_cover();//封面
        String tag = post_study.getTag();//标签
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
