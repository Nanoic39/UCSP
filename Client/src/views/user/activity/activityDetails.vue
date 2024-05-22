<script setup>
import menus from '@/views/commonalityElement/menu.vue'
import '@/assets/font/font.css'
import screen from './component/screen.vue';
import background from './component/background.vue';
import classess from './component/classess.vue';
</script>

<template>
  <menus></menus>
  <background></background>
  <screen></screen>
  <div class="all">
    <div class="specific">
      <classess v-for="item in 12" :key="item"></classess>
    </div>
    <div class="page">
      <div class="example-pagination-block">
        <el-pagination layout="prev, pager, next" :total="500" />
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.all {
  width: 100%;
  height: auto;
  background-color: #FFFFFF;

  .specific {
    width: 1339px;
    margin: auto;
    height: auto;
    display: grid;
    grid-template-columns: repeat(3, 3fr);
    /* 3 列，自动调整列宽 */
    gap: 80px;

  }

  .page {
    width: 100%;
    height: 90px;
    background-color: #fafafa;
  }

  .example-pagination-block {
    width: 430px;
    position: relative;
    top: 30px;
    left: 564px;
  }

  .example-pagination-block+.example-pagination-block {
    margin-top: 10px;
  }

  .example-pagination-block .example-demonstration {
    margin-bottom: 16px;
  }
}
</style>
