import { defineStore } from 'pinia'
import { ref } from 'vue'

// 用户模块 token setToken removeToken
// big-user是一个唯一标识，使用来作区分的
export const usecountStore = defineStore(
  'biger-users',
  () => {
    const top = ref(null)

    const settop = (newCount) => {
      top.value = newCount
    }

    const removetop = () => {
      top.value = ''
    }

    const counts = ref('')

    const setCount = (newCount) => {
      counts.value = newCount
    }

    const removeCount = () => {
      counts.value = ''
    }


    const examinations = ref('')

    const setExaminations = (newexaminations) => {
      examinations.value = newexaminations
    }

    const removeExaminations = () => {
      examinations.value = 0
    }

    const asks = ref('')

    const setAsks = (newasks) => {
      asks.value = newasks
    }

    const removeAsks = () => {
      asks.value = 0
    }
    // 将token暴露出去
    return {
        counts,
        setCount,
        removeCount,
        examinations,
        setExaminations,
        removeExaminations,
        asks,
        setAsks,
        removeAsks,
        top,
        settop,
        removetop
    }
  },
  // 如果想要持久化处理
  {
    persist: true
  }
)
