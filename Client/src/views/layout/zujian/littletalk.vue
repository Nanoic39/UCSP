<script setup>
import '@/assets/font/font.css'
</script>

<template>
  <div class="littleTalk">
    <div class="fuhao"></div>
    <div class="wenzi">
      <slot name="first"></slot>
    </div>
    <div class="touxiang"></div>
    <div class="mingzi"><slot name="second"></slot></div>
    <div class="riqi"><slot name="third"></slot></div>
  </div>
</template>
<style lang="scss" scoped>
.littleTalk {
  width: 390px;
  height: 330px;
  border-radius: 10px;
  background-color: #ffffff;
  opacity: 1;
  box-sizing: border-box;
  border: 1px solid #efefef;
  box-shadow: 0px 1px 0px 0px #e6e6e6;
  position: relative;
  .fuhao {
    position: absolute;
    left: 21px;
    top: 31px;
    width: 30px;
    height: 30px;
    background-image: url('/src/assets/layout/屏幕截图 2024-04-25 165537.png');
    background-repeat: no-repeat;
    background-size: contain;
    /*符号颜色*/
    opacity: 1;
    /**/
    border: 1px;
  }

  .touxiang {
    position: absolute;
    left: 31px;
    top: 227px;
    width: 80px;
    height: 80px;
    background-image: url('/src/assets/layout/屏幕截图 2024-04-25 165616.png');
    background-repeat: no-repeat;
    background-size: contain;
    border-radius: 5px;
    opacity: 1;
  }

  .mingzi {
    position: absolute;
    left: 132px;
    top: 233px;
    width: 100px;
    height: 33px;
    opacity: 1;
    font-family: 'Alibaba-PuHuiTi-B';
    font-size: 24px;
    font-weight: 500;
    line-height: 33px;
    color: #3d3d3d;
  }

  .riqi {
    position: absolute;
    left: 132px;
    top: 266px;
    width: 187px;
    height: 27px;
    opacity: 1;
    font-family: 'Alibaba-PuHuiTi-B';
    font-size: 20px;
    line-height: 27px;
    color: #d1d1d1;
  }

  .wenzi {
    position: absolute;
    left: 43px;
    top: 82px;
    width: 327px;
    height: 167px;
    opacity: 1;
    font-family: 'Alibaba-PuHuiTi-B';
    font-size: 20px;
  }
}
</style>
