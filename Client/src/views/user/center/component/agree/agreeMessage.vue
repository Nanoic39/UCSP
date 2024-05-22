<script setup>
import '@/assets/font/font.css'
import '@/assets/svg/helpeach/agree/iconfont.css'
import '@/assets/svg/helpeach/eyes/iconfont.css'
import tag from './shareMessageTag/tag.vue'
</script>

<template>
  <div class="messageShare">
    <div class="title">高等数学A2定积分部分学习经验分享</div>
    <div class="introduce">
      曾国藩，初名子城，字伯函，号涤生，谥文正，汉族，出生于湖南长沙府湘乡县杨树坪。晚清重臣，湘军乡派”创立人。晚清“中兴四大名臣”之一，官至两江总督、直隶总督、当事人
      勇侯，色生个娃谥曰...
    </div>
    <div class="imgs"></div>
    <div class="author">余子璇</div>
    <div class="watch">
      <div class="iconfont icon-xiaoyanjing"></div>
      <div class="count">203</div>
    </div>
    <div class="agree">
      <div class="iconfont icon-damuzhi"></div>
      <div class="counts">56</div>
    </div>
    <tag><template #first>高等数学</template></tag>
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
  margin-left: 100px;

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
    background-image: url('@/assets/studyhelp/屏幕截图 2024-05-04 125438.png');
    background-repeat: no-repeat;
    background-size: cover;
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
  box-shadow: 0 0 10px 5px hsl(25, 3%, 90%);
  cursor: pointer;
}
</style>
