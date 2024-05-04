package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.service.PostService;
import cc.nanoic.ucsp.server.service.TransmitService;
import jakarta.annotation.Resource;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class TransmitController {
    @Resource
    TransmitService TransmitService;


    //请求最新帖子输出（1次10条，首次为0）
    @AuthAccess
    @PostMapping("/transmit/time")
    public ArrayList<Post> transmit_time(Integer number){
        try {
            return TransmitService.time(number);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
