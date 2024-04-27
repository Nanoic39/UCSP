package cc.nanoic.ucsp.server.mapper;

import org.apache.ibatis.annotations.*;

import java.util.Date;

@Mapper
public interface PostMapper {
    /**
     * 发 帖
     * @param: id
     * @param: post_id
     * @param: post_content
     * @param: post_title
     * @param: post_image
     */
    @Insert("insert into `post_1` value (null,#{title},#{author_id},#{intro},#{content},#{post_cover},null,#{create_time},#{update_time},#{like_num})")
    void insertPost(
            @Param("title") String title,//文章标题
            @Param("author_id") Integer author_id,//作者ID
            @Param("intro") String intro,//摘要
            @Param("content") String content,//文章正文
            @Param("post_cover") String post_cover,//文章封面
            @Param("create_time") Date create_time,//创建时间
            @Param("update_time") Date update_time,//最后一次更新时间
            @Param("like_num") Integer like_num//点赞数

    );

    /**
     * 删 帖
     * @param: posts_id
     */
    @Delete("delete from`post_1` where id=#{id}")
    void deletePost(@Param("id")Integer id);


    /**
     * 更 新 帖
     * @param:posts_content
     * @param:posts_title
     * @param:post_image
     * @param:posts_id
     * */
    @Update("update  `post_1` set `title`=#{title},`intro`=#{intro},`content`=#{content},`post_cover`=#{post_cover},`update_time`=#{update_time} where `id`=#{id}; ")
    void updatePost(@Param("title")  String  title,//文章标题
                     @Param("intro") String intro,//摘要
                     @Param("content") String content,//文章正文
                     @Param("post_cover") String post_cover,//文章封面
                     @Param("update_time") Date update_time,//最后一次更新时间
                     @Param("id") Integer id)//文章id
    ;

}




