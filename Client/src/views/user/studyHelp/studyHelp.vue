<script setup>
import '@/assets/font/font.css'
import menus from '@/views/commonalityElement/menu.vue'
import sharesel from './component/sharesel.vue'
import { ref } from 'vue'
import shareMessage from './component/shareMessage.vue'
import topMenu from './component/topMenu.vue'
import calendarx from './component/calendarx.vue'
import '@/assets/svg/helpeach/huangguan/iconfont.css'
import rank from './component/rank.vue'
import { useRouter } from 'vue-router'
import shareContent from './shareContent.vue'
const router = useRouter()
const contain = ref(null)
const counts = ref(10)

window.onscroll = function () {
  const containHeight = ref(contain.value.offsetHeight)

  const containTop = ref(contain.value.offsetTop)

  var scrollTop = document.documentElement.scrollTop || document.body.scrollTop

  var windowHeight = document.documentElement.clientHeight

  if (Math.round(windowHeight + scrollTop) == containHeight.value + containTop.value + 142) {
    console.log('到底了')
    counts.value += 10
  }
}

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
      <div class="contain" ref="contain">
        <shareMessage @click="shareContents()" v-for="item in counts" :key="item"></shareMessage>
      </div>
    </div>
    <calendarx></calendarx>
    <rank></rank>
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
}
</style>
