package cc.nanoic.ucsp.server.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @Description:
 * @Author: yrpyy
 * @Date: 2024-04-26
 * @FileName: User_Menu
 **/

@Data
public class User_Menu {
    private int id;
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
