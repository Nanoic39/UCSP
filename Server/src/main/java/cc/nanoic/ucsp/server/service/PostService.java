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
        PostMapper.insertPost(post.getTitle(),
                post.getAuthor_id(),
                post.getIntro(),
                post.getContent(),
                post.getPost_cover(),
                post.getCreate_time(),
                post.getUpdate_time(),
                post.getLike_num());
    }

    public void delete(Post post) {//删除帖子

        PostMapper.deletePost(post.getId());
    }

    public void update(Post post) {//更新帖子
        PostMapper.updatePost(post.getTitle(), post.getIntro(), post.getContent(), post.getPost_cover(),post.getUpdate_time(),post.getId());
    }
}
