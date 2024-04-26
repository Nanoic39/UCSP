<script setup>
import '@/assets/font/font.css'
</script>

<template>
  <div class="tags">
    <div class="content">#<slot></slot></div>
  </div>
</template>
<style lang="scss" scoped>
.tags {
  width: 63px;
  height: 24px;
  border-radius: 10px;
  background-color: #ffffff;
  position: relative;
  top: 12px;
  left: 12px;

  .content {
    width: 36px;
    height: 19px;
    margin: auto;
    position: relative;
    top: 2px;
    color: #fe0606;
    font-size: 13px;
    font-family: 'Alibaba-PuHuiTi-B';
    line-height: 19px;
  }
}
</style>
