<script setup>
import $ from 'jquery'
import { onMounted } from 'vue'
import { House, User, ChatRound, Camera, Tools } from '@element-plus/icons-vue'
onMounted(() => {
  const $links = document.querySelectorAll('.menu li a')
  const $indicator = document.querySelector('.menu .indicator')
  for (let i = 0; i < $links.length; i++) {
    $links[i].addEventListener('click', () => {
      $links.forEach(($link) => {
        $link.classList.remove('active')
      })
      $links[i].classList.add('active')
      $indicator.style.left = `${i * 50 + 20}px`
    })
  }
})
</script>

<template>
  <el-row class="topBg">
    <el-col :span="4" class="lefts"></el-col>
    <el-col :span="16">
      <ul class="menu">
        <li>
          <a class="active">
            <el-icon>
              <House />
            </el-icon>
          </a>
          <span>Home</span>
        </li>
        <li>
          <a>
            <el-icon>
              <User />
            </el-icon>
          </a>
          <span>Category</span>
        </li>
        <li>
          <a>
            <el-icon>
              <ChatRound />
            </el-icon>
          </a>
          <span>Chart</span>
        </li>
        <li>
          <a>
            <el-icon>
              <Camera />
            </el-icon>
          </a>
          <span>Inbox</span>
        </li>
        <li>
          <a>
            <el-icon>
              <Tools />
            </el-icon>
          </a>
          <span>Setting</span>
        </li>
        <li class="indicator"></li>
      </ul>
    </el-col>
    <el-col :span="4"></el-col>
  </el-row>
</template>



<style lang="scss" scoped>
/* 抖音/公众号： 前端斌少 */
/* @import url(https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css);
@import url(https://fonts.cdnfonts.com/css/poppins); */
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
.lefts {
  height: 100%;
  background-image: url('@/assets/logo2.png');
  background-size: contain;
  background-repeat: no-repeat;
  background-position: 60px;
}
.topBg {
  height: 100px;
  width: 100%;
  background: linear-gradient(to bottom, #04287d, #0b75df);
}

.menu {
  position: relative;
  top: 30px;
  background: linear-gradient(to bottom, #1a84b8, #a7d0ef);
  color: #f5f5f5;
  height: 70px;
  border-radius: 8px;
  padding: 0 20px;
  display: flex;
  align-items: center;
  font-family: 'Poppins';
}

li {
  position: relative;
  list-style: none;
  align-items: center;
}

li span {
  position: absolute;
  top: 100%;
  left: 50%;
  transform: translateX(-50%);
  font-size: 13px;
  font-weight: 500;
  transition: all 0.3s ease;
  transition-delay: 0s;
}

a {
  color: #f5f5f5;
  z-index: 100;
  text-decoration: none;
  width: 50px;
  height: 50px;
  top: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 30px;
  border-radius: 50%;
  position: relative;
  transition: all 0.3s ease;
}

li span {
  opacity: 0;
  visibility: none;
}

.indicator {
  position: absolute;
  width: 60px;
  height: 60px;
  background-color: #705fe0;
  left: 20px;
  top: -30px;
  border: 4px solid #f5f5f5;
  border-radius: 50%;
  transition: all 0.3s ease;
}

li a.active + span {
  top: 50%;
  opacity: 1;
  visibility: visible;
  transition-delay: 0.1s;
}

a.active {
  width: 60px;
  height: 60px;
  top: -35px;
}

a.active:hover {
  background: transparent;
}

a:hover {
  background-color: #167cca;
}
</style>