/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-05 16:24:39
 * @LastEditTime: 2024-04-05 16:28:38
 * @FilePath: \Client\src\script\request.ts
 * @Describe:
 */
import axios from 'axios'
import router from '@/router'
/* import Message from '@/components/tips/tips' */

const request = axios.create({
  baseURL: 'http://localhost:9090', //本地后端接口地址
  timeout: 30000 //超时时长
})

request.interceptors.request.use(
  (config) => {
    config.headers['Content-Type'] = 'application/json;charset=UTF-8'
    /*     const user = JSON.parse(localStorage.getItem('user-data') || '{}')
    config.headers['uuid'] = user.uuid
    config.headers['token'] = user.token */
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
    if (res.data.statusCode === '401') {
      router.push('/login')
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
