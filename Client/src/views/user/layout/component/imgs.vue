<script setup>
import '@/assets/font/font.css'
import tags from './tags.vue'
import plays from './play/plays.vue'
import playstwo from './play/playstwo.vue'
import playsthree from './play/playsthree.vue'
</script>

<template>
  <div class="imgs">
    <div class="first">
      <tags>节目</tags>
      <div class="firstTitle">南邮通达2024-2025学年民族运动会开幕啦</div>
      <plays>2024.4.1-2024.4.3</plays>
    </div>
    <div class="second">
      <div class="one">
        <tags>社团</tags>
        <playstwo>南邮通达第十六届计算机设计大赛</playstwo>
        <plays>2024.4.1-2024.4.3</plays>
      </div>
      <div class="two">
        <tags>社团</tags>
        <playstwo>南邮通达第十六届计算机设计大赛</playstwo>
        <plays>2024.4.1-2024.4.3</plays>
      </div>
      <div class="three">
        <tags>文体</tags>
        <playstwo>南邮通达第十六届计算机设计大赛</playstwo>
        <plays>2024.4.1-2024.4.3</plays>
      </div>
    </div>
    <div class="third">
      <div class="ones">
        <tags>竞赛</tags>
        <playsthree>南邮通达第十六届计算机设计大赛</playsthree>
        <plays>2024.4.1-2024.4.3</plays>
      </div>
      <div class="twos">
        <tags>竞赛</tags>
        <playsthree>南邮通达第十六届计算机设计大赛</playsthree>
        <plays>2024.4.1-2024.4.3</plays>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.imgs {
  width: 1213px;
  height: 678px;
  margin: auto;
  .first {
    width: 910px;
    height: 244px;
    float: left;
    border-radius: 10px;
    background-image: url('/src/assets/layout/屏幕截图 2024-04-24 231858.png');
    background-repeat: no-repeat;
    background-size: cover;
    position: relative;
    .firstTitle {
      width: 860px;
      height: 41px;
      position: absolute;
      left: 12px;
      bottom: 42px;
      font-size: 30px;
      font-weight: 900;
      color: #ffffff;
      line-height: 41px;
      font-family: 'Alibaba-PuHuiTi-B';
    }
  }
  .second {
    width: 280px;
    height: 678px;
    float: right;
    .one {
      border-radius: 10px;
      width: 280px;
      height: 210px;
      background-image: url('/src/assets/layout/屏幕截图 2024-04-24 232033.png');
      background-repeat: no-repeat;
      background-size: cover;
      position: relative;
    }
    .two {
      width: 280px;
      height: 210px;
      border-radius: 10px;
      margin-top: 24px;
      background-image: url('/src/assets/layout/屏幕截图 2024-04-24 232058.png');
      background-repeat: no-repeat;
      background-size: cover;
      position: relative;
    }
    .three {
      width: 280px;
      height: 210px;
      border-radius: 10px;
      margin-top: 24px;
      background-image: url('/src/assets/layout/屏幕截图 2024-04-24 232123.png');
      background-repeat: no-repeat;
      background-size: cover;
      position: relative;
    }
  }
  .third {
    width: 910px;
    height: 410px;
    margin-top: 24px;
    background-color: aliceblue;
    float: left;
    .ones {
      width: 443px;
      height: 410px;
      float: left;
      border-radius: 10px;
      background-image: url('/src/assets/layout/屏幕截图 2024-04-24 232159.png');
      background-repeat: no-repeat;
      background-size: cover;
      position: relative;
    }
    .twos {
      width: 443px;
      height: 410px;
      float: right;
      border-radius: 10px;
      background-image: url('/src/assets/layout/屏幕截图 2024-04-24 232143.png');
      background-repeat: no-repeat;
      background-size: cover;
      position: relative;
    }
  }
}
</style>
