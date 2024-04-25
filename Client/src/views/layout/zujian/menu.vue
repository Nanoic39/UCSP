<<<<<<< Updated upstream
﻿<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <el-row class="head">
    <el-col :span="4" class="left"></el-col>
    <el-col :span="14" class="middle">
      <router-link to="/home">首页</router-link>
      <router-link to="/life">生活服务</router-link>
      <router-link to="/study">学习资料</router-link>
      <router-link to="/trip">旅游出行</router-link>
    </el-col>
    <el-col :span="6" class="right">
      <el-col :span="7" :offset="3">
        <div class="user">
          <el-icon class="user1"><User /></el-icon>
        </div>
      </el-col>
      <el-col :span="13"><searchContainer></searchContainer></el-col>
    </el-col>
  </el-row>
</template>

<script setup>
import searchContainer from '@/views/layout/zujian/searchContainer.vue'
import { User } from '@element-plus/icons-vue'
</script>

<style lang="scss" scoped>
.head {
  height: 100px;
  background: linear-gradient(to bottom, #04287d, #0b75df);

  .right {
    display: flex;
    align-items: center;
    .user {
      width: 40px;
      height: 40px;
      background-color: #fff;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);
      border-radius: 40px;
      position: relative;
      overflow: hidden;
      font-size: 30px;
      .user1 {
        width: 40px;
        height: 40px;
        display: flex;
        justify-content: center;
        align-items: center;
        cursor: pointer;
      }
    }
  }
  .left {
    height: 100%;
    background-image: url('@/assets/logo2.png');
    background-size: contain;
    background-repeat: no-repeat;
    background-position: 30px;
  }
  .middle {
    box-sizing: border-box;
    font-family: sans-serif;
    display: flex;
    justify-content: space-around;
    align-items: center;
    a {
      position: relative;
      padding: 10px 30px;
      // margin: 0 15px;
      color: #ffc000;
      text-decoration: none;
      font-weight: 700;
      text-transform: uppercase;
      letter-spacing: 2px;
      font-size: 20px;
      overflow: hidden;
      transition: 0.2s;
      -webkit-box-reflect: below 1px linear-gradient(transparent, #0003);
    }
    a:nth-child(1) {
      filter: hue-rotate(50deg);
    }

    a:nth-child(2) {
      filter: hue-rotate(200deg);
    }

    a:nth-child(3) {
      filter: hue-rotate(300deg);
    }

    a:nth-child(4) {
      filter: hue-rotate(500deg);
    }

    a:hover {
      background: #ffc000;
      color: #111;
      box-shadow: 0 0 50px #ffc000;
      transition-delay: 0.2s;
    }

    a:before {
      content: '';
      position: absolute;
      top: 0;
      left: 0;
      width: 10px;
      height: 10px;
      border-top: 2px solid #ffc000;
      border-left: 2px solid #ffc000;
      transition: 0.2s;
      transition-delay: 0.2s;
    }

    a:hover:before {
      width: 100%;
      height: 100%;
      transition-delay: 0s;
    }

    a:after {
      content: '';
      position: absolute;
      bottom: 0;
      right: 0;
      width: 10px;
      height: 10px;
      border-bottom: 2px solid #ffc000;
      border-right: 2px solid #ffc000;
      transition: 0.2s;
      transition-delay: 0.2s;
    }

    a:hover:after {
      width: 100%;
      height: 100%;
      transition-delay: 0s;
=======
﻿<script setup>
import { Search, Bell } from '@element-plus/icons-vue'
import '@/assets/font/font.css'
</script>

<template>
  <div class="topmenu">
    <div class="logo">
      <img src="/src/assets/layout/One-stop campus website.png" alt="" />
    </div>
    <div class="menus">
      <div class="menuFirst">首页</div>
      <div class="menuSecond">通达论坛</div>
      <div class="menuThird">学习资源</div>
      <div class="menuFourth">教务大厅</div>
      <div class="menuFifth">跑腿互助</div>
    </div>
    <el-input class="search">
      <template #prefix>
        <el-button class="clear">
          <el-icon><Search /></el-icon>
        </el-button>
      </template>
    </el-input>
    <div class="message">
      <el-icon><Bell /></el-icon>
    </div>
    <div class="headimg">
      <img src="/src/assets/layout/211540yrmp8w0prt8opzm0.jpg" alt="" />
    </div>
  </div>
</template>
<style lang="scss" scoped>
.topmenu {
  height: 74px;
  width: 100%;
  background-color: #ffffff;
  .logo {
    width: 138px;
    height: 45px;
    position: absolute;
    left: 51px;
    top: 19px;
    img {
      width: 138px;
      height: 45px;
    }
  }
  .menus {
    width: 720px;
    height: 27px;
    position: absolute;
    top: 26px;
    left: 247px;
    font-size: 20px;
    color: #3d3d3d;
    .menuFirst {
      width: 40px;
      height: 27px;
      position: absolute;
      left: 0;
    }
    .menuSecond,
    .menuThird,
    .menuFourth,
    .menuFifth {
      width: 80px;
      height: 27px;
    }
    .menuSecond {
      position: absolute;
      left: 130px;
    }
    .menuThird {
      position: absolute;
      left: 300px;
    }
    .menuFourth {
      position: absolute;
      left: 470px;
    }
    .menuFifth {
      position: absolute;
      right: 0;
    }
  }
  :deep(.search) {
    width: 245px;
    height: 36px;
    position: absolute;
    left: 1018px;
    top: 21px;
    border-radius: 100px;
    border: 1px solid #d8d8d8;

    .el-input-group__prepend {
      border-radius: 100px;
      box-shadow: 0 0 0 0px;
    }

    .el-input__wrapper {
      border-radius: 100px;
      box-shadow: 0 0 0 0px;
    }

    .el-input-group__append {
      border-radius: 100px;
      box-shadow: 0 0 0 0px;
    }
    .clear {
      border: 0;
      width: 20px;
      height: 20px;
      border-radius: 30px;
      position: absolute;
      right: 0;
      cursor: pointer;
    }
  }
  .message {
    width: 35px;
    height: 29px;
    position: absolute;
    left: 1286px;
    top: 22px;
    font-size: 33px;
    color: #a6c5f6;
  }
  .headimg {
    width: 50px;
    height: 50px;
    position: absolute;
    left: 1341px;
    top: 14px;
    border-radius: 50px;
    img {
      width: 50px;
      height: 50px;
      border-radius: 50px;
>>>>>>> Stashed changes
    }
  }
}
</style>
