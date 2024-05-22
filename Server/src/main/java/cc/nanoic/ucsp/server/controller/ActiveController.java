package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Active1;
import cc.nanoic.ucsp.server.entity.entityRequest.Num;
import cc.nanoic.ucsp.server.entity.entityRequest.ReqUser_Id;
import cc.nanoic.ucsp.server.service.ActiveService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-05-17
 * @FileName: ActiveController
 **/

@RestController
public class ActiveController {
    @Resource
    ActiveService activeService;


    //添加
    @PostMapping("/active/insert")
    public Result insert(@RequestBody Active1 active){
        try {
            if(active!=null){
                activeService.insert(active);
                return Result.success("增加成功");
            }
            return Result.error("数据上传失败");
        } catch (Exception e) {
            return Result.error("500","服务器错误");
        }
    }

    //手动删除
    @PostMapping("/active/delete")
    public Result insert(@RequestBody ReqUser_Id active_id){
        try {
            if (active_id !=null){
                activeService.delete(active_id.getId());
                return Result.success("删除成功");
            }return Result.error("无法获取ID");
        } catch (Exception e) {
            return Result.error("500","服务器错误");
        }
    }

    //活动结束
    @PostMapping("/active/update_delete")
    public Result update_delete(@RequestBody ReqUser_Id active_id){
        try {
            if (active_id!=null){
                activeService.update_delete(active_id.getId());
                return Result.success("活动结束成功");
            }return Result.error("无法获取ID");
        } catch (Exception e) {
            return Result.error("500","服务器错误");
        }
    }

    //活动更新
    @PostMapping("/active/update")
    public Result update(@RequestBody Active1 active ){
        try {if(active!=null)  {
                  activeService.update(active);
                  return Result.success("更新成功");
              }return Result.error("获取数据失败");
        } catch (Exception e) {
            return Result.error("500","服务器错误");
        }
    }


    //读取活动
    @AuthAccess
    @PostMapping("/active/get_id")
    public Result get_id(@RequestBody Num num){


        ArrayList<Active1> active = new ArrayList<>();
        active=activeService.get_id(num.getNum());
        return Result.success(active);
    }





}
