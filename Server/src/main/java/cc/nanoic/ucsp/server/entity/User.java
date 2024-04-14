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
    private Integer id;//账号
    private String user_name;//用户名
    private String password;//密码
    private Integer is_active;//状态
    private Integer phone;//电话
    private Integer email;//邮箱
    private String token;//令牌
}
