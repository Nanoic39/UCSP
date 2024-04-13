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

    //根据账号查用户
    @Select("SELECT * FROM `user` WHERE user_name = #{user_name}")
    User selectById(@Param("username") Integer id);
    //根据用户名查用户
    @Select("SELECT * FROM `user` WHERE user_name = #{user_name}")
    User selectByUserName(@Param("user_name") String user_name);
    //注册用户
    @Insert("insert into `user` values (#{Username})")
    User insertUser(@Param("id")  Integer id,
                    @Param("User_name") String user_name,
                    @Param("Userpwd") String password,
                    @Param("Userphone")Integer phone);
}
