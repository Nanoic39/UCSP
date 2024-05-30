package cc.nanoic.ucsp.server.entity;

import cc.nanoic.ucsp.server.entity.entityRequest.Post_cover;
import lombok.Data;

import java.util.Date;

@Data
public class Post {
    private Integer id;//文章id（自增）
    private String title;//文章标题
    private Integer author_id;//作者ID
    private String intro;//摘要
    private String  content;//文章正文
    private Integer status;//状态
    private Post_cover post_cover;//图片数组
    private Integer auth;//访问权限
    private Date create_time;//创建时间
    private Date update_time;//最后一次更新时间
    private Integer like_num;//点赞数

    private Integer comment_num;//评论数
    private Integer collection_num;//收藏数
    private Integer review;//默认值


}
