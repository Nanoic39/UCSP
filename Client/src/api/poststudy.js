// 注册接口
import request from '@/utils/request'

export const poststudys = ({title, content, author_id, tag, intro, post_cover}) => {
    return request.post('/study/postinsert',{title , content , author_id, tag, intro, post_cover} );
};
