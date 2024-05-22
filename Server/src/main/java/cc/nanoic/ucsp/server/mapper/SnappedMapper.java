package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Success_Snapped;
import cc.nanoic.ucsp.server.entity.Warehouse;
import org.apache.ibatis.annotations.*;

import java.util.Date;

@Mapper
public interface SnappedMapper {
    /**
     * 根据商品名搜索库存量
     * @param: goodsId
     */
    @Select("select * from `warehouse` where snapped_id = #{snappedId}")
    Warehouse selectWarehouse(@Param("snappedId")Integer snappedId);

    /**
     * 抢购成功后操作数据库减少库存量
     * @param: goodsName
     */
    @Update("UPDATE `warehouse` set `goods_inventory` = `goods_inventory`-1 where snapped_id = (#{snappedId})")
    int updateWarehouseStocks(@Param("snappedId") Integer snappedId);

    /**
     * 插入抢购成功人员到数据库
     * @param: id
     * @param: activityName
     */
    @Insert("insert into success_snapped values (#{snappedId},#{id})")
    int insertSuccessSnapped(@Param("id")Integer id,
                             @Param("snappedId")Integer snappedId);

    /**
     * 删除活动
     * @param: snappedId
     */
    @Delete("delete from `warehouse` where snapped_id = #{snappedId}")
    int deleteWarehouse(@Param("snappedId")Integer snappedId);

    /**
     * 删除抢购成功人员
     * @param: snappedId
     */
    @Delete("delete from `success_snapped` where `snapped_id` = #{snappedId}")
    int deleteSuccessSnapped(@Param("snappedId")Integer snappedId);

    /**
     * 添加活动
     * @param: snappedId
     * @param: goodsName
     * @param: preSales
     * @param: startTime
     * @param: eddTime
     */
    @Insert("insert into `warehouse` values (#{snappedId},#{goodsName},#{preSales},#{preSales},#{startTime},#{eddTime})")
    int addSnapped(@Param("snappedId")Integer snappedId,
                   @Param("goodsName")String goodsName,
                   @Param("preSales")Integer preSales,
                   @Param("startTime")Date startTime,
                   @Param("eddTime")Date eddTime);

    /**
     * 添加活动
     * @param: id
     * @param: snappedId
     */
    @Select("select `id` from `success_snapped` where `snapped_id` = #{snappedId} and `id` = #{id}")
    Success_Snapped selectSuccessSnapped(@Param("snappedId")Integer snappedId,
                                         @Param("id")Integer id);
}
