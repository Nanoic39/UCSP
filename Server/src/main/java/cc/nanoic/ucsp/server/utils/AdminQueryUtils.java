package cc.nanoic.ucsp.server.utils;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.entity.*;
import cc.nanoic.ucsp.server.exception.ServiceException;
import cc.nanoic.ucsp.server.mapper.AdminMapper;
import cc.nanoic.ucsp.server.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: yrpyy
 * @Date: 2024-4-26
 * @FileName: AdminQueryUtils
 * @Status: dev
 **/

@Component
public class AdminQueryUtils {
    @Resource
    AdminService adminService;
    @Autowired
    AdminMapper adminMapper;

    /**
     * @return
     */
    public List<User_Role_Authority> queryAuthority(String type, Integer id) {
        //返回值
        List<User_Role_Authority> userRoleAuthorities = new ArrayList<>();
        //返回值单个数据(临时)
        User_Role_Authority temp_userRoleAuthorities = new User_Role_Authority();

        //角色列表
        List<Role> roles = new ArrayList<>();
        //角色列表单个数据(临时)
        Role temp_role = new Role();

        //角色权限关联表
        List<Role_Authority> roleAuthorities = new ArrayList<>();
        //角色权限关联表单个数据(临时)
        Role_Authority temp_roleAuthorities = new Role_Authority();

        //角色权限列表
        List<Authority> authorities = new ArrayList<>();
        //角色权限列表单个数据(临时)
        Authority authority = new Authority();

        //角色拥有菜单列表
        List<Menu> menus = new ArrayList<>();
        //角色拥有菜单列表单个数据(临时)
        Menu menu = new Menu();

        try {
            //type: getMenu(获取菜单) | getRole(获取角色) | getAuth(获取权限)

            //获取角色
            try {
                //用户-角色关联表列表
                List<User_Role> userRoles = adminMapper.selectUserRoleById(id);
                for (User_Role item_userRoles : userRoles) {
                    //获取角色
                    if (type.equals("getRoles")) {
                        temp_role = adminMapper.selectUserRoleByRoleId(item_userRoles.getRole_id());
                        if (temp_role != null) {
                            roles.add(temp_role);
                        }
                    }

                    //获取权限
                    if (type.equals("getAuth") || type.equals("getMenu")) {
                        //查询角色权限关联表
                        roleAuthorities = adminMapper.selectRoleAuthorityByRoleId(item_userRoles.getRole_id());
                        for (Role_Authority item_roleAuthority : roleAuthorities) {
                            authority = adminMapper.selectAuthorityByAuthorityId(item_roleAuthority.getAuthority_id());
                            if (authority != null) {
                                authorities.add(authority);
                            }
                            if (type.equals("getMenu")){
                                menu = adminMapper.selectMenuByAuthorityLevel(authority.getLevel());
                                if (menu != null){
                                    menus.add(menu);
                                }
                            }
                        }
                    }
                }

                //返回数据处理
                if (type.equals("getRoles")) {
                    for (Role item_roles : roles) {
                        temp_userRoleAuthorities.setId(item_roles.getId());
                        temp_userRoleAuthorities.setName(item_roles.getName());
                        temp_userRoleAuthorities.setIntro(item_roles.getIntro());
                        temp_userRoleAuthorities.setIcon(item_roles.getIcon());
                        temp_userRoleAuthorities.setColor(item_roles.getColor());
                        //统一化
                        userRoleAuthorities.add(temp_userRoleAuthorities);
                    }

                }

                if (type.equals("getAuth")) {
                    for (Authority item_authorities : authorities) {
                        temp_userRoleAuthorities.setId(item_authorities.getId());
                        temp_userRoleAuthorities.setLevel(item_authorities.getLevel());
                        temp_userRoleAuthorities.setIntro(item_authorities.getIntro());
                        //统一化
                        userRoleAuthorities.add(temp_userRoleAuthorities);
                    }
                }

                if (type.equals("getMenu")) {
                    for (Menu item_menus : menus) {
                        temp_userRoleAuthorities = new User_Role_Authority();
                        temp_userRoleAuthorities.setId(item_menus.getId());
                        temp_userRoleAuthorities.setParent_id(item_menus.getParent_id());
                        temp_userRoleAuthorities.setName(item_menus.getName());
                        temp_userRoleAuthorities.setPath(item_menus.getPath());
                        temp_userRoleAuthorities.setIcon(item_menus.getIcon());
                        temp_userRoleAuthorities.setAuth(item_menus.getAuth());
                        temp_userRoleAuthorities.setName(item_menus.getName());
                        temp_userRoleAuthorities.setLevel(item_menus.getLevel());
                        temp_userRoleAuthorities.setSort(item_menus.getSort());
                        temp_userRoleAuthorities.setStatus(item_menus.getStatus());
                        temp_userRoleAuthorities.setCreat_time(item_menus.getCreat_time());
                        temp_userRoleAuthorities.setUpdate_time(item_menus.getUpdate_time());
                        //统一化
                        userRoleAuthorities.add(temp_userRoleAuthorities);
                    }
                }
                //返回数据
                return userRoleAuthorities;
            } catch (Exception e) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
