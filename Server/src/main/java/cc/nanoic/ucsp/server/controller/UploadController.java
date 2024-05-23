package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Confignature;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.exception.ServiceException;
import cc.nanoic.ucsp.server.utils.GetTypeUtils;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;

import cn.hutool.core.util.StrUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
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

    @Resource
    GetTypeUtils getTypeUtils;

    @PostMapping("/image")
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException, IllegalStateException {
        System.out.println(file);
        User user = TokenUtils.getCurrentUser();//用户信息

        //本地测试会报错，因为本地没有这个路径，也没有这个权限
        //获取文件原始名称
        String originalFilename = file.getOriginalFilename();
        System.out.println("文件名称是：" + originalFilename);

        //获取文件的类型
        String type = FileUtil.extName(originalFilename);
        System.out.println("文件类型是：" + type);

        //TODO:BUG?
        if(!getTypeUtils.isRealType(type, file)){
            throw new ServiceException("文件后缀类型不匹配");
        }

        //获取文件大小
        long size = file.getSize();

        String fileUploadPath = confignature.FILE_UPLOAD_PATH + "image/";
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

        File uploadFile = new File(fileUploadPath + user.getId().toString() + "_" + uuid + StrUtil.DOT + type);
        //将临时文件转存到指定磁盘位置
        file.transferTo(uploadFile);

        return Result.success(user.getId().toString() + "_" + uuid + StrUtil.DOT + type);
    }




}
