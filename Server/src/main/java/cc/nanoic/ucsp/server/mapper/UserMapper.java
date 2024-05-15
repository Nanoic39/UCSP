package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-03-30
 * @FileName: UserMapper
 **/

@Mapper
public interface UserMapper {
    /**
     * 根据用户名查用户
     * @return User格式的用户信息
     */
    @Select("SELECT * FROM `user` WHERE account = #{account}")
    User selectByAccount(@Param("account") String account);
    /**
     * 根据id查用户
     * @return User格式的用户信息
     */
    @Select("SELECT * FROM `user` WHERE id = #{id}")
    User selectById(@Param("id") Integer id);

    /**
     * 根据用户名查用户
     * @return User格式的用户信息
     */
    @Select("SELECT * FROM `user` WHERE account = #{account}")
    User selectByUserName(@Param("account") String account);
    /**
     * 根据邮箱查用户
     * @return User格式的用户信息
     */
    @Select("SELECT * FROM `user` WHERE Phone = #{Phone}")
    User selectByPhone(@Param("Phone") String Phone);

    /**
     * 用户注册(添加用户信息)
     */
    @Insert("insert into `user` values (null, #{account}, #{password}, NULL, 1, #{phone}, NULL, Null)")
    void registerUser(@Param("account") String account,
                      @Param("password") String password,
                      @Param("phone")String phone
                      );

    /**
     * 用户注销
     */
    @Update("update `user` set `status`=0 where `id`= (#{id});update `authority` set `authority_level`=0 where `id` = (#{id})")
    User logoutUser(@Param("id")  Integer id);

    @Insert("insert into user_role values (null,#{id},1)")
    void insert_role(
            @Param("id") Integer id
    );

    /**
     * 根据level查询菜单
     * @param id
     * @return User_menu格式用户信息
     */

}