// 上传接口
import request from '@/utils/request'

export const upload = (file) => {
  return request.post(
    '/upload/image',
    { image: file },
    {
      headers: {
        'Content-Type': 'application/form-data'
      }
    }
  )
}
// 删除图片接口
export const Deleteimg = (file_name) => {
  return request.post('/delete/image', {file_name: file_name})
}