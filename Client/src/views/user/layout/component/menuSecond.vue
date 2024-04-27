<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-26 17:34:52
 * @LastEditTime: 2024-04-27 11:02:05
 * @FilePath: \Client\src\views\user\layout\component\menuSecond.vue
 * @Describe: 
-->
<script setup>
import '@/assets/font/font.css'
// import school from '@/assets/svg/school.svg'
</script>

<template>
  <div class="menuSecond">
    <div class="box">
      <div class="icon"><img src="@/assets/svg/school.svg" /></div>
      <div class="name">校园活动</div>
    </div>
    <div class="box">
      <div class="icon"><img src="@/assets/svg/bbs.svg" /></div>
      <div class="name">通达论坛</div>
    </div>
    <div class="box">
      <div class="icon"><img src="@/assets/svg/study_resources.svg" /></div>
      <div class="name">学习资源</div>
    </div>
    <div class="box">
      <div class="icon"><img src="@/assets/svg/academic_affairs.svg" /></div>
      <div class="name">教务大厅</div>
    </div>
    <div class="box">
      <div class="icon"><img src="@/assets/svg/help.svg" /></div>
      <div class="name">跑腿互助</div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.menuSecond {
  height: 192px;
  width: 100%;
  position: relative;
  top: -110px;
  display: flex;
  justify-content: space-evenly;

  .box {
    width: 150px;
    height: 192px;
    .icon {
      width: 150px;
      height: 150px;
      border-radius: 5px;
      border: 1px solid #efefef;
      box-shadow: 0px 1px 0px 0px #e6e6e6;
      background: #ffffff;
      cursor: pointer;

      display: flex;
      justify-content: center;
      align-items: center;

      img {
        width: 50%;
        height: 50%;
      }
    }
    .name {
      width: 79px;
      height: 27px;
      position: relative;
      left: 35px;
      top: 15px;
      font-family: 'Alibaba-PuHuiTi-B';
      font-size: 19px;
      color: #3d3d3d;
      line-height: 27px;

      cursor: default;
    }
  }
}
</style>
