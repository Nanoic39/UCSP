package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.mapper.ButtonMapper;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * @FileName ButtonService
 * @Description
 * @Author fazhu
 * @date 2024-05-04
 **/
@Service
public class ButtonService {
    @Autowired
    ButtonMapper ButtonMapper;

    public void zan(Integer user_id, Integer post_id){
    }

    public void attendance(Integer user_id){
        Integer day=ButtonMapper.attendance_day(user_id);
        String type=ButtonMapper.attendance_month_day(user_id);
        day++;
        LocalDate date = LocalDate.now();
        if (type==null){
            type=""+date.getDayOfMonth();
        }else {
            type=type+","+date.getDayOfMonth();
        }
        ButtonMapper.attendance_status1(user_id);
        ButtonMapper.attendance_up(day,user_id, type);


    }

    /**
     * cron属性可以设置指定时间执行，cron表达式跟linux一样
     */
    @Scheduled(cron = "0 0 0 ? * *")
    public void fixTimeExecution() {
        ButtonMapper.attendance_status2();
    }



}
