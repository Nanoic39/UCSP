package cc.nanoic.ucsp.server.mapper;

import org.apache.ibatis.annotations.*;

import java.util.Date;

@Mapper
public interface PostMapper {
    /**
     * 发 帖
     * @param: title
     * @param: author_id
     * @param: intro
     * @param: content
     * @param: like_num
     */
    @Insert("insert into `post_1` value (null,#{title},#{author_id},#{intro},#{content},#{post_cover},null,null,null,0)")
    void insertPost(
            @Param("title") String title,//文章标题
            @Param("author_id") Integer author_id,//作者ID
            @Param("intro") String intro,//摘要
            @Param("content") String content,//文章正文
            @Param("post_cover") String post_cover//文章封面


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
    @Update("update  `post_1` set `title`=#{title},`intro`=#{intro},`content`=#{content},`post_cover`=#{post_cover} where `id`=#{id}; ")
    void updatePost(@Param("title")  String  title,//文章标题
                     @Param("intro") String intro,//摘要
                     @Param("content") String content,//文章正文
                     @Param("post_cover") String post_cover,//文章封面

                     @Param("id") Integer id)//文章id
    ;

}




