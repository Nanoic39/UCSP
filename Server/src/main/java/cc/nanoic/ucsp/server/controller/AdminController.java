package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

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
}
