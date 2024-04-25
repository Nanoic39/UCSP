<script setup>
import '@/assets/font/font.css'
</script>

<template>
  <div class="playsthree"><slot></slot></div>
</template>
<style lang="scss" scoped>
.playsthree {
  width: 360px;
  height: 82px;
  left: 12px;
  position: absolute;
  bottom: 42px;
  font-size: 30px;
  font-weight: 900;
  line-height: 41px;
  color: #ffffff;
  font-family: 'Alibaba-PuHuiTi-B';
}
</style>
