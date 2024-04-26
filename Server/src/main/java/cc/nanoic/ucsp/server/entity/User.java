package cc.nanoic.ucsp.server.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-03-30
 * @FileName: user_info
 **/

@Data
public class User {
    private Integer id;//序号
    private String user_name;//用户名
    private String password;//密码
    private Integer status;//状态
    private Integer phone;//电话
    private Integer email;//邮箱
    private Date registration_date;//注册时间
    private String token;//令牌
}
