package cc.nanoic.ucsp.server.mapper;

import org.apache.ibatis.annotations.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Mapper
public interface PostMapper {
    /**
     * 查询对应数据量
     *
     * @param: type
     */
    @Select("select num from `table_num` where type=#{type}")
    Integer numSelect(
            @Param("type") String type
    );

    @Update("update `table_num` set `num`=#{num} where `type`=#{type}; ")
    void numUpdate(
            @Param("num") Integer num,
            @Param("type") String type
    );

    /**
     *
     */
    @Select("select MAX(id) from `${p}`")
    Integer numSelectMax(
            @Param("p") String p
    );


    /**
     * 发 帖
     *
     * @param: title
     * @param: author_id
     * @param: intro
     * @param: content
     * @param: like_num
     */
    @Insert("insert into `${p}` value (null,#{title},#{author_id},#{intro},#{content},1,#{post_cover},null,#{create_time},#{update_time},0,0,0)")
    void insertPost(
            @Param("p") String p,
            @Param("title") String title,//文章标题
            @Param("author_id") Integer author_id,//作者ID
            @Param("intro") String intro,//摘要
            @Param("content") String content,//文章正文
            @Param("post_cover") String post_cover,//文章封面
            @Param("create_time") Date create_time,//发布时间
            @Param("update_time") Date update_time//更新时间
    );

    /**
     * 删 帖
     *
     * @param: posts_id
     */
    @Delete("delete from`post_1` where id=#{id}")
    void deletePost(@Param("id") Integer id);


    /**
     * 更 新 帖
     *
     * @param:posts_content
     * @param:posts_title
     * @param:post_image
     * @param:posts_id
     */
    @Update("update ${p} set `title`=#{title},`intro`=#{intro},`content`=#{content},`post_cover`=#{post_cover},`update_time`=#{update_time} where `id`=#{id}; ")
    void updatePost(
            @Param("p") String p,
            @Param("title") String title,//文章标题
            @Param("intro") String intro,//摘要
            @Param("content") String content,//文章正文
            @Param("post_cover") String post_cover,//文章封面
            @Param("id") Integer id,//文章id
            @Param("update_time") Date update_time//更新时间
    );

    @Insert("insert into `post_study_1` value (null,#{title},#{author_id},#{intro},#{content},#{post_cover},null,null,null,#{tag},0)")
    void insertPost_study(
            @Param("title") String title,//文章标题
            @Param("author_id") Integer author_id,//作者ID
            @Param("intro") String intro,//摘要
            @Param("content") String content,//文章正文
            @Param("post_cover") String post_cover,//文章封面
            @Param("tag") String tag
    );

}




