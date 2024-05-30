<script setup>
import '@/assets/font/font.css'
import { ref, onMounted, inject, provide } from 'vue'
import selecthelp from './selects/selectHelp.vue'
import selectother from './selects/selectOther.vue'
import selectjob from './selects/selectJob.vue'
import { readstudy } from '@/api/study.js'
const carouselRef = ref(null)
const myDiv = ref(null)
const isCarouselVisible = ref(false)
const { activeIndex } = inject('indexs')
import selectkind from './selects/selectkind.vue'


const readstudyss = async () => {
  const res = await readstudy()
  console.log(res.data.data)
}
// readstudyss()
onMounted(() => {
  // 获取 div 元素的实际 DOM 对象
  const divElement = myDiv.value

  // 添加鼠标移入事件处理函数
  divElement.addEventListener('mouseenter', handleMouseEnter)
})

// 鼠标移入时执行的函数
function handleMouseEnter() {
  const a = document.querySelector('.studyContainer')
  a.style.display = 'block'
  isCarouselVisible.value = true
}

const changeStudys = () => {
  const a = document.querySelector('.studyContainer')
  a.style.display = 'none'
  isCarouselVisible.value = false
}

provide('isCarouselVisibles', { isCarouselVisible })
</script>

<template>
  <div class="menuStudy" :class="{ Color: 3 === activeIndex }" ref="myDiv" @mouseleave="changeStudys()">
    学习资源
    <div class="studyContainer">
      <div class="university">大学</div>
      <div class="selectsubject">
        <selectkind></selectkind>
      </div>
      <div class="job">升学/学业</div>
      <div class="selectjob">
        <selectjob></selectjob>
      </div>
      <div class="other">其他</div>
      <div class="selectother">
        <selectother></selectother>
      </div>
      <div class="helpEach">互助室</div>
      <div class="selecthelp">
        <selecthelp></selecthelp>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.menuStudy {
  cursor: pointer;
}

.studyContainer {
  position: absolute;
  top: 28px;
  right: -29px;
  width: 517px;
  height: 361px;
  background-color: #ffffff;
  box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
  border-radius: 5px;
  display: none;
  z-index: 10;

  .selectsubject {
    width: 100%;
    position: relative;
    top: 53px;
  }

  .selectjob {
    width: 100%;
    position: absolute;
    top: 137px;
  }

  .selectother {
    width: 100%;
    position: absolute;
    top: 221px;
  }

  .selecthelp {
    width: 100%;
    position: absolute;
    top: 305px;
  }

  .university {
    width: 40px;
    height: 27px;
    position: absolute;
    top: 19px;
    left: 24px;
    font-family: 'Alibaba-PuHuiTi-B';
    font-weight: 700;
    color: #3d3d3d;
    font-size: 20px;
    line-height: 27px;
  }

  .job {
    width: 92px;
    height: 27px;
    position: absolute;
    top: 103px;
    left: 27px;
    font-family: 'Alibaba-PuHuiTi-B';
    font-weight: 700;
    color: #3d3d3d;
    font-size: 20px;
    line-height: 27px;
  }

  .other {
    width: 40px;
    height: 27px;
    position: absolute;
    top: 187px;
    left: 27px;
    font-family: 'Alibaba-PuHuiTi-B';
    font-weight: 700;
    color: #3d3d3d;
    font-size: 20px;
    line-height: 27px;
  }

  .helpEach {
    width: 60px;
    height: 27px;
    position: absolute;
    top: 271px;
    left: 27px;
    font-family: 'Alibaba-PuHuiTi-B';
    font-weight: 700;
    color: #3d3d3d;
    font-size: 20px;
    line-height: 27px;
  }
}

.menuStudy:hover {
  border-bottom: 3px solid #3e84fe;
  color: #3e84fe !important;
}
</style>
