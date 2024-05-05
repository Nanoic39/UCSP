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
    private Integer id;//用户唯一ID
    private String nickname;//昵称
    private int sex;//性别
    private int age;//年龄
    private String profile;//个人简介
    private Date birthday;//生日
    private String avatar;//头像
    private String profileImage;//个人主页背景
}
