package cc.nanoic.ucsp.server.entity.entityRequest;

import cc.nanoic.ucsp.server.entity.Comments_get;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

/**
 * @FileName reply
 * @Description
 * @Author fazhu
 * @date 2024-05-24
 **/
@Data
public class Reply {
        private Integer id;//自增ID

        private Integer post_id;//帖子ID
        private Integer user_id;//评论者ID
        private String user_name;//评论者名
        private String content;//评论内容
        private Date create_time;//创建时间
        private Integer like_num;//点赞数
        private Integer comments_id;//所属回复id
        private Integer reply_id;//回复对象评论id
        private String reply_name;//对象名
    }
