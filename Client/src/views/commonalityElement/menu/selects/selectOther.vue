<script setup>
import '@/assets/font/font.css'
</script>

<template>
  <div class="selectSubject">
    <el-carousel class="lunbo" height="auto" :autoplay="false" indicator-position="none">
      <el-carousel-item class="contain" style="height: 38px">
        <router-link to="/study" class="tagMath"><slot name="first"></slot></router-link>
        <router-link to="/study" class="tagEnglish"><slot name="second"></slot></router-link>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>
<style lang="scss" scoped>
.selectSubject {
  width: 100%;
  height: 27px;
  :deep(.lunbo) {
    font-size: 16px;
    position: relative;
    .contain {
      div:hover {
        background-color: #3e84fe;
        color: #ffffff;
      }
      a {
        text-decoration: none;
        color: #3d3d3d;
      }
    }
    .el-carousel__arrow--left {
      // width: 18px;
      // height: 18px;
      // position: absolute;
      // left: 5px;
      // background-color: #83f1f1;
      display: none;
    }
    .el-carousel__arrow--right {
      // width: 18px;
      // height: 18px;
      // position: absolute;
      // right: 5px;
      // background-color: #83f1f1;
      display: none;
    }
    .tagMath,
    .tagEnglish {
      width: 85px;
      height: 26px;
      background-color: #f6f9ff;
      border-radius: 30px;
      font-size: 16px;
      font-weight: 500;
      font-family: 'Alibaba-PuHuiTi-B';
      color: #3d3d3d;
      text-align: center;
      line-height: 26px;
    }

    .tagComputer {
      width: 94px;
      height: 26px;
      background-color: #f6f9ff;
      border-radius: 30px;
      font-size: 16px;
      font-weight: 500;
      font-family: 'Alibaba-PuHuiTi-B';
      color: #3d3d3d;
      text-align: center;
      line-height: 26px;
      position: absolute;
      left: 254px;
    }
    .tagMath {
      position: absolute;
      left: 25px;
    }
    .tagEnglish {
      position: absolute;
      left: 138px;
    }
    .tagCompetition {
      width: 118px;
      height: 26px;
      background-color: #f6f9ff;
      border-radius: 30px;
      font-size: 16px;
      font-weight: 500;
      font-family: 'Alibaba-PuHuiTi-B';
      color: #3d3d3d;
      text-align: center;
      line-height: 26px;
      position: absolute;
      left: 375px;
    }
  }
}
</style>
