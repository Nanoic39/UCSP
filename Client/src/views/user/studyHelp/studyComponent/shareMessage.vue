<script setup>
import '@/assets/font/font.css'
import '@/assets/svg/helpeach/agree/iconfont.css'
import '@/assets/svg/helpeach/eyes/iconfont.css'
import tag from './shareMessageTag/tag.vue'
import { ref } from 'vue'

const imageProps = ref({
  src: '',
  alt: ''
}) 
</script>

<template>
  <div class="messageShare">
    <div class="title">
      <slot name="title"></slot>
    </div>
    <div class="introduce">
      <slot name="intro"></slot>
    </div>
    <div class="imgs">
      <slot name="image" v-bind="imageProps"></slot>
    </div>
    <div class="author">
      <slot name="author"></slot>
    </div>
    <div class="watch">
      <div class="iconfont icon-xiaoyanjing"></div>
      <div class="count">203</div>
    </div>
    <div class="agree">
      <div class="iconfont icon-damuzhi"></div>
      <div class="counts">56</div>
    </div>
    <tag><template #first>
        <slot name="tag"></slot>
      </template></tag>
  </div>
</template>
<style lang="scss" scoped>
.messageShare {
  width: 603px;
  height: 118px;
  position: relative;
  border-width: 0px 0px 1px 0px;
  border-style: solid;
  border-color: #bab7b7;

  .title {
    min-width: 193px;
    max-width: 450px;
    font-size: 12px;
    font-weight: 600;
    color: #3d3d3d;
    height: 20px;
    line-height: 20px;
    position: absolute;
    font-family: 'Alibaba-PuHuiTi-B';
    left: 0;
    top: 15px;
  }

  .introduce {
    width: 459px;
    height: 48px;
    position: absolute;
    left: 8px;
    top: 43px;
    font-size: 10px;
    color: #717171;
    font-family: 'Alibaba-PuHuiTi-B';
  }

  .imgs {
    width: 122px;
    height: 82px;
    position: absolute;
    right: 0;
    top: 15px;
  }

  .author {
    min-width: 30px;
    max-width: 60px;
    height: 16px;
    position: absolute;
    left: 0;
    bottom: 7px;
    font-size: 10px;
    color: #717171;
    line-height: 16px;
    font-family: 'Alibaba-PuHuiTi-B';
  }

  .watch {
    min-width: 26px;
    max-width: 46px;
    height: 16px;
    position: absolute;
    left: 46px;
    bottom: 7px;
    display: flex;

    .iconfont {
      height: 10px;
      width: 10px;
      font-size: 12px;
      padding-top: 2px;
    }

    .count {
      min-width: 26px;
      padding-left: 6px;
      max-width: 36px;
      line-height: 16px;
      font-size: 10px;
      color: #717171;
      font-family: 'Alibaba-PuHuiTi-B';
    }
  }

  .agree {
    min-width: 26px;
    max-width: 46px;
    height: 16px;
    position: absolute;
    left: 100px;
    bottom: 7px;
    display: flex;

    .iconfont {
      height: 10px;
      width: 10px;
      font-size: 12px;
      padding-top: 2px;
    }

    .counts {
      min-width: 26px;
      padding-left: 6px;
      max-width: 36px;
      line-height: 16px;
      font-size: 10px;
      color: #717171;
      font-family: 'Alibaba-PuHuiTi-B';
    }
  }
}

.messageShare:hover {
  transform: translate(0, -2%);
  transform-origin: center center;
  box-shadow: 0 0 10px 5px hsl(15, 3%, 90%);
  cursor: pointer;
}
</style>
