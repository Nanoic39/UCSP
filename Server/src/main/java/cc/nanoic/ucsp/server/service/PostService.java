package cc.nanoic.ucsp.server.service;


import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostMapper PostMapper;

    public void inserPost(Post post) {//增加帖子
        PostMapper.insertPost(post.getTitle(),//文章标题
                post.getAuthor_id(),//作者ID
                post.getIntro(),//摘要
                post.getContent(),//文章正文
                post.getPost_cover());//文章封面
    }

    public void delete(Post post) {//删除帖子

        PostMapper.deletePost(post.getId());
    }

    public void update(Post post) {//更新帖子
        PostMapper.updatePost(post.getTitle(), post.getIntro(), post.getContent(), post.getPost_cover(),post.getId());
    }


}
