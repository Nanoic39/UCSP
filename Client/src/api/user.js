// 注册接口
import request from '@/utils/request'

export const userRegisterService = ({ account, password, phone }) =>
  request.post('/register', { account, password, phone })

export const userLoginService = ({ account, password }) =>
  request.post('/login', { account, password })
