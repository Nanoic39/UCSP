/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-27 13:01:07
 * @LastEditTime: 2024-05-01 00:19:16
 * @FilePath:
 * @Describe: 
 */
package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Countdown;
import cc.nanoic.ucsp.server.entity.Holiday;
import cc.nanoic.ucsp.server.exception.ServiceException;
import cc.nanoic.ucsp.server.service.CountdownService;
import cn.hutool.core.date.DateTime;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.Date;


@RestController
public class CountdownController {
    @Resource
    CountdownService countdownService;

    @AuthAccess
    @PostMapping("/date")
    public Result dateSelect(@RequestBody Countdown countdown) {
        Holiday holidayDate = new Holiday();
        try {
            //模糊查询
            if (countdown.getType().equals("blur")) {
                holidayDate = countdownService.selectDateByDate(new Date());
            }
            //根据名称查询
            else if (countdown.getType().equals("accurate") && !countdown.getName().isEmpty()) {
                holidayDate = countdownService.selectDateByName(countdown.getName());
            }
            //异常
            else {
                throw new ServiceException("500", "请检查是否有此类型/参数是否齐全");
            }
        } catch (Exception e) {
            throw new ServiceException("500", "数据查询失败" + e.getMessage());
        }
        if (holidayDate != null) {
            return Result.success(holidayDate);
        } else {
            throw new ServiceException("500", "数据为空");
        }

    }

}
