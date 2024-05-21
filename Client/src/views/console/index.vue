<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-12 14:17:36
 * @LastEditTime: 2024-05-18 18:31:09
 * @FilePath: \Client\src\views\console\index.vue
 * @Describe: 
-->
<template>
  <div style="height: 100vh">
    <div class="common-layout">
      <el-container>
        <el-container width="100%" style="height: 700px">
          <el-aside :width="isCollapse ? '4.4%':'12%'" style="height: 100vh;background-color:aquamarine" id="trueAside">
            <el-menu default-active="2" class="el-menu-vertical" :collapse="isCollapse"  :collapse-transition="false">
              <template v-for="item in newMenu " :key="item.id">
                <!-- 单个 -->
                <template v-if='item.children.length === 0 ? true : false'>
                  <el-menu-item :index="item.path">
                    <el-icon>
                      <component :is='item.icon'> </component>
                    </el-icon>
                    <span>{{ item.name }}</span>
                  </el-menu-item>
                </template>
                <!-- 嵌套 -->
                <template v-if="item.level == 1">
                  <el-sub-menu v-if='item.children.length !== 0 ? true : false' :index="item.path">
                    <template #title>
                      <el-icon>
                        <component :is='item.icon'> </component>
                      </el-icon>
                      <span>{{ item.name }}</span>
                    </template>
                    <template v-for="subItem in item.children" :key="subItem.id">
                      <el-menu-item :index="subItem.path" @click="handleMenuItemClick(subItem)">
                        <template #title>
                          <el-icon>
                            <component :is='subItem.icon'> </component>
                          </el-icon>
                          <span>{{ subItem.name }}</span>
                        </template>
                      </el-menu-item>
                    </template>
                  </el-sub-menu>
                </template>
              </template>
            </el-menu>
          </el-aside>
          <!-- 在左边塞一个等大区域用来个占位置  -->
          <el-collapse-transition>
            
          </el-collapse-transition>
          <el-aside :width="isCollapse ? '4.4%':'12%'"></el-aside>
          <el-container id="leftContainer"  style='background-color: bisque;' >
            <el-header>
              <el-button type="info" id="asideBtn" @click="changeAside"> 
                <el-icon><Operation /></el-icon>
              </el-button>
            </el-header>
            <el-main id="main">
              我来组成中间
            </el-main>
            <el-footer>Footer</el-footer>
          </el-container>
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

//导航栏
const activeIndex = ref('1')
const activeIndex2 = ref('1')
// const handleSelect = (key: string, keyPath: string[]) => {
//   console.log(key, keyPath)
// } ——>莫名其妙vscode报错了，源代码就是这么写的啊？？？

//侧边栏
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'

const isCollapse = ref(false)
const changeAside = () => {
  isCollapse.value = !isCollapse.value
}





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
    menu.value = res.data?.data
    newMenu.value = menuToTree(res.data.data)
    console.log('newMenu', newMenu.value)
  } else {
    console.error('ERROR', res.data)
  }
})
</script>

<style>
.el-container {
  height: 100vh;
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

.el-menu {
  background-color: rgba(254,209,16,0.6);
}

#trueAside {
  position: fixed;
  overflow-x: hidden;
}

#leftContainer {
  height: 1000px;
}

.el-header {
  background-color: rgba(47,144,185,0.6);
  height: 8%;
  width: 100%;
  position: fixed;
}

.el-footer{
  background-color: rgba(18,161,130,0.6);
  height: 12%;
  width: 100%;
}

#main {
  margin-top: 5% !important ;
}

#asideBtn {
  height:40%;
  width: 30px;
  position:relative;
  top: 30%;
}
</style>
