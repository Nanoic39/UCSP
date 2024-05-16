package cc.nanoic.ucsp.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @FileName PermissionMapper
 * @Description
 * @Author fazhu
 * @date 2024-05-15
 **/

@Mapper
public interface PermissionMapper {
    @Select("select * from `user_role`where id=#{id} ")
    int select(@Param("id")Integer id);

}
