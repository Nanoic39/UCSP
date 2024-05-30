// 注册接口
import request from '@/utils/request'

// 发评论
export const postreview = ({ content, post_id, comments_id,reply_id}) => {
    return request.post('/post/comments/insert',{ content, post_id,  comments_id,reply_id} );
};
// 读评论
export const readreview = ({ post_id, num }) => {
    return request.post('/post/comments/get',{  post_id, num} );
};
// 扩展回复
export const morereview = ({ post_id, num }) => {
    return request.post('/post/reply/post',{  post_id, num} );
};