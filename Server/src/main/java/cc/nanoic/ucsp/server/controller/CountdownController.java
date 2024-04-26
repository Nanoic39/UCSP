package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Countdown;
import cc.nanoic.ucsp.server.service.CountdownService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CountdownController {
    @Resource
    CountdownService countdownService;

    @AuthAccess
    @PostMapping("/date")
    public Countdown select(String holiday, Date time){
        if (holiday!=null){
            Countdown countdown = new Countdown();

            countdown.setHoliday(holiday);
            countdown.setTime(time);

            Countdown count;
           count=countdownService.selectDate(countdown);
            return count;
        }
        Countdown count=new Countdown();

        return count;
    }


}
