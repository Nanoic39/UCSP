<script setup>
import '@/assets/font/font.css'
</script>

<template>
  <div class="tag"><slot name="first"></slot></div>
</template>
<style lang="scss" scoped>
.tag {
  min-width: 31px;
  max-width: 102px;
  height: 17px;
  position: absolute;
  right: 136px;
  bottom: 7px;
  background-color: #f6f9ff;
  border-radius: 3px;
  line-height: 17px;
  color: #3e84fe;
  font-size: 10px;
  font-family: 'Alibaba-PuHuiTi-B';
  padding-left: 9px;
  padding-right: 9px;
}
</style>
