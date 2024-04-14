import { userGetInfoService } from '@/api/user'
import { defineStore } from 'pinia'
import { ref } from 'vue'

// 用户模块 token setToken removeToken
// big-user是一个唯一标识，使用来作区分的
export const useUserStore = defineStore(
  'big-user',
  () => {
    const token = ref('')
    // 更新token
    const setToken = (newToken) => {
      token.value = newToken
    }
    // 移除token
    const removeToken = () => {
      token.value = ''
    }

    // 清除user信息的方法
    const setUser = (obj) => {
      user.value = obj
    }

    //封装获取数据的方法，后面再到主页面文件去导入方法并调用
    const user = ref({})
    const getUser = async () => {
      const res = await userGetInfoService() //请求获取数据
      user.value = res.data.data //存数据
    }

    // 将token暴露出去
    return {
      token,
      setToken,
      removeToken,
      user,
      getUser,
      setUser
    }
  },
  // 如果想要持久化处理
  {
    persist: true
  }
)
