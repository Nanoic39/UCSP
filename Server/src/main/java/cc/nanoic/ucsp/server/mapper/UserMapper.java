package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.User_Info_Menu;
import cc.nanoic.ucsp.server.entity.User_Menu;
import cc.nanoic.ucsp.server.entity.User_Info;
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

    /**
     * 用户注销
     * @param id
     * @return User格式的用户信息
     */
    @Update("update `user` set `is_active`=0 where `id`= (#{id});update `authority` set `authority_level`=0 where `id` = (#{id})")
    User logoutUser(@Param("id")  Integer id);

    /**
     * 根据level查询菜单
     * @param id
     * @return User_menu格式用户信息
     */
    @Update("select `authority_level` from `authority` where id = (#{id})")
    String queryAuthorityLevel(@Param("id") Integer id);

    /**
     * 根据level查询菜单
     * @param level
     * @return User_menu格式用户信息
     */
    @Update("select * from `menu` where level = (#{level})")
    List<User_Info_Menu> queryMenu(@Param("level") String level);

    /**
     * 根据id查询用户信息
     * @param id
     * @return User_menu格式用户信息
     */
    @Update("select * from `user_info` where id = (#{id})")
    List<User_Info_Menu> queryInfo(@Param("id") Integer id);
}