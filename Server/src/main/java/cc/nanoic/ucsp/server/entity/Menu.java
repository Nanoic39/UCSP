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
public class Menu {
    private Integer id;//用户唯一ID
    private Integer parent_id;//该菜单的父级菜单id
    private String name;//该菜单的父级菜单id
    private String path;//菜单路径
    private String icon;//该菜单的父级菜单id
    private String auth;//所需权限
    private String level;//菜单层级
    private String sort;//菜单排序
    private String status;//菜单状态
    private Date creat_time;//创建时间
    private Date update_time;//更新时间
}
