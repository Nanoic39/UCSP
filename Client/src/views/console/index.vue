<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-12 14:17:36
 * @LastEditTime: 2024-05-15 14:57:02
 * @FilePath: \Client\src\views\console\index.vue
 * @Describe: 
-->
<template>
  <div style="height: 100vh">
    <div class="common-layout">
      <el-container>
        <el-header>仪表盘</el-header>
        <el-container>
          <el-aside width="250px">
            <!--
                :collapse="isCollapse"
              @open="handleOpen"
              @close="handleClose"
            -->
            <el-menu class="el-menu-vertical" router="true" v-model="newMenu">
              <el-menu-item>
                <el-icon>
                </el-icon>
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

request.post("/date", {type: 'blur', name: ''}).then(res => {
  console.log(res.data)
})

// request
//   .get('/get/console/menu')
//   .then((res) => {
//     if (res.data?.statusCode == '200') {
//       console.log(res.data)
//       const newMenu = ref(menuToTree(res.data.data))
//       console.log("newMenu",newMenu.value);
//     } else {
//       console.error('ERROR', res.data)
//     }
//   })
</script>

<style>
.el-container {
  height: 100%;
}
</style>
