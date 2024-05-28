package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Attendance;
import org.apache.ibatis.annotations.*;
import org.springframework.data.annotation.CreatedBy;


@Mapper
public interface AttendanceMapper {

    /**
     * 查询所有
     */
    @Select("select * from `attendance` where user_id=#{user_id}")
    Attendance attendance(@Param("user_id") Integer user_id);

    /**
     * 查询总签到数
     */
    @Select("select `day` from `attendance` where user_id=#{user_id}")
    Integer attendance_day(
            @Param("user_id") Integer user_id
    );

    /**
     * 查询月内签到数
     */
    @Select("select `month_day` from `attendance` where user_id=#{user_id}")
    String attendance_month_day(
            @Param("user_id") Integer user_id
    );

    /**
     * 查询状态
     */
    @Select("select `status` from `attendance` where user_id=#{user_id}")
    Boolean attendance_status(
            @Param("user_id") Integer user_id
    );

    /**
     * 改变状态
     */
    @Select("update `attendance` set status= 1  where user_id=#{user_id}")
    void attendance_status1(
            @Param("user_id") Integer user_id
    );



    /**
     * 更新总签到数
     */
    @Update("update `attendance` set day=#{day} , month_day=#{month_day} where user_id=#{user_id}")
    void attendance_up(
            @Param("day") Integer day,
            @Param("user_id") Integer user_id,
            @Param("month_day") String month_day
    );


    @Insert("insert into `attendance` values (null,#{user_id},0,null,0)")
    void attendance_In(
            @Param("user_id") Integer user_id
    );

    @Select("select id from `user` where account=#{account}")
    Integer last_id(
            @Param("account") String account
    );

    /**
     * 每日刷新
     */
    @Update("update `attendance` set status= 0  ")
    void attendance_status2();//状态码更新

    @Update("update  `attendance` set day=0 where status= 0")
    void attendance_status3();//未签到清零

    /**
     * 每月刷新
     */
    @Update("update  `attendance` set `month_day`=null ")
    void attendance_status4();//每月清零

}
