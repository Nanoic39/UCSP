import { defineStore } from 'pinia'
import { ref } from 'vue'

// 用户模块 token setToken removeToken
// big-user是一个唯一标识，使用来作区分的
export const studypostStore = defineStore(
  'study-content',
  () => {
    const studycontents = ref(null)

    const setstudycontents = (newCount) => {
      studycontents.value = newCount
    }

    const removestudycontents = () => {
      studycontents.value = ''
    }

    
    // 将token暴露出去
    return {
        studycontents,
        setstudycontents,
        removestudycontents
    }
  },
  // 如果想要持久化处理
  {
    persist: true
  }
)
