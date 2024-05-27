package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Comments_get;
import cc.nanoic.ucsp.server.entity.entityRequest.Comments;
import cc.nanoic.ucsp.server.entity.entityRequest.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.Date;

/**
 * @FileName CommentsMapper
 * @Description
 * @Author fazhu
 * @date 2024-05-24
 **/
@Mapper
public interface CommentsMapper {

    //增加评论
    @Insert("insert into `${p}` value (null,#{content},#{create_time},#{user_id},#{post_id},0,#{comments_id},#{reply_id})")
    void comments(
            @Param("p")String p,
            @Param("post_id") Integer post_id,//回复的帖子ID
            @Param("user_id") Integer user_id,//评论者ID
            @Param("content") String content,//评论内容
            @Param("create_time") Date create_time,//创建时间
            @Param("comments_id")Integer comments_id ,//所属回复id
            @Param("reply_id") Integer reply_id//回复对象评论id
                  );

    //增加回复
    @Insert("insert into `post_reply_1` value (null,#{object_id},#{user_id},#{type},#{content},#{create_time},0)")
    void reply(@Param("object_id") Integer object_id,//回复的对象ID
               @Param("user_id") Integer user_id,//评论者ID
               @Param("type") Integer type,//回复的：评论/回复
               @Param("content") String content,//评论内容
               @Param("create_time") Date create_time//创建时间
    );




    //查询角色ID对应姓名
    @Select("select `account` from `user` where id=#{id} ")
    String user_name(
            @Param("id") Integer id
    );
    //查询对应帖子的作者id
    @Select("select `user_id` from `post_comments_1` where id=#{id} ")
    Integer reply_id(
            @Param("id") Integer id
    );


    //查询该评论下的的回复(3条)
    @Select("select * from `post_comments_1`  where comments_id=#{id} order by like_num desc limit  #{num},#{num2}")
   ArrayList<Reply>  post_Reply_select(
            @Param("id") Integer id,
            @Param("num") Integer num,
            @Param("num2") Integer num2
    );
    //请求评论
    @Select("select * from `post_comments_1`  where post_id=#{id} and comments_id is NULL and reply_id is null order by like_num desc  limit #{num},#{num2}")
    ArrayList<Comments_get>  post_comments(
            @Param("id") Integer id,
            @Param("num") Integer num,
            @Param("num2") Integer num2
    );



}
