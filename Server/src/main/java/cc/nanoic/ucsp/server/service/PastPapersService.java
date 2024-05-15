package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.Past_Papers;
import cc.nanoic.ucsp.server.mapper.PastPapersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PastPapersService {
    @Autowired
    PastPapersMapper pastPapersMapper;
    public List<Past_Papers> selectPastPapers(){ return pastPapersMapper.selectPastPapers();}

    public List<Past_Papers> selectPastPapersByType(String papersType) { return pastPapersMapper.selectPastPapersByType(papersType);}

    public void insertPastPapers(String papersName,String papersUrl,String papersType){ pastPapersMapper.insertPastPapers(papersName,papersUrl,papersType); }
}