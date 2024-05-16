<script setup>
import '@/assets/font/font.css'
import menus from '@/views/commonalityElement/menu.vue'
import sharesel from './studyComponent/sharesel.vue'
import { ref, provide } from 'vue'
import shareMessage from './studyComponent/shareMessage.vue'
import topMenu from './studyComponent/topMenu.vue'
import calendarx from './studyComponent/calendarx.vue'
import '@/assets/svg/helpeach/huangguan/iconfont.css'
import rank from './studyComponent/rank.vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const contains = ref(null)
const counts = ref(10)

window.onscroll = function () {
  if (window.location.pathname == '/studyHelp') {
    const containHeight = ref(contains.value.offsetHeight)
    const containTop = ref(contains.value.offsetTop)

    var scrollTop = document.documentElement.scrollTop || document.body.scrollTop

    var windowHeight = document.documentElement.clientHeight

    if (Math.round(windowHeight + scrollTop) - containHeight.value - containTop.value >= 100) {
      console.log('到底了')
      counts.value += 10
    }
  } else {
    return
  }
}

const messagestate = ref(true)
provide('messageContent', { messagestate })

const shareContents = () => {
  router.push('/studyHelp/shareContent')
}
</script>

<template>
  <menus></menus>
  <div class="pageShare">
    <sharesel></sharesel>
    <div class="shareContent">
      <topMenu></topMenu>
      <div class="contain" ref="contains">
        <shareMessage @click="shareContents()" v-for="item in counts" :key="item"></shareMessage>
      </div>
    </div>
    <div class="all">
      <calendarx></calendarx>
      <rank></rank>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.pageShare {
  width: 100%;
  height: 100%;
  position: relative;
  .shareContent {
    width: 647px;
    min-height: 185px;
    background: #ffffff;
    position: absolute;
    top: 24px;
    left: 346px;
    .contain {
      width: 625px;
      min-height: 136px;
      max-height: 100%;
      position: relative;
      padding-top: 17px;
      padding-left: 22px;
    }
  }

  .all {
    width: 296px;
    min-height: 820px;
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    position: absolute;
    right: 110px;
    top: 24px;
  }
}
</style>
