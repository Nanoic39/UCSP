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
    Integer id;
    Integer user_id;
    Integer day;
    String month_day;
    Integer status;
}
