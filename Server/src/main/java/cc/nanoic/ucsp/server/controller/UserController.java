package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.User_Desen;
import cc.nanoic.ucsp.server.service.UserService;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/ping")//第1个是连接通畅性测试，所以只要能返回成功，就证明连接通畅，

    public Result PING() {
        return Result.success();
    }



    @AuthAccess
    @PostMapping("/login")//登录
    public Result login(String account, String password) {
        try {
            if (account != null && password != null) {
                User user = new User();
                user.setAccount(account);
                user.setPassword(password);
                User dbUser = userService.selectByUserName(user);//从数据库匹配账号密码

                if (dbUser != null) {//如果这个人存在则发令牌
                    String token = TokenUtils.createToken(dbUser.getAccount().toString(), dbUser.getPassword());

                    User_Desen resUser = new User_Desen();
                    resUser.setId(dbUser.getId());
                    resUser.setAccount(dbUser.getAccount());
                    resUser.setToken(token);
                    return Result.success(resUser);
                } else {
                    return Result.error("600","没有此用户");
                }

            } else {
                return Result.error("401", "账号或密码不能为空");
            }
        } catch (Exception e) {
            return Result.error("服务器内部错误");
        }
    }

    //注册
    @AuthAccess
    @PostMapping("/userinsert")
    public Result insert(@RequestBody User user){
        System.out.println((user));
        try{

            if (user.getAccount() !=null&& user.getPassword() !=null&& user.getPhone() !=null){
                userService.registerUser(user);
                return Result.success("注册成功");
            }return Result.error("401","不得为空");

        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }


}
