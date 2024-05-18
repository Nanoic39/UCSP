package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.entityRequest.ReqAuthority;
import cc.nanoic.ucsp.server.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void authority_update(ReqAuthority ReqAuthority){
        adminMapper.authority_update(ReqAuthority.getUser_id(), ReqAuthority.getAuthority_old(), ReqAuthority.getAuthority_new());
    }
    public void authority_delete(Integer id,Integer authority_old ){
        adminMapper.authority_delete(id,authority_old);
    }

}
