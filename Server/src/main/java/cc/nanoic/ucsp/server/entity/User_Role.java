package cc.nanoic.ucsp.server.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-04-27
 * @FileName: User_Role
 **/

@Data
public class User_Role {
    private Integer id;//自增id
    private Integer user_id;//用户id
    private Integer role_id;//角色id
}
