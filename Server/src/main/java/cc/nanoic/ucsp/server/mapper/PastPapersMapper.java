package cc.nanoic.ucsp.server.mapper;

import cc.nanoic.ucsp.server.entity.Past_Papers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PastPapersMapper {
    @Select("select * from `past_papers`")
    List<Past_Papers> selectPastPapers();

    /**
     * 通过papersType查询历年真题
     * @param: papersType
     */
    @Select("select * from `past_papers` where type = (#{papersType})")
    List<Past_Papers> selectPastPapersByType(@Param("papersType") String papersType);

    @Update("insert into `past_papers` values (#{papersName},#{papersUrl},#{papersType})")
    void insertPastPapers(
            @Param("papersName") String papersName,
            @Param("papersUrl") String papersUrl,
            @Param("papersType") String papersType
    );
}