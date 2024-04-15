package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.service.UserService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.*;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-03-30
 * @FileName: UserMapper
 **/

@Mapper
public interface UserMapper {

    /**
     *
     * @param id
     * @return User格式的用户信息
     */
    @Select("SELECT * FROM `user` WHERE user_name = #{user_name}")
    User selectById(@Param("username") Integer id);

    /**
     * 根据用户名查用户
     * @param user_name
     * @return User格式的用户信息
     */
    @Select("SELECT * FROM `user` WHERE user_name = #{user_name}")
    User selectByUserName(@Param("user_name") String user_name);

    /**
     * 用户注册(添加用户信息)
     * @param id
     * @param user_name
     * @param password
     * @param phone
     * @return User格式的用户信息
     */
    @Insert("insert into `user` values (#{Username})")
    User insertUser(@Param("id")  Integer id,
                    @Param("User_name") String user_name,
                    @Param("Userpwd") String password,
                    @Param("Userphone")Integer phone);

}
