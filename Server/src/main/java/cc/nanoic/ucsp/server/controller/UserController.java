package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.*;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.User_Desen;
import cc.nanoic.ucsp.server.mapper.AttendanceMapper;
import cc.nanoic.ucsp.server.service.UserService;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import jakarta.annotation.Resource;

import jakarta.servlet.http.HttpServletRequest;
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
    @Resource
    AttendanceMapper attendanceMapper;


    @AuthAccess
    @GetMapping("/ping")//第1个是连接通畅性测试，所以只要能返回成功，就证明连接通畅，
    public Result PING() {
        return Result.success();
    }

    @AuthAccess
    @PostMapping("/login")//登录

    public Result login(@RequestBody User param_user) {
        String account = param_user.getAccount();
        String password = param_user.getPassword();
        try {
//            String account = paramUser.getAccount();
//            String password = paramUser.getPassword();
            System.out.println(account+"||"+password);
            if (account != null && password != null) {
                User user = new User();
                user.setAccount(account);
                user.setPassword(password);

                User dbUser = userService.selectByUserName(user);//从数据库匹配账号密码
                System.out.println(dbUser);
                if(dbUser.getStatus()<0){
                    return Result.error("700","该账号已被封禁");
                }
                if (dbUser != null) {//如果这个人存在则发令牌
                    String token = TokenUtils.createToken(dbUser.getAccount().toString(), dbUser.getPassword());
                    User_Desen resUser = new User_Desen();
                    resUser.setId(dbUser.getId());
                    resUser.setAccount(dbUser.getAccount());
                    resUser.setToken(token);
                    return Result.success(resUser);
                } else  {
                    return Result.error("600","账号密码错误");
                }
            } else {
                return Result.error("401", "账号或密码不能为空");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("服务器内部错误");
        }
    }

    //注册
//    @LimitRequest(count = 3,time = 20000)
    @InterfaceLimit(time = 6000,value = 3)
    @AuthAccess
    @PostMapping("/register")
    public Result insert(@RequestParam("account") String account,
                         @RequestParam("password") String password,
                         @RequestParam("phone") String phone){
        try{
            if (account !=null&& password !=null&& phone !=null){
                if(userService.repeat(account)){
                    return Result.error("该用户名已被注册");
                }
                userService.registerUser(account,password,phone);//注册
                attendanceMapper.attendance_In(attendanceMapper.last_id(account)); //加入签到表
                userService.role(attendanceMapper.last_id(account));//加入role表
                return Result.success("注册成功");
            }return Result.error("401","不得为空");
        }catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    //注销
    @AuthAccess
    @PostMapping("/logout")
    public Result logout(@RequestBody HttpServletRequest request){
        String token = request.getHeader("token");
        try {
            if (token!=null){
                User user = TokenUtils.getCurrentUser();
                userService.logout(user);
                return Result.success("注销成功");
            }
            return Result.error("注销失败,token出现问题");
        } catch (Exception e) {
            return Result.error("服务器内部错误");
        }
    }

}
