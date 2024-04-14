<script setup>
import menus from './zujian/menu.vue'
import jieshao from './zujian/jieshao.vue'
import lunbo from './zujian/lunbo.vue'
import biaoti from './zujian/biaoti.vue'
</script>

<template>
  <div class="tops"><menus></menus></div>
  <el-row class="all">
    <el-col :span="24" class="main">
      <el-row>
        <el-col :span="24">
          <lunbo></lunbo>
        </el-col>
      </el-row>
      <biaoti>
        <template #first>主</template>
        <template #second>题</template>
        <template #third>介</template>
        <template #fourth>绍</template>
      </biaoti>
      <jieshao></jieshao>
    </el-col>
  </el-row>
</template>
<style lang="scss" scoped>
.tops {
  position: sticky;
  top: 0;
  left: 0;
  z-index: 100;
}
</style>
