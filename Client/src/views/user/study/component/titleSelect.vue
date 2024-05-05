<script setup>
import '@/assets/font/font.css'
import { usecountStore } from '@/stores/count'
import { inject, ref, watch } from 'vue'
const usecount = usecountStore()
// 从父组件提供的数据中注入selectedOption
const { selectedOption } = inject('menuData')

const content = ref([
  { id: 1, names: '全部' },
  { id: 2, names: '高等数学' },
  { id: 3, names: '线性代数' },
  { id: 4, names: '概率论与数理统计' },
  { id: 5, names: '数学实验' }
])

const activeIndex = ref(0)

const activate = (item) => {
  activeIndex.value = item
}

const values = ref(usecount.examinations)
console.log(values)
setInterval(() => {
  values.value = usecount.examinations
}, 10)
watch(
  values,
  (newValue) => {
    if (newValue) {
      activeIndex.value = newValue
    } else {
      activeIndex.value = 0
    }
  },
  { deep: true }
)

const deactivate = () => {
  if (usecount.examinations) {
    activeIndex.value = usecount.examinations
  } else {
    activeIndex.value = 0
  }
}

const handleMenuClick = (item, index) => {
  activeIndex.value = index
  usecount.setExaminations(index)
}
</script>

<template>
  <div class="titleSelect" v-if="selectedOption.id == 1">
    <div class="titles">全部课程</div>
    <div class="selectclass">
      <div class="all">全部 (xxx)</div>
      <div class="hot">最新</div>
      <div class="new">最热</div>
    </div>
  </div>
  <div class="titleExaminations" v-if="selectedOption.id == 2" @mouseleave="deactivate">
    <div class="examinations">历年真题</div>
    <div class="examinationOption">
      <div
        v-for="(item, index) in content"
        :key="item"
        :class="{ blueBackground: index === activeIndex }"
        @mouseenter="activate(index)"
        @click="handleMenuClick(item, index)"
      >
        {{ item.names }}
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.blueBackground {
  color: #3e84fe;
}
.titleSelect {
  width: 100%;
  height: 178px;
  position: relative;
  background-color: #fafafa;
  .titles {
    width: 142px;
    height: 49px;
    position: absolute;
    top: 59px;
    left: 206px;
    font-family: 'Alibaba-PuHuiTi-B';
    color: #3d3d3d;
    font-size: 35px;
    line-height: 49px;
  }
  .selectclass {
    width: 217px;
    height: 25px;
    position: absolute;
    bottom: 30px;
    left: 206px;
    display: flex;
    justify-content: space-between;
    .all {
      width: 99px;
      height: 25px;
      color: #3e84fe;
      font-size: 18px;
      font-family: 'Alibaba-PuHuiTi-B';
      line-height: 25px;
    }
    .hot {
      width: 36px;
      height: 25px;
      color: #3d3d3d;
      font-size: 18px;
      font-family: 'Alibaba-PuHuiTi-B';
      line-height: 25px;
    }
    .new {
      width: 36px;
      height: 25px;
      color: #3d3d3d;
      font-size: 18px;
      font-family: 'Alibaba-PuHuiTi-B';
      line-height: 25px;
    }
  }
}

.titleExaminations {
  width: 100%;
  height: 178px;
  position: relative;
  background-color: #fafafa;
  .examinations {
    width: 142px;
    height: 49px;
    position: absolute;
    top: 59px;
    left: 206px;
    font-family: 'Alibaba-PuHuiTi-B';
    color: #3d3d3d;
    font-size: 35px;
    line-height: 49px;
  }
  .examinationOption {
    min-width: 100px;
    max-width: 800px;
    height: 25px;
    position: absolute;
    bottom: 30px;
    left: 206px;
    display: flex;
    gap: 30px;
    justify-content: space-between;
    div {
      min-width: 36px;
      max-width: 170px;
    }
  }
}
</style>
