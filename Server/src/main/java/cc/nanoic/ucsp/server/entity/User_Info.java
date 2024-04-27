package cc.nanoic.ucsp.server.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @Description:
 * @Author: yrpyy
 * @Date: 2024-04-26
 * @FileName: User_info
 **/

@Data
public class User_Info {
    private Integer id;
    private String nickname;
    private int sex;
    private int age;
    private String profile;
    private Date birthday;
    private String avatar;
    private String profileImage;
}
