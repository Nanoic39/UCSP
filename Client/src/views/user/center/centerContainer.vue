<script setup>
import menus from '@/views/commonalityElement/menu.vue'
import '@/assets/font/font.css'
import { ref, provide } from 'vue'
import personalbackground from './component/personalbackground.vue';
import secondmenu from './component/secondmenu.vue'
import essay from './component/essay.vue'
import shareMessage from '../studyHelp/studyComponent/shareMessage.vue';
import '@/assets/svg/center/lock/iconfont.css'
import collectdefault from './component/collectdefault.vue';
import collectother from './component/collectother.vue';
const state = ref(0)
provide('states', { state })
</script>

<template>
  <menus></menus>
  <div class="personal">
    <personalbackground></personalbackground>
    <secondmenu></secondmenu>
    <div class="trends" v-if="state == 0">
      <essay></essay>
    </div>
    <div class="essay" v-if="state == 1">
      <shareMessage v-for="item in 10" :key="item"></shareMessage>
    </div>
    <div class="essay" v-if="state == 2">
      <shareMessage v-for="item in 10" :key="item"></shareMessage>
    </div>
    <div class="collect" v-if="state == 3">
      <div class="topmenu">
        <el-button class="create">我创建的 2</el-button>
        <el-button class="subscribe">我订阅的 2</el-button>
        <div class="newcreate">+新建收藏夹</div>
      </div>
      <div class="collection">
        <collectdefault></collectdefault>
        <collectother v-for="item in 5" :key="item"></collectother>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.personal {
  width: 800px;
  height: auto;
  background-color: #ffffff;
  position: relative;
  left: 319px;

  .trends {
    width: 100%;
    height: auto;

  }

  .essay {
    width: 700px;
    height: auto;
    margin-left: 100px;
  }

  .collect {
    width: 800px;
    height: auto;
    padding-bottom: 80px;
    background-color: #FFFFFF;

    .topmenu {
      width: 603px;
      height: 59px;
      // background-color: aqua;
      margin: auto;
      position: relative;

      .create {
        min-width: 95px;
        height: 26px;
        background-color: #F2F7FF;
        border-radius: 100px;
        position: absolute;
        top: 25px;
        left: 0;
      }

      .subscribe {
        min-width: 95px;
        height: 26px;
        background-color: #F2F7FF;
        border-radius: 100px;
        position: absolute;
        top: 25px;
        left: 115px;
      }

      .newcreate {
        min-width: 77px;
        height: 19px;
        position: absolute;
        right: 0;
        top: 25px;
        font-size: 14px;
        color: #3E84FE;
      }
    }
  }
}
</style>
