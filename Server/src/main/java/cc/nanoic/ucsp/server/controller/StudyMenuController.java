package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.entityRequest.Subjects_big;
import cc.nanoic.ucsp.server.entity.entityRequest.Subjects_small;
import cc.nanoic.ucsp.server.service.StudyMenuService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import java.util.ArrayList;

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
    @GetMapping("/studymenu_big")
    public Result studymenu_big( ) {
        ArrayList<Subjects_big> a=new ArrayList();
       a= studyMenuService.select();
        return Result.success(a);
    }
    @AuthAccess
    @PostMapping("/studymenu_small")
    public Result studymenu_small(@RequestBody Subjects_big subjects_big){
        ArrayList<Subjects_small> a=new ArrayList();
        a= studyMenuService.select_small(subjects_big);
        return Result.success(a);
    }

}
