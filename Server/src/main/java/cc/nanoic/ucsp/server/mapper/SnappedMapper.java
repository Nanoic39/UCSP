package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Success_Snapped;
import cc.nanoic.ucsp.server.entity.Active;
import cn.hutool.core.date.DateTime;
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
     * @param: enlistsStartTime
     * @param: enlistsEndTime
     */
    @Insert("insert into `active` values (#{snappedId},0,#{sponsor},#{facultyName},#{gradeName},#{authority},#{activeName},#{activeIntro},#{activeContent},#{preSales},#{preSales},#{enlistsStartTime},#{enlistsEndTime},#{beganStartTime},#{beganEndTime})")
    int addSnapped(@Param("snappedId")Integer snappedId,
                   @Param("sponsor")String sponsor,
                   @Param("facultyName")String facultyName,
                   @Param("gradeName")String gradeName,
                   @Param("authority")Integer authority,
                   @Param("activeName")String activeName,
                   @Param("activeIntro")String activeIntro,
                   @Param("activeContent")String activeContent,
                   @Param("preSales")Integer preSales,
                   @Param("enlistsStartTime")Date enlistsStartTime,
                   @Param("enlistsEndTime")Date enlistsEddTime,
                   @Param("beganStartTime") Date beganStartTime,
                   @Param("beganEndTime")Date beganEndTime);

    /**
     * 查询抢购成功人员
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
    @Select("select `snapped_id`,`enlists_start_time`,`enlists_end_time`,`began_start_time`,`began_end_time` from `active` where `authority`<= #{level} ORDER BY `enlists_start_time` DESC")
    List<Active> selectVisibleActive(@Param("level")Integer level);

    /**
     * 查询活动全部信息
     * @param: snappedId
     */
    @Select("select * from active where snapped_id = #{snappedId}")
    Active selectActiveAll(@Param("snappedId")Integer snappedId);

    /**
     * 改变活动状态码
     * @param: status
     * @param: snappedId
     */
    @Select("update active set `status` = #{status} where snapped_id = #{snappedId}")
    void updateActiveStatus(@Param("status")int status,
                              @Param("snappedId")Integer snappedId);
}
