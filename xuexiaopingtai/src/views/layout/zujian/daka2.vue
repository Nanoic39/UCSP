<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="bgg">
    <div class="box">
      <div class="card" :style="{ transform: `rotateY(${cards}deg)` }">
        <div class="front">
          <el-col :span="20" :offset="2">
            <el-button class="btn1" @click="handle">立即打卡</el-button>
          </el-col>
        </div>
        <div class="back"></div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
const cards = ref(0)
const handle = () => {
  cards.value += 180
}
</script>

<style lang="scss" scoped>
.bgg {
  perspective: 500px;
  .box {
    width: 400px;
    height: 600px;
    margin: 100px auto;
    transform-style: preserve-3d;
    .card {
      position: relative;
      transform-style: preserve-3d;
      transition: all 0.5s;
      .front,
      .back {
        position: absolute;
        top: 0;
        left: 0;
        width: 400px;
        height: 600px;
        border-radius: 20px;
        background-size: cover;
        background-repeat: no-repeat;
      }
      .front {
        transform: translateZ(1px);
        background-image: url('@/assets/01d9f860b8568411013f472053f119.png@1280w_1l_2o_100sh.png');
        font-size: 20px;
        .btn1 {
          width: 100%;
          position: relative;
          height: 45px;
          border-radius: 30px;
          background-color: aqua;
          top: 550px;
        }
      }

      .back {
        transform: rotateY(180deg);
        background-image: url('@/assets/72572957dc9ff4557dac41e88c5fd143.jpg');
      }
    }
  }
}
img {
  vertical-align: middle;
}
</style>
