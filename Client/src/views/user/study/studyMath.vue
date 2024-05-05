<script setup>
import '@/assets/font/font.css'
import menus from '@/views/commonalityElement/menu.vue'
import subjectSelect from './component/subjectSelect.vue'
import titleSelect from './component/titleSelect.vue'
import classess from './component/classess.vue'
import { ref, onMounted } from 'vue'
import { provide } from 'vue'
import { usecountStore } from '@/stores/count'
import { ArrowRight } from '@element-plus/icons-vue'
import paper from './component/paper.vue'
const usecount = usecountStore()
const amount = ref([1, 2, 3, 4, 5, 6, 7, 8, 9])
const amounts = ref([1, 2, 3, 4, 5])

const menuOptions = ref([
  { id: 1, names: '全部' },
  { id: 2, names: '应试题库' },
  { id: 3, names: '高等数学' },
  { id: 4, names: '线性代数' },
  { id: 5, names: '概率论与数理统计' },
  { id: 6, names: '数学实验' }
])

// 当前选中的菜单项
const selectedOption = ref(menuOptions.value[0])

// 使用provide将数据提供给所有子组件
provide('menuData', {
  menuOptions,
  selectedOption
})
</script>
<!--  -->
<template>
  <div class="bg">
    <menus></menus>
    <subjectSelect></subjectSelect>
    <titleSelect></titleSelect>
    <div class="container" v-if="selectedOption.id == 1">
      <classess v-for="item in amount" :key="item"></classess>
    </div>
    <div class="examinationContent" v-if="selectedOption.id == 2">
      <paper v-for="item in 5" :key="item"></paper>
    </div>
    <div class="page">
      <div class="example-pagination-block">
        <el-pagination layout="prev, pager, next" :total="500" />
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.bg {
  width: 100%;
  height: 100%;
  background-color: #fafafa;
}
.container {
  min-height: 332px;
  max-height: 1628px;
  width: 1048px;
  position: relative;
  left: 206px;
  display: grid;
  grid-template-columns: repeat(3, 3fr); /* 3 列，自动调整列宽 */
  gap: 56px;
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

.examinationContent {
  width: 1033px;
  min-height: 214px;
  max-height: 1184px;
  position: relative;
  left: 203px;
  display: grid;
  gap: 31px;
}
</style>
