<script setup>
import '@/assets/font/font.css'
</script>

<template>
  <div class="tagstwo">
    <div class="content">#<slot></slot></div>
  </div>
</template>
<style lang="scss" scoped>
.tagstwo {
  width: 63px;
  height: 24px;
  border-radius: 10px;
  background: linear-gradient(180deg, #efcc76 10%, #f7cb5f 100%);
  position: relative;
  top: 12px;
  left: 12px;

  .content {
    width: 36px;
    height: 19px;
    margin: auto;
    position: relative;
    top: 2px;
    color: #ffffff;
    font-size: 13px;
    font-family: 'Alibaba-PuHuiTi-B';
    line-height: 19px;
  }
}
</style>
