package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Attendance;
import cc.nanoic.ucsp.server.mapper.ButtonMapper;
import cc.nanoic.ucsp.server.service.ButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * @FileName ButtonController
 * @Description 各种按钮小功能
 * @Author fazhu
 * @date 2024-05-04
 **/
@RestController
public class ButtonController {
    @Autowired
    ButtonService ButtonService;
    @Autowired
    ButtonMapper ButtonMapper;

    @AuthAccess
    @PostMapping("/button/zan")
    public Result zan(Integer user_id, Integer post_id){
        if (user_id!=null&&post_id!=null){
        }
        return Result.success();
    }
    /**
     * 签到
     * @param user_id
      */

    @AuthAccess
    @PostMapping("/button/attendance")
    public Result attendance(Integer user_id){
        try {
            if (user_id!=null){
                if (ButtonMapper.attendance_status(user_id)){
                    return Result.error("今天已经签过到了");
                }
                ButtonService.attendance(user_id);
            }
            return Result.success("签到成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }}

    /**
     * 读取签到数据
     * @param user_id
      */
    @AuthAccess
    @PostMapping("/button/select_attendance")
    public Result select_attendance(Integer user_id){
        try {
            if (user_id!=null){
               Attendance a= ButtonMapper.attendance(user_id);
               return Result.success(ButtonMapper.attendance(user_id));
            }
          return Result.error("读取失败");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}

