package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Menu;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.User_Info_Menu;
import cc.nanoic.ucsp.server.entity.User_Role_Authority;
import cc.nanoic.ucsp.server.service.AdminService;
import cc.nanoic.ucsp.server.utils.AdminQueryUtils;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/queryMenu")
    //菜单查询
    public Result query(){
        User user = TokenUtils.getCurrentUser();

        Menu menu = new Menu();
        List<Menu> menus = new ArrayList<>();
        List<User_Role_Authority> UIM;
        if (user != null) {
            UIM = adminQueryUtils.queryAuthority("getMenu",user.getId());
            if(UIM != null){
                for (User_Role_Authority userRoleAuthority : UIM){
                    menu.setId(userRoleAuthority.getId());
                    menu.setParent_id(userRoleAuthority.getParent_id());
                    menu.setName(userRoleAuthority.getName());
                    menu.setPath(userRoleAuthority.getPath());
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
}
