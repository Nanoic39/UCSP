<script setup>
import '@/assets/font/font.css'
import { ref } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
const content = ref('关注')
const open = () => {
  ElMessageBox.confirm('你确定取消关注吗?', '注意', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning',
    draggable: true
  })
    .then(() => {
      ElMessage({
        type: 'success',
        message: '取关成功'
      })
      content.value = '关注'
    })
    .catch(() => {
      ElMessage({
        type: 'info',
        message: '取消成功'
      })
    })
}
const changeAttention = () => {
  if (content.value == '关注') {
    ElMessage({
      type: 'success',
      message: '关注成功'
    })
    content.value = '已关注'
  } else if ((content.value = '已关注')) {
    open()
  }
}
</script>

<template>
  <div class="personal">
    <div class="topinformation">
      <div class="headimg"></div>
      <div class="name">法助</div>
    </div>
    <div class="introduce">
      <div class="box" v-for="item in 3" :key="item">
        <div class="amount">1</div>
        <div class="kind">文章</div>
      </div>
    </div>
    <div class="buttons">
      <button class="attention" @click="changeAttention()">{{ content }}</button>
      <button class="message">私信</button>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.personal {
  width: 262px;
  height: 185px;
  position: absolute;
  top: 100px;
  left: 1007px;
  padding-top: 18px;
  padding-left: 17px;
  padding-right: 17px;
  padding-bottom: 17px;
  background-color: #ffffff;

  .topinformation {
    width: 262px;
    height: 62px;
    border-bottom: 1px solid #bab7b7;
    position: relative;

    .headimg {
      width: 50px;
      height: 50px;
      border-radius: 50%;
      background-image: url('@/assets/layout/211540yrmp8w0prt8opzm0.jpg');
      background-repeat: no-repeat;
      background-size: cover;
    }

    .name {
      min-width: 32px;
      max-width: 66px;
      height: 22px;
      position: absolute;
      top: 14px;
      left: 74px;
      font-size: 16px;
      line-height: 22px;
      color: #3d3d3d;
      font-family: 'Alibaba-PuHuiTi-B';
    }
  }

  .introduce {
    width: 244px;
    height: 55px;
    padding-top: 13px;
    padding-left: 9px;
    padding-right: 9px;
    display: flex;
    justify-content: space-between;

    .box {
      min-width: 32px;
      max-width: 56px;
      height: 55px;

      .amount {
        min-width: 27px;
        max-width: 56px;
        height: 33px;
        margin: auto;
        font-size: 24px;
        line-height: 33px;
        color: #3d3d3d;
        font-family: 'Alibaba-PuHuiTi-B';
        text-align: center;
      }

      .kind {
        width: 32px;
        height: 22px;
        margin: auto;
        font-size: 16px;
        line-height: 22px;
        color: #717171;
        font-family: 'Alibaba-PuHuiTi-B';
      }
    }
  }

  .buttons {
    width: 244px;
    height: 30px;
    padding-top: 24px;
    padding-left: 9px;
    padding-right: 9px;
    display: flex;
    justify-content: space-between;

    .attention,
    .message {
      width: 109px;
      height: 30px;
      background-color: #f6f9ff;
      color: #3e84fe;
      font-size: 16px;
      line-height: 30px;
      font-family: 'Alibaba-PuHuiTi-B';
      border: 1px solid #a6c5f6;
      border-radius: 3px;
    }
  }

  .buttons > button:hover {
    background-color: #3e84fe;
    color: #ffffff;
  }
}
</style>
