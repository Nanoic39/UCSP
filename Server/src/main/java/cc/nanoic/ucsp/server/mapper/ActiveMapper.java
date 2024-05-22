package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Active1;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * @FileName ActiveMapper
 * @Description
 * @Author fazhu
 * @date 2024-05-19
 **/
@Mapper
public interface ActiveMapper {

    //根据活动名查询
    @Select("select *from `active` where `active_name`=#{active_name} ")
    ArrayList<Active1> select_active_name(@Param("active_name") String active_name);

    //增加
    @Insert("insert into `active`  value (null,#{sponsor},#{active_name},1,#{active_start_time},#{active_end_time},#{active_range} ,#{authority},#{register_start_time},#{register_end_time},#{num},#{active_intro},#{active_content},#{creat_time},#{update_time})")
    void insert(
            @Param("sponsor") String sponsor,//发起人
            @Param("active_name") String active_name,//活动名
            @Param("active_start_time") Date active_start_time,//活动开始时间
            @Param("active_end_time") Date active_end_time,//活动结束时间
            @Param("active_range") String active_range,//活动范围
            @Param("authority")  Integer authority,//报名权限
            @Param("register_start_time")Date register_start_time,//报名开始时间
            @Param("register_end_time") Date register_end_time,//报名结束时间
            @Param("num") Integer num,//名额
            @Param("active_intro") String active_intro,//活动简介
            @Param("active_content") String active_content,//活动详情内容
            @Param("creat_time") Date creat_time,//创建时间
            @Param("update_time") Date update_time//修改时间

    );
    //删
    @Delete("delete from`active` where id=#{id}")
    void delete(@Param("id") Integer id );
    //活动结束
    @Update("update `active` set status=0 where id=#{id} ")
    void update_delete(@Param("id") Integer id);

    //改
    @Update("update `active`  set active_name=#{active_name},active_start_time=#{active_start_time}," +
            "active_end_time=#{active_end_time},active_range=#{active_range} ,authority=#{authority}," +
            "register_start_time=#{register_start_time},register_end_time=#{register_end_time}," +
            "num=#{num},active_intro=#{active_intro},active_content=#{active_content}," +
            "update_time=#{update_time} where id=#{id}")
    void update(
            @Param("id") Integer id,//ID
            @Param("active_name") String active_name,//活动名
            @Param("active_start_time") Date active_start_time,//活动开始时间
            @Param("active_end_time") Date active_end_time,//活动结束时间
            @Param("active_range") String active_range,//活动范围
            @Param("authority")  Integer authority,//报名权限
            @Param("register_start_time")Date register_start_time,//报名开始时间
            @Param("register_end_time") Date register_end_time,//报名结束时间
            @Param("num") Integer num,//名额
            @Param("active_intro") String active_intro,//活动简介
            @Param("active_content") String active_content,//活动详情内容
            @Param("update_time") Date update_time//修改时间
    );

    //获取最大ID
    @Select("select  MAX(id) from `active`")
    Integer max_id();

    @Select("select *from `active` where id=#{id}")
    Active1 get_id(
            @Param("id") Integer id
    );
}
