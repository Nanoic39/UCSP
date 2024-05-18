package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.*;
import org.apache.ibatis.annotations.*;

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

    //修改身份
    @Update("update user_role set role_id=#{authority_new} where user_id=#{id} and role_id=#{authority_old} ")
    void authority_update( @Param("id") Integer id,
                 @Param("authority_old")Integer authority_old,
                 @Param("authority_new")Integer authority_new);

    //删除身份
    @Delete("delete from `user_role` where user_id=#{id} and role_id=#{authority_old}")
    void authority_delete( @Param("id") Integer id,
                           @Param("authority_old")Integer authority_old);
}
