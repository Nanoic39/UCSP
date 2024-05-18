package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.service.StudyMenuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @FileName StudyMenuController
 * @Description
 * @Author fazhu
 * @date 2024-05-18
 **/
@RestController
public class StudyMenuController {//学习区菜单
    @Resource
    StudyMenuService studyMenuService;

    @AuthAccess
    @PostMapping("/studymenu/select")
    public Result postInsert( ) {
        studyMenuService.select();
    }

}
