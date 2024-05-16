package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Permissions;
import cc.nanoic.ucsp.server.entity.Post_Study;
import cc.nanoic.ucsp.server.mapper.PermissionMapper;
import cc.nanoic.ucsp.server.service.PermissionService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @FileName Permissions
 * @Description
 * @Author fazhu
 * @date 2024-05-15
 **/
@RestController
public class PermissionsController {//权限

    @Resource
    PermissionService permissionService;
    @Autowired
    PermissionMapper permissionMapper;

    @AuthAccess
    @PostMapping("/Permissions/select")//查询身份
    public Result Permissions_select(@RequestParam("user_id") Integer user_id){
        ArrayList<Permissions> Array= permissionService.select(user_id);
        return Result.success(Array);
    }


    @AuthAccess
    @PostMapping("/Permissions")//修改用户权限
    public Result studyInsert(@RequestBody Integer user_id) {

        permissionService.update(1,1,1);

        return Result.error();
    }
}
