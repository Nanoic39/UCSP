package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Post_Study;
import cc.nanoic.ucsp.server.service.PermissionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @AuthAccess
    @PostMapping("/Permissions")//修改用户权限
    public Result studyInsert(@RequestBody Integer user_id) {
        permissionService.update();
        return Result.error();
    }
}
