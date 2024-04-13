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

    @AuthAccess
    @GetMapping("/indexCarousel")
    public List carousel(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("src","https://t.mwm.moe/pc/");
        jsonObject.put("intro","次元API");

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("id",2);
        jsonObject1.put("src","https://t.mwm.moe/fj");
        jsonObject1.put("intro","次元API随机");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("id",3);
        jsonObject2.put("src","http://www.98qy.com/sjbz/api.php");
        jsonObject2.put("intro","次元API随机图片");



        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        jsonObjects.add(jsonObject);
        jsonObjects.add(jsonObject1);
        jsonObjects.add(jsonObject2);

        return jsonObjects;
    }



}
