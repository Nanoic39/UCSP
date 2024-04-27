<template>
  <div class="main">
    <div class="panel">
        <div class="title">后台管理系统</div>
        <el-form ref="formData"></el-form>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue';

const formData = ref();

console.log(formData)
</script>

<style lang="scss" scoped>
.main {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-image: var(--image-console-login-background);
  background-size: cover;
  transition: all .3s ease;

  .panel{
    width: 1000px;
    height: 500px;
    backdrop-filter: blur(2px);
    background-color: rgba(255, 255, 255, 0.8);
    border-radius: 12px;

    .title {
        text-align: center;
        margin: 20px;
        font-size: 32px;
        /* font-family: ''; */
    }
  }


}
</style>
