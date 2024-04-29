package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Countdown;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CountdownMapper {
    @Select("SELECT * FROM `countdown` WHERE id = #{id}")
    Countdown selectDate(@Param("id") Integer id);
}
