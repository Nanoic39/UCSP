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

const arr = ref(null)

const messagestate = ref(true)
provide('messageContent', { messagestate })

const shareContents = async (index) => {
  const res = await readstudytype(staticss.value)
  localStorage.setItem('postid', JSON.stringify(res.data.data[index].id))
  console.log(JSON.parse(localStorage.getItem('postid')))
  router.push('/studyHelp/shareContent')
}

import { readstudypost, readstudytype } from '@/api/studypost.js'
const staticss = ref({
  num: 0,
  type: "studypost",
  subjects: "高等数学"
})
const messages = ref(null)
const collect = ref(null)
// 文章id的储存
const postid = ref(null)
const readstudytypes = async () => {
  const res = await readstudytype(staticss.value)
  console.log(res.data)
  messages.value = res.data.data
  collect.value = res.data.data.length
  console.log(messages.value)
}
readstudytypes()

const state = ref(1)

const addreadstudytypes = async () => {
  staticss.value.num += 1
  console.log(staticss.value)
  const res = await readstudytype(staticss.value)
  console.log(res.data)
  arr.value = res.data.data
  console.log(arr.value)
  collect.value = res.data.data.length
  for (let i = 0; i < arr.value.length; i++) {
    messages.value.push(arr.value[i])
  }
  if (collect.value < 10) {
    state.value = 0
  }
  console.log(messages.value)
}

</script>

<template>
  <menus></menus>
  <div class="pageShare">
    <sharesel></sharesel>
    <div class="shareContent">
      <topMenu></topMenu>
      <div class="contain" ref="contains">
        <shareMessage @click="shareContents(index)" v-for="(item, index) in messages" :key="index">
          <template #title>{{ item.title }}</template>
          <template #intro>{{ item.intro }}</template>
          <template #image="{ src }">
            <img :src="'http://upload.nanoic.cc/image/' + item.post_cover" style=" width: 122px; height:
              82px;" />
          </template>
          <template #tag>{{ item.tag }}</template>
          <template #author>{{ item.author_name }}</template>
        </shareMessage>
        <div class="last" v-if="state == 1" @click="addreadstudytypes()">加载更多</div>
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

      .last {
        margin-top: 16px;
        width: 603px;
        height: 40px;
        text-align: center;
        font-size: 12px;
        color: #717171;
        line-height: 40px;
        font-family: 'Alibaba-PuHuiTi-B';
        background-color: #efefef;
        cursor: pointer;
        margin-bottom: 20px;
      }
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
