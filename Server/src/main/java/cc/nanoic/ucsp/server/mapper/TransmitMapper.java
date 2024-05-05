package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Post;
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


}
