package cc.nanoic.ucsp.server.entity;

import lombok.Data;

import java.util.Date;

/**
 * @FileName Acttive
 * @Description
 * @Author fazhu
 * @date 2024-05-19
 **/
@Data
public class Active1 {
    private Integer id; //id
    private String sponsor;//发起人
    private String active_name;//活动名
    private Date active_start_time;//活动开始时间
    private Date active_end_time;//活动结束时间
    private String active_range;//活动范围
    private Integer authority;//报名权限
    private Date register_start_time;//报名开始时间
    private Date register_end_time;//报名结束时间
    private Integer num;//名额
    private String active_intro;//活动简介
    private String active_content;//活动详情内容
    private Date creat_time;//创建时间
    private Date update_time;//修改时间
}
