import request from '@/utils/request'

export const poststudys = ({title,content,tag,intro,post_cover}) => {
  return request.post('/study/postinsert',{title,content,tag,intro,post_cover})
}

// 读取学习帖子
export const readstudypost = ({num,type}) => {
  return request.post('/transmit/time',{number,type})
}

// 按属性读取学习帖子
export const readstudytype = ({num,type,subjects}) => {
  return request.post('/transmit/type',{num,type,subjects})
}

// 读取具体文章内容
export const studycontent = ({type,post_id}) => {
  return request.post('/post/get',{type,post_id})
}