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
    private Integer id;//用户唯一ID
    private String nickname;//昵称
    private int sex;//性别
    private int age;//年龄
    private String profile;//个人简介
    private Date birthday;//生日
    private String avatar;//头像
    private String profileImage;//个人主页背景
    private int parent_id;//该菜单的父级菜单id
    private String menu_name;//该菜单的父级菜单id
    private String icon;//该菜单的父级菜单id
    private String path;//菜单路径
    private String file_path;//菜单文件路径
    private String level;//菜单层级
    private String sort;//菜单排序
    private String status;//菜单状态(0/1)
    private Date creat_time;//创建时间
    private Date update_time;//更新时间
}
