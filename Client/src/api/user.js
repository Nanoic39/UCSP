// 注册接口
import request from '@/utils/request'

export const userRegisterService = ({ account, password, phone }) =>
  request.post('http://146.56.193.5:4514/register', { account, password, phone })

export const userLoginService = ({ account, password }) =>
  request.post('http://146.56.193.5:4514/login', { account, password })