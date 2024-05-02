package cc.nanoic.ucsp.server.service;


import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.entity.Post_Study;
import cc.nanoic.ucsp.server.mapper.PostMapper;
import cc.nanoic.ucsp.server.utils.CreateTableOnMethodCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostMapper PostMapper;

    public void insertPost(Post post) {//增加帖子
       Integer i=PostMapper.numSelect("帖子表");//i为当前帖子总数
        String p="post_"+(i/3000000+1);//利用帖子总数确定表数
        CreateTableOnMethodCall createTableOnMethodCall = new CreateTableOnMethodCall();

        if(createTableOnMethodCall.TableName(p)) {//如果新表不存在则创建
            createTableOnMethodCall.Table(i/3000000+1);
        }
        Integer max= PostMapper.numSelectMax(p);//拿到最新表的条数
        if (max==null) max=0;
        PostMapper.numUpdate((i/3000000)*3000000+max+1,"帖子表");//更新帖子总数
        PostMapper.insertPost(
                p,
                post.getTitle(),//文章标题
                post.getAuthor_id(),//作者ID
                post.getIntro(),//摘要
                post.getContent(),//文章正文
                post.getPost_cover(),//文章封面
                post.getCreate_time(),
                post.getUpdate_time()
        );
    }

    public void delete(Post post) {//删除帖子
        String p="post_"+(post.getId()/3000000+1);
        if(post.getId()%3000000==0){p="post_"+(post.getId()/3000000);}
        Integer id=post.getId()%3000000;
        if(id==0){id=3000000;}
        PostMapper.deletePost(p,id);
    }
    public void studyDelete(Post post) {//删除学习区帖子
        String p="studypost_"+(post.getId()/3000000+1);
        if(post.getId()%3000000==0){p="studypost_"+(post.getId()/3000000);}
        System.out.println(p);
        Integer id=post.getId()%3000000;
        if(id==0){id=3000000;}
        PostMapper.deletePost(p,id);
    }

    public void update(Post post) {//更新帖子
        String p="post_"+(post.getId()/3000000+1);
        if(post.getId()%3000000==0){p="post_"+(post.getId()/3000000);}
        System.out.println(p);
        Integer id=post.getId()%3000000;
        if(id==0){id=3000000;}
        System.out.println(id);

        PostMapper.updatePost(p,post.getTitle(), post.getIntro(), post.getContent(), post.getPost_cover(),id,post.getUpdate_time());
    }


    public void insertPost_study(Post_Study Post_Study) {//增加学习区帖子
        Integer i=PostMapper.numSelect("学习表");//i为当前帖子总数
        String p="studypost_"+(i/3000000+1);//利用帖子总数确定表数
        if( i%3000000==0) {//如果新表的条数到300W建新表
            CreateTableOnMethodCall createTableOnMethodCall = new CreateTableOnMethodCall();
            createTableOnMethodCall.studyTable(i/3000000+1);
        }
        Integer max= PostMapper.numSelectMax(p);//拿到最新表的条数
        if (max==null) max=0;
        PostMapper.numUpdate((i/3000000)*3000000+max+1,"学习表");//更新帖子总数

        PostMapper.insertPost_study(
                p,
                Post_Study.getTitle(),//文章标题
                Post_Study.getAuthor_id(),//作者ID
                Post_Study.getIntro(),//摘要
                Post_Study.getContent(),//文章正文
                Post_Study.getPost_cover(),//文章封面
                Post_Study.getCreate_time(),
                Post_Study.getUpdate_time(),
                Post_Study.getTag() //标签
        );
    }

    public void updatePost_study(Post_Study post) {//更新帖子
        String p="studypost_"+(post.getId()/3000000+1);
        if(post.getId()%3000000==0){p="studypost_"+(post.getId()/3000000);}
        System.out.println(p);
        Integer id=post.getId()%3000000;
        if(id==0){id=3000000;}
        System.out.println(id);

        PostMapper.updatePost(p,post.getTitle(), post.getIntro(), post.getContent(), post.getPost_cover(),id,post.getUpdate_time());
    }

}
