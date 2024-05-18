package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.entity.Warehouse;
import cc.nanoic.ucsp.server.service.RedisServiceImpl;
import cc.nanoic.ucsp.server.service.SnappedService;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;

public class SnappedController {
    @Resource
    private RedisServiceImpl redisService;
    @Resource
    private SnappedService snappedService;

    @RequestMapping("/startSnapped")
    public Result snappedStart(String goodsName){
        try {
            Warehouse warehouse = snappedService.selectWarehouse(goodsName);
            redisService.set("product-sales",0+"");
            redisService.set("product-inventory",warehouse.getGoods_pre_sale_volume()+"");
            redisService.expire("product-sales",60);
            return Result.success("开始抢购成功");
        } catch (Exception e) {
            return Result.error("开始抢购发生错误");
        }
    }

    @RequestMapping("/snapped")
    public Result snapped(String goodsName,int preSales){
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
}
