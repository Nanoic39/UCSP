/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-05 13:14:12
 * @LastEditTime: 2024-05-16 12:38:14
 * @FilePath: \Client\src\api\user.js
 * @Describe: 
 */
// 注册接口
import request from '@/utils/request'

export const userRegisterService = ({ account, password, phone }) =>
  request.post('/register', { account, password, phone })

export const userLoginService = ({ account, password }) =>
  request.post('/login', { account, password })
