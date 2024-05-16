package cc.nanoic.ucsp.server.entity;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @FileName Permissions
 * @Description
 * @Author fazhu
 * @date 2024-05-16
 **/
@Data
public class Permissions {
    Integer id;//用户ID
    String name;//身份名
}
