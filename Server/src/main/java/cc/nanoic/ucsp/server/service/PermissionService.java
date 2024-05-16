package cc.nanoic.ucsp.server.service;



import cc.nanoic.ucsp.server.entity.Permissions;
import cc.nanoic.ucsp.server.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @FileName Permissionservice
 * @Description
 * @Author fazhu
 * @date 2024-05-15
 **/

@Service
public class PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    //更新
    public void update(Integer id,Integer permissions1,Integer permissions2){

    }

    //查询身份
    public ArrayList<Permissions> select(Integer user_id) {
        ArrayList<Integer> Array = new ArrayList<>();//身份ID
        ArrayList<Permissions> Array2=new ArrayList<>();//转化为身份
        Array = permissionMapper.select(user_id);
        System.out.println(Array);

        for (int i = 0; i < Array.size(); i++) {
            int element = Array.get(i);
            System.out.println(permissionMapper.select_role(element));
            Array2.add(permissionMapper.select_role(element));
        }
        System.out.println(Array2);
        return Array2;
    }
}
