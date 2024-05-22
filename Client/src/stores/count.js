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

    const firstmenu = ref('')

    const setfirstmenu = (newfirstmenu) => {
      firstmenu.value = newfirstmenu
    }

    const removefirstmenu = () => {
      firstmenu.value = 0
    }

    const collect = ref('')

    const setcollect = (newcollect) => {
      collect.value = newcollect
    }

    const removecollect = () => {
      collect.value = 0
    }

    const index = ref(0)

    const setindex = (newindex) => {
      index.value = newindex
    }

    const removeindex = () => {
      index.value = 0
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
        removetop,
        firstmenu,
        setfirstmenu,
        removefirstmenu,
        collect,
        setcollect,
        removecollect,
        index,
        setindex,
        removeindex
    }
  },
  // 如果想要持久化处理
  {
    persist: true
  }
)
