package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Confignature;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.entityRequest.ReqUpload;
import cn.hutool.core.io.FileUtil;

import cn.hutool.core.util.StrUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-05-18
 * @FileName: UploadController
 **/

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Resource
    Confignature confignature;

    @AuthAccess
    @PostMapping("/image")
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        //本地测试会报错，因为本地没有这个路径，也没有这个权限
        try {
            String fileUploadPath = confignature.FILE_UPLOAD_PATH;
            System.out.println("fileUploadPath");
            System.out.println(fileUploadPath);

            //获取文件原始名称
            String originalFilename = file.getOriginalFilename();
            System.out.println("文件名称是：" + originalFilename);
            //获取文件的类型
            String type = FileUtil.extName(originalFilename);
            System.out.println("文件类型是：" + type);
            //获取文件大小
            long size = file.getSize();

            File uploadParentFile = new File(fileUploadPath);

            //判断文件目录是否存在
            if (!uploadParentFile.exists()) {
                //如果不存在就创建文件夹
                uploadParentFile.mkdirs();
                System.out.println("uploadParentFile");
                System.out.println(uploadParentFile);
            }
            //定义一个文件唯一标识码（UUID）
            String uuid = UUID.randomUUID().toString();

            File uploadFile = new File(fileUploadPath + uuid + StrUtil.DOT + type);
            //将临时文件转存到指定磁盘位置
            file.transferTo(uploadFile);

            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }


}
