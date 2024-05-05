<script setup>
import '@/assets/font/font.css'
import tagstwos from './tagstwos.vue'
</script>

<template>
  <div class="classes">
    <div class="imgs">
      <tagstwos></tagstwos>
    </div>
    <div class="names">python数据分析与展示</div>
    <div class="teacher">嵩天</div>
    <div class="internet">https://www.icourse163.org/course/...</div>
  </div>
</template>
<style lang="scss" scoped>
.classes {
  width: 308px;
  height: 332px;
  border-radius: 10px;
  border: 2px solid #efefef;
  box-shadow: 0px 1px 0px 0px #e6e6e6;
  position: relative;
  font-family: 'ADLaMDisplay-Regular';
  .imgs {
    width: 308px;
    height: 199px;
    background-image: url('/src/assets/layout/屏幕截图 2024-04-25 190303.png');
    background-repeat: no-repeat;
    background-size: cover;
    border-radius: 10px 10px 0px 0px;
    position: absolute;
  }
  .names {
    width: 270px;
    height: 21px;
    position: absolute;
    left: 15px;
    bottom: 93px;
    font-weight: 700;
    font-size: 18px;
    color: #3d3d3d;
    line-height: 21px;
  }
  .teacher {
    width: 270px;
    height: 19px;
    position: absolute;
    left: 15px;
    bottom: 66px;
    font-size: 16px;
    color: #cbcbcb;
    line-height: 19px;
  }
  .internet {
    width: 270px;
    height: 19px;
    position: absolute;
    left: 15px;
    bottom: 33px;
    font-size: 14px;
    color: #3e84fe;
    line-height: 19px;
  }
}
</style>
