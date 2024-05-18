<script setup>
import '@/assets/font/font.css'
import menus from '@/views/commonalityElement/menu.vue'
import lovepublish from './layoutComponent/lovepublish.vue'
import lovepersonal from './layoutComponent/lovepersonal.vue'
import goodmessage from './layoutComponent/goodmessage.vue'
import menuselect from './layoutComponent/menuselect.vue'
import essays from './layoutComponent/essays.vue'
</script>

<template>
  <menus></menus>
  <div class="bodys">
    <menuselect></menuselect>
    <div class="message">
      <lovepublish></lovepublish>
      <essays></essays>
    </div>
    <lovepersonal></lovepersonal>
    <goodmessage></goodmessage>
  </div>
</template>
<style lang="scss" scoped>
.bodys {
  width: 100%;
  height: 100%;
  position: relative;

  .loveSelect {
    width: 200px;
    height: 415px;
    position: absolute;
    top: 24px;
    left: 119px;
    background-color: #ffffff;
  }

  .message {
    width: 647px;
    min-height: 600px;
    position: absolute;
    top: 24px;
    left: 346px;
  }
}
</style>
