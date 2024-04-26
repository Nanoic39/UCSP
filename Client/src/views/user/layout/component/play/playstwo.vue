<script setup>
import '@/assets/font/font.css'
</script>

<template>
  <div class="playestwo">
    <slot></slot>
  </div>
</template>
<style lang="scss" scoped>
.playestwo {
  width: 214px;
  height: 66px;
  position: absolute;
  // background-color: aqua;
  left: 12px;
  bottom: 38px;
  font-weight: 900;
  color: #ffffff;
  line-height: 33px;
  font-family: 'Alibaba-PuHuiTi-B';
  font-size: 24px;
}
</style>
