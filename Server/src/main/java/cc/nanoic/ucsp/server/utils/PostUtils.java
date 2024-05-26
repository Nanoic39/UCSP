package cc.nanoic.ucsp.server.utils;

import cc.nanoic.ucsp.server.common.Confignature;
import cc.nanoic.ucsp.server.exception.ServiceException;
import cc.nanoic.ucsp.server.mapper.PostMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-05-26
 * @FileName: GetPostNumUtils
 **/

@Component
public class PostUtils {

    @Resource
    Confignature confignature;

    @Resource
    PostMapper postMapper;

    public int getPostNum(String type) {
        int num;
        try {
            return postMapper.numSelect(type);
        } catch (Exception e) {
            throw new ServiceException("获取失败：" + e.getMessage());
        }
    }

    public int getTableNum(String type) {
        int num;
        try {
            num = postMapper.numSelect(type);
            return (num / confignature.NUMBER_OF_A_TABLE);
        } catch (Exception e) {
            throw new ServiceException("获取失败：" + e.getMessage());
        }
    }

    public int whatTableCanIInsert(String type) {
        int num;
        try {
            num = postMapper.numSelect(type);
            return ((num + 1) / confignature.NUMBER_OF_A_TABLE);
        } catch (Exception e) {
            throw new ServiceException("获取失败：" + e.getMessage());
        }
    }


}
