package cc.nanoic.ucsp.server.entity;

import cc.nanoic.ucsp.server.entity.entityRequest.Reply;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

/**
 * @FileName comments_get
 * @Description
 * @Author fazhu
 * @date 2024-05-24
 **/
@Data
public class Comments_get {
    private Integer id;//自增ID
    private ArrayList<Reply> comments;//回复的数组
    private Integer post_id;//帖子ID
    private Integer user_id;//评论者ID
    private String user_name;//评论者名字
    private String content;//评论内容
    private Date create_time;//创建时间
    private Integer like_num;//点赞数
    private Integer more;
    private Integer thumbsUp;
}
