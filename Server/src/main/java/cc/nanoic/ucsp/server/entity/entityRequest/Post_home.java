package cc.nanoic.ucsp.server.entity.entityRequest;

import lombok.Data;

import java.util.Date;

/**
 * @FileName Post_home
 * @Description
 * @Author fazhu
 * @date 2024-05-26
 **/
@Data
public class Post_home {
    private Integer id;//文章id（自增）
    private String title;//文章标题
    private Integer author_id;//作者ID
    private String author_name;//作者姓名
    private String intro;//摘要
    private Integer status;//状态
    private String  post_cover;//文章封面
    private Integer auth;//访问权限
    private Integer like_num;//点赞数
    private Integer comment_num;//评论数
    private Integer collection_num;//收藏数
    private String tag;//标签

}
