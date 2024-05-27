package cc.nanoic.ucsp.server.mapper;

import cn.hutool.core.date.DateTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMassageMapper {
    //获取当前用户user_id
    @Select("select `user_id` from `user_role` where `id` = #{id}")
    Integer returnUserId(@Param("id")Integer id);
    //获取当前用户sex
    @Select("select `sex` from `user_info` where `id` = #{id}")
    String returnSex(@Param("id")Integer id);
    //获取当前用户age
    @Select("select `age` from `user_info` where `id` = #{id}")
    Integer returnAge(@Param("id")Integer id);
    //获取当前用户hobby
    @Select("select `hobby` from `user_info` where `id` = #{id}")
    String returnHobby(@Param("id")Integer id);
    //获取当前用户签到天数
    @Select("select `day` from `attendance` where `id` = #{id}")
    Integer returnDay(@Param("id")Integer id);
    //获取当前用户权限等级
    @Select("select `level` from `authority` where `id` = #{id}")
    Integer returnLevel(@Param("id")Integer id);
    //获取当前用户权限介绍
    @Select("select `intro` from `authority` where `id` = #{id}")
    String returnLevelIntro(@Param("id")Integer id);
    //获取当前用户权限id
    @Select("select `authority_id` from `role_authority` where `id` = #{id}")
    Integer returnAuthorityId(@Param("id")Integer id);
    //获取当前用户密码
    @Select("select `password` from `user` where `id` = #{id}")
    String returnPassword(@Param("id")Integer id);
    //获取当前用户账号
    @Select("select `account` from `user` where `id` = #{id}")
    String returnAccount(@Param("id")Integer id);
    //获取当前用户电话号
    @Select("select `phone` from `user` where `id` = #{id}")
    String returnPhone(@Param("id")Integer id);
    //获取当前用户邮箱
    @Select("select `email` from `user` where `id` = #{id}")
    String returnEmail(@Param("id")Integer id);
    //获取当前用户注册时间
    @Select("select `registration_date` from `user` where `id` = #{id}")
    DateTime returnRegistrationDate(@Param("id")Integer id);
    //获取当前用户账号激活状态
    @Select("select `status` from `user` where `id` = #{id}")
    int returnStatus(@Param("id")Integer id);
    //获取当前用户账号头像路径
    @Select("select `avatar`from `user` where `id` = #{id}")
    String returnAvatar(@Param("id")Integer id);
    //获取当前用户角色id
    @Select("select `role_id` from `user_role` where `id` = #{id}")
    int returnRoleId(@Param("id")Integer id);

    @Select("select `nickname` from `user_info` where `id` = #{id}")
    String returnNickname(@Param("id") Integer id);
}
