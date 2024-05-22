package cc.nanoic.ucsp.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMassage {
    //获取当前用户id
    @Select("select #{id} from `user_role` where `id` = #{id}")
    Integer returnId(@Param("id")Integer id,
                         @Param("id")String field);
    //获取当前用户user_id
    @Select("select #{userId} from `user_role` where `id` = #{id}")
    Integer returnUserId(@Param("userId")String field,
                         @Param("id")Integer id);
    //获取当前用户sex
    @Select("select #{sex} from `user_role` where `id` = #{id}")
    String returnSex(@Param("sex")String field,
                      @Param("id")Integer id);
    //获取当前用户age
    @Select("select #{age} from `user_role` where `id` = #{id}")
    Integer returnAge(@Param("age")String field,
                      @Param("id")Integer id);
    //获取当前用户hobby
    @Select("select #{hobby} from `user_role` where `id` = #{id}")
    String returnHobby(@Param("hobby")String field,
                       @Param("id")Integer id);

    @Select("select #{day} from `attendance` where `id` = #{id}")
    Integer returnDay(@Param("day")String field,
                      @Param("id")Integer id);

    @Select("select #{level} from `authority` where `id` = #{id}")
    Integer returnLevel(@Param("level")String field,
                        @Param("id")Integer id);

    @Select("select #{levelIntro} from `authority` where `id` = #{id}")
    String returnLevelIntro(@Param("levelIntro")String field,
                            @Param("id")Integer id);

    @Select("select #{authorityId} from `role_authority` where `id` = #{id}")
    Integer returnAuthorityId(@Param("authority")String field,
                              @Param("id")Integer id);


}
