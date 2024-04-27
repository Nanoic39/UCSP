package cc.nanoic.ucsp.server.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @Description:
 * @Author: yrpyy
 * @Date: 2024-04-27
 * @FileName: User_Info_Menu
 **/
@Data
public class User_Info_Menu {
    private Integer id;
    private String nickname;
    private int sex;
    private int age;
    private String profile;
    private Date birthday;
    private String avatar;
    private String profileImage;
    private int parent_id;
    private String menu_name;
    private String icon;
    private String path;
    private String level;
    private String sort;
    private String status;
    private Date creat_time;
    private Date update_time;
}
