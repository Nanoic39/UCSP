package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 用户Controller
 * @Author: Nanoic
 * @Date: 2024-03-30
 * @FileName: WebController
 **/

@RestController
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("/ping")
    public Result PING(){
        return Result.success();
    }

    @PostMapping("/register")
    public Result register(){
        return Result.success();
    }


}
