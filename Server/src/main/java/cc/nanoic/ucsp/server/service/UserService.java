package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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
        User a = userMapper.selectByUserName(user.getAccount());//以账号获取密码

        if (a == null){//以电话获取密码
            a = userMapper.selectByPhone(user.getAccount());
        }
        if (a == null)return null;
       if(user.getPassword().equals(a.getPassword()))//获取的密码对比
       {//邮箱或密码登录传回信息
           if (userMapper.selectByUserName(user.getAccount())==null) return userMapper.selectByPhone(user.getAccount());
           return userMapper.selectByUserName(user.getAccount());
       }
        return null;
    }
    public User selectByUser(User user) {
        User a = userMapper.selectByUserName(user.getAccount());//以账号获取密码


        if (a == null)return null;

//           if (userMapper.selectByUserName(user.getAccount())==null) return userMapper.selectByPhone(user.getAccount());
           return userMapper.selectByUserName(user.getAccount());


    }

    public void registerUser(String account,String password,String phone){
        userMapper.registerUser(account,password,phone);
    }

    public User logout(User user){
        return userMapper.logoutUser(user.getId());
    }

    public boolean repeat(String repeat){
       if (userMapper.selectByUserName(repeat)!=null){
             return true;
       }
        return false;
    }



    @Async
    public void role(Integer id){
        userMapper.insert_role(id);
    }


}
