package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.User_Info_Menu;
import cc.nanoic.ucsp.server.entity.User_Menu;
import cc.nanoic.ucsp.server.entity.User_Info;
import cc.nanoic.ucsp.server.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-03-30
 * @FileName: AdminService
 **/

@Service
public class AdminService {

    @Autowired
    UserMapper userMapper;

    //权限查询
    public String queryAuthority (Integer id){return userMapper.queryAuthorityLevel(id);}

    //查询菜单
    public List<User_Info_Menu> queryMenu(String level){return userMapper.queryMenu(level);}

    //查询用户资料
    public List<User_Info_Menu> queryInfo(Integer id){return userMapper.queryInfo(id);}
}
