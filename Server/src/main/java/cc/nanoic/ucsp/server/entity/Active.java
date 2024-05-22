package cc.nanoic.ucsp.server.entity;

import cn.hutool.core.date.DateTime;
import lombok.Data;

@Data
public class Active {
    private Integer snapped_id;  //活动id
    private String sponsor;  //活动发起人
    private String faculty_name;  //院系名
    private String grade_name;  //年级名
    private String active_name;  //活动名
    private Integer authority;//报名权限
    private Integer active_inventory;  //库存量
    private Integer goods_pre_sale_volume;  //预售量
    private String active_intro;//活动简介
    private String active_content;//活动详情内容
    private long startTime;
    private long eddTime;
    private DateTime start_date;  //开始时间
    private DateTime end_date;  //结束时间
}
