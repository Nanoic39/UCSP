<script setup>
import '@/assets/font/font.css'
</script>

<template>
  <div class="topMenu">
    <div class="recommend">最新</div>
    <div class="newest">热门</div>
    <el-button class="contribute">发布</el-button>
  </div>
</template>
<style lang="scss" scoped>
.topMenu {
  width: 100%;
  height: 46px;
  position: relative;
  border-bottom: solid 1px #bab7b7;
  background-color: #ffffff;

  .recommend {
    width: 28px;
    height: 19px;
    position: absolute;
    top: 13px;
    left: 31px;
    font-size: 14px;
    line-height: 19px;
    font-family: 'Alibaba-PuHuiTi-B';
    color: #3d3d3d;
  }

  .newest {
    width: 28px;
    height: 19px;
    position: absolute;
    top: 13px;
    left: 77px;
    font-size: 14px;
    line-height: 19px;
    font-family: 'Alibaba-PuHuiTi-B';
    color: #3d3d3d;
  }

  .screen {
    width: 134px;
    height: 25px;
    position: absolute;
    top: 8px;
    left: 117px;
    background-color: #f6f9ff;
  }

  .contribute {
    width: 59px;
    height: 26px;
    background-color: #3e84fe;
    color: #ffffff;
    font-size: 12px;
    line-height: 26px;
    font-family: 'Alibaba-PuHuiTi-B';
    position: absolute;
    top: 9px;
    right: 22px;
  }
}
</style>
