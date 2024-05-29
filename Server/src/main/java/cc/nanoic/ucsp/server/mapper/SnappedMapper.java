package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Success_Snapped;
import cc.nanoic.ucsp.server.entity.Active;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface SnappedMapper {
    /**
     * 根据商品名搜索库存量
     * @param: goodsId
     */
    @Select("select * from `active` where snapped_id = #{snappedId}")
    Active selectActive(@Param("snappedId")Integer snappedId);

    /**
     * 抢购成功后操作数据库减少库存量
     * @param: goodsName
     */
    @Update("UPDATE `active` set `active_inventory` = `active_inventory`-1 where snapped_id = (#{snappedId})")
    int updateActiveStocks(@Param("snappedId") Integer snappedId);

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
    @Delete("delete from `active` where snapped_id = #{snappedId}")
    int deleteActive(@Param("snappedId")Integer snappedId);

    /**
     * 删除抢购成功人员
     * @param: snappedId
     */
    @Delete("delete from `success_snapped` where `snapped_id` = #{snappedId}")
    int deleteSuccessSnapped(@Param("snappedId")Integer snappedId);

    /**
     * 添加活动
     * @param: snappedId
     * @param: sponsor
     * @param: facultyName
     * @param: activeName
     * @param: preSales
     * @param: startTime
     * @param: eddTime
     */
    @Insert("insert into `active` values (#{snappedId},#{sponsor},#{facultyName},#{gradeName},#{authority},#{activeName},#{preSales},#{preSales},#{startTime},#{eddTime})")
    int addSnapped(@Param("snappedId")Integer snappedId,
                   @Param("sponsor")String sponsor,
                   @Param("facultyName")String facultyName,
                   @Param("gradeName")String gradeName,
                   @Param("authority")Integer authority,
                   @Param("activeName")String activeName,
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

    /**
     * 查询用户权限等级
     * @param: id
     */
    @Select("select `level` from `authority` where id = #{id}")
    Integer selectAuthority(@Param("id")Integer id);

    /**
     * 查询用户可见活动
     * @param: level
     */
    @Select("select `sponsor`,`faculty_name`,`grade_name`,`active_name`,`active_inventory`,`goods_pre_sale_volume`,`active_intro`,`active_content`,`start_time`,`edd_time` from `active` where `authority`<= #{level} ORDER BY `start_time` DESC")
    List<Active> selectVisibleActive(@Param("level")Integer level);

    /**
     * 查询用户可见活动
     * @param: snappedId
     */
    @Select("select * from active where snapped_id = #{snappedId}")
    Active selectActiveAll(@Param("snappedId")Integer snappedId);
}
