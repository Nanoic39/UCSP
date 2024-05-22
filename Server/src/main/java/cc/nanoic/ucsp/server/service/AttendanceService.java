package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.mapper.AttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.time.LocalDate;

/**
 * @FileName ButtonService
 * @Description
 * @Author fazhu
 * @date 2024-05-04
 **/
@Service
public class AttendanceService {
    @Autowired
    AttendanceMapper AttendanceMapper;

    //签到
    public void attendance(Integer user_id){
        Integer day= AttendanceMapper.attendance_day(user_id);
        String type= AttendanceMapper.attendance_month_day(user_id);
        day++;
        LocalDate date = LocalDate.now();
        if (type==""){
            type=""+date.getDayOfMonth();
        }else {
            type=type+","+date.getDayOfMonth();
        }
        AttendanceMapper.attendance_status1(user_id);
        AttendanceMapper.attendance_up(day,user_id, type);
    }

    /**
     * cron属性可以设置指定时间执行，cron表达式跟linux一样
     */
    @Scheduled(cron = "1 0 0 ? * *")//每日清零
    public void fixTimeExecution_day() {
        try{
            AttendanceMapper.attendance_status3();
            AttendanceMapper.attendance_status2();
            System.out.println("每日清零完成");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @Scheduled(cron = "0 0 0 1 * *")//每月清零
    public void fixTimeExecution_month() {
        AttendanceMapper.attendance_status4();
    }



}
