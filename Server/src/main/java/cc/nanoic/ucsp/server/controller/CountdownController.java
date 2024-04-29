package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.entity.Countdown;
import cc.nanoic.ucsp.server.service.CountdownService;
import cc.nanoic.ucsp.server.utils.ConnInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.Date;




@RestController
public class CountdownController {
    @Resource
    CountdownService countdownService;

    @AuthAccess
    @PostMapping("/date")
    public int select(String holiday, Date time){

        ConnInfo a=new ConnInfo();


        System.out.println(a);
        return 0;
    }


}
