<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-12 14:17:36
 * @LastEditTime: 2024-05-16 22:26:10
 * @FilePath: \Client\src\views\console\index.vue
 * @Describe: 
-->
<template>
  <div style="height: 100vh">
    <div class="common-layout">
      <el-container>
        <el-header>
          <el-menu
    :default-active="activeIndex2"
    class="el-menu-demo"
    mode="horizontal"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
    @select="handleSelect"
  >
    <el-menu-item index="1">Processing Center</el-menu-item>
    <el-sub-menu index="2">
      <template #title>Workspace</template>
      <el-menu-item index="2-1">item one</el-menu-item>
      <el-menu-item index="2-2">item two</el-menu-item>
      <el-menu-item index="2-3">item three</el-menu-item>
      <el-sub-menu index="2-4">
        <template #title>item four</template>
        <el-menu-item index="2-4-1">item one</el-menu-item>
        <el-menu-item index="2-4-2">item two</el-menu-item>
        <el-menu-item index="2-4-3">item three</el-menu-item>
      </el-sub-menu>
    </el-sub-menu>
    <el-menu-item index="3" disabled>Info</el-menu-item>
    <el-menu-item index="4">Orders</el-menu-item>
  </el-menu>
        </el-header>
        <el-container>
          <el-aside width="250px">
            <!--
                :collapse="isCollapse"
              @open="handleOpen"
              @close="handleClose"
            -->
            <el-menu class="el-menu-vertical" router="true" v-model="newMenu">
              <el-menu-item>
                <el-icon> </el-icon>
                <template #title>{{ newMenu.name }}</template>
              </el-menu-item>
            </el-menu>
          </el-aside>
          <el-main>Main</el-main>
        </el-container>
      </el-container>
    </div>
  </div>
</template>

<script setup>
import { refereshRouter } from '@/utils/menu/refereshRouter'
import { menuToTree } from '@/utils/menu/toTree'
import request from '@/utils/request'
import { ref } from 'vue'

const menu = ref([
  {
    id: 0,
    parent_id: 0,
    name: 'string',
    path: 'string',
    file_path: null,
    icon: 'string',
    auth: 'string',
    level: 'string',
    sort: 'string',
    status: 'string',
    creat_time: 0,
    update_time: 0
  }
])
const newMenu = ref({})

request.get('/get/console/menu').then((res) => {
  if (res.data?.statusCode == '200') {
    //console.log(res.data)
    menu.value = res.data?.data
    console.log('menu.value', menu.value)
    newMenu.value = menuToTree(res.data.data)
    console.log('newMenu', newMenu.value)
  } else {
    console.error('ERROR', res.data)
  }
})
</script>

<style>
.el-container {
  height: 100%;
}
</style>
