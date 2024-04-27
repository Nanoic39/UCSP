package cc.nanoic.ucsp.server.utils;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.entity.User_Info_Menu;
import cc.nanoic.ucsp.server.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

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

    /**
     *
     *
     * @return
     */
    @AuthAccess
    @PostMapping("/authority")
    public List<User_Info_Menu> queryAuthority(String type, Integer id){
        try {
            if (type.equals("getMenu")){
                String level = adminService.queryAuthority(id);
                return adminService.queryMenu(level);
            }else if (type.equals("getInfo")){
                return adminService.queryInfo(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
