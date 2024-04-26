<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-26 17:34:52
 * @LastEditTime: 2024-04-26 17:48:08
 * @FilePath: \Client\src\views\layout\component\littletalk.vue
 * @Describe: 
-->
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
  cursor: pointer;
  width: 390px;
  height: 330px;
  border-radius: 10px;
  background-color: #ffffff;
  opacity: 1;
  box-sizing: border-box;
  border: 1px solid #efefef;
  box-shadow: var(--shadow-box-03);
  position: relative;
  transition: all .2s ease;

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

.littleTalk:hover {
  
  box-shadow: 0px 2px 2px 0px #acacac;
}
</style>
