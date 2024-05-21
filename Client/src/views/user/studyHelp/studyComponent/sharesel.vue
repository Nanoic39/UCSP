<script setup>
import '@/assets/font/font.css'
import '@/assets/svg/helpeach/book/iconfont.css'
import '@/assets/svg/helpeach/pc/iconfont.css'
import '@/assets/svg/helpeach/ask/iconfont.css'
import { usecountStore } from '@/stores/count'
import { ref, inject } from 'vue'
const { messagestate } = inject('messageContent')
const usecount = usecountStore()
const ask = ref([
  {
    id: 1,
    // url: new URL('@/assets/svg/helpeach/书.svg', import.meta.url).href,
    url: 'iconfont icon-shu',
    names: '学习经验分享'
  },
  {
    id: 2,
    url: 'iconfont icon-diannao301',
    // url: new URL('@/assets/svg/helpeach/pc.svg', import.meta.url).href,
    names: '选课攻略'
  },
  {
    id: 3,
    url: 'iconfont icon-dayijiehuo',
    // url: new URL('@/assets/svg/helpeach/答疑.svg', import.meta.url).href,
    names: '互助答疑'
  }
])

const getClass = (items) => {
  return items
}

const activeIndex = ref(0)

const activate = (index) => {
  activeIndex.value = index
}

const deactivate = () => {
  if (usecount.asks) {
    activeIndex.value = usecount.asks
  } else {
    activeIndex.value = 0
  }
}

const handleMenuClick = (index) => {
  activeIndex.value = index
  usecount.setAsks(index)
  if (index == 0) {
    messagestate.value = true
  } else if (index == 2) {
    messagestate.value = false
  }
}
</script>

<template>
  <div class="sharesel" @mouseleave="deactivate">
    <div class="ask" v-for="(item, index) in ask" :key="item" :class="{ blueBackground: index === activeIndex }"
      @mouseenter="activate(index)" @click="handleMenuClick(index)">
      <div :class="getClass(item.url)"></div>
      <div class="content" :class="{ color: index === activeIndex }">
        {{ item.names }}
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.sharesel {
  width: 188px;
  height: 407px;
  position: absolute;
  background-color: #ffffff;
  left: 119px;
  top: 24px;
  padding-top: 8px;
  padding-left: 12px;

  .ask {
    width: 176px;
    height: 47px;
    position: relative;
    border-radius: 3px;

    .iconfont {
      padding-top: 1px;
      width: 20px;
      height: 20px;
      position: absolute;
      top: 14px;
      left: 10px;
      font-size: 22px;
      font-weight: 500;

      img {
        width: 20px;
        height: 20px;
      }
    }

    .content {
      min-width: 63px;
      max-width: 120px;
      height: 22px;
      position: absolute;
      left: 39px;
      top: 14px;
      color: #565555;
      font-size: 16px;
      font-family: 'Alibaba-PuHuiTi-B';
      line-height: 22px;
    }
  }
}

.blueBackground {
  background-color: #f6f9ff;
  color: #3e84fe;
}

.color {
  color: #3e84fe !important;
}
</style>
