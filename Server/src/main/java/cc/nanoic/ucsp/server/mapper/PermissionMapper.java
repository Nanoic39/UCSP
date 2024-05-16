package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Permissions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;


/**
 * @FileName PermissionMapper
 * @Description
 * @Author fazhu
 * @date 2024-05-15
 **/

@Mapper
public interface PermissionMapper {
    //查询用户ID所对应的身份ID
    @Select("select role_id from `user_role`where user_id=#{id} ")
    ArrayList<Integer> select(@Param("id")Integer id);
    //查询身份id对应的身份
    @Select("select * from `role` where id=#{id}")
    Permissions select_role(@Param("id") Integer id);

//    //修改身份
    @Update("update user_role set role_id=#{permissions2} where user_id=#{id} and role_id=#{permissions1} ")
    void update(@Param("permissions2")Integer permissions2,
                @Param("permissions2")Integer permissions1,
                @Param("id") Integer id
                );

}
