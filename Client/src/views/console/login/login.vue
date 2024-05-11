<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-27 13:01:07
 * @LastEditTime: 2024-05-12 00:41:51
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
          <input
            type="password"
            class="passwordInput"
            placeholder="请输入密码"
            v-model="password"
          />
        </div>
        <!-- 登录 -->
        <div class="submit" @click="login">登 录</div>
      </div>
      <div></div>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { debounceRef, debounceFunc } from '@/utils/debounce/debounce.js'
import request from '@/utils/request'

const account = ref('')
const password = ref('')

function login() {
  // request.post("/register", {account: account.value, password: password.value, phone: 100000}).then(res => {
  //   console.log(res.data)
  // })

  request.post('/login', { account: account.value, password: password.value }).then((res) => {
    console.log(res.data)
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
        background-color: var(--theme-blue-deep);
      }
    }
  }
}
</style>
