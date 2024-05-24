package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.Confignature;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.entityRequest.ReqDelete;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import jakarta.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-05-22
 * @FileName: DeleteController
 **/

@RequestMapping("/delete")
@RestController
public class DeleteController {
    @Resource
    Confignature confignatur;


    @PostMapping("/image")
    public Result delete(@RequestBody ReqDelete reqDelete) {
        String fileUploadPath = Confignature.FILE_UPLOAD_PATH + "image/";
        boolean flag = false;
        if (StringUtils.substringBefore(reqDelete.getFile_name(), "_").equals(TokenUtils.getCurrentUser().getId().toString())) {
            //根据路径创建文件对象
            File file = new File(fileUploadPath + reqDelete.getFile_name());
            //路径是个文件且不为空时删除文件
            if (file.isFile() && file.exists()) {
                try {
                    file.delete();
                    return Result.success("删除成功");
                } catch (Exception e) {
                    return Result.error(e.getMessage());
                }
            }
            //删除失败时，返回false
            return Result.error("删除失败");
        } else {
            return Result.error("您选择删除的文件可能不是您自己上传的!");
        }

    }
}
