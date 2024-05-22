package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.Warehouse;
import cc.nanoic.ucsp.server.entity.entityRequest.ReqRedis;
import cc.nanoic.ucsp.server.service.SnappedService;
import cc.nanoic.ucsp.server.utils.RedisUtils;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import cn.hutool.core.date.DateTime;
import jakarta.annotation.Resource;
import lombok.val;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SnappedController {
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private SnappedService snappedService;
    @AuthAccess
    @RequestMapping("/startSnapped")
    public Result snappedStart(@RequestBody Warehouse warehouse){
        try {
            Warehouse reWarehouse = snappedService.selectWarehouse(warehouse.getSnapped_id());
            String goodsName = reWarehouse.getGoods_name();
            redisUtils.set(goodsName+"-sales",0+"");
            redisUtils.set(goodsName+"-inventory",reWarehouse.getGoods_pre_sale_volume()+"");
            return Result.success("开始抢购成功");
        } catch (Exception e) {
            return Result.error("开始抢购发生错误");
        }
    }

    @AuthAccess
    @RequestMapping("/snapped")
    public Result snapped(@RequestBody Warehouse warehouse){
        User user = TokenUtils.getCurrentUser();
        int id = user.getId();
        if (snappedService.selectSuccessSnapped(warehouse.getSnapped_id(),id) == null) {
            return Result.success("你已抢过了");
        }
        try {
            String goodsName = warehouse.getGoods_name();
            Integer preSales = warehouse.getGoods_pre_sale_volume();
            Integer snappedId = warehouse.getSnapped_id();
            Integer sales = Integer.parseInt(((ReqRedis)redisUtils.get(goodsName+"-sales")).getValue());
            Integer inventory = Integer.parseInt(((ReqRedis)redisUtils.get(goodsName+"-inventory")).getValue());
            if (preSales < sales + inventory){
                return Result.success("已被抢完");
            }
            redisUtils.set(goodsName+"-sales",sales+1+"");
            redisUtils.set(goodsName+"-inventory",inventory-1+"");
            if (inventory >= 1) {
                snappedService.updateWarehouseStocks(snappedId);
                snappedService.insertSuccessSnapped(id, snappedId);
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
    public Result addSnapped(@RequestBody Warehouse warehouse){
        if (snappedService.selectWarehouse(warehouse.getSnapped_id()) != null) {
            return Result.error("该活动id已存在");
        }
        try {
            Date StartTime = new DateTime(warehouse.getStartTime());
            Date EddTime = new DateTime(warehouse.getEddTime());
            int flag = snappedService.addSnapped(warehouse.getSnapped_id(), warehouse.getGoods_name(),warehouse.getGoods_pre_sale_volume(),StartTime,EddTime);
            if ( flag != 0){
                return Result.success("添加抢购活动成功");
            }else {
                return Result.error("添加抢购活动失败");
            }
        } catch (Exception e) {
            return Result.error("添加抢购活动发生错误");
        }
    }

    @AuthAccess
    @RequestMapping("/deleteSnapped")
    public Result deleteSnapped(@RequestBody Warehouse warehouse){
        try {
            Warehouse reWarehouse = snappedService.selectWarehouse(warehouse.getSnapped_id());
            if (reWarehouse != null){
                int flag = snappedService.deleteWarehouse(reWarehouse.getSnapped_id());
                snappedService.deleteSuccessSnapped(reWarehouse.getSnapped_id());
                if (flag != 0){
                    if (redisUtils.get(reWarehouse.getGoods_name()+"-sales")!=null) {
                        redisUtils.delete(reWarehouse.getGoods_name()+"-sales");
                    }
                    if (redisUtils.get(reWarehouse.getGoods_name()+"-inventory")!=null) {
                        redisUtils.delete(reWarehouse.getGoods_name()+"-inventory");
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
    public Result snappedFeedback(@RequestBody Warehouse warehouse){
        Warehouse reWarehouse = snappedService.selectWarehouse(warehouse.getSnapped_id());
        try {
            if (reWarehouse.getGoods_inventory() >= 0){
                return Result.success(reWarehouse.getGoods_inventory());
            }else {
                return Result.success("库存已空");
            }
        } catch (Exception e) {
            return Result.error("库存检查发生错误");
        }
    }
}
