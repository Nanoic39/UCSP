package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.Holiday;
import cc.nanoic.ucsp.server.mapper.CountdownMapper;
import cn.hutool.core.date.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CountdownService {
    @Autowired
    CountdownMapper countdownMapper;

    public Holiday selectDateByDate(Date date){//查找假日
        return countdownMapper.selectDateByDate(date);
    }

    public Holiday selectDateByName(String name) {
        return countdownMapper.selectDateByName(name);
    }
}
