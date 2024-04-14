<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-12 20:48:04
 * @LastEditTime: 2024-04-12 21:50:38
 * @FilePath: \UCSP\Client\src\views\test\leftmenu.vue
 * @Describe: 
-->
<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="leftmenu">
    <ul>
      <li
        v-for="(item, index) in list"
        :key="index"
        @mouseenter="handleMouseEanter(index)"
        @mouseleave="handleMouseLeave()"
      >
        <el-row class="arrow">
          <el-col :span="16" :offset="2"
            ><div>{{ item.name }}</div></el-col
          >
          <el-col :span="3" :offset="1">
            <el-icon class="rightarrow"><ArrowRightBold /></el-icon>
          </el-col>
        </el-row>
      </li>
    </ul>
  </div>
  <div class="zhankaiye">
    第一页
    <!-- <el-calendar class="custom-calendar">
      <template #date-cell="{ data }">
        <p :class="data.isSelected ? 'is-selected' : ''">
          {{ data.day.split('-').slice(1).join('-') }}
          {{ data.isSelected ? '✔️' : '' }}
        </p>
      </template>
    </el-calendar> -->
    <!-- <el-button class="daka">立即打卡</el-button> -->
  </div>
  <div class="zhankaiye">第二页</div>
  <div class="zhankaiye">第三页</div>
  <div class="zhankaiye">第四页</div>
  <div class="zhankaiye">第五页</div>
</template>

<script setup lang="ts">
import { ArrowRightBold } from '@element-plus/icons-vue'
import { onMounted, ref } from 'vue'
import $ from 'jquery'
const list = ref([
  { id: 0, name: '打卡签到' },
  { id: 1, name: '考试通知' },
  { id: 2, name: '课表查询' },
  { id: 3, name: '服务通知' },
  { id: 4, name: '课程进度' }
])

const divArray = ref([])

const handleMouseEanter = (index) => {
  divArray.value.forEach((element) => {
    element.style.display = 'none'
  })
  divArray.value[index].style.display = 'block'
  // console.log(divArray.value[index].classList.value)
}

const handleMouseLeave = () => {
  divArray.value.forEach((element) => {
    if (element.style.display == 'block') {
      element.style.display = 'none'
    }
  })
}

onMounted(() => {
  for (let i = 0; i < $('.zhankaiye').length; i++) {
    divArray.value.push($('.zhankaiye')[i])
  }
  // console.log(divArray.value)
})
</script>

<style lang="scss" scoped>
.leftmenu {
  position: absolute;
  width: 20%;
  height: 100%;
  background-color: rgba(212, 209, 209, 0.5);
  z-index: 1;
  margin: 0;
  padding: 0;

  ul {
    width: 100%;
    height: 100%;
    margin: 0;
    padding: 0;
    list-style: none;
    li {
      width: 100%;
      height: 10%;
      color: rgb(0, 4, 8);
      .arrow {
        position: relative;
        top: 15px;
        .rightarrow {
          font-size: 22px;
          color: black;
        }
      }
    }
    li:hover {
      background-color: skyblue;
    }
  }
}
.zhankaiye {
  width: 80%;
  height: 100%;
  background-color: rgb(235, 229, 229);
  position: absolute;
  top: 0%;
  left: 20%;
  z-index: 10;
  display: none;

  .daka {
    position: relative;
    left: 830px;
    bottom: 15px;
  }
  .custom-calendar {
    width: 100%;
  }
  ::v-deep .el-calendar-table .el-calendar-day {
    height: 100%;
  }
  .is-selected {
    color: #1989fa;
  }
}
</style>
