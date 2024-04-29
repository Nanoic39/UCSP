package cc.nanoic.ucsp.server.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Countdown {//日期倒计时
    private  Integer id;//自增id
    private String holiday;//假期名字
    private Date time;//假期日期
}
