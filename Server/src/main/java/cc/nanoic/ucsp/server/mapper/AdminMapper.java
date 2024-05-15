package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-03-30
 * @FileName: AdminMapper
 **/

@Mapper
public interface AdminMapper {

    //用户_角色关联查询
    @Select("SELECT `id`, `user_id`, `role_id` FROM user_role WHERE `user_id` = #{id}")
    List<User_Role> selectUserRoleById(@Param("id") Integer id);

    //角色查询
    @Select("SELECT `id`, `name`, `intro`, `icon`, `color` FROM role WHERE `id` = #{role_id}")
    Role selectUserRoleByRoleId(@Param("role_id") Integer id);

    //查询角色_权限关联表
    @Select("SELECT `id`, `role_id`, `authority_id` FROM role_authority WHERE `id` = #{role_id}")
    List<Role_Authority> selectRoleAuthorityByRoleId(@Param("role_id") Integer roleId);

    //查询权限
    @Select("SELECT `id`,`level`,`intro` FROM authority WHERE `id` = (#{authorityId})")
    Authority selectAuthorityByAuthorityId(@Param("authorityId") Integer authorityId);

    //查询菜单
    @Select("SELECT * FROM menu WHERE auth = #{authorityLevel}")
    List<Menu> selectMenuByAuthorityLevel(@Param("authorityLevel") String authorityLevel);
}
