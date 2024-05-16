<script setup>
import '@/assets/font/font.css'
import '@/assets/svg/helpeach/agree/iconfont.css'
import '@/assets/svg/helpeach/review/iconfont.css'
import { ArrowDown } from '@element-plus/icons-vue'
import { ref } from 'vue'
const activeIndex = ref(null)
const changeState = () => {
  if (activeIndex.value != 0) {
    activeIndex.value = 0
  } else {
    activeIndex.value = null
  }
}
</script>

<template>
  <div class="content">
    <div class="headimg"></div>
    <div class="main">
      <div class="name">关益辰</div>
      <div class="message">
        小知不及大知，小年不及大年。奚以知其然也？朝菌不知晦朔，蟪蛄不，众人匹之，不亦悲乎！
      </div>
      <div class="bottom">
        <div class="static">
          <div class="time">22小时前</div>
          <div class="agree">
            <div
              class="iconfont icon-damuzhi"
              v-for="(item, index) in 1"
              :key="item"
              :class="{ color: index === activeIndex }"
              @click="changeState()"
            ></div>
            <div class="word">点赞</div>
          </div>
          <div class="comment">
            <div class="iconfont icon-pinglun"></div>
            <div class="word">评论</div>
          </div>
        </div>
        <div class="more">
          <el-icon><ArrowDown /></el-icon>
        </div>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.color {
  color: red;
  cursor: pointer;
}
.content {
  width: 100%;
  min-height: 76px;
  display: flex;
  gap: 12px;

  .headimg {
    width: 38px;
    height: 38px;
    border-radius: 50%;
    background-image: url('@/assets/layout/211540yrmp8w0prt8opzm0.jpg');
    background-repeat: no-repeat;
    background-size: cover;
  }

  .main {
    width: 460px;
    min-height: 76px;

    .name {
      min-width: 33px;
      max-width: 75px;
      height: 16px;
      margin-top: 3px;
      font-size: 12px;
      color: #717171;
      line-height: 16px;
      font-family: 'Alibaba-PuHuiTi-B';
    }

    .message {
      width: 456px;
      min-height: 32px;
      max-height: 64px;
      margin-top: 7px;
      font-size: 12px;
      color: #3d3d3d;
      font-family: 'Alibaba-PuHuiTi-B';
      line-height: 16px;
    }

    .bottom {
      width: 100%;
      height: 14px;
      display: flex;
      gap: 470px;

      .static {
        width: 140px;
        height: 14px;
        margin-top: 4px;
        display: flex;
        gap: 11px;

        .time {
          min-width: 42px;
          height: 14px;
          color: #717171;
          font-size: 10px;
          line-height: 14px;
          font-family: 'Alibaba-PuHuiTi-B';
        }

        .iconfont {
          width: 14px;
          height: 14px;
        }

        .word {
          width: 20px;
          height: 14px;
          font-size: 10px;
          line-height: 14px;
          font-family: 'Alibaba-PuHuiTi-B';
          color: #717171;
        }

        .agree {
          width: 37px;
          height: 14px;
          display: flex;
          gap: 3px;

          .iconfont {
            font-size: 14px;
          }
        }

        .comment {
          width: 38px;
          height: 14px;
          display: flex;
          gap: 3px;
        }
      }
      .more {
        width: 16px;
        height: 16px;
      }
    }
  }
}
</style>
