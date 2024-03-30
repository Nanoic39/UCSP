package cc.nanoic.ucsp.server.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-03-30
 * @FileName: user_info
 **/

@Data
public class User {
    private Integer id;
    private String user_name;
    private String password;
    private Integer is_active;
    private Integer phone;
    private Integer email;
    private String token;
}
