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
        return userMapper.selectByUserName(user.getAccount());
    }

    public void registerUser(User user){
        userMapper.registerUser(user.getAccount(),user.getPassword(),user.getPhone());
    }

    public User logout(User user){return userMapper.logoutUser(user.getId());}
}
