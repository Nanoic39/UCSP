package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.Comments_get;
import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.entityRequest.Comments;
import cc.nanoic.ucsp.server.entity.entityRequest.Num;
import cc.nanoic.ucsp.server.entity.entityRequest.Reply;
import cc.nanoic.ucsp.server.mapper.CommentsMapper;
import cc.nanoic.ucsp.server.mapper.PostMapper;
import cc.nanoic.ucsp.server.utils.CreateTableOnMethodCall;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import cn.hutool.core.date.DateTime;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @FileName CommentsService
 * @Description
 * @Author fazhu
 * @date 2024-05-24
 **/
@Service
public class CommentsService {

    @Resource
    CommentsMapper commentsMapper;
    @Resource
    PostMapper PostMapper;

    int limit = 3000000;

        //增加评论
    public void post_comments_insert(Comments comments) {
        String type = "post_comments";
        Integer i = PostMapper.numSelect(type);//i为当前帖子总数
        String p = type + "_" + (i / limit + 1);//利用帖子总数确定表数
        CreateTableOnMethodCall createTableOnMethodCall = new CreateTableOnMethodCall();
        if (createTableOnMethodCall.TableName(p)) {//如果新表不存在则创建
            System.out.println(i / limit + 1);
            createTableOnMethodCall.post_comments(i / limit + 1);
        }
        Integer max = PostMapper.numSelectMax(p);//拿到最新表的条数
        if (max == null) max = 0;
        PostMapper.numUpdate((i / limit) * limit + max + 1, type);//更新帖子总数

        DateTime dateTime = new DateTime();
        comments.setCreate_time(dateTime);

//        User user= TokenUtils.getCurrentUser();
        commentsMapper.comments(p,
                comments.getPost_id(),
                comments.getUser_id(),
                comments.getContent(),
                comments.getCreate_time(),
                comments.getComments_id(),
                comments.getReply_id()
        );
    }


    //获取
    public ArrayList<Comments_get> post_comments_post(Num num) {
        ArrayList<Comments_get> List = new ArrayList<>();

        for (int o = 0; ; o++) {
        }
    }

    //请求评论
    public ArrayList<Comments_get> post_comments_get(Integer id, Integer num) {
        ArrayList<Comments_get> comments = new ArrayList<>();
        Integer num2 = 0;
        if (num == 0) {
            num = 0;
            num2 = 4;
        } else {  //设定读取位数
            num = num * 5 - 1;
            num2 = num + 4;
        }
        //按点赞数获取最高的
        comments = commentsMapper.post_comments(id, num, num2);
        for (Comments_get element : comments) {
            element.setUser_name(commentsMapper.user_name(element.getUser_id()));//查出发评人姓名
            element.setComments(commentsMapper.post_Reply_select(element.getId(),0,2));//查询该帖子下的子评论
            for (Reply e : element.getComments()) { //遍历子评论
                e.setUser_name(commentsMapper.user_name(e.getUser_id()));//子评论发评人
                if (e.getReply_id() == null) {//如果没有对象，则指向父评论
                    e.setReply_name(commentsMapper.user_name(element.getUser_id()));//查询父评论的作者
                } else {
                    e.setReply_name(commentsMapper.user_name(commentsMapper.reply_id(e.getReply_id())));//查询@的作者
                }
            }
        }
        return comments;
    }
    //请求回复
    public ArrayList<Reply> post_reply_get(Integer id,Integer num){
        Integer num2=0;
            num=num*5+3;
            num2=num+4;

        ArrayList<Reply>  reply= commentsMapper.post_Reply_select(id,num,num2);
        for(Reply e: reply){
            e.setUser_name(commentsMapper.user_name(e.getUser_id()));//子评论发评人
            if (e.getReply_id() == null) {//如果没有对象，则指向父评论
                e.setReply_name(commentsMapper.user_name(id));//查询父评论的作者
            } else {
                e.setReply_name(commentsMapper.user_name(commentsMapper.reply_id(e.getReply_id())));//查询@的作者
            }
        }
        return reply;
    }

}


