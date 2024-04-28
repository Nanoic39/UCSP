package cc.nanoic.ucsp.server.test;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-04-05
 * @FileName: testAPI
 **/
@RestController
public class testAPI {//页面图片

	//API

    @AuthAccess
    @GetMapping("/getPhone")
    public Result carousel() {


    return  Result.success();
    }


}
