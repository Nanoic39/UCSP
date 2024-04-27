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
    /**
     *
     * @param id
     * @return User格式的用户信息
     */
    @Select("SELECT * FROM `user` WHERE id = #{id}")
    User selectById(@Param("id") Integer id);

    /**
     * 根据用户名查用户
     * @param account
     * @return User格式的用户信息
     */
    @Select("SELECT * FROM `user` WHERE account = #{account}")
    User selectByUserName(@Param("account") String account);

    /**
     * 用户注册(添加用户信息)
     * @param account
     * @param password
     * @param phone
     * @return User格式的用户信息
     */
    @Insert("insert into `user` values (null, #{account},#{password},NULL,0,#{phone},NULL,null)")
    void registerUser(@Param("account") String account,
                      @Param("password") String password,
                      @Param("phone")Integer phone);

}