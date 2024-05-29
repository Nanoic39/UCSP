import { defineStore } from 'pinia'
import { ref } from 'vue'

// 用户模块 token setToken removeToken
// big-user是一个唯一标识，使用来作区分的
export const studypostStore = defineStore(
  'study-post',
  () => {
    const postvalues = ref(null)
    const poststate = ref(null)

    const setpostvalues = (newCount) => {
        postvalues.value = newCount
    }
    const setpoststate = (newCount) => {
      poststate.value = newCount
  }

    const removepostvalues = () => {
        postvalues.value = ''
    }

    
    // 将token暴露出去
    return {
        poststate,
        postvalues,
        setpoststate,
        setpostvalues,
        removepostvalues
    }
  },
  // 如果想要持久化处理
  {
    persist: true
  }
)
