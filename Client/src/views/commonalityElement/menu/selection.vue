<script setup>
import '@/assets/font/font.css'
import { ref, onMounted } from 'vue'
import selecthelp from './selects/selectHelp.vue'
import selectother from './selects/selectOther.vue'
import selectjob from './selects/selectJob.vue'
const carouselRef = ref(null)
const myDiv = ref(null)
const isCarouselVisible = ref(false)
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
</script>

<template>
  <div class="menuStudy" ref="myDiv" @mouseleave="changeStudys()">
    学习资源
    <div class="studyContainer">
      <div class="university">大学</div>
      <div class="selectsubject">
        <div class="selectSubject">
          <el-carousel
            v-if="isCarouselVisible"
            ref="carouselRef"
            class="lunbo"
            height="auto"
            :autoplay="false"
            indicator-position="none"
          >
            <el-carousel-item class="contain" style="height: 38px">
              <router-link to="/study" class="tagMath">数学</router-link>
              <router-link to="/study" class="tagEnglish">英语</router-link>
              <router-link to="/study" class="tagComputer">计算机</router-link>
              <router-link to="/study" class="tagCompetition">大学生竞赛</router-link>
            </el-carousel-item>
            <el-carousel-item class="contain" style="height: 38px">
              <router-link to="/study" class="tagMath">物理</router-link>
              <router-link to="/study" class="tagEnglish">金融</router-link>
              <router-link to="/study" class="tagComputer">设计</router-link>
              <router-link to="/study" class="tagCompetition">编程</router-link>
            </el-carousel-item>
          </el-carousel>
        </div>
      </div>
      <div class="job">升学/学业</div>
      <div class="selectjob">
        <selectjob>
          <template #first>考公</template>
          <template #second>考研</template>
          <template #third>教资</template>
          <template #fourth>计算机二级</template>
        </selectjob>
      </div>
      <div class="other">其他</div>
      <div class="selectother">
        <selectother>
          <template #first>技能课程</template>
          <template #second>驾照</template>
        </selectother>
      </div>
      <div class="helpEach">互助室</div>
      <div class="selecthelp">
        <selecthelp>
          <template #first>互助室</template>
        </selecthelp>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.menuStudy {
  width: 80px;
  height: 27px;
  position: absolute;
  left: 300px;
}

.studyContainer {
  position: absolute;
  top: 30px;
  left: -69px;
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

.selectSubject {
  width: 100%;
  height: 27px;
  :deep(.lunbo) {
    font-size: 16px;
    position: relative;
    .contain {
      a:hover {
        background-color: #3e84fe !important;
        color: #ffffff !important;
      }
      a {
        text-decoration: none;
        color: #3d3d3d;
      }
      // z-index: 100;
    }
    .el-carousel__arrow--left {
      width: 18px;
      height: 18px;
      position: absolute;
      left: 5px;
      background-color: #83f1f1;
    }
    .el-carousel__arrow--right {
      width: 18px;
      height: 18px;
      position: absolute;
      right: 5px;
      background-color: #83f1f1;
    }
    .tagMath,
    .tagEnglish {
      width: 85px;
      height: 26px;
      background-color: #f6f9ff;
      border-radius: 30px;
      font-size: 16px;
      font-weight: 500;
      font-family: 'Alibaba-PuHuiTi-B';
      color: #3d3d3d;
      text-align: center;
      line-height: 26px;
    }

    .tagComputer {
      width: 94px;
      height: 26px;
      background-color: #f6f9ff;
      border-radius: 30px;
      font-size: 16px;
      font-weight: 500;
      font-family: 'Alibaba-PuHuiTi-B';
      color: #3d3d3d;
      text-align: center;
      line-height: 26px;
      position: absolute;
      left: 254px;
    }
    .tagMath {
      position: absolute;
      left: 25px;
    }
    .tagEnglish {
      position: absolute;
      left: 138px;
    }
    .tagCompetition {
      width: 118px;
      height: 26px;
      background-color: #f6f9ff;
      border-radius: 30px;
      font-size: 16px;
      font-weight: 500;
      font-family: 'Alibaba-PuHuiTi-B';
      color: #3d3d3d;
      text-align: center;
      line-height: 26px;
      position: absolute;
      left: 375px;
    }
  }
}
</style>
