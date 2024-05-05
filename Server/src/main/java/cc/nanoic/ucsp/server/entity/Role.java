package cc.nanoic.ucsp.server.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-04-27
 * @FileName: Role
 **/

@Data
public class Role {
    private Integer id;//自增主键
    private String name;//名称
    private String intro;//简介
    private String icon;//图标
    private String color;//颜色
}
