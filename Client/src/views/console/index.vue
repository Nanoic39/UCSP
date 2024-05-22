<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-12 14:17:36
 * @LastEditTime: 2024-05-18 18:31:09
 * @FilePath: \Client\src\views\console\index.vue
 * @Describe: 
-->
<script setup>
import ConsoleMenu from '@/views/console/ConsoleMenu.vue'
import panel from '@/views/console/mainIndex/dashBoard/panel.vue'
import userDelete from '@/views/console/mainIndex/user/userDelete.vue'
import userSelect from '@/views/console/mainIndex/user/userSelect.vue'
import { ref } from 'vue'


const isCollapse = ref(true) //定义侧边菜单栏是否收缩，默认false为不收缩
const MainId = ref(2)  //定义主体区域内容对应的菜单id，可以设置默认展示的内容，2为仪表盘内容
const changeAside = () => {
  isCollapse.value = !isCollapse.value
}
const getIndexFromMenu = (value) => {
  MainId.value = value
  //console.log('当前选中的菜单值为：',value)
}

</script>

<template>
  <div style="height: 100vh">
    <div class="common-layout">
      <el-container>
        <el-container width="100%" style="height: 700px">
          <!--:width="isCollapse ? '4.4%':'12%'"-->
          <el-aside width='collapse' style="height: 100vh;background-color:white" id="trueAside">
            <ConsoleMenu :CollapseInf='isCollapse' :sendFnToMenu='getIndexFromMenu' />
          </el-aside>
          <el-container id="leftContainer" style='background-color: bisque;'>
            <el-header style="display:flex;padding-left:0;">
              <div id="leftHeader">
                <div id="buttonBox">
                  <el-button type="info" id="asideBtn" @click="changeAside" circle>
                    <el-icon v-if="isCollapse">
                      <ArrowRightBold />
                    </el-icon>
                    <el-icon v-else>
                      <ArrowLeftBold />
                    </el-icon>
                  </el-button>
                </div>
                <div id="IconBox">
                  <img src="../../assets/layout/justFishIcon.png" id="headerIcon" />
                </div>
                <div id="headerTitle">
                  <div style="font-size: 26px;">
                    E通达
                  </div>
                  <div>
                    <span style="font-size: 11px;">
                      One-stop campus website
                    </span>
                  </div>
                </div>

              </div>
              <div id="rightHeader">
                <!-- 右边有主题切换，帮助按钮，登录者信息-->
              </div>
            </el-header>
            <el-main id="main">
              <panel v-if="MainId === 2" />
              <userDelete v-if="MainId === 6" />
              <userSelect v-if="MainId === 5" />
            </el-main>
            <el-footer>Footer</el-footer>
          </el-container>
        </el-container>
      </el-container>
    </div>
  </div>
</template>

<style>
.el-container {
  height: 100vh;
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
}

.el-menu {
  background-color: rgba(254, 209, 16, 0.6);
}

#trueAside {
  overflow-x: hidden;
  transition: all 0.3s cubic-bezier(0.645, 0.045, 0.355, 1);
  border-right: 2px dashed grey;
}

#falseAside {
  transition: all 0.3s cubic-bezier(0.645, 0.045, 0.355, 1);
}

#leftContainer {
  /* height: 1000px; */
  position: relative;
}

.el-header {
  background-color: rgba(47, 144, 185, 0.6);
  height: 8%;
  width: 100%;
}

.el-footer {
  background-color: rgba(18, 161, 130, 0.6);
  height: 12%;
  width: 100%;
}

#main {
  margin-top: 5% !important;
}



#headerIcon {
  width: 50%;
}

#leftHeader {
  width: 50%;
  display: flex;
  display: flex;
  justify-content: flex-start;
  align-items: center
}

#rightHeader {
  width: 50%;
  display: flex;
  display: flex;
  justify-content: flex-end;
  align-items: center
}

#buttonBox {
  width: 4%;
  height: 8%;
  position: absolute;
  left: -10px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}

#asideBtn {
  height: 20px;
  width: 20px;
  
}

#IconBox {
  width: 18%;
  display: flex;
  justify-content: space-around;
  align-items: center
}

#headerTitle {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  position: relative;
  left: -20px;
  
}

#headerTitle div {
  font-size: clamp(0.7rem, 0.489rem + 1.05vw, 1.2rem);
}
</style>
