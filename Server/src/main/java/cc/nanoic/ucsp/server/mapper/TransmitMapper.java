package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.entity.Post_Study;
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
    @Select("select * from `${p}` where id=#{id}")
    Post newPost(@Param("p")String p,
            @Param("id")Integer id
    );
    @Select("select * from `${p}` where id=#{id} and tag=#{subjects}")
    Post_Study newPost_type(@Param("p")String p,
                            @Param("id")Integer id,
                            @Param("subjects") String subjects
            );

    @Select("select * from `${p}` where id=#{id}")
    Post post_get(
            @Param("p") String p,
            @Param("id") Integer id
    );

}
