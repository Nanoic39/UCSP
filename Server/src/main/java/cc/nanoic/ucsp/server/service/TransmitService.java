package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.entity.Post;
import cc.nanoic.ucsp.server.entity.Post_Study;
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
        String p=null;    String ps=null;
        switch (type){
        case "post":
            p = "post_" ;
            break;
        case "study_post":
            p = "studypost_" ;
            break;
        case "share_post":
            p = "sharepost_" ;
            break;
    }
        Integer i=PostMapper.numSelect(type)-number*10;//i为当前帖子总数
        ArrayList<Post> array=new ArrayList<>();
        int s=(i / 3000000 + 1);//利用帖子总数确定表数
        ps=p+""+s;
        System.out.println(ps);



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
                    s-=1;
                    ps = p +""+s;//利用帖子总数确定表数

                    System.out.println(ps);
                    System.out.println(i);
                    System.out.println(max);
                }
            }
//            System.out.println(i);
//            System.out.println(TransmitMapper.newPost(ps,max).getId()+(i / 3000000)*3000000);
            System.out.println(i);
            Post end=TransmitMapper.newPost(ps,max);
            if (i%3000000==0)i--;
            int k=(i / 3000000)*3000000;
            end.setId(TransmitMapper.newPost(ps,max).getId()+k);
            array.add(end);
        }
        return  array;
    }

    //按类型查询学习区帖子
    public ArrayList<Post_Study> type(String type,Integer number,String subjects){
        String p=null;    String ps=null;
        switch (type){
            case "post":
                p = "post_" ;
                break;
            case "study_post":
                p = "studypost_" ;
                break;
            case "share_post":
                p = "sharepost_" ;
                break;
        }
        Integer i=PostMapper.numSelect(type)-number*10;//i为当前帖子总数
        ArrayList<Post_Study> array=new ArrayList<>();
        int s=(i / 3000000 + 1);//利用帖子总数确定表数
        ps=p+""+s;
        System.out.println(ps);

        if (i % 3000000 == 0) ps = p + (i / 3000000);
        Integer max = PostMapper.numSelectMax(ps)-number*10;
        if (max == null) max = 3000000;
        max++;i++;

        for (int o=0;o<10;o++) {
            i--;
            max--;
            for(;TransmitMapper.newPost_type(ps,max,subjects)==null;) {
                max--;i--;
                if(max<=0)
                {
                    max=3000000;
                    s-=1;
                    ps = p +""+s;//利用帖子总数确定表数
                    System.out.println(ps);
                }
            }
            System.out.println(i);
            System.out.println(TransmitMapper.newPost(ps,max).getId()+(i / 3000000)*3000000);
            Post_Study end=TransmitMapper.newPost_type(ps,max,subjects);
            if (i%3000000==0)i--;
            int k=(i / 3000000)*3000000;
            end.setId(TransmitMapper.newPost_type(ps,max,subjects).getId()+k);
            array.add(end);
        }
        return  array;
    }
    //查询一个帖子
    public Post post_select(String type,Integer id){
        Integer a=id/3000000;
        type=type+"_"+(a+1);
        id=id%3000000;

return TransmitMapper.post_get(type,id);
    }
}
