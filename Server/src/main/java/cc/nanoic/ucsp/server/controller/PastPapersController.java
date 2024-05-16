package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Past_Papers;
import cc.nanoic.ucsp.server.service.PastPapersService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class PastPapersController {
    @Resource
    PastPapersService pastPapersService;

    @AuthAccess
    @PostMapping("/selectPastPapers")
    public Result selectPastPapers(){
        try {
            List<Past_Papers> pastPapersList = pastPapersService.selectPastPapers();
            return Result.success(pastPapersList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("真题查询失败，出现错误");
        }
    }

    @AuthAccess
    @PostMapping("/selectPastPapersByType")
    public Result selectPastPapersByType(@RequestBody String papersType){
        try {
            List<Past_Papers> pastPapersList = pastPapersService.selectPastPapersByType(papersType);
            return Result.success(pastPapersList);
        } catch (Exception e) {
            return Result.error("真题筛选出现错误");
        }
    }

    @AuthAccess
    @PostMapping("/addPastPapers")
    public Result insertPastPapers(@RequestParam("papersName")String papersName,
                                   @RequestParam("papersUrl")String papersUrl,
                                   @RequestParam("papersType")String papersType
    ){
        try {
            if (papersName != null && papersType != null && papersUrl != null) {
                pastPapersService.insertPastPapers(papersName,papersUrl,papersType);
                return Result.success("添加真题成功");
            }
        } catch (Exception e) {
            return Result.error("添加真题失败,出现错误");
        }
        return null;
    }
}