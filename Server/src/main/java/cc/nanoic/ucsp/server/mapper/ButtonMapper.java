package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

@Mapper
public interface ButtonMapper {
    /**
     *更新点赞数
     */
    @Update("update `#{post}`set `like_num`=#{like_num} where `id`=#{id}")
    void zan(
            @Param("post") String post,
            @Param("like_num") Integer like_num,
            @Param("id") Integer id
            );
    /**
     * 查询所有
     * */
    @Select("select * from `attendance` where user_id=#{user_id}")
    Attendance attendance(@Param("user_id") Integer user_id);

    /**
     * 查询总签到数
     * */
    @Select("select `day` from `attendance` where user_id=#{user_id}")
    Integer attendance_day(
            @Param("user_id") Integer user_id
    );
    /**
     * 查询月内签到数
     * */
    @Select("select `month_day` from `attendance` where user_id=#{user_id}")
    String attendance_month_day(
            @Param("user_id") Integer user_id
    );
    /**
     * 查询状态
     * */
    @Select("select `status` from `attendance` where user_id=#{user_id}")
    Boolean attendance_status(
            @Param("user_id") Integer user_id
    );
    /**
     * 改变状态
     * */
    @Select("update `attendance` set status= 1  where user_id=#{user_id}")
    void  attendance_status1(
            @Param("user_id") Integer user_id
    );
    @Select("update `attendance` set status= 0  ")
    void  attendance_status2(

    );
    /**
     * 更新总签到数
     * */
    @Update("update `attendance` set day=#{day} , month_day=#{month_day} where user_id=#{user_id}")
    void attendance_up(
            @Param("day") Integer day,
            @Param("user_id") Integer user_id,
            @Param("month_day") String month_day
            );
}
