<script setup>
import '@/assets/font/font.css'
import { inject, ref } from 'vue'
const { messagestate } = inject('messageContent')

const options = ref([
  {
    value: '1',
    label: '全部'
  },
  {
    value: '2',
    label: '前端'
  },
  {
    value: '3',
    label: 'javaScript'
  },
  {
    value: '4',
    label: 'Vue.js'
  },
  {
    value: '5',
    label: 'React.js'
  },
  {
    value: '6',
    label: '面试'
  },

  {
    value: '7',
    label: 'css'
  },
  {
    value: '8',
    label: 'java'
  },
  {
    value: '9',
    label: 'python'
  }
])

const value = ref([])
const limit = ref(1)

const select = ref([
  { id: 1, name: '最新' },
  { id: 2, name: '最热' }
])

const activeIndex = ref(0)

const changestate = (index) => {
  activeIndex.value = index
}
</script>

<template>
  <div class="topMenu">
    <div v-for="(item, index) in select" @click="changestate(index)" :key="item.id"
      :class="{ blueBackground: index === activeIndex }">{{ item.name }}</div>
    <div class="screen">
      <el-select-v2 v-model="value" filterable :options="options" placeholder="全部" style="width: 100%; height: 25px"
        :multiple-limit=limit />
    </div>
    <el-button class="contribute" v-if="messagestate">投稿</el-button>
    <el-button class="contribute" v-else>提问</el-button>
  </div>
</template>
<style lang="scss" scoped>
.blueBackground {
  color: #3e84fe;
}

.topMenu {
  width: 100%;
  height: 46px;
  position: relative;
  border-bottom: solid 1px #bab7b7;

  .screen {
    width: 134px;
    height: 25px;
    position: absolute;
    top: 8px;
    left: 117px;
    background-color: #f6f9ff;
  }

  .contribute {
    width: 59px;
    height: 26px;
    background-color: #3e84fe;
    color: #ffffff;
    font-size: 12px;
    line-height: 26px;
    font-family: 'Alibaba-PuHuiTi-B';
    position: absolute;
    top: 9px;
    right: 22px;
  }
}

.topMenu>div:nth-child(1) {
  width: 28px;
  height: 19px;
  position: absolute;
  top: 13px;
  left: 31px;
  font-size: 14px;
  line-height: 19px;
  font-family: 'Alibaba-PuHuiTi-B';
  // color: #3d3d3d;
  cursor: pointer;
}

.topMenu>div:nth-child(2) {
  width: 28px;
  height: 19px;
  position: absolute;
  top: 13px;
  left: 77px;
  font-size: 14px;
  line-height: 19px;
  font-family: 'Alibaba-PuHuiTi-B';
  // color: #3d3d3d;
  cursor: pointer;
}
</style>
