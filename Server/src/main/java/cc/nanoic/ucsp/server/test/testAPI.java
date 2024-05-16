package cc.nanoic.ucsp.server.test;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Confignature;
import cc.nanoic.ucsp.server.common.Result;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


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


    @AuthAccess
    @PostMapping("/test")
    public Result carousel() {
        
        return Result.success();

    }


}
