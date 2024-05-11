import { customRef } from 'vue'

const debounceFunc = (func, delay) => {
  return function () {
    let timer = null
    clearTimeout(timer)
    setTimeout(function () {
      if (typeof func == 'function') {
        func()
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
