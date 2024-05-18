package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.entity0.User_ID;
import cc.nanoic.ucsp.server.mapper.AttendanceMapper;
import cc.nanoic.ucsp.server.service.AttendanceService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @FileName AttendanceController
 * @Description 签到
 * @Author fazhu
 * @date 2024-05-04
 **/
@RestController
public class AttendanceController {
    @Resource
    AttendanceService AttendanceService;
    @Resource
    AttendanceMapper AttendanceMapper;

    /**
     * 签到
     * @param : user_id
      */
    @AuthAccess
    @PostMapping("/button/attendance")
    public Result attendance(@RequestBody User_ID user){
        System.out.println("1");
        Integer user_id=user.getId();
        try {
            if (user_id!=null){
                if (AttendanceMapper.attendance_status(user_id)){
                    return Result.error("今天已经签过到了");
                }
                AttendanceService.attendance(user_id);

            }
            return Result.success("签到成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }}

    /**
     * 读取签到数据
     * @param :user_id
     * @return attendance格式的签到信息
      */
    @AuthAccess
    @PostMapping("/button/select_attendance")
    public Result select_attendance(@RequestBody User_ID user){
        System.out.println(user);
        Integer user_id=user.getId();
        try {
            if (user_id!=null){
               return Result.success(AttendanceMapper.attendance(user_id));
            }
          return Result.error("读取失败");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}

