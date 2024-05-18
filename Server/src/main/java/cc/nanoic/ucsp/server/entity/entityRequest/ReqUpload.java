package cc.nanoic.ucsp.server.entity.entityRequest;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-05-18
 * @FileName: ReqUpload
 **/
@Data
public class ReqUpload {
    private String type;
    private String file_name;
    private MultipartFile file_content;
    private String file_type;
}
