package cc.nanoic.ucsp.server.entity;

import cn.hutool.core.date.DateTime;
import lombok.Data;

import java.util.Date;

@Data
public class Holiday {//日期倒计时
    private Integer id;//自增id
    private String name;//假期名字
    private Date date;//假期日期
}
