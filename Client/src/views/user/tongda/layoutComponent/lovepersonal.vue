<script setup>
import '@/assets/font/font.css'
import { ref } from 'vue'
const kind = ref([
  { id: 1, names: '动态' },
  { id: 2, names: '关注' },
  { id: 3, names: '好友' }
])
</script>

<template>
  <div class="personal">
    <div class="topinformation">
      <div class="headimg"></div>
      <div class="name">法助</div>
    </div>
    <div class="introduce">
      <div class="box" v-for="item in kind" :key="item">
        <div class="amount">1</div>
        <div class="kind">{{ item.names }}</div>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.personal {
  width: 256px;
  height: 145px;
  position: absolute;
  top: 24px;
  right: 114px;
  padding-top: 18px;
  padding-left: 20px;
  padding-right: 20px;
  padding-bottom: 14px;
  background-color: #ffffff;

  .topinformation {
    width: 262px;
    height: 62px;
    border-bottom: 1px solid #bab7b7;
    position: relative;

    .headimg {
      width: 50px;
      height: 50px;
      border-radius: 50%;
      background-image: url('@/assets/layout/211540yrmp8w0prt8opzm0.jpg');
      background-repeat: no-repeat;
      background-size: cover;
    }

    .name {
      min-width: 32px;
      max-width: 66px;
      height: 22px;
      position: absolute;
      top: 14px;
      left: 74px;
      font-size: 16px;
      line-height: 22px;
      color: #3d3d3d;
      font-family: 'Alibaba-PuHuiTi-B';
    }
  }

  .introduce {
    width: 244px;
    height: 55px;
    padding-top: 13px;
    padding-left: 9px;
    padding-right: 9px;
    display: flex;
    justify-content: space-between;

    .box {
      min-width: 32px;
      max-width: 56px;
      height: 55px;

      .amount {
        min-width: 27px;
        max-width: 56px;
        height: 33px;
        margin: auto;
        font-size: 24px;
        line-height: 33px;
        color: #3d3d3d;
        font-family: 'Alibaba-PuHuiTi-B';
        text-align: center;
      }

      .kind {
        width: 32px;
        height: 22px;
        margin: auto;
        font-size: 16px;
        line-height: 22px;
        color: #717171;
        font-family: 'Alibaba-PuHuiTi-B';
      }
    }
  }
}
</style>
