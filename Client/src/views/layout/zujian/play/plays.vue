<script setup>
import '@/assets/font/font.css'
</script>

<template>
  <div class="play">
    <span>活动时间：</span>
    <span><slot></slot></span>
  </div>
</template>
<style lang="scss" scoped>
.play {
  width: 235px;
  height: 19px;
  position: absolute;
  left: 12px;
  bottom: 19px;
  font-family: 'Alibaba-PuHuiTi-B';
  color: #ffffff;
  font-size: 14px;
  line-height: 19px;
  font-weight: 500;
}
</style>
