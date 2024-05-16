// // 导入axios
// import axios from 'axios';

// // 创建自定义axios实例
// const customAxios = axios.create({
//   baseURL: 'http://146.56.193.5:4514', // 设置基础URL为localhost:9090
//   timeout: 5000, // 设置请求超时时间
//   headers: {
//     'Content-Type': 'application/json', // 设置默认请求头
//   },
// });

// // 添加请求拦截器
// customAxios.interceptors.request.use(
//   (config) => {
//     // 在发送请求之前做些什么，比如添加token
//     config.headers.Authorization = `Bearer ${localStorage.getItem('token')}`;
//     return config;
//   },
//   (error) => {
//     // 对请求错误做些什么
//     return Promise.reject(error);
//   }
// );

// // 添加响应拦截器
// customAxios.interceptors.response.use(
//   (response) => {
//     // 对响应数据做些什么，比如处理通用的错误状态
//     return response.data;
//   },
//   (error) => {
//     // 对响应错误做些什么
//     return Promise.reject(error);
//   }
// );

// // 导出自定义axios实例
// export default customAxios;

/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-12 00:14:45
 * @LastEditTime: 2024-05-12 16:38:27
 * @FilePath: \Client\src\utils\request.js
 * @Describe:
 */
import axios from 'axios'
import { ElMessage } from 'element-plus'
// import router from '@/router'

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
    if (res.data.statusCode != '200') {
      ElMessage({
        message: res.data.msg,
        type: 'warning',
      })
      return Promise.reject(res.data)
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
