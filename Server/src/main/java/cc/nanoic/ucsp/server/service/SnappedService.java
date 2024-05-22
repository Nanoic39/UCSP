package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.Success_Snapped;
import cc.nanoic.ucsp.server.entity.Warehouse;
import cc.nanoic.ucsp.server.mapper.SnappedMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SnappedService {
    @Resource
    SnappedMapper snappedMapper;

    //查询抢购物品信息
    public Warehouse selectWarehouse(Integer snappedId){return snappedMapper.selectWarehouse(snappedId);}

    //抢购成功后操作数据库减少库存量
    public int updateWarehouseStocks(Integer snappedId){return snappedMapper.updateWarehouseStocks(snappedId);}

    //插入抢购成功人员到数据库
    public int insertSuccessSnapped(Integer id,Integer snappedId){return snappedMapper.insertSuccessSnapped(id,snappedId);}

    //删除抢购活动
    public int deleteWarehouse(Integer snappedId){return snappedMapper.deleteWarehouse(snappedId);}

    //删除抢购成功人员信息
    public int deleteSuccessSnapped(Integer snappedId){return snappedMapper.deleteSuccessSnapped(snappedId);}

    //添加活动
    public int addSnapped(Integer snappedId,String goodsName, Integer preSales, Date startTime,Date eddTime){return snappedMapper.addSnapped(snappedId,goodsName,preSales,startTime,eddTime);}

    //查询抢购情况
    public Success_Snapped selectSuccessSnapped(Integer snappedId, Integer id){return snappedMapper.selectSuccessSnapped(snappedId,id);}
}
