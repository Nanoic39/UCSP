package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.Post;

import cc.nanoic.ucsp.server.entity.entityRequest.Post_get;
import cc.nanoic.ucsp.server.entity.entityRequest.Post_home;
import cc.nanoic.ucsp.server.mapper.PostMapper;
import cc.nanoic.ucsp.server.mapper.TransmitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;


import java.util.ArrayList;
import java.util.Arrays;

import static cc.nanoic.ucsp.server.common.Confignature.URL_IMAGE;


@Service
public class TransmitService {
    @Autowired
    TransmitMapper TransmitMapper;
    @Autowired
    PostMapper PostMapper;


    //查询最新帖子
    public ArrayList<Post_home> time(String type, Integer number){
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
        ArrayList<Post_home> array=new ArrayList<>();
        int s=(i / 3000000 + 1);//利用帖子总数确定表数
        ps=p+""+s;

        if (i % 3000000 == 0) ps = p + (i / 3000000);
        Integer max = PostMapper.numSelectMax(ps) - number * 10;
        if (max == null) max = 3000000;
        max++;
        i++;


        try {
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
                    }

                }
                Post_home end=TransmitMapper.newPost(ps,max);
                if (i%3000000==0)i--;
                int k=(i / 3000000)*3000000;
                end.setId(TransmitMapper.newPost(ps,max).getId()+k);
                end.setAuthor_name(TransmitMapper.user_name(end.getAuthor_id()));
                array.add(end);
            }
            return  array;
        } catch (Exception e) {
            return  array;
        }
    }

    //查询一个帖子
    public Post_get post_select(String type, Integer id) {
        Integer a = id / 3000000;
        type = type + "_" + (a + 1);
        id = id % 3000000;
        return TransmitMapper.post_get(type, id);
    }


    //按类型查询学习区帖子
    public ArrayList<Post_home> type(String type, Integer num, String subjects) {
        ArrayList<Post_home> array = null;
        try {
            String p = null;
            String ps = null;
            switch (type) {
                case "post":
                    p = "post_";
                    break;
                case "studypost":
                    type = "study_post";
                    p = "studypost_";
                    break;
                case "sharepost":
                    type = "study_post";
                    p = "sharepost_";
                    break;
            }
            Integer i = PostMapper.numSelect(type) - num * 10;//i为当前此种帖子总数
            int s = (i / 3000000 + 1);//利用帖子总数确定表数
            ps = p + "" + s; //拼接表名

            if (i % 3000000 == 0) ps = p + (i / 3000000);

            array= TransmitMapper.newPost_type2(ps,subjects,num*10,10);

//            if(array.size()!=10){
//                num2=10-array.size();
//                ps=p+""+(s-1);
//                ArrayList<Post_home> array2=TransmitMapper.newPost_type2(ps,subjects,0,num2);
//                for (Post_home e:array2){
//                    e.setAuthor_name(TransmitMapper.user_name(e.getAuthor_id()));
//                    e.setId(s*3000000+e.getId());  }
//                array.addAll(array2);
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return array;
    }

}
