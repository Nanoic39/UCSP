<script setup>
import '@/assets/font/font.css'
import { ref } from 'vue'
import calenders from './calendar/calendar.vue'

const trend = ref([
  { id: 1, content: '文章' },
  { id: 2, content: '问题' },
  { id: 3, content: '关注' },
  { id: 4, content: '好友' }
])
</script>

<template>
  <div class="calendar">
    <div class="personage">
      <div class="head"></div>
      <div class="names">法助</div>
    </div>
    <div class="trends">
      <div class="information" v-for="item in trend" :key="item">
        <div class="counts">1</div>
        <div class="classify">{{ item.content }}</div>
      </div>
    </div>
    <div class="mainContainer">
      <calenders></calenders>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.calendar {
  width: 262px;
  min-height: 432px;
  padding-left: 17px;
  padding-right: 17px;
  padding-top: 17px;
  background: #ffffff;

  .personage {
    width: 100%;
    height: 62px;
    position: relative;
    border-bottom: 1px solid #bab7b7;
    .head {
      width: 50px;
      height: 50px;
      border-radius: 50px;
      position: absolute;
      left: 0;
      bottom: 12px;
      background-image: url('@/assets/layout/211540yrmp8w0prt8opzm0.jpg');
      background-repeat: no-repeat;
      background-size: cover;
    }

    .names {
      min-width: 32px;
      max-width: 106px;
      height: 22px;
      position: absolute;
      left: 74px;
      top: 14px;
      color: #3d3d3d;
      font-size: 16px;
      line-height: 22px;
      font-family: 'Alibaba-PuHuiTi-B';
    }
  }

  .trends {
    width: 244px;
    height: 66px;
    padding-left: 9px;
    padding-right: 9px;
    padding-top: 12px;
    display: flex;
    justify-content: space-between;

    .information {
      min-width: 32px;
      max-width: 56px;
      height: 55px;

      .counts {
        min-width: 14px;
        max-width: 56px;
        height: 33px;
        margin: auto;
        color: #3d3d3d;
        font-family: 'Alibaba-PuHuiTi-B';
        font-size: 24px;
        line-height: 33px;
        text-align: center;
      }
      .classify {
        width: 32px;
        height: 22px;
        margin: auto;
        color: #717171;
        font-size: 16px;
        line-height: 22px;
        font-family: 'Alibaba-PuHuiTi-B';
      }
    }
  }

  .mainContainer {
    width: 100%;
    height: 100%;
  }
}
</style>
