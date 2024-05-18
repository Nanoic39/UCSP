/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-12 11:22:02
 * @LastEditTime: 2024-05-18 18:39:15
 * @FilePath: \Client\src\utils\infoSave.js
 * @Describe:
 */
const saveUserInfo = (id, token, account = '') => {
  return localStorage.setItem('user-data', JSON.stringify({ id: id, token: token, account: account }))
}

const saveAdminInfo = (id,level,intro = '') => {
  return localStorage.setItem('user-level', JSON.stringify({ id: id,level:level,intro:intro }))
}


export { saveUserInfo ,saveAdminInfo }
