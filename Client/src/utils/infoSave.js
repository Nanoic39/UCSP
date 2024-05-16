/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-12 11:22:02
 * @LastEditTime: 2024-05-14 11:39:42
 * @FilePath: \Client\src\utils\infosave.js
 * @Describe:
 */
const saveUserInfo = (id, token, account = '') => {
  return localStorage.setItem('user-data', JSON.stringify({ id: id, token: token, account: account }))
}

export { saveUserInfo }
