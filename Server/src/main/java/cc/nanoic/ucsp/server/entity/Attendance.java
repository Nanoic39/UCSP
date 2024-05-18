package cc.nanoic.ucsp.server.entity;

import lombok.Data;

/**
 * @FileName Attendance
 * @Description
 * @Author fazhu
 * @date 2024-05-05
 **/
@Data
public class Attendance {
    private Integer id;//id
    private Integer user_id;//角色名
    private Integer day;//连续签到天数
    private String month_day;//一个月签到的日期
    private Integer status;//状态
}
