package cc.nanoic.ucsp.server.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-04-27
 * @FileName: Role_Authority
 **/
@Data
public class Role_Authority {
    private Integer id;//自增id
    private Integer role_id;//角色id
    private Integer authority_id;//权限id
}
