<script setup>
import '@/assets/font/font.css'
</script>

<template>
  <div class="recommend">
    <div class="container">
      <div>精选帖子</div>
    </div>
    <div class="mainContain">
      <div class="charts" v-for="item in 5" :key="item">
        <div class="title">今天在路上,看到一个穿白裙子的小姐姐,...</div>
        <div class="data">790点赞 · 368转发</div>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.recommend {
  width: 276px;
  min-height: 280px;
  background: #ffffff;
  position: absolute;
  top: 223px;
  right: 114px;
  padding: 10px 10px 10px 10px;

  .container {
    width: 276px;
    height: 32px;
    border-bottom: 1px solid #bab7b7;

    div {
      width: 65px;
      height: 22px;
      color: #3d3d3d;
      font-size: 16px;
      line-height: 22px;
      font-family: 'Alibaba-PuHuiTi-B';
    }
  }

  .mainContain {
    width: 100%;
    height: 255px;
    padding-top: 13px;
    display: flex;
    flex-wrap: wrap;
    gap: 13px;

    .charts {
      width: 100%;
      height: 41px;
      display: flex;
      flex-wrap: wrap;
      gap: 6px;

      .title {
        width: 100%;
        height: 19px;
        font-size: 14px;
        line-height: 19px;
        color: #3d3d3d;
        font-family: 'Alibaba-PuHuiTi-B';
      }

      .data {
        width: 100%;
        height: 16px;
        font-size: 12px;
        line-height: 16px;
        color: #717171;
        font-family: 'Alibaba-PuHuiTi-B';
      }
    }
  }
}
</style>
