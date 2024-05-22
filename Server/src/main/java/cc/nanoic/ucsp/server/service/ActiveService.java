package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.Active1;
import cc.nanoic.ucsp.server.mapper.ActiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * @FileName ActiveServicer
 * @Description
 * @Author fazhu
 * @date 2024-05-19
 **/
@Service
public class ActiveService {
    @Autowired
    ActiveMapper activeMapper;

    public void insert(Active1 active){
        Date date = new Date();
        active.setCreat_time(date);
        active.setUpdate_time(date);

        activeMapper.insert(active.getSponsor(),
                active.getActive_name(),active.getActive_start_time(),
                active.getActive_end_time(), active.getActive_range(),
                active.getAuthority(),active.getRegister_start_time(),
                active.getRegister_end_time(), active.getNum(),
                active.getActive_intro(), active.getActive_content(),
                active.getCreat_time(), active.getUpdate_time());
    }
    public void delete(Integer active_id) {
        activeMapper.delete(active_id);
    }
    public void update_delete(Integer active_id){
        activeMapper.update_delete(active_id);
    }

    public void update(Active1 active){
        Date date = new Date();
        active.setUpdate_time(date);
        activeMapper.update(
                active.getId(),
                active.getActive_name(),active.getActive_start_time(),
                active.getActive_end_time(), active.getActive_range(),
                active.getAuthority(),active.getRegister_start_time(),
                active.getRegister_end_time(), active.getNum(),
                active.getActive_intro(), active.getActive_content(),
                active.getUpdate_time());
    }

    public ArrayList<Active1> get_id(Integer num){
       Integer max_id=activeMapper.max_id();
        System.out.println("max_id="+max_id);
        int i=max_id - num*10;
        ArrayList<Active1> active=new ArrayList();
       for(int o=0;o<10;o++){

           active.add(activeMapper.get_id(i));
           i-=1;
       }
return active;
    }

}
