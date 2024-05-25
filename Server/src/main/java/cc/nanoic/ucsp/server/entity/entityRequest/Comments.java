package cc.nanoic.ucsp.server.entity.entityRequest;

import lombok.Data;

import java.util.Date;

/**
 * @FileName Comments
 * @Description
 * @Author fazhu
 * @date 2024-05-24
 **/

@Data
public class Comments {
    private Integer id;//自增ID
    private String content;//评论内容
    private Date create_time;//创建时间
    private Integer user_id;//评论者ID
    private Integer post_id;//所属帖子ID
    private Integer like_num;//点赞数
    private Integer comments_id;//所属回复id
    private Integer reply_id;//回复对象评论id
}
