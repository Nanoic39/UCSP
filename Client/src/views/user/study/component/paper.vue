<script setup>
import '@/assets/font/font.css'
import { ArrowRight } from '@element-plus/icons-vue'
</script>

<template>
  <div class="paper">
    <div class="paperName">2023年南京邮电大学通达学院高等数学A2期末试卷</div>
    <div class="img"></div>
    <div class="introduce">
      E通达整理发布2023年南京邮电大学通达学院高等数学A2期末试卷及答案（图片版）
    </div>
    <div class="reference">欢迎浏览，仅供参考</div>
    <div class="more">
      <div>查看详情</div>
      <div class="arrow">
        <el-icon>
          <ArrowRight />
        </el-icon>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.paper:hover {
  transform: translateY(-20px);
  transition: all 0.3s;
}

.paper {
  width: 100%;
  height: 212px;
  background-color: #ffffff;
  position: relative;
  border-radius: 3px;
  border-width: 0px 0px 2px 0px;
  border-style: solid;
  border-color: #d8d8d8;

  .paperName {
    min-width: 400px;
    max-width: 800px;
    height: 25px;
    position: absolute;
    top: 16px;
    left: 18px;
    color: #3d3d3d;
    font-size: 18px;
    font-family: 'Alibaba-PuHuiTi-B';
    font-weight: 500;
  }

  .img {
    width: 168px;
    height: 124px;
    position: absolute;
    top: 61px;
    left: 28px;
    background-image: url('@/assets/study/屏幕截图 2024-05-03 150005.png');
    background-repeat: no-repeat;
    background-size: cover;
  }

  .introduce {
    min-width: 600px;
    max-width: 800px;
    height: 25px;
    position: absolute;
    top: 87px;
    left: 211px;
    font-size: 18px;
    line-height: 25px;
    color: #3d3d3d;
    font-family: 'Alibaba-PuHuiTi-B';
  }

  .reference {
    min-width: 300px;
    max-width: 800px;
    height: 25px;
    position: absolute;
    bottom: 75px;
    left: 211px;
    font-size: 18px;
    line-height: 25px;
    color: #3d3d3d;
    font-family: 'Alibaba-PuHuiTi-B';
  }

  .more {
    width: 101px;
    height: 25px;
    display: flex;
    position: absolute;
    right: 64px;
    bottom: 31px;
    font-size: 18px;
    line-height: 25px;
    color: #3d3d3d;
    font-family: 'Alibaba-PuHuiTi-B';

    .arrow {
      margin-top: 3px;
    }
  }
}
</style>
