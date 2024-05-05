package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
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
    public Result transmit_time(String type, Integer number){
        try {
            if (type!=null&&number!=null) {
                return Result.success(TransmitService.time(type, number));
            }
            return Result.error("数据不全");
        } catch (Exception e) {
            return Result.error("服务器错误");
        }

    }
}
