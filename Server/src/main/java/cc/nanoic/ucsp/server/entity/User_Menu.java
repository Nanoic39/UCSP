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
    private Integer id;//用户唯一ID
    private int parent_id;//该菜单的父级菜单id
    private String menu_name;//该菜单的父级菜单id
    private String icon;//该菜单的父级菜单id
    private String path;//菜单路径
    private String level;//菜单层级
    private String sort;//菜单排序
    private String status;//菜单状态(0/1)
    private Date creat_time;//创建时间
    private Date update_time;//更新时间
}
