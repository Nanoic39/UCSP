package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;

import cc.nanoic.ucsp.server.entity.Authority;
import cc.nanoic.ucsp.server.entity.Menu;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.User_Role_Authority;
import cc.nanoic.ucsp.server.entity.entity0.User_ID;
import cc.nanoic.ucsp.server.entity.entity0.authority;
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
    //菜单查询
    public Result query(){
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

    @AuthAccess
    @PostMapping("/update/authority")
    public Result updateAuthority(@RequestBody authority authority){

        if (authority.getUser_id() != null && authority.getAuthority_old()!=null && authority.getAuthority_old()!=null) {
//        Integer user_id=authority.getUser_id();
//        Integer authority_old=authority.getAuthority_old();
//        Integer authority_new=authority.getAuthority_new();

            adminService.authority_update(authority);
        } else {
            return Result.error("获取失败");
        }
        return Result.success("更新成功");
    }
    @AuthAccess
    @PostMapping("/delete/authority")
    public Result deleteAuthority(@RequestBody  authority authority){

        if (authority.getUser_id()!= null && authority.getAuthority_old()!=null ) {

            adminService.authority_delete(authority.getUser_id(),authority.getAuthority_old());
        } else {
            return Result.error("获取失败");
        }
        return Result.success("更新成功");
    }
}
