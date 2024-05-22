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

import cc.nanoic.ucsp.server.entity.entityRequest.ReqVerifyCode;
import cc.nanoic.ucsp.server.utils.RedisUtils;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.*;


import com.aliyun.teaopenapi.models.Config;
import jakarta.annotation.Resource;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.PostConstruct;

import static cc.nanoic.ucsp.server.utils.ValidateCodeUtils.generateValidateCode;

@RequestMapping("/captcha")
@RestController
public class CaptchaController {//验证码

    @Resource
    RedisUtils redisUtils;

    @Resource
    Confignature confignature;

    String AccessKey_ID = confignature.SMS_Access_ID;
    String AccessKey_Secret = confignature.SMS_Access_Secret;

    @AuthAccess
    @PostMapping("/post")
    public Result get(@RequestBody ReqVerifyCode reqVerifyCode) {

        Integer Captcha = generateValidateCode(6);

        try {
            String phone = reqVerifyCode.getPhone();
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
            redisUtils.set(reqVerifyCode.getPhone(), Captcha.toString(), 120);
            // 复制代码运行请自行打印 API 的返回值
            client.sendSms(sendSmsRequest);
            return Result.success("发送成功");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @AuthAccess
    @PostMapping("/check")
    public Result check(@RequestBody ReqVerifyCode reqVerifyCode) {
        String verifyCode = redisUtils.get(reqVerifyCode.getPhone()).getValue();
        if (reqVerifyCode.getVerify_code().equals(verifyCode)) {
            redisUtils.delete(reqVerifyCode.getPhone());
            return Result.success("验证成功");
        }
        return Result.error("验证码错误");
    }
}



