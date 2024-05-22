package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.entityRequest.Subjects_big;
import cc.nanoic.ucsp.server.entity.entityRequest.Subjects_small;
import cc.nanoic.ucsp.server.mapper.StudyMenuMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @FileName StudyMenuService
 * @Description
 * @Author fazhu
 * @date 2024-05-18
 **/
@Service
public class StudyMenuService {
    @Resource
    StudyMenuMapper studyMenuMapper;

    public ArrayList<Subjects_big> select(){
       return studyMenuMapper.select();
    }
    public ArrayList<Subjects_small> select_small(Subjects_big subjects_big){

        return studyMenuMapper.select_small(subjects_big.getId());

    }

}
