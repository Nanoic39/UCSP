package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.Countdown;
import cc.nanoic.ucsp.server.mapper.CountdownMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountdownService {
    @Autowired
    CountdownMapper countdownMapper;

    public Countdown selectDate(Countdown countdown){//查找假日
        return countdownMapper.selectDate(countdown.getHoliday());
    }
}
