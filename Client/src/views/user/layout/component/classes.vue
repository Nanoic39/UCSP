<script setup>
import '@/assets/font/font.css'
import tagstwo from './tagstwo.vue'
</script>

<template>
  <div class="classes">
    <div class="imgs">
      <tagstwo><slot name="first"></slot></tagstwo>
    </div>
    <div class="names"><slot name="second"></slot></div>
    <div class="teacher"><slot name="third"></slot></div>
    <div class="internet"><slot name="fourth"></slot></div>
  </div>
</template>
<style lang="scss" scoped>
.classes {
  width: 390px;
  height: 420px;
  border-radius: 10px;
  border: 2px solid #efefef;
  box-shadow: 0px 1px 0px 0px #e6e6e6;
  position: relative;
  font-family: 'ADLaMDisplay-Regular';
  .imgs {
    width: 390px;
    height: 252px;
    background-image: url('/src/assets/layout/屏幕截图 2024-04-25 190303.png');
    background-repeat: no-repeat;
    background-size: cover;
    border-radius: 10px 10px 0px 0px;
  }
  .names {
    width: 350px;
    height: 27px;
    position: absolute;
    left: 19px;
    bottom: 119px;
    font-weight: 700;
    font-size: 20px;
    color: #3d3d3d;
    line-height: 27px;
  }
  .teacher {
    width: 350px;
    height: 19px;
    position: absolute;
    left: 19px;
    bottom: 84px;
    font-size: 18px;
    color: #cbcbcb;
    line-height: 25px;
  }
  .internet {
    width: 350px;
    height: 22px;
    position: absolute;
    left: 19px;
    bottom: 23px;
    font-size: 16px;
    color: #3e84fe;
    line-height: 22px;
  }
}
</style>
