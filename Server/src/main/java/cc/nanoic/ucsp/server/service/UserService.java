package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-03-30
 * @FileName: WebService
 **/

@Service
public class UserService {//登录 | 注册 | 注销 |
    @Autowired
    UserMapper userMapper;

    public User selectByUserName(User user) {
        User a= userMapper.selectByUserName(user.getAccount());//以账号获取密码
        if (a==null){//以邮箱获取密码
            a=userMapper.selectByEmail(user.getAccount());
        }
        if (a==null)return null;
       if(user.getPassword().equals(a.getPassword()))//获取的密码对比
       {//邮箱或密码登录传回信息
           if (userMapper.selectByUserName(user.getAccount())==null) return userMapper.selectByEmail(user.getAccount());
           return userMapper.selectByUserName(user.getAccount());
       }
        return null;
    }
    public void registerUser(User user){
        userMapper.registerUser(user.getAccount(),user.getPassword(),user.getPhone());
    }

    public User logout(User user){
        return userMapper.logoutUser(user.getId())
                ;}

    public boolean repeat(String repeat){
        System.out.println(userMapper.selectByUserName(repeat));
       if (userMapper.selectByUserName(repeat)!=null){
             return true;
       }
        return false;
    }
}
