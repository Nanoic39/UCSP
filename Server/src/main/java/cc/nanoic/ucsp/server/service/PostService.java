/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-27 13:01:07
 * @LastEditTime: 2024-05-03 21:50:19
 * @FilePath: \ProgramDev\Program\UCSP\Server\src\main\java\cc\nanoic\\ucsp\server\service\PostService.java
 * @Describe: 
 */
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


    //增加帖子
    public void insertPost(Post post) {
       Integer i=PostMapper.numSelect("post");//i为当前帖子总数

        String p="post_"+(i/3000000+1);//利用帖子总数确定表数
        CreateTableOnMethodCall createTableOnMethodCall = new CreateTableOnMethodCall();

        if(createTableOnMethodCall.TableName(p)) {//如果新表不存在则创建
            createTableOnMethodCall.Table(i/3000000+1);
        }
        Integer max= PostMapper.numSelectMax(p);//拿到最新表的条数
        if (max==null) max=0;
        //System.out.println(max);
        PostMapper.numUpdate((i/3000000)*3000000+max+1,"post");//更新帖子总数
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

    //删除帖子
    public void delete(Post post) {
        String p="post_"+(post.getId()/3000000+1);
        if(post.getId()%3000000==0){p="post_"+(post.getId()/3000000);}
        Integer id=post.getId()%3000000;
        if(id==0){id=3000000;}
        PostMapper.deletePost(p,id);
    }

    //更新帖子
    public void update(Post post) {
        String p="post_"+(post.getId()/3000000+1);
        if(post.getId()%3000000==0){p="post_"+(post.getId()/3000000);}
        System.out.println(p);
        Integer id=post.getId()%3000000;
        if(id==0){id=3000000;}
        System.out.println(id);

        PostMapper.updatePost(p,post.getTitle(), post.getIntro(), post.getContent(), post.getPost_cover(),id,post.getUpdate_time());
    }


    //增加学习区帖子
    public void insertPost_study(Post_Study Post_Study) {
        Integer i=PostMapper.numSelect("study_post");
        String p="studypost_"+(i/3000000+1);
        CreateTableOnMethodCall createTableOnMethodCall = new CreateTableOnMethodCall();
        if( createTableOnMethodCall.TableName(p)) {//表不存在

            createTableOnMethodCall.studyTable(i/3000000+1);
        }
        Integer max= PostMapper.numSelectMax(p);//拿到最新表的条数
        if (max==null) max=0;
        PostMapper.numUpdate((i/3000000)*3000000+max+1,"study_post");//更新帖子总数

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

    //删除学习区帖子
    public void studyDelete(Post post) {
        String p="studypost_"+(post.getId()/3000000+1);
        if(post.getId()%3000000==0){p="studypost_"+(post.getId()/3000000);}
        System.out.println(p);
        Integer id=post.getId()%3000000;
        if(id==0){id=3000000;}
        PostMapper.deletePost(p,id);
    }

    //更新学习区帖子
    public void updatePost_study(Post_Study post) {
        String p="studypost_"+(post.getId()/3000000+1);
        if(post.getId()%3000000==0){p="studypost_"+(post.getId()/3000000);}
        System.out.println(p);
        Integer id=post.getId()%3000000;
        if(id==0){id=3000000;}
        System.out.println(id);

        PostMapper.updatePost_study(p,post.getTitle(), post.getIntro(), post.getContent(), post.getPost_cover(),id,post.getUpdate_time(),post.getTag());
    }

    //增加分享区帖子
    public void insertPost_share(Post_Study Post_Study) {
        Integer i=PostMapper.numSelect("share_post");
        String p="sharepost_"+(i/3000000+1);
        CreateTableOnMethodCall createTableOnMethodCall = new CreateTableOnMethodCall();
        if( createTableOnMethodCall.TableName(p)) {//表不存在
            createTableOnMethodCall.shareTable(i/3000000+1);
        }
        Integer max= PostMapper.numSelectMax(p);//拿到最新表的条数
        if (max==null) max=0;
        PostMapper.numUpdate((i/3000000)*3000000+max+1,"share_post");//更新帖子总数

        PostMapper.insertPost_share(
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
    //删除分享区帖子
    public void shareDelete(Post post) {
        String p="sharepost_"+(post.getId()/3000000+1);
        if(post.getId()%3000000==0){p="sharepost_"+(post.getId()/3000000);}
        System.out.println(p);
        Integer id=post.getId()%3000000;
        if(id==0){id=3000000;}
        PostMapper.deletePost(p,id);
    }
    //更新分享区帖子
    public void updatePost_share(Post_Study post) {
        String p="sharepost_"+(post.getId()/3000000+1);
        if(post.getId()%3000000==0){p="sharepost_"+(post.getId()/3000000);}
        System.out.println(p);
        Integer id=post.getId()%3000000;
        if(id==0){id=3000000;}
        System.out.println(id);

        PostMapper.updatePost(p,post.getTitle(), post.getIntro(), post.getContent(), post.getPost_cover(),id,post.getUpdate_time());
    }
}
