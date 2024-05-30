/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-29 13:29:09
 * @LastEditTime: 2024-05-29 17:36:56
 * @FilePath: \Client\src\api\active.js
 * @Describe: 
 */
import request from '@/utils/request'

export const getAllActive = () => {
    return request.post('/getAllActive');
};