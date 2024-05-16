<script setup>
import '@/assets/font/font.css'
import content from './content/content.vue'
import { ref, watch } from 'vue'

const publish = ref('')
const wordCount = ref(0)

const updateWordCount = () => {
  wordCount.value = publish.value.trim().length
}
</script>

<template>
  <div class="discuss">
    <div class="total">评论 19</div>
    <div class="write">
      <div class="headimg"></div>
      <div class="publish">
        <el-input
          class="cn"
          type="textarea"
          placeholder="平等交流，友善表达"
          @input="updateWordCount"
          v-model="publish"
        ></el-input>
        <div class="all">{{ wordCount }}/1000</div>
        <el-button class="btn">发送</el-button>
      </div>
    </div>
    <div class="hotOrnew">
      <div class="hot">最热</div>
      <div class="new">最新</div>
    </div>
    <div class="review">
      <content v-for="item in 5" :key="item"></content>
    </div>
    <div class="last">查看全部56条评论</div>
  </div>
</template>
<style lang="scss" scoped>
.discuss {
  width: 677px;
  min-height: 500px;
  background-color: #ffffff;
  padding-left: 36px;
  padding-right: 36px;
  padding-top: 20px;
  padding-bottom: 11px;

  .total {
    min-width: 62px;
    max-width: 80px;
    height: 25px;
    color: #3d3d3d;
    font-size: 18px;
    font-weight: 500;
    line-height: 25px;
    font-family: 'Alibaba-PuHuiTi-B';
  }

  .write {
    width: 100%;
    height: 88px;
    padding-top: 16px;
    display: flex;

    .headimg {
      width: 40px;
      height: 40px;
      border-radius: 50%;
      background-image: url('@/assets/layout/211540yrmp8w0prt8opzm0.jpg');
      background-repeat: no-repeat;
      background-size: cover;
    }

    .publish {
      width: 620px;
      height: 88px;
      margin-left: 15px;
      position: relative;

      ::v-deep(.cn) {
        .el-textarea__inner {
          resize: none;
          height: 88px;
          background-color: #efefef;
        }
      }
      .all {
        position: absolute;
        min-width: 48px;
        max-width: 80px;
        height: 19px;
        font-size: 14px;
        color: #717171;
        line-height: 19px;
        font-family: 'Alibaba-PuHuiTi-B';
        bottom: 10px;
        right: 85px;
      }

      .btn {
        width: 60px;
        height: 29px;
        font-size: 14px;
        color: #ffffff;
        line-height: 29px;
        font-family: 'Alibaba-PuHuiTi-B';
        position: absolute;
        right: 12px;
        bottom: 5px;
        background-color: #3e84fe;
      }
    }
  }

  .hotOrnew {
    width: 62px;
    height: 16px;
    margin-top: 20px;
    display: flex;

    .hot {
      width: 29px;
      height: 16px;
      border-right: 2px solid #d8d8d8;
      color: #3d3d3d;
      font-size: 12px;
      line-height: 16px;
      font-family: 'Alibaba-PuHuiTi-B';
    }

    .new {
      width: 24px;
      height: 16px;
      padding-left: 6px;
      color: #3d3d3d;
      font-size: 12px;
      line-height: 16px;
      font-family: 'Alibaba-PuHuiTi-B';
    }
  }

  .review {
    width: 100%;
    min-height: 420px;
    margin-top: 28px;
    display: flex;
    flex-wrap: wrap;
    gap: 10px;
  }

  .last {
    margin-top: 16px;
    width: 100%;
    height: 40px;
    text-align: center;
    font-size: 12px;
    color: #717171;
    line-height: 40px;
    font-family: 'Alibaba-PuHuiTi-B';
    background-color: #efefef;
  }
}
</style>
