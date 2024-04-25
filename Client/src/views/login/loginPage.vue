<<<<<<< Updated upstream
﻿<script setup>
import { User, Lock } from '@element-plus/icons-vue'
import { ref } from 'vue'
import dna from './zujianLogin/dna.vue'
const isRegister = ref(true)
</script>

<template>
  <el-row class="login-page">
    <el-col :span="12" class="bg"></el-col>
    <el-col :span="6" :offset="3" class="form">
      <dna></dna>
      <div class="login_form_container">
        <el-form
          ref="form"
          size="large"
          class="login_form"
          autocomplete="off"
          v-if="isRegister"
        >
          <el-form-item>
            <h1>注册</h1>
          </el-form-item>
          <el-form-item>
            <el-input :prefix-icon="User" placeholder="请输入用户名"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input
              :prefix-icon="Lock"
              type="password"
              placeholder="请输入密码"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-input
              :prefix-icon="Lock"
              type="password"
              placeholder="请输入再次密码"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button class="button" type="primary" auto-insert-space>
              注册
            </el-button>
          </el-form-item>
          <el-form-item class="flex">
            <el-link type="info" :underline="false" @click="isRegister = false">
              ← 返回
            </el-link>
          </el-form-item>
        </el-form>

        <el-form
          ref="form"
          size="large"
          autocomplete="off"
          class="login_form"
          v-else
        >
          <el-form-item>
            <h1>登录</h1>
          </el-form-item>
          <el-form-item>
            <i class="fa fa-user"></i>
            <el-input
              :prefix-icon="User"
              placeholder="请输入账号"
              autocomplete="off"
            ></el-input>
          </el-form-item>

          <el-form-item class="input_group">
            <i class="fa fa-unlock-alt"></i>
            <el-input
              name="password"
              :prefix-icon="Lock"
              type="password"
              placeholder="请输入密码"
              autocomplete="off"
            ></el-input>
          </el-form-item>

          <el-form-item class="input_group">
            <i class="fa fa-unlock-alt"></i>
            <el-input
              name="password"
              :prefix-icon="Lock"
              type="password"
              placeholder="请输入验证码"
              autocomplete="off"
              class="yanzheng"
            ></el-input>
            <el-button class="btn" type="primary" auto-insert-space
              >发送验证码</el-button
            >
          </el-form-item>

          <el-form-item class="flex">
            <el-checkbox>我已阅读并同意用户隐私条款和用户规范</el-checkbox>
          </el-form-item>
          <el-form-item>
            <el-button class="button" type="primary" auto-insert-space
              >登录</el-button
            >
          </el-form-item>
          <el-form-item class="flex">
            <div class="flex">
              <el-link
                type="info"
                :underline="false"
                @click="isRegister = true"
              >
                注册 →
              </el-link>
              <el-link type="primary" :underline="false">忘记密码？</el-link>
            </div>
          </el-form-item>
        </el-form>
      </div>
    </el-col>
  </el-row>
</template>

<style lang="scss" scoped>
.login-page {
  height: 100vh;
  background-color: #fff;
  .bg {
    background:
      url('@/assets/logo2.png') no-repeat 60% center / 240px auto,
      url('@/assets/login_bg.jpg') no-repeat center / cover;
    border-radius: 0 20px 20px 0;
  }
  .form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    user-select: none;
    .title {
      margin: 0 auto;
    }
    .button {
      width: 100%;
    }
    .flex {
      width: 100%;
      display: flex;
      justify-content: space-between;
    }
  }
}
.yanzheng {
  width: 200px;
}
.login_form_container {
  position: relative;
  width: 400px;
  height: 530px;
  background: #040717;
  border-radius: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
  overflow: hidden;
  margin-top: 70px;
  box-shadow:
    30px 30px 30px -10px rgba(0, 0, 0, 0.65),
    inset 15px 15px 10px rgba(255, 255, 255, 0.75),
    -15px -15px 35px rgba(255, 255, 255, 0.55),
    inset -1px -1px 10px rgba(0, 0, 0, 0.2);
}
.login_form_container::before {
  position: absolute;
  width: 170%;
  height: 170%;
  content: '';
  background-image: conic-gradient(
    hsl(360, 100%, 50%),
    hsl(315, 100%, 50%),
    hsl(270, 100%, 50%),
    hsl(225, 100%, 50%),
    hsl(180, 100%, 50%),
    hsl(135, 100%, 50%),
    hsl(90, 100%, 50%),
    hsl(45, 100%, 50%),
    hsl(0, 100%, 50%)
  );
  animation: rotate_border 6s linear infinite;
  animation-delay: -3s;
}
.login_form_container::after {
  position: absolute;
  width: 170%;
  height: 170%;
  content: '';
  background-image: conic-gradient(
    hsl(360, 100%, 50%),
    hsl(315, 100%, 50%),
    hsl(270, 100%, 50%),
    hsl(225, 100%, 50%),
    hsl(180, 100%, 50%),
    hsl(135, 100%, 50%),
    hsl(90, 100%, 50%),
    hsl(45, 100%, 50%),
    hsl(0, 100%, 50%)
  );
  animation: rotate_border 6s linear infinite;
  animation-delay: -3s;
}
@keyframes rotate_border {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}
.login_form {
  position: absolute;
  content: '';
  background-color: #a7c5e0;
  border-radius: 50px;
  inset: 5px;
  padding: 50px 40px;
  z-index: 100;
  color: #00a6ff;
}
h2 {
  font-size: 40px;
  font-weight: 600;
  text-align: center;
}
.input_group {
  margin-top: 20px;
  position: relative;
  display: flex;
  align-items: center;
  justify-content: start;
}
.input_text {
  width: 95%;
  height: 30px;
  background: transparent;
  border: none;
  border-bottom: 1px solid #ffd700;
  font-size: 20px;
  padding-left: 10px;
  color: #ffd700;
}
::placeholder {
  font-size: 15px;
  color: #ffd700;
  letter-spacing: 1px;
}
.fa {
  font-size: 20px;
}
#login_button {
  position: relative;
  width: 300px;
  height: 20px;
  transition: 1s;
  margin-top: 70px;
}
#login_button a {
  position: absolute;
  width: 100%;
  height: 100%;
  text-decoration: none;
  z-index: 10;
  cursor: pointer;
  font-size: 22px;
  letter-spacing: 2px;
  border: 1px solid #00ccff;
  border-radius: 50px;
  background-color: #ffd700;
  display: flex;
  justify-content: center;
  align-items: center;
}
.fotter {
  margin-top: 30px;
  display: flex;
  justify-content: space-between;
}
.fotter a {
  text-decoration: none;
  cursor: pointer;
  font-size: 18px;
}
.glowIcon {
  text-shadow: 0 0 10px #00ccff;
}
</style>
=======
﻿
>>>>>>> Stashed changes
