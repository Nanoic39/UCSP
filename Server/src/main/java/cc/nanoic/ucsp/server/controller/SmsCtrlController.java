package cc.nanoic.ucsp.server.controller;

/**
 * @FileName SmsCtrlController
 * @Description
 * @Author fazhu
 * @date 2024-05-13
 **/
import cc.nanoic.ucsp.server.service.RedisService;
import cc.nanoic.ucsp.server.utils.CodeUtil;
import cc.nanoic.ucsp.server.utils.SmsTool;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.utils.StringUtils;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/sms")
public class SmsCtrlController {


    /***
     * 注入redis模版
     */
    @Resource
    private RedisService redisService;
    private  String tokenId="TOKEN-USER-";


    /**
     * 发送短信
     * @ResponseBody 返回json数据
     * @RequestMapping 拦截请求，指定请求类型：POST
     * @RequestBody 接受前台传入的json数据 接受类型为Map
     * @throws ClientException 抛出异常
     */
    @ResponseBody
    @RequestMapping(value = "/smsXxs", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String,Object> smsXxs(@RequestBody Map<String,Object> requestMap,HttpServletRequest request) throws ClientException {
        Map<String,Object> map = new HashMap<>();
        String phone = requestMap.get("phoneNumber").toString();
        // 调用工具栏中生成验证码方法（指定长度的随机数）
        String code = CodeUtil.generateVerifyCode(6);
        //填充验证码
        String TemplateParam = "{\"code\":\""+code+"\"}";
        SendSmsResponse response = SmsTool.sendSms(phone,TemplateParam);//传入手机号码及短信模板中的验证码占位符

        map.put("verifyCode",code);
        map.put("phone",phone);
        request.getSession().setAttribute("CodePhone",map);
        if( response.getCode().equals("OK")) {
            map.put("isOk","OK");
            //验证码绑定手机号并存储到redis
            redisService.set(tokenId+phone,code);
            redisService.expire(tokenId+phone,620);//调用reids工具类中存储方法设置超时时间
        }
        return map;
    }


    /**
     * 注册验证
     * @ResponseBody 返回json数据
     * @RequestMapping 拦截请求，指定请求类型：POST
     * @RequestBody 接受前台传入的json数据 接受类型为Map
     * @throws ClientException 抛出异常
     */
    @ResponseBody
    @RequestMapping(value = "/validateNum", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> validateNum(@RequestBody Map<String,Object> requestMap) throws ClientException {

        Map<String,Object> map = new HashMap<>();
        String phone = requestMap.get("phone").toString();//获取注册手机号码
        String verifyCode = requestMap.get("verifyCode").toString();//获取手机验证码

        //首先比对验证码是否失效
        String redisauthcode= redisService.get(tokenId+phone); //传入tonkenId返回redis中的value
        if(StringUtils.isEmpty(redisauthcode)){
            //如果未取到则过期验证码已失效
            map.put("ruselt",404);
        }else  if(!"".equals(redisauthcode)&&!verifyCode.equals(redisauthcode)){
            //验证码错误
            map.put("ruselt",500);
        }else{
            //用户注册成功
            map.put("ruselt",200);
        }
        return map;
    }


}