package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.mapper.PostMapper;
import cc.nanoic.ucsp.server.mapper.TransmitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

@Service
public class TransmitService {
    @Autowired
    TransmitMapper  TransmitMapper;
    @Autowired
    PostMapper PostMapper;

    //查询最新帖子
    public ArrayList<Post> time(Integer a){
        Integer i=PostMapper.numSelect("帖子表")-a*10;//i为当前帖子总数
        ArrayList<Post> array=new ArrayList<Post>();
        String p = "post_" + (i / 3000000 + 1);//利用帖子总数确定表数
        if (i % 3000000 == 0) p = "post_" + (i / 3000000);
        Integer max = PostMapper.numSelectMax(p)-a*10;
        if (max == null) max = 3000000;
        max++;i++;
        for (int o=0;o<10;o++) {
            i--;
            max--;
            for(;TransmitMapper.newPost(p,max)==null;) {
                max--;i--;
                if(max<=0)
                {
                    max=3000000;
                    p = "post_" + (i / 3000000+1);//利用帖子总数确定表数
                    if (i % 3000000 == 0) p = "post_" + ((i / 3000000));
                    System.out.println(p);
                }
            }
            System.out.println(i);
            System.out.println(TransmitMapper.newPost(p,max).getId()+(i / 3000000)*3000000);
            Post end=TransmitMapper.newPost(p,max);
            end.setId(TransmitMapper.newPost(p,max).getId()+(i / 3000000)*3000000);
            array.add(end);
        }
        return  array;
    }
}
