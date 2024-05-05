// 注册接口
import request from '@/utils/request'

export const userRegisterService = ({ account, password, phone }) =>
  request.post('http://localhost:9090/register', { account, password, phone })