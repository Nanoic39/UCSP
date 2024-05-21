package cc.nanoic.ucsp.server.entity.entityRequest;

import lombok.Data;

/**
 * @FileName Phone
 * @Description
 * @Author fazhu
 * @date 2024-05-18
 **/
@Data
public class ReqVerifyCode {
    String phone;
    String verify_code;
}
