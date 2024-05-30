<script setup>
import menus from '@/views/commonalityElement/menu.vue'
import '@/assets/font/font.css'
import screen from './component/screen.vue'
import background from './component/background.vue'
import classess from './component/classess.vue'

import { onMounted, ref } from 'vue'
import { getAllActive } from '@/api/active'

const allActive = ref({})

onMounted(() => {
  getActive()
})

const getActive = async () => {
  allActive.value = (await getAllActive()).data.data
  console.log(allActive.value)
}
</script>

<template>
  <menus></menus>
  <background></background>
  <screen></screen>
  <div class="all">
    <div class="specific">
      <classess
        v-for="item in allActive"
        :key="item"
        :to="'http://localhost:5173/activity/' + item.snapped_id"
      >
        <template #activeName>{{ item.active_name }}</template>
      </classess>
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
  background-color: #ffffff;

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

  .example-pagination-block + .example-pagination-block {
    margin-top: 10px;
  }

  .example-pagination-block .example-demonstration {
    margin-bottom: 16px;
  }
}
</style>
