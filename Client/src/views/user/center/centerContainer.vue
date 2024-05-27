<script setup>
import menus from '@/views/commonalityElement/menu.vue'
import '@/assets/font/font.css'
import { ref, provide, onMounted, watch } from 'vue'
import personalbackground from './component/personalbackground.vue';
import secondmenu from './component/secondmenu.vue'
import essay from './component/trends/essay.vue'
import shareMessage from './component/essay/shareMessage.vue';
import '@/assets/svg/center/lock/iconfont.css'
import collectdefault from './component/collect/collectdefault.vue';
import topmenus from './component/collect/topmenu.vue'
import subscribe from './component/collect/subscribe.vue'
import agreesessay from './component/agree/essay.vue'
import agreemenu from './component/agree/agreemenu.vue'
import agreemessage from './component/agree/agreeMessage.vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import attention from './component/attention/attention.vue';
import personal from './component/personal/personal.vue';
import { usecountStore } from '@/stores/count'
const usecount = usecountStore()

const station = ref(0)
provide('stations', { station })

const activeIndex = ref(null)

provide('indexs', { activeIndex })

const agrees = ref(0)
provide('agree', { agrees })

import { collectid, collectaccount } from '@/api/centercollect'

const tokens = ref({
  uuid: '',
  token: ''
})

tokens.value.uuid = JSON.parse(localStorage.getItem('user-data')).id

tokens.value.token = JSON.parse(localStorage.getItem('user-data')).token

console.log(tokens.value)

const collect = async () => {
  const res = await collectaccount()
  console.log(res)
}
collect()
</script>

<template>
  <menus></menus>
  <div class="personal" ref="sub">
    <personalbackground></personalbackground>
    <secondmenu></secondmenu>
    <div class="trends" v-if="usecount.index == 0">
      <essay></essay>
    </div>
    <div class="essay" v-if="usecount.index == 1">
      <shareMessage v-for="item in 10" :key="item"></shareMessage>
    </div>
    <div class="essay" v-if="usecount.index == 2">
      <shareMessage v-for="item in 10" :key="item"></shareMessage>
    </div>
    <div class="collect" v-if="usecount.index == 3">
      <topmenus></topmenus>
      <div class="collects" v-if="usecount.collect == 0">
        <collectdefault></collectdefault>
      </div>
      <div class="collects" v-if="usecount.collect == 1">
        <subscribe></subscribe>
      </div>
    </div>
    <div class="agree" v-if="usecount.index == 4">
      <agreemenu></agreemenu>
      <div v-if="agrees == 0">
        <agreesessay></agreesessay>
      </div>
      <div v-if="agrees == 1">
        <agreemessage v-for="item in 10" :key="item"></agreemessage>
      </div>
      <div v-if="agrees == 2">
        <agreemessage v-for="item in 10" :key="item"></agreemessage>
      </div>
    </div>
    <div class="attention" v-if="usecount.index == 5">
      <attention></attention>
    </div>
    <div class="personals" v-if="usecount.index == 6">
      <personal></personal>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.personal {
  width: 800px;
  height: auto;
  background-color: #ffffff;
  position: relative;
  top: 21px;
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
    padding-bottom: 60px;
    background-color: #FFFFFF;
  }

  .agree,
  .attention,
  .personals {
    width: 800px;
    height: auto;
    padding-bottom: 60px;
    background-color: #FFFFFF;
    padding-top: 27px;
  }
}
</style>
