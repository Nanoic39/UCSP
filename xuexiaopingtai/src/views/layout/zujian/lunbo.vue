<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <el-row>
    <el-col :span="24">
      <leftmenu></leftmenu>
      <div class="lunbo">
        <el-carousel :interval="5000" arrow="hover" motion-blur width="100%" height="630px">
          <el-carousel-item v-for="item in imgs" :key="item.id">
            <img :src="item.imgUrl" />
          </el-carousel-item>
        </el-carousel>
      </div>
    </el-col>
  </el-row>
</template>

<script setup>
import leftmenu from './leftmenu.vue'
const imgs = [
  {
    id: 1,
    imgUrl: new URL('@/assets/images/fuji-mountain.jpg', import.meta.url).href
  },
  {
    id: 2,
    imgUrl: new URL('@/assets/images/great-wall.jpg', import.meta.url).href
  },
  {
    id: 3,
    imgUrl: new URL('@/assets/images/marina-bay.jpg', import.meta.url).href
  },
  {
    id: 4,
    imgUrl: new URL('@/assets/images/taj-mahal.jpg', import.meta.url).href
  }
]
</script>

<style lang="scss" scoped>
.lunbo {
  position: relative;
  img {
    width: 100%;
    height: 630px;
  }
}
:deep(.lunbo) {
  .el-carousel__indicator--horizontal {
    .el-carousel__button {
      width: 10px;
      height: 10px;
      border-radius: 50%;
      background-color: #fff;
      opacity: 1;
    }
  }
  .el-carousel__indicator--horizontal.is-active {
    button {
      width: 10px;
      height: 10px;
      border-radius: 50%;
      background-color: #fff;
      opacity: 0.5;
    }
  }
  .el-carousel__arrow--left {
    position: absolute;
    left: 20%;
    font-size: 45px;
    // color: black;
  }
  .el-carousel__arrow--right {
    font-size: 45px;
    // color: black;
  }
}
</style>
