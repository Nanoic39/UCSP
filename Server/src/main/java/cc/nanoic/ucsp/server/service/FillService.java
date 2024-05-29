package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.mapper.FillMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @FileName FilleService
 * @Description
 * @Author fazhu
 * @date 2024-05-27
 **/
@Service
public class FillService {
    @Resource
    FillMapper fillMapper;

    public void fill(String post_location,String post_name){

    }
}
