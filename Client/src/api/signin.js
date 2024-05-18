/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-16 06:13:54
 * @LastEditTime: 2024-05-18 13:21:21
 * @FilePath: \Client\src\api\signin.js
 * @Describe: 
 */
// 注册接口
import request from '@/utils/request'

export const readsign = (id) => {
  return request.post('/button/select_attendance', {id: id})
}

export const sign = (id) => {
  return request.post('/button/attendance', {id: id})
}
