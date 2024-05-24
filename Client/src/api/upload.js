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
