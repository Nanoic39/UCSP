package cc.nanoic.ucsp.server.entity;

import lombok.Data;

@Data
public class Posts {
    private Integer id;//自增id
    private Integer posts_id;//文章id
    private String  posts_content;//文章正文
    private String posts_title;//文章标题
    private Byte posts_image;//文章图片
    private Integer posts_state;//帖子状态
    private Integer Posts_praise;//帖子点赞数
}
