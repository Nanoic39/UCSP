<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-17 19:32:20
 * @LastEditTime: 2024-05-22 11:28:45
 * @FilePath: \Client\src\views\user\activity\activityDetails.vue
 * @Describe: 
-->
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

</script>

<template>
  <menus></menus>
  
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
