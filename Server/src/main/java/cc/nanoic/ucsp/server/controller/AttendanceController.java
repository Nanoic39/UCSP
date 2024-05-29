package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.entityRequest.ReqUser_Id;
import cc.nanoic.ucsp.server.mapper.AttendanceMapper;
import cc.nanoic.ucsp.server.service.AttendanceService;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Utilities;

import static cc.nanoic.ucsp.server.utils.TokenUtils.getCurrentUser;


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
    public Result attendance(){
      User user= TokenUtils.getCurrentUser();
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

            throw new RuntimeException(e);
        }}

    /**
     * 读取签到数据
     * @param :user_id
     * @return attendance格式的签到信息
      */
    @AuthAccess
    @PostMapping("/button/select_attendance")
    public Result select_attendance(){
        User user= TokenUtils.getCurrentUser();
        Integer user_id=user.getId();
        try {
            if (user_id!=null){
               return Result.success(AttendanceMapper.attendance(user_id));
            }
          return Result.error("读取失败");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

