package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.entity.entityRequest.Subjects_big;
import cc.nanoic.ucsp.server.entity.entityRequest.Subjects_small;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * @FileName StudyMenuMapper
 * @Description
 * @Author fazhu
 * @date 2024-05-18
 **/
@Mapper
public interface StudyMenuMapper {

    @Select("select id,subjects_big from `subjects_big`")
    ArrayList<Subjects_big> select();

    @Select("select * from `subjects_small` where `subjects_big`=#{id}")
    ArrayList<Subjects_small> select_small(@Param("id") Integer id);
}
