<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-17 19:32:20
 * @LastEditTime: 2024-05-22 11:45:31
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
  <background></background>
  <screen></screen>
</template>

<style lang="scss" scoped></style>
