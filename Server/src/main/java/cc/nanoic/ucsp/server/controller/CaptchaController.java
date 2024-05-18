package cc.nanoic.ucsp.server.controller;
/**
 * @FileName SampleController
 * @Description
 * @Author fazhu
 * @date 2024-05-18
 **/

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Confignature;
import cc.nanoic.ucsp.server.common.Result;

import cc.nanoic.ucsp.server.entity.entity0.Phone;
import cc.nanoic.ucsp.server.service.RedisService;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.*;


import com.aliyun.teaopenapi.models.Config;
import jakarta.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.PostConstruct;

import static cc.nanoic.ucsp.server.utils.ValidateCodeUtils.generateValidateCode;

@RestController
public class CaptchaController {//验证码

    @Resource
    RedisService redisService;

    @Resource
    Confignature confignature;

   String AccessKey_ID = confignature.SMS_Access_ID;
   String AccessKey_Secret = confignature.SMS_Access_Secret;
   
    @AuthAccess
    @PostMapping("/Captcha/get")
    public Result transmit(@RequestBody Phone number) {



       Integer Captcha=  generateValidateCode( 6);

        try {
            String phone = number.getPhone();
            Config config = new Config()
                    //这里修改为我们上面生成自己的AccessKey ID
                    .setAccessKeyId(AccessKey_ID)
                    //这里修改为我们上面生成自己的AccessKey Secret
                    .setAccessKeySecret(AccessKey_Secret);
            // 访问的域名
            config.endpoint = "dysmsapi.aliyuncs.com";
            Client client = new Client(config);
            SendSmsRequest sendSmsRequest = new SendSmsRequest()
                    .setSignName("Nanoic的小站")//短信签名
                    .setTemplateCode("SMS_298495363")//短信模板
                    .setPhoneNumbers(phone)//这里填写接受短信的手机号码
                    .setTemplateParam("{\"code\":\"" +
                           Captcha.toString()
                            + "\"}");//验证码
            //向redis中存储验证码
            redisService.set(number.getPhone(),Captcha.toString());
            redisService.expire(number.getPhone(),120);
            // 复制代码运行请自行打印 API 的返回值
            client.sendSms(sendSmsRequest);
            return Result.success("发送成功");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @AuthAccess
    @PostMapping("/Captcha/set")
    public Result transmit0(@RequestBody Phone number){
      String redis_password= redisService.get(number.getPhone());
     if (number.getPassword().equals(redis_password)){
         redisService.remove(number.getPhone());
         return Result.success("验证成功");
     }
     return Result.error("验证码错误");
    }
}



