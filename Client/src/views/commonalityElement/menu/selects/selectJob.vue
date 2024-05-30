<script setup>
import '@/assets/font/font.css'
import { ref } from 'vue'
const kindfirst = ref([
  {
    id: 1, name: '考公', url: ''
  },
  {
    id: 2, name: '考研', url: ''
  },
  {
    id: 3, name: '教资', url: ''
  },
  {
    id: 4, name: '计算机二级', url: ''
  }
])
</script>

<template>
  <div class="selectSubject">
    <el-carousel class="lunbo" height="auto" :autoplay="false" indicator-position="none">
      <el-carousel-item class="contain" style="height: 38px">
        <router-link to="/study" v-for="item in kindfirst" :key="item.id">
          {{ item.name }}
        </router-link>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>
<style lang="scss" scoped>
.selectSubject {
  width: 100%;
  height: 27px;

  :deep(.lunbo) {
    font-size: 16px;
    position: relative;

    .contain {
      a:hover {
        background-color: #3e84fe !important;
        color: #ffffff !important;
      }

      a {
        text-decoration: none;
        color: #3d3d3d;
        min-width: 45px;
        height: 26px;
        background-color: #f6f9ff;
        border-radius: 30px;
        font-size: 16px;
        font-weight: 500;
        font-family: 'Alibaba-PuHuiTi-B';
        color: #3d3d3d;
        text-align: center;
        line-height: 26px;
        padding-left: 15px;
        padding-right: 15px;
      }

      display: flex;
      gap: 30px;
      margin-left: 25px;
      margin-top: 2px;
    }

    .el-carousel__arrow--left {
      // width: 18px;
      // height: 18px;
      // position: absolute;
      // left: 5px;
      // background-color: #83f1f1;
      display: none;
    }

    .el-carousel__arrow--right {
      // width: 18px;
      // height: 18px;
      // position: absolute;
      // right: 5px;
      // background-color: #83f1f1;
      display: none;
    }
  }
}
</style>
