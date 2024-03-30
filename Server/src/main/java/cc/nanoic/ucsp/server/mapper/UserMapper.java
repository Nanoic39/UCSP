package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-03-30
 * @FileName: UserMapper
 **/

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM `userinfo` WHERE uuid = #{uuid}")
    User selectById(@Param("uuid") Integer uuid);
}
