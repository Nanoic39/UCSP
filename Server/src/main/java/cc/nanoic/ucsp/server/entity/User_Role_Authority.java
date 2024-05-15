package cc.nanoic.ucsp.server.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-04-27
 * @FileName: User_Role_Authority
 **/
@Data
public class User_Role_Authority {
    private Integer id;//用户唯一ID
    private Integer user_id;//用户id
    private Integer role_id;//角色id
    private Integer authority_id;//权限id
    private String name;//名称
    private String intro;//简介
    private String icon;//图标
    private String color;//颜色
    private String level;//权限
    private Integer parent_id;//该菜单的父级菜单id
    private String path;//菜单路径
    private String file_path;//菜单文件路径
    private String auth;//所需权限
    private String sort;//菜单排序
    private String status;//菜单状态
    private Date creat_time;//创建时间
    private Date update_time;//更新时间
}
