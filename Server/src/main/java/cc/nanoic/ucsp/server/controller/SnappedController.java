package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.AuthAccess;
import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.Warehouse;
import cc.nanoic.ucsp.server.service.RedisServiceImpl;
import cc.nanoic.ucsp.server.service.SnappedService;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SnappedController {
    @Resource
    private RedisServiceImpl redisService;
    @Resource
    private SnappedService snappedService;
    @AuthAccess
    @RequestMapping("/startSnapped")
    public Result snappedStart(@RequestBody String goodsName){
        try {
            Warehouse warehouse = snappedService.selectWarehouse(goodsName);
            redisService.set(goodsName+"-sales",0+"");
            redisService.set(goodsName+"-inventory",warehouse.getGoods_pre_sale_volume()+"");
            return Result.success("开始抢购成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("开始抢购发生错误");
        }
    }

    @AuthAccess
    @RequestMapping("/snapped")
    public Result snapped(@RequestBody String goodsName, int preSales){
        try {
            int sales = Integer.parseInt(redisService.get("product-sales"));
            int preSaleVolume = Integer.parseInt(redisService.get("product-inventory"));
            if (preSales < sales + preSaleVolume){
                return Result.success("已被抢完");
            }
            redisService.increment("product-sales",1);
            redisService.increment("pre-sale-volume",-1);
            User user = TokenUtils.getCurrentUser();
            int id = user.getId();
            if (preSaleVolume < 1) {
                snappedService.updateWarehouseStocks(goodsName);
                snappedService.updateSuccessSnapped(id, goodsName);
                return Result.success("抢购成功");
            }else {
                redisService.increment("product-sales",-1);
                redisService.increment("pre-sale-volume",1);
            }
        } catch (NumberFormatException e) {
            return Result.error("抢购发生错误");
        }
        return null;
    }

    @AuthAccess
    @RequestMapping("/addSnapped")
    public Result addSnapped(String goodsName,Integer goodsPreSale,Long startTime,Long eddTime){
        try {
            Date StartTime = new Date(startTime);
            Date EddTime = new Date(eddTime);
            int flag = snappedService.addSnapped(goodsName,goodsPreSale,StartTime,EddTime);
            if (flag != 0){
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
    public Result deleteSnapped(@RequestBody String goodsName){
        try {
            int flag = snappedService.deleteSnapped(goodsName);
            if (flag != 0){
                redisService.remove(goodsName+"-sales");
                redisService.remove(goodsName+"-inventory");
                return Result.success("删除抢购活动成功");
            }else {
                return Result.error("删除失败或没有该活动");
            }
        } catch (Exception e) {
            return Result.error("抢购删除发生错误");
        }
    }

    @AuthAccess
    @RequestMapping("/snappedFeedback")
    public Result snappedFeedback(@RequestBody String goodsName){
        try {
            Warehouse warehouse = snappedService.selectWarehouse(goodsName);
            if (warehouse.getGoods_inventory() <= 0){
                return Result.success(warehouse.getGoods_inventory());
            }else {
                return Result.success("库存已空");
            }
        } catch (Exception e) {
            return Result.error("库存检查发生错误");
        }
    }
}
