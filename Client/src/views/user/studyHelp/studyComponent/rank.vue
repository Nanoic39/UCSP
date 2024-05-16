<script setup>
import '@/assets/font/font.css'
import { ref } from 'vue'
import '@/assets/svg/helpeach/huangguan/iconfont.css'
const ranks = ref([
  { ranks: '01.', names: '安一鸣', result: '21' },
  { ranks: '02.', names: '安一鸣', result: '20' },
  { ranks: '03.', names: '安一鸣', result: '19' },
  { ranks: '04.', names: '安一鸣', result: '18' },
  { ranks: '05.', names: '安一鸣', result: '17' },
  { ranks: '06.', names: '安一鸣', result: '16' },
  { ranks: '07.', names: '安一鸣', result: '15' },
  { ranks: '08.', names: '安一鸣', result: '14' },
  { ranks: '09.', names: '安一鸣', result: '13' },
  { ranks: '10.', names: '安一鸣', result: '12' }
])
</script>

<template>
  <div class="ranking">
    <div class="imgs">
      <div class="title">
        <div class="iconfont icon-huangguan"></div>
      </div>
      <div class="hop">HOP10</div>
      <div class="date">周榜单日期: 2024-5-1~2024-5-7</div>
    </div>
    <div class="contents">
      <div class="ranks" v-for="item in ranks" :key="item">
        <div class="number">{{ item.ranks }}</div>
        <div class="headimg"></div>
        <div class="names">安一鸣</div>
        <div class="result">
          已连续打卡<span>{{ item.result }}</span
          >天!
        </div>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.ranking {
  width: 296px;
  min-height: 389px;
  max-height: 551px;
  padding-bottom: 25px;
  border-radius: 30px;
  background: #ffffff;

  .imgs {
    width: 296px;
    height: 178px;
    background-image: url('@/assets/studyhelp/屏幕截图 2024-05-04 181204 copy.png');
    background-repeat: no-repeat;
    background-size: cover;
    border-top-right-radius: 30px;
    border-top-left-radius: 30px;
    position: relative;

    .title {
      width: 106px;
      height: 70px;
      position: absolute;
      top: 28px;
      left: 21px;
      background-color: antiquewhite;
      background-image: url('@/assets/studyhelp/202454182711.png');
      background-repeat: no-repeat;
      background-size: contain;

      .iconfont {
        width: 20px;
        height: 20px;
        position: absolute;
        top: 1px;
        left: 52px;
        font-size: 22px;
        color: #f7bc3a;
      }
    }

    .hop {
      width: 80px;
      height: 33px;
      position: absolute;
      right: 84px;
      top: 72px;
      color: #3e84fe;
      font-size: 24px;
      font-weight: 700;
      line-height: 33px;
      font-family: 'Alibaba-PuHuiTi-B';
    }

    .date {
      min-width: 212px;
      max-width: 255px;
      height: 19px;
      position: absolute;
      left: 21px;
      bottom: 44px;
      color: #3d3d3d;
      font-size: 14px;
      line-height: 19px;
      font-family: 'Alibaba-PuHuiTi-B';
    }
  }

  .contents {
    width: 100%;
    min-height: 211px;
    max-height: 372px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    display: flex;
    flex-wrap: wrap;
    gap: 8px;

    .ranks {
      width: 100%;
      height: 30px;
      position: relative;

      .number {
        width: 26px;
        height: 25px;
        position: absolute;
        top: 2px;
        left: 7px;
        color: #fbb727;
        font-size: 18px;
        font-weight: 700;
        line-height: 25px;
        font-family: 'Alibaba-PuHuiTi-B';
      }

      .headimg {
        width: 30px;
        height: 30px;
        border-radius: 50%;
        position: absolute;
        left: 38px;
        background-image: url('@/assets/layout/211540yrmp8w0prt8opzm0.jpg');
        background-repeat: no-repeat;
        background-size: contain;
      }

      .names {
        min-width: 42px;
        max-width: 84px;
        position: absolute;
        left: 87px;
        height: 19px;
        color: #3d3d3d;
        font-size: 14px;
        font-family: 'Alibaba-PuHuiTi-B';
        line-height: 19px;
        top: 5px;
      }

      .result {
        min-width: 118px;
        max-width: 168px;
        height: 25px;
        position: absolute;
        top: 2px;
        right: 7px;
        color: #3d3d3d;
        font-size: 14px;
        font-family: 'Alibaba-PuHuiTi-B';
        line-height: 25px;

        span {
          color: #3e84fe;
          font-size: 18px;
          font-weight: 500;
          line-height: 25px;
          font-family: 'Alibaba-PuHuiTi-B';
        }
      }
    }
  }
}
</style>
