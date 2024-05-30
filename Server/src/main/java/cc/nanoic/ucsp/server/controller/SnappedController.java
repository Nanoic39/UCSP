package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Success_Snapped;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.Active;
import cc.nanoic.ucsp.server.service.SnappedService;
import cc.nanoic.ucsp.server.utils.RedisUtils;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class SnappedController {
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private SnappedService snappedService;

    @AuthAccess
    @RequestMapping("/getAllActive")
    public Result getActive(){
        try {
            User user = TokenUtils.getCurrentUser();Integer level = snappedService.selectAuthority(user.getId());
            List<Active> activeList = snappedService.selectVisibleActive(level);
            System.out.println(activeList);
            return Result.success(activeList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("返回活动失败");
        }
    }

    @AuthAccess
    @RequestMapping("getActive")
    public Result getActive(@RequestBody Active active){
        try {
            Active reActive = snappedService.selectActiveAll(active.getSnapped_id());
            System.out.println(reActive);
            if (reActive != null) {
                return Result.success(reActive);
            }else {
                return Result.success("数据库不存在该活动");
            }
        } catch (Exception e) {
            return Result.error("返回活动信息发生错误");
        }
    }

    @AuthAccess
    @RequestMapping("/startSnapped")
    public Result snappedStart(@RequestBody Active active){
        try {
            int snappedId = active.getSnapped_id();
            Active reActive = snappedService.selectActive(snappedId);
            redisUtils.set(snappedId+"-inventory", reActive.getGoods_pre_sale_volume()+"");
            //redisUtils.set(snappedId+"-inventory", "500");
            snappedService.updateSuccessSnapped(1, snappedId);
            return Result.success("开始抢购成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("开始抢购发生错误");
        }
    }

    @AuthAccess
    @RequestMapping("/snapped")
    public Result snapped(@RequestBody Active active){
        User user = TokenUtils.getCurrentUser();
        int id = user.getId();
        Integer snappedId = active.getSnapped_id();
        Success_Snapped successSnapped = snappedService.selectSuccessSnapped(active.getSnapped_id(),id);
        if (successSnapped != null) {
            return Result.success("你已抢过了");
        }
        int inventory = Integer.parseInt(redisUtils.get(snappedId+"-inventory").getValue());
        try {
            if (inventory >= 1){
                redisUtils.set(snappedId+"-inventory",inventory-1+"");
                snappedService.insertSuccessSnapped(id,snappedId);
                return Result.success("抢购成功");
            }else {
                return Result.success("已被抢完");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Result.error("抢购发生错误");
        }
    }

//    @AuthAccess
//    @RequestMapping("/addSnapped")
//    public Result addSnapped(@RequestBody Active active){
//        if (snappedService.selectActive(active.getSnapped_id()) != null) {
//            return Result.error("该活动id已存在");
//        }
//        try {
//            int flag = snappedService.addSnapped(active.getSnapped_id(),active.getSponsor(),active.getFaculty_name(),active.getGrade_name(),active.getAuthority(),active.getActive_name(), active.getActive_intro(), active.getActive_content(), active.getGoods_pre_sale_volume(),StartTime,EddTime,BeganStartTime,BeganEndTime);
//            if ( flag != 0){
//                return Result.success("添加活动成功");
//            }else {
//                return Result.success("添加活动失败");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Result.error("添加活动发生错误");
//        }
//    }

    @AuthAccess
    @RequestMapping("/deleteSnapped")
    public Result deleteSnapped(@RequestBody Active active){
        try {
            int snappedId = active.getSnapped_id();
            Active reActive = snappedService.selectActive(snappedId);
            if (reActive != null){
                int flag = snappedService.deleteActive(reActive.getSnapped_id());
                snappedService.deleteSuccessSnapped(reActive.getSnapped_id());
                if (flag != 0){
                    if (redisUtils.get(snappedId+"-inventory")!=null) {
                        redisUtils.delete(snappedId+"-inventory");
                    }
                    return Result.success("删除抢购活动成功");
                }else {
                    return Result.success("删除失败或没有该活动");
                }
            }else {
                return Result.success("删除失败或没有该活动");
            }
        } catch (Exception e) {
            return Result.error("抢购删除发生错误");
        }
    }

    @AuthAccess
    @RequestMapping("/snappedFeedback")
    public Result snappedFeedback(@RequestBody Active active){
        Active reActive = snappedService.selectActive(active.getSnapped_id());
        try {
            if (reActive.getActive_inventory() >= 0){
                return Result.success(reActive.getActive_inventory());
            }else {
                return Result.success("库存已空");
            }
        } catch (Exception e) {
            return Result.error("库存检查发生错误");
        }
    }
}
