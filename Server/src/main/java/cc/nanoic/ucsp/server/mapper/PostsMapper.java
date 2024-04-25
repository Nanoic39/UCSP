package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Posts;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PostsMapper {
 /**
 * 发 帖
 * @param: id
 * @param: posts_id
 * @param: posts_content
 * @param: posts_title
 * @param: posts_image
 */
    @Insert("insert into `posts` value (#{id},#{posts_id},#{posts_content},#{posts_title},#{post_image},)")
    Posts insertPosts(@Param("id") Integer id,
                      @Param("posts_id") Integer posts_id,
                      @Param("posts_content") String posts_content,
                      @Param("posts_title") String posts_title,
                      @Param("post_image") Byte posts_image);

    /**
     * 删 帖
     * @param: posts_id
     */
    @Delete("delete into`posts` where #{posts_id}")
    Posts deletePosts(@Param("posts_id")Integer posts_id);


    /**
     * 更 新 帖
     * @param:posts_content
     * @param:posts_title
     * @param:post_image
     * @param:posts_id
    * */
    @Update("update  `posts` set posts_content=#{posts_content},posts_title=#{posts_title},post_image=#{post_image} where id=#{post_id} ")
   Posts updatePosts(@Param("posts_content")  String  posts_content,
                     @Param("posts_title") String posts_title,
                     @Param("post_image") Byte posts_image,
                     @Param("post_id") Integer posts_id);

}




