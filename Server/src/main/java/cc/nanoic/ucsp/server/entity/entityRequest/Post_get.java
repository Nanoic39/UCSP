package cc.nanoic.ucsp.server.entity.entityRequest;

import lombok.Data;

import java.util.Date;

/**
 * @FileName Post_get
 * @Description
 * @Author fazhu
 * @date 2024-05-27
 **/
@Data
public class Post_get {
    private String title;//文章标题
    private String  content;//文章正文
    private String user_name;//作者名
    private Date update_time;//最后一次更新时间
    private Integer like_num;//点赞数
    private Integer comment_num;//评论数
    private Integer collection_num;//收藏数
}
