package cc.nanoic.ucsp.server.entity;

import lombok.Data;

import java.math.BigInteger;


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
    private Object enlists_start_date;  //开始时间戳
    private Long enlists_end_date;  //结束时间戳
    private BigInteger began_start_date;  //开始时间戳
    private Long began_end_date;  //结束时间戳
}
