<!-- eslint-disable vue/multi-word-component-names -->
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
    }
  }
}
</style>
