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
.classes::before {
  content: '';
  width: 50px;
  height: 100%;
  background: #3e84fe;
  position: absolute;
  top: 0;
  left: 0;
  transform: skewX(60deg) translateX(170px);
  transition: 0.5s;
}

.classes:hover {
  z-index: 3;
  top: -20px;
  transition-delay: 0s, 0.5s, 0.5s;
  transform: translateY(20px);
}

.classes:hover:before {
  transform: skewX(45deg) translateX(-150px);
}


.classes {
  z-index: 2;
  position: relative;
  top: 0;
  width: 308px;
  height: 332px;
  border-radius: 10px;
  font-size: 5em;
  color: #fff;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: sans-serif;
  border: 1px solid #ffffff66;
  border-right: 1px solid #ffffff33;
  border-bottom: 1px solid #ffffff33;
  backdrop-filter: blur(5px);
  box-shadow: 0 5px 45px #1098d81a;
  text-decoration: none;
  overflow: hidden;
  transition: top 0.5s, z-index 0s, transform 0.5s;
  transition-delay: 0.5s 0.5s 0s;
  cursor: pointer;
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
    top: 0;
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
