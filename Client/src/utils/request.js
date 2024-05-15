/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-12 00:14:45
 * @LastEditTime: 2024-05-15 15:04:32
 * @FilePath: \Client\src\utils\request.js
 * @Describe:
 */
import axios from 'axios'
import router from '@/router'

const localBaseURL = 'http://localhost:9090'
const devBaseURL = 'http://146.56.193.5:4514'
const devLocaltoServerBaseURL = 'http://localhost:4514'

const request = axios.create({
  baseURL: devBaseURL, //本地后端接口地址
  timeout: 30000 //超时时长
})

request.interceptors.request.use(
  (config) => {
    config.headers['Content-Type'] = 'application/json;charset=UTF-8'
    let user = JSON.parse(localStorage.getItem('user-data') || '{}')
    config.headers['uuid'] = user.id
    config.headers['token'] = user.token
    return config
  },
  (error) => {
    console.error('request-error: ' + error)
    return Promise.reject(error)
  }
)

request.interceptors.response.use(
  (response) => {
    let res = response
    if (typeof res === 'string') {
      res = res ? JSON.parse(res) : res
    }
    return res
  },
  (error) => {
    console.error('request-error: ' + error)
    return Promise.reject(error)
  }
)
//导出
export default request
