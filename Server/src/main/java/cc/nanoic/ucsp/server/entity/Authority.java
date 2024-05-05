package cc.nanoic.ucsp.server.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-04-27
 * @FileName: Authority
 **/
@Data
public class Authority {
    private Integer id;//自增id
    private String level;//权限
    private String intro;//简介
}
