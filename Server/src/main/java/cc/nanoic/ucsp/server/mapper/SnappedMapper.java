package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Warehouse;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SnappedMapper {
    /**
     * 根据商品名搜索库存量
     * @param: goodsName
     */
    @Select("select * from `warehouse` where goods_name = #{goodsName}")
    Warehouse selectWarehouse(@Param("goodsName")String goodsName);

    /**
     * 抢购成功后操作数据库减少库存量
     * @param: goodsName
     */
    @Update("UPDATE `warehouse` set `goods_inventory` = `goods_inventory`-1 where goods_name = (#{goodsName})")
    int updateWarehouseStocks(@Param("goodsName") String goodsName);

    /**
     * 插入抢购成功人员到数据库
     * @param: id
     * @param: activityName
     */
    @Insert("insert into success_snapped values (#{id},#{activity})")
    int updateSuccessSnapped(@Param("id")int id,
                             @Param("activityName")String activityName);
}
