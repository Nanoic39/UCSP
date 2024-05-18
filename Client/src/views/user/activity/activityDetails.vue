<script setup>
import menus from '@/views/commonalityElement/menu.vue'
import { useRoute, useRouter } from 'vue-router'
import { ref } from 'vue'
import request from '@/utils/request'
import { ElMessage } from 'element-plus'

//路由
const route = useRoute()
const router = useRouter()

//通过路由获取id
const activeId = ref('')

const postTips = (msg) => {
  ElMessage({ message: msg, type: 'warning' })
}

activeId.value = route?.params.activeId

//请求结果(详细活动数据)
const activeInfo = ref({
  id: '0',
  title: '活动标题',
  intro: '简介',
  content: '详细内容:如此如此这般这般<br/><button class="enroll" @click="">点击报名</button>',
  start_time: 0, //活动开始时间戳
  end_time: 0 //活动结束时间戳
})
//请求相应id的帖子
//request.get()
</script>

<template>
  <menus></menus>
  <div>
    <div class="contain">
      <div class="breadcrumb" @click="postTips('干什么！不许点我(龙)')">
        <span class="title">{{ activeInfo?.title }}</span>
        <span style="color: darkgray"> / </span>
        <span class="title">活动详情</span>
      </div>
      <div class="mainTitle">{{ activeInfo?.title }}</div>
      <div class="mainContent" v-html="activeInfo?.content"></div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.contain {
  min-height: 500px;
  border-radius: 8px;
  background-color: white;
  width: 80%;
  margin-top: 20px;
  padding: 10px;

  .breadcrumb {
    width: fit-content;
    cursor: pointer;

    .title {
      color: var(--theme-blue);
    }
    .title:hover {
      color: var(--theme-blue-hover);
    }
  }

  .mainTitle {
    margin-top: 10px;
    font-size: 24px;
  }

  //活动内容
  .mainContent {
    margin-top: 10px;
    
  }
}
</style>
