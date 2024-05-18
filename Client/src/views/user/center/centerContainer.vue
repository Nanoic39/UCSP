<script setup>
import menus from '@/views/commonalityElement/menu.vue'
</script>

<template>
  <menus></menus>
  <div class="personal">
    <div class="personalbackground">
      <div class="headimg"></div>
      <div class="name"></div>
      <div class="profession"></div>
      <div class="static">
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.personal {
  width: 800px;
  height: 1600px;
  background-color: antiquewhite;
  margin: auto;

  .personalbackground {
    width: 100%;
    height: 150px;
    background-color: aqua;
    position: relative;

    .headimg {
      width: 100px;
      height: 100px;
      border-radius: 50%;
      background-color: rgb(61, 77, 77);
    }
  }
}
</style>
