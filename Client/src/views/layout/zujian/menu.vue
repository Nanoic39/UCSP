<script setup>
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
    }
  }
}
</style>
