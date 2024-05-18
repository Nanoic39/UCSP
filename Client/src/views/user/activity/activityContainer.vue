<script setup>
import request from "@/utils/request"

const active_list = ref([])

request.get("/active/getAllActive")

</script>

<template>
  <div class="main">
    <div class="banner"></div>
    <div class="content">
      <div class="controller"></div>
      <div class="activesPanelBox">
        <div class="activeItemPanel">
          <div class="title"></div>
        </div>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.main {
  display: flex;
  flex-direction: column;

  .banner {
    width: 100%;
    height: 80px;
    background-color: red;
  }

  .content {
    width: 100%;
    min-height: 500px;

    //控制按钮面板
    .controller {
      width: 100%;
      height: 50px;
      background-color: green;
    }

    //主内容
    .activesPanelBox {
      width: 100%;
      min-height: 200px;

      display: grid;
      grid-template-columns: repeat();

      background-color: yellow;
    }
  }
}
</style>
