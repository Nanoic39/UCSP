<script setup>
import '@/assets/font/font.css'
import { usecountStore } from '@/stores/count'
import { onMounted, watch, ref } from 'vue'
const usecount = usecountStore()
const newmainSubject = ref(null)
const newHeight = ref(null)
const count = ref(null)

onMounted(() => {
  const mainSubjectdiv = document.querySelectorAll('.mainSubject div')
  const distance = ref(mainSubjectdiv[mainSubjectdiv.length - 1].offsetTop)
  const subjectMenu = document.querySelector('.subjectMenu')

  // 更新 newmainSubject 的值
  newHeight.value = distance.value + 55
  // 更新 subjectMenu 样式高度
  subjectMenu.style.height = newHeight.value + 'px'
})

const activeIndex = ref(0)

const activate = (item) => {
  activeIndex.value = item
}
const deactivates = () => {
  if (usecount.counts) {
    activeIndex.value = usecount.counts
  } else {
    activeIndex.value = 0
  }
}

import { inject } from 'vue'

// 从父组件提供的数据中注入menuOptions和handleMenuSelected方法
const { menuOptions, selectedOption } = inject('menuData')

// 处理菜单选项变化

const handleMenuClick = (item, index) => {
  activeIndex.value = index
  usecount.setCount(index)
  selectedOption.value = item
  usecount.removeExaminations()
  localStorage.removeItem('big-users')
}
</script>

<template>
  <div class="subjectMenu" @mouseleave="deactivates">
    <div class="subjectName">数学</div>
    <div class="divide"></div>
    <div class="mainSubject">
      <div v-for="(item, index) in menuOptions" :key="item.id" :class="{ blueBackground: index === activeIndex }"
        @mouseenter="activate(index)" @click="handleMenuClick(item, index)">
        {{ item.names }}
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.blueBackground {
  background-color: #3e84fe;
  color: #ffffff;
}

.subjectMenu {
  width: 100%;
  background-color: #ffffff;
  padding-top: 20px;
  padding-bottom: 20px;
  position: relative;

  .subjectName {
    width: 56px;
    height: 38px;
    position: absolute;
    left: 206px;
    top: 21px;
    bottom: 21px;
    font-weight: 700;
    font-size: 28px;
    color: #3d3d3d;
    line-height: 38px;
    font-family: 'Alibaba-PuHuiTi-B';
  }

  .divide {
    width: 2px;
    height: 20px;
    background-color: #d8d8d8;
    position: absolute;
    left: 287px;
    top: 30px;
  }

  .mainSubject {
    min-width: 758px;
    max-width: 958px;
    position: absolute;
    left: 312px;
    top: 23px;
    display: flex;
    display: flex;
    flex-wrap: wrap;
    gap: 10px;

    /* 上下和左右间距相同 */
    div {
      min-width: 51px;
      max-width: 170px;
      height: 35px;
      padding-left: 20px;
      padding-right: 20px;
      font-size: 15px;
      line-height: 35px;
      text-align: center;
      font-weight: 500;
      border-radius: 30px;
      grid-column: span 1;
    }
  }
}
</style>
