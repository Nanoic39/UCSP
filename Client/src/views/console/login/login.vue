<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-27 13:01:07
 * @LastEditTime: 2024-05-16 16:15:44
 * @FilePath: \Client\src\views\console\login\login.vue
 * @Describe: 
-->
<template>
  <div class="main">
    <div class="panel">
      <div class="title">后台管理系统</div>
      <div class="formBox">
        <!-- 账号密码 -->
        <div class="accountBox inputBox">
          <div class="inputTitle">账号：</div>
          <input type="text" class="accountInput" placeholder="请输入账号" v-model="account" />
        </div>
        <div class="passwordBox inputBox">
          <div class="inputTitle">密码：</div>
          <input type="password" class="passwordInput" placeholder="请输入密码" v-model="password" />
        </div>
        <!-- 登录 -->
        <div class="submit" @click="login">登 录</div>
      </div>
      <div></div>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive,onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { debounceRef, debounceFunc } from '@/utils/debounce/debounce.js'
import request from '@/utils/request'
import { saveUserInfo,saveAdminInfo } from '@/utils/infoSave'
import router from '@/router'

const account = ref('')
const password = ref('')
const ConsoleRouter = useRouter()
const isExit = ref(false)
const AdminInfo = ref([])

async function login() {
 // console.log(isExit.value)
  request.post('/login', { account: account.value, password: password.value }).then((res) => {
    console.log(res.data)
    saveUserInfo(res.data.data.id, res.data.data.token, res.data.data.account)
    if (res.data?.statusCode == '200') {
      request.get('/get/authority').then((resp) => {
        console.log(resp.data.data)  
        if (resp.data.statusCode == '200' && resp.data.data != null) {
          resp.data.data.forEach((element) => {
            if (parseInt(element.level) >= 500000) {
              isExit.value = true
              AdminInfo.value.push(element.id, element.level,element.intro)
            }
          })
          if (isExit.value) {
              saveAdminInfo(AdminInfo.value[0],AdminInfo.value[1] ,AdminInfo.value[2])
              //console.log(JSON.parse(localStorage.getItem('user-level'))['intro'])
              ElMessage({
                message: '登录成功',
                type: 'success',
              })
              ConsoleRouter.push('/console/dashboard')
            }else {
              ElMessage({
                message: '您的权限不足',
                type: 'info',
              })
          }
        }
      })
    }
  })
}
</script>

<script></script>

<style lang="scss" scoped>
.main {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-image: var(--image-console-login-background);
  background-size: cover;
  transition: all 0.3s ease;

  .panel {
    width: 1000px;
    height: 500px;
    backdrop-filter: blur(2px);
    background-color: rgba(255, 255, 255, 0.8);
    border-radius: 12px;

    .title {
      text-align: center;
      margin: 20px;
      font-size: 32px;
      /* font-family: ''; */
    }

    .formBox {
      display: flex;
      flex-direction: column;
      align-items: center;

      .accountBox,
      .passwordBox {
        margin: 5px 0;
        display: flex;
        flex-direction: column;

        width: 50%;

        input {
          font-size: 20px;
          font-family: 'RubikMonoOne-Regular';
          height: 40px;
          line-height: 40px;
          padding-left: 10px;
          border-radius: 5px;
          border: 0;
          border-bottom: 2px solid black;
          outline: 0;
        }

        .inputTitle {
          margin: 0 0 5px 0;
          width: fit-content;
          font-size: 16px;
        }
      }

      .submit {
        margin: 35px 0 0 0;
        width: 50%;
        min-height: 55px;
        line-height: 55px;
        font-family: 'ADLaMDisplay-Regular'; //TODO: 字体修改
        font-size: 26px;
        background-color: var(--theme-blue);
        border-radius: 8px;
        text-align: center;
        cursor: pointer;
      }

      .submit:hover {
        background-color: var(--theme-blue-hover);
      }
    }
  }
}
</style>
