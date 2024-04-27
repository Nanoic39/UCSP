package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.User_Info_Menu;
import cc.nanoic.ucsp.server.entity.User_Menu;
import cc.nanoic.ucsp.server.service.AdminService;
import cc.nanoic.ucsp.server.utils.AdminQueryUtils;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    AdminQueryUtils adminQueryUtils;

    @AuthAccess
    @PostMapping("/queryUserMenu")
    //菜单查询
    public List<User_Menu> query(){
        User user = TokenUtils.getCurrentUser();
        User_Menu userMenu = null;
        List<User_Menu> UM = null;
        List<User_Info_Menu> UIM = adminQueryUtils.queryAuthority("getMenu",user.getId());
        for (int i=0;i< UIM.size();i++){
            userMenu.setId(UIM.get(i).getId());
            userMenu.setParent_id(UIM.get(i).getParent_id());
            userMenu.setMenu_name(UIM.get(i).getMenu_name());
            userMenu.setIcon(UIM.get(i).getIcon());
            userMenu.setPath(UIM.get(i).getPath());
            userMenu.setLevel(UIM.get(i).getLevel());
            userMenu.setSort(UIM.get(i).getSort());
            userMenu.setStatus(UIM.get(i).getStatus());
            userMenu.setCreat_time(UIM.get(i).getCreat_time());
            userMenu.setUpdate_time(UIM.get(i).getUpdate_time());
            UM.add(i,userMenu);
        }
        return UM;
    }
}
