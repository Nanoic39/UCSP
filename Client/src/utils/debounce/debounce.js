/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-16 06:13:54
 * @LastEditTime: 2024-05-22 16:58:27
 * @FilePath: \Client\src\utils\debounce\debounce.js
 * @Describe:
 */
import { customRef } from 'vue'

const debounceFunc = (func, delay) => {
  let timer = null
  return (...args) => {
    if (timer) {
      clearTimeout(timer)
    }
    timer = setTimeout(function () {
      if (typeof func == 'function') {
        func.call(this, ...args)
      } else if (typeof func == 'string') {
        eval(func)
      } else {
        console.log('未知格式，无法执行\r\n' + `格式：${typeof func}\r\n` + `内容：${func}`)
      }
    }, delay)
  }
}

const debounceRef = (value, delay = 1000) => {
  let timer = null
  return customRef((track, trigger) => {
    return {
      get() {
        //收集依赖，返回数据
        track()
        return value
      },
      set(val) {
        //派发更新
        clearTimeout(timer)
        timer = setTimeout(function () {
          trigger()
          value = val
        }, delay)
      }
    }
  })
}

export { debounceRef, debounceFunc }
