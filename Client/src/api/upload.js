// 上传接口
import request from '@/utils/request'

export const upload = (file) => {
  return request.post('/upload/image', {files : file})
}