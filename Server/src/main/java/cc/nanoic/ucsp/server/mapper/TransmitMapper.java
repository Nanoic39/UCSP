package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.entity.Post_Study;
import cc.nanoic.ucsp.server.entity.entityRequest.Post_home;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.Date;

@Mapper
public interface TransmitMapper {
    /**
     * 根据id查询帖子内容
     * */
    @Select("select * from `${p}` where id=#{id} and status>0")
    Post_home newPost(@Param("p")String p,
                      @Param("id")Integer id
    );

    @Select("select `id`,`title`, `author_id`, `intro`, `status`, `post_cover`, `auth`, `like_num`, `comment_num`, `collection_num`, `tag` from `${p}` where id=#{id} and tag=#{subjects}")
    Post_home newPost_type(@Param("p") String p, @Param("id") Integer id, @Param("subjects") String subjects);


    @Select("select * from `${p}` where id=#{id}")
    Post post_get(@Param("p") String p, @Param("id") Integer id);

    //查询角色ID对应姓名
    @Select("select `account` from `user` where id=#{id} ")
    String user_name(
            @Param("id") Integer id
    );

}
