// 注册接口
import customAxios from '@/utils/request'

export const userRegisterService = ({ account, password, phone }) =>
customAxios.post('http://localhost:9090/register', { account, password, phone })