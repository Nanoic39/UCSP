package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Holiday;
import cn.hutool.core.date.DateTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface CountdownMapper {
    @Select("SELECT * FROM `holiday` WHERE date > #{date} order by date desc limit 1")
    Holiday selectDateByDate(@Param("date") Date date);

    @Select("SELECT * FROM `holiday` WHERE name = #{name}")
    Holiday selectDateByName(@Param("name") String name);
}
