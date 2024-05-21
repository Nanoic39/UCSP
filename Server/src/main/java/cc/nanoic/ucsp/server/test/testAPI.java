package cc.nanoic.ucsp.server.test;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Confignature;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.entityRequest.ReqRedis;
import cc.nanoic.ucsp.server.utils.RedisUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-04-05
 * @FileName: testAPI
 **/
@RestController
public class testAPI {//页面图片

    //API
    @Autowired
    private Confignature confignature;

    @Resource
    RedisUtils redisUtils;


    @AuthAccess
    @PostMapping("/test")
    public Result carousel() {

        return Result.success();

    }

    @AuthAccess
    @PostMapping("/redisSet")
    public Result redis_set(@RequestBody ReqRedis reqRedis) {
        System.out.println(reqRedis);
        redisUtils.set(reqRedis.getName(), reqRedis.getValue());
        return Result.success();
    }

    @AuthAccess
    @PostMapping("/redisGet")
    public Result redis_get(@RequestBody ReqRedis reqRedis) {
        Object obj = redisUtils.get(reqRedis.getName());
        return Result.success(obj);
    }


}
