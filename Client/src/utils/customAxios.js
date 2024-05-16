/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-05 13:14:12
 * @LastEditTime: 2024-05-12 00:09:08
 * @FilePath: \Client\src\utils\request.js
 * @Describe: 
 */
// 导入axios
import axios from 'axios';

const localBaseURL = "http://localhost:9090";
const devBaseURL = "http://146.56.193.5:4514"

// 创建自定义axios实例
const customAxios = axios.create({
  baseURL: devBaseURL, // 设置基础URL为localhost:9090
  timeout: 5000, // 设置请求超时时间
  headers: {
    'Content-Type': 'application/json', // 设置默认请求头
    'User-Agent': 'Apifox/1.0.0 (https://apifox.com)' // 添加自定义请求头
  },
});

// 添加请求拦截器
customAxios.interceptors.request.use(
  (config) => {
    // 在发送请求之前做些什么，比如添加token
    config.headers.Authorization = `Bearer ${localStorage.getItem('token')}`;
    return config;
  },
  (error) => {
    // 对请求错误做些什么
    return Promise.reject(error);
  }
);

// 添加响应拦截器
customAxios.interceptors.response.use(
  (response) => {
    // 对响应数据做些什么，比如处理通用的错误状态
    return response.data;
  },
  (error) => {
    // 对响应错误做些什么
    return Promise.reject(error);
  }
);

// 导出自定义axios实例
export default customAxios;