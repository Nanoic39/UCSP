package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.Active;
import cc.nanoic.ucsp.server.entity.entityRequest.ReqRedis;
import cc.nanoic.ucsp.server.service.SnappedService;
import cc.nanoic.ucsp.server.utils.RedisUtils;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import cn.hutool.core.date.DateTime;
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
            User user = TokenUtils.getCurrentUser();
            Integer level = snappedService.selectAuthority(user.getId());
            List<Active> activeList = snappedService.selectVisibleActive(level);
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
            Active reActive = snappedService.selectActive(active.getSnapped_id());
            String goodsName = reActive.getActive_name();
            redisUtils.set(goodsName+"-sales",0+"");
            redisUtils.set(goodsName+"-inventory", reActive.getGoods_pre_sale_volume()+"");
            return Result.success("开始抢购成功");
        } catch (Exception e) {
            return Result.error("开始抢购发生错误");
        }
    }

    @AuthAccess
    @RequestMapping("/snapped")
    public Result snapped(@RequestBody Active active){
        User user = TokenUtils.getCurrentUser();
        int id = user.getId();
//        if (snappedService.selectSuccessSnapped(active.getSnapped_id(),id) != null) {
//            return Result.success("你已抢过了");
//        }
        try {
            String goodsName = active.getActive_name();
            Integer preSales = active.getGoods_pre_sale_volume();
            Integer snappedId = active.getSnapped_id();
            Integer sales = Integer.parseInt(redisUtils.get(goodsName+"-sales").getValue());
            Integer inventory = Integer.parseInt(redisUtils.get(goodsName+"-inventory").getValue());
            if (preSales < sales + inventory){
                return Result.success("已被抢完");
            }
            redisUtils.set(goodsName+"-sales",sales+1+"");
            redisUtils.set(goodsName+"-inventory",inventory-1+"");
            if (inventory >= 1) {
                //snappedService.updateActiveStocks(snappedId);
                //snappedService.insertSuccessSnapped(id, snappedId);
                return Result.success("抢购成功");
            }else {
                redisUtils.set(goodsName+"-sales",sales-1+"");
                redisUtils.set(goodsName+"-inventory",inventory+1+"");
            }
        } catch (NumberFormatException e) {
            return Result.error("抢购发生错误");
        }
        return null;
    }

    @AuthAccess
    @RequestMapping("/addSnapped")
    public Result addSnapped(@RequestBody Active active){
        if (snappedService.selectActive(active.getSnapped_id()) != null) {
            return Result.error("该活动id已存在");
        }
        try {
            Date StartTime = new DateTime(active.getStartTime());
            Date EddTime = new DateTime(active.getEddTime());
            int flag = snappedService.addSnapped(active.getSnapped_id(),active.getSponsor(),active.getFaculty_name(),active.getGrade_name(),active.getAuthority(),active.getActive_name(), active.getGoods_pre_sale_volume(),StartTime,EddTime);
            if ( flag != 0){
                return Result.success("添加活动成功");
            }else {
                return Result.success("添加活动失败");
            }
        } catch (Exception e) {
            return Result.error("添加活动发生错误");
        }
    }

    @AuthAccess
    @RequestMapping("/deleteSnapped")
    public Result deleteSnapped(@RequestBody Active active){
        try {
            Active reActive = snappedService.selectActive(active.getSnapped_id());
            if (reActive != null){
                int flag = snappedService.deleteActive(reActive.getSnapped_id());
                snappedService.deleteSuccessSnapped(reActive.getSnapped_id());
                if (flag != 0){
                    if (redisUtils.get(reActive.getActive_name()+"-sales")!=null) {
                        redisUtils.delete(reActive.getActive_name()+"-sales");
                    }
                    if (redisUtils.get(reActive.getActive_name()+"-inventory")!=null) {
                        redisUtils.delete(reActive.getActive_name()+"-inventory");
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
