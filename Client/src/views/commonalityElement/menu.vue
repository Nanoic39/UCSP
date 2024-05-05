<script setup>
import { Search, Bell, User } from '@element-plus/icons-vue'
import '@/assets/font/font.css'
import selection from './menu/selection.vue'
import panels from './menu/panel.vue'
</script>

<template>
  <div class="topmenu">
    <div class="logo">
      <img src="/src/assets/layout/One-stop campus website.png" alt="" />
    </div>
    <div class="menus">
      <router-link class="menuHomePage" to="/home">首页</router-link>
      <router-link class="menuTongda" to="/tongda">通达论坛</router-link>
      <selection></selection>
      <router-link class="menuTeach" to="/teach">教务大厅</router-link>
      <router-link class="menuHelp" to="/help">跑腿互助</router-link>
    </div>
    <el-input class="search">
      <template #prefix>
        <el-button class="clear">
          <el-icon><Search /></el-icon>
        </el-button>
      </template>
    </el-input>

    <el-dropdown>
      <router-link class="message" to="/message">
        <el-icon><Bell /></el-icon>
      </router-link>
      <template #dropdown>
        <el-dropdown-menu class="options">
          <el-dropdown-item>评论</el-dropdown-item>
          <el-dropdown-item>赞和收藏</el-dropdown-item>
          <el-dropdown-item>新增粉丝</el-dropdown-item>
          <el-dropdown-item>私信</el-dropdown-item>
          <el-dropdown-item>系统通知</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>

    <panels></panels>
  </div>
</template>
<style lang="scss" scoped>
.options {
  width: 121px;
  height: 161px;
}
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
    a {
      text-decoration: none;
      color: #3d3d3d;
    }
    .menuHomePage {
      width: 40px;
      height: 27px;
      position: absolute;
      left: 0;
    }
    .menuTongda,
    .menuTeach,
    .menuHelp {
      width: 80px;
      height: 27px;
    }
    .menuTongda {
      position: absolute;
      left: 130px;
    }

    .menuTeach {
      position: absolute;
      left: 470px;
    }
    .menuHelp {
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
}

.menuHomePage:hover {
  border-bottom: 3px solid #3e84fe;
  color: #3e84fe !important;
}
.menuTongda:hover {
  border-bottom: 3px solid #3e84fe;
  color: #3e84fe !important;
}
.menuTeach:hover {
  border-bottom: 3px solid #3e84fe;
  color: #3e84fe !important;
}
.menuHelp:hover {
  border-bottom: 3px solid #3e84fe;
  color: #3e84fe !important;
}
</style>
