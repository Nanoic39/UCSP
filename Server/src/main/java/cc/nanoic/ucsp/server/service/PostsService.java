package cc.nanoic.ucsp.server.service;


import cc.nanoic.ucsp.server.entity.Posts;
import cc.nanoic.ucsp.server.mapper.PostsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {
    @Autowired
    PostsMapper postsMapper;

    public Posts inserPosts(Posts posts){//增加帖子
       return postsMapper.insertPosts(posts.getId(), posts.getPosts_id(), posts.getPosts_content(), posts.getPosts_title(), posts.getPosts_image());
    }
    public Posts delete(Posts posts){
        return postsMapper.deletePosts(posts.getPosts_id());
    }
    public Posts update(Posts posts){
        return postsMapper.updatePosts(posts.getPosts_content(),posts.getPosts_title(),posts.getPosts_image(),posts.getPosts_id());
    }
}
