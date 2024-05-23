package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.Result;

import cc.nanoic.ucsp.server.entity.*;
import cc.nanoic.ucsp.server.entity.entityRequest.ReqAuthority;
import cc.nanoic.ucsp.server.service.AdminService;
import cc.nanoic.ucsp.server.utils.AdminQueryUtils;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 管理员Controller
 * @Author: Nanoic
 * @Date: 2024-03-30
 * @FileName: AdminController
 **/


@RestController
public class AdminController {
    @Resource
    AdminService adminService;

    @Resource
    AdminQueryUtils adminQueryUtils;

    @GetMapping("/get/console/menu")
    public Result getConsoleMenu(){//菜单查询
        User user = TokenUtils.getCurrentUser();

        List<Menu> menus = new ArrayList<>();
        List<User_Role_Authority> UIM;
        if (user != null) {
            UIM = adminQueryUtils.queryAuthority("getMenu", user.getId());
            if(UIM != null){
                for (User_Role_Authority userRoleAuthority : UIM){
                    Menu menu = new Menu();
                    menu.setId(userRoleAuthority.getId());
                    menu.setParent_id(userRoleAuthority.getParent_id());
                    menu.setName(userRoleAuthority.getName());
                    menu.setPath(userRoleAuthority.getPath());
                    menu.setFile_path(userRoleAuthority.getFile_path());
                    menu.setIcon(userRoleAuthority.getIcon());
                    menu.setAuth(userRoleAuthority.getAuth());
                    menu.setName(userRoleAuthority.getName());
                    menu.setLevel(userRoleAuthority.getLevel());
                    menu.setSort(userRoleAuthority.getSort());
                    menu.setStatus(userRoleAuthority.getStatus());
                    menu.setCreat_time(userRoleAuthority.getCreat_time());
                    menu.setUpdate_time(userRoleAuthority.getUpdate_time());
                    //统一处理
                    menus.add(menu);
                }
            } else {
                return Result.error("获取失败");
            }

        }
        return Result.success(menus);
    }

    @GetMapping("/get/authority")
    public Result getAuthority(){
        //获取角色
        User user = TokenUtils.getCurrentUser();

        //定义返回列表
        List<Authority> authorities = new ArrayList<>();

        List<User_Role_Authority> userRoleAuthorities = new ArrayList<>();

        if (user != null) {
            userRoleAuthorities = adminQueryUtils.queryAuthority("getAuth", user.getId());
            for (User_Role_Authority userRoleAuthority : userRoleAuthorities){
                Authority authority = new Authority();
                authority.setId(userRoleAuthority.getId());
                authority.setLevel(userRoleAuthority.getLevel());
                authority.setIntro(userRoleAuthority.getIntro());
                //统一处理
                authorities.add(authority);
            }
        } else {
            return Result.error("获取失败");
        }
        return Result.success(authorities);
    }


    @PostMapping("/update/authority")
    public Result updateAuthority(@RequestBody ReqAuthority ReqAuthority){

        if (ReqAuthority.getUser_id() != null && ReqAuthority.getAuthority_old()!=null && ReqAuthority.getAuthority_old()!=null) {
//        Integer user_id=authority.getUser_id();
//        Integer authority_old=authority.getAuthority_old();
//        Integer authority_new=authority.getAuthority_new();

            adminService.authority_update(ReqAuthority);
        } else {
            return Result.error("获取失败");
        }
        return Result.success("更新成功");
    }

    @PostMapping("/delete/authority")
    public Result deleteAuthority(@RequestBody ReqAuthority ReqAuthority) {

        if (ReqAuthority.getUser_id() != null && ReqAuthority.getAuthority_old() != null) {

            adminService.authority_delete(ReqAuthority.getUser_id(), ReqAuthority.getAuthority_old());
        } else {
            return Result.error("获取失败");
        }
        return Result.success("更新成功");
    }


    @GetMapping("/get/role")
    public Result getRole(){
        //获取角色
        User user = TokenUtils.getCurrentUser();

        //定义返回列表
        List<Role> roles = new ArrayList<>();

        List<User_Role_Authority> userRoleAuthorities = new ArrayList<>();

        if (user != null) {
            userRoleAuthorities = adminQueryUtils.queryAuthority("getRoles", user.getId());
            for (User_Role_Authority userRoleAuthority : userRoleAuthorities){
                Role role = new Role();
                role.setId(userRoleAuthority.getId());
                role.setName(userRoleAuthority.getName());
                role.setIntro(userRoleAuthority.getIntro());
                role.setIcon(userRoleAuthority.getIcon());
                role.setColor(userRoleAuthority.getColor());

                //统一处理
                roles.add(role);
            }
        } else {
            return Result.error("获取失败");
        }
        return Result.success(roles);

    }

    @GetMapping("/update/role")
    public Result updateRole(){
        //获取user_role
        User user = TokenUtils.getCurrentUser();
        List<User_Role_Authority> userRoleAuthorities = new ArrayList<>();

        if (user != null) {
            userRoleAuthorities = adminQueryUtils.queryAuthority("updateRoles", user.getId());
        }
        return null;
    }
}
