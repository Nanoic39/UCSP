<script setup>
import '@/assets/font/font.css'
import '@/assets/svg/tongda/new/iconfont.css'
import '@/assets/svg/tongda/hot/iconfont.css'
import '@/assets/svg/tongda/attention/iconfont.css'
import '@/assets/svg/tongda/day/iconfont.css'
import '@/assets/svg/tongda/love/iconfont.css'
import '@/assets/svg/tongda/venting/iconfont.css'
import { usecountStore } from '@/stores/count'
import { ref } from 'vue'
const usecount = usecountStore()
const ask = ref([
  {
    id: 1,
    url: 'iconfont icon-shizhong',
    names: '最新'
  },
  {
    id: 2,
    url: 'iconfont icon-hot',
    names: '热门'
  },
  {
    id: 3,
    url: 'iconfont icon-icon-test',
    names: '关注'
  },
  {
    id: 4,
    url: 'iconfont icon-cha',
    names: '日常'
  },
  {
    id: 5,
    url: 'iconfont icon-aixin',
    names: '表白'
  },
  {
    id: 6,
    url: 'iconfont icon-tucao1',
    names: '吐槽'
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
}
</script>

<template>
  <div class="sharesel" @mouseleave="deactivate">
    <div
      class="ask"
      v-for="(item, index) in ask"
      :key="item"
      :class="{ blueBackground: index === activeIndex }"
      @mouseenter="activate(index)"
      @click="handleMenuClick(index)"
    >
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
      padding-top: 3px;
      width: 20px;
      height: 20px;
      position: absolute;
      top: 14px;
      left: 10px;
      //   font-size: 22px;
      font-weight: 500;
      img {
        width: 20px;
        height: 20px;
      }
    }

    .icon-icon-test {
      padding-top: 2px;
      font-size: 18px;
    }
    .icon-cha {
      padding-top: 0px;
      font-size: 22px;
    }
    .icon-aixin {
      font-size: 18px;
    }
    .icon-tucao1 {
      padding-top: 1px;
      font-size: 20px;
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
