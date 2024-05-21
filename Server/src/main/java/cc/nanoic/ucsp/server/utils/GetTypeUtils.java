package cc.nanoic.ucsp.server.utils;

import cc.nanoic.ucsp.server.exception.ServiceException;
import cn.hutool.core.io.FileTypeUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-05-21
 * @FileName: GetTypeUtils
 **/

@Component
public class GetTypeUtils {

    public boolean isRealType(String type, MultipartFile file){
        try {
            String RealType = FileTypeUtil.getType(file.getInputStream());
            if(RealType.equals(type)){
                return true;
            } else {
                return false;
            }
        } catch (IOException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public String getType(MultipartFile file){
        try {
            String RealType = FileTypeUtil.getType(file.getInputStream());
            return RealType;
        } catch (IOException e){
            throw new ServiceException(e.getMessage());
        }
    }
}
