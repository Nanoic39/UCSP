package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.User_Info_Menu;
import cc.nanoic.ucsp.server.entity.User_Info;
import cc.nanoic.ucsp.server.entity.entity0.authority;
import cc.nanoic.ucsp.server.mapper.AdminMapper;
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
    AdminMapper adminMapper;

    public void authority_update(authority authority){
        adminMapper.authority_update(authority.getUser_id(),authority.getAuthority_old(),authority.getAuthority_new());
    }
    public void authority_delete(Integer id,Integer authority_old ){
        adminMapper.authority_delete(id,authority_old);
    }

}
