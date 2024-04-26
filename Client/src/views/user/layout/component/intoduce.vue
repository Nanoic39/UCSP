<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-26 17:34:52
 * @LastEditTime: 2024-04-26 20:42:39
 * @FilePath: \Client\src\views\layout\component\intoduce.vue
 * @Describe: 
-->
<script setup>
import '@/assets/font/font.css'
import { ArrowRight } from '@element-plus/icons-vue'
</script>

<template>
  <div class="introduce">
    <div class="title"><slot></slot></div>
    <div class="more">
      <div class="fonts">查看全部</div>
      <div class="icons">
        <el-icon><ArrowRight /></el-icon>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.introduce {
  height: 57px;
  width: 100%;
  .title {
    width: 200px;
    height: 57px;
    margin: auto;
    font-size: 50px;
    font-family: 'ZhanKuKuaiLeTi2016XiuDingBan-1';
    color: #3d3d3d;
  }
  .more {
    width: 71px;
    height: 22px;
    position: absolute;
    top: 18px;
    right: 113px;
    cursor: pointer;

    .fonts {
      width: 63px;
      height: 22px;
      float: left;
      font-size: 15px;
      line-height: 22px;
      font-family: 'Alibaba-PuHuiTi-B';
      color: #818181;
    }
    .icons {
      width: 8px;
      height: 22px;
      float: right;
      position: relative;
      left: -7px;
      font-size: 20px;
      color: #818181;
    }
  }
}
</style>
