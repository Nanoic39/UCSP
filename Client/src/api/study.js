import request from '@/utils/request'

export const readstudy = () => {
  return request.get('/studymenu_big')
}