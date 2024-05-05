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
    public ArrayList<Post> time(String type,Integer number){
        Integer i=PostMapper.numSelect(type)-number*10;//i为当前帖子总数
        ArrayList<Post> array=new ArrayList<>();
        String p=null;    String ps=null;
        switch (type){
            case "post":
                 p = "post_" ;
            break;
            case "study":
                p = "studypost_" ;
            break;
            case "share":
                p = "sharepost_" ;
            break;
        }
        ps=p+ (i / 3000000 + 1);//利用帖子总数确定表数

        if (i % 3000000 == 0) ps = p + (i / 3000000);
        Integer max = PostMapper.numSelectMax(ps)-number*10;
        if (max == null) max = 3000000;
        max++;i++;

        for (int o=0;o<10;o++) {
            i--;
            max--;
            for(;TransmitMapper.newPost(ps,max)==null;) {
                max--;i--;
                if(max<=0)
                {
                    max=3000000;
                    ps = p + (i / 3000000+1);//利用帖子总数确定表数
                    if (i % 3000000 == 0) ps = p + ((i / 3000000));
                    System.out.println(ps);
                }
            }
            System.out.println(i);
            System.out.println(TransmitMapper.newPost(ps,max).getId()+(i / 3000000)*3000000);
            Post end=TransmitMapper.newPost(ps,max);
            end.setId(TransmitMapper.newPost(ps,max).getId()+(i / 3000000)*3000000);
            array.add(end);
        }
        return  array;
    }
}
