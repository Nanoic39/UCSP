package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.User_Desen;
import cc.nanoic.ucsp.server.service.UserService;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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

    @PostMapping("/register")//还没开始写，所以暂时先用返回成功占个位
    public Result register() {
        return Result.success();
    }

    @AuthAccess
    @PostMapping("/login")//登录
    public Result login(String username, String password) {
        try {
            if (username != null && password != null) {
                User user = new User();
                user.setUser_name(username);
                user.setPassword(password);
                User dbUser = userService.selectByUserName(user);//从数据库匹配账号密码

                if (dbUser != null) {//如果这个人存在则发令牌
                    String token = TokenUtils.createToken(dbUser.getUser_name().toString(), dbUser.getPassword());
                    User_Desen resUser = new User_Desen();
                    resUser.setId(dbUser.getId());
                    resUser.setUser_name(dbUser.getUser_name());
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
        /*return Result.success();*/
    }

    //注册
    @AuthAccess
    @PostMapping("/insert")
    public Result insert(Integer id,String user_name,String password,Integer phone){
      try{  if (id != null&&user_name !=null&&password!=null&&phone!=null){
            User user=new User();
            user.setId(id);
            user.setUser_name(user_name);
            user.setPassword(password);
            user.setPhone(phone);
            userService.insertUser(user);
            return Result.success("注册成功");
        }return Result.error("注册失败");
    }catch (Exception e) {
            return Result.error("服务器内部错误");
        }
    }





}
