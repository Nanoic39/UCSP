/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-05 13:14:12
 * @LastEditTime: 2024-05-22 19:15:30
 * @FilePath: \Client\src\api\user.js
 * @Describe: 
 */
// 注册接口
import request from '@/utils/request'

export const userRegisterService = ({ account, password, phone }) =>
  request.post('/register', { account, password, phone })

export const userLoginService = ({ account, password }) =>
  request.post('/login', { account, password })

export const postsms = (phone) =>
  request.post('/captcha/post', {phone: phone})

export const postcheck = (phone, verify) =>
  request.post('/captcha/check', {phone: phone, verify_code: verify})
