package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.Success_Snapped;
import cc.nanoic.ucsp.server.entity.Active;
import cc.nanoic.ucsp.server.mapper.SnappedMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SnappedService {
    @Resource
    SnappedMapper snappedMapper;

    //查询抢购物品信息
    public Active selectActive(Integer snappedId){return snappedMapper.selectActive(snappedId);}

    //抢购成功后操作数据库减少库存量
    public int updateActiveStocks(Integer snappedId){return snappedMapper.updateActiveStocks(snappedId);}

    //插入抢购成功人员到数据库
    public int insertSuccessSnapped(Integer id,Integer snappedId){return snappedMapper.insertSuccessSnapped(id,snappedId);}

    //删除抢购活动
    public int deleteActive(Integer snappedId){return snappedMapper.deleteActive(snappedId);}

    //删除抢购成功人员信息
    public int deleteSuccessSnapped(Integer snappedId){return snappedMapper.deleteSuccessSnapped(snappedId);}

    //添加活动
    public int addSnapped(Integer snappedId,String sponsor,String facultyName,String gradeName,Integer authority,String activeName, Integer preSales, Date startTime,Date eddTime){return snappedMapper.addSnapped(snappedId,sponsor,facultyName,gradeName,authority,activeName,preSales,startTime,eddTime);}

    //查询抢购情况
    public Success_Snapped selectSuccessSnapped(Integer snappedId, Integer id){return snappedMapper.selectSuccessSnapped(snappedId,id);}
}
