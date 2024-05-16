<script setup>
import menus from '@/views/commonalityElement/menu.vue'
import '@/assets/font/font.css'
import messageContent from './shareComponent/messageContent.vue'
import personal from './shareComponent/personal.vue'
import recommend from './shareComponent/recommend.vue'
import review from './shareComponent/review.vue'
</script>

<template>
  <menus></menus>
  <div class="main">
    <messageContent></messageContent>
    <review></review>
  </div>
  <personal></personal>
  <recommend></recommend>
</template>
<style lang="scss" scoped>
.main {
  width: 749px;
  display: flex;
  flex-wrap: wrap;
  gap: 21px;
  position: absolute;
  top: 100px;
  left: 240px;
}
</style>
