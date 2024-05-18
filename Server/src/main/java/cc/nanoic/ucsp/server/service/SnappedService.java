package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.Warehouse;
import cc.nanoic.ucsp.server.mapper.SnappedMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SnappedService {
    @Resource
    SnappedMapper snappedMapper;

    //查询抢购物品信息
    public Warehouse selectWarehouse(String goodsName){
        Warehouse warehouse = snappedMapper.selectWarehouse(goodsName);
        return warehouse;
    }

    //抢购成功后操作数据库减少库存量
    public int updateWarehouseStocks(String goodsName){return snappedMapper.updateWarehouseStocks(goodsName);}

    //插入抢购成功人员到数据库
    public int updateSuccessSnapped(int id,String goodsName){return snappedMapper.updateSuccessSnapped(id,goodsName);}
}
