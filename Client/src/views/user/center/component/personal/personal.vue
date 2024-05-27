<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-22 11:44:49
 * @LastEditTime: 2024-05-26 23:26:42
 * @FilePath: \Client\src\views\user\center\component\personal\personal.vue
 * @Describe: 
-->
<script setup>
import '@/assets/font/font.css'
import { ref, onMounted } from 'vue'

const person = ref([
    { id: 0, name: '萧榕润1', },
    { id: 1, name: '萧榕润2', },
    { id: 2, name: '萧榕润3', },
    { id: 3, name: '萧榕润4', },
    { id: 4, name: '萧榕润5', },
    { id: 5, name: '萧榕润6', },
    { id: 6, name: '萧榕润7', },
    { id: 7, name: '萧榕润8', },
    { id: 8, name: '萧榕润9', },
    { id: 9, name: '萧榕润10', },
    { id: 10, name: '萧榕润11', },
    { id: 11, name: '萧榕润12', }
])

//TODO
onMounted(() => {
    
})
</script>

<template>
    <div class="personallist" v-for="(item, index) in person" :key="item.id">
        <div class="headimg"></div>
        <div class="name">{{ item.name }}</div>
        <div class="othercollect">私信</div>
    </div>
</template>
<style lang="scss" scoped>
.personallist {
    width: 603px;
    height: 68px;
    margin: auto;
    position: relative;
    cursor: pointer;

    .headimg {
        width: 40px;
        height: 40px;
        border-radius: 50%;
        position: absolute;
        top: 14px;
        left: 0;
        background-image: url('@/assets/center/20245181447.png');
        background-repeat: no-repeat;
        background-size: cover;
    }

    .name {
        min-width: 44px;
        height: 17px;
        position: absolute;
        top: 26px;
        left: 58px;
        color: #3D3D3D;
        font-size: 14px;
        font-weight: 500;
        line-height: 17px;
        font-family: 'Alibaba-PuHuiTi-B';
    }

    .othercollect {
        width: 70px;
        height: 30px;
        background-color: #F6F9FF;
        color: #3E84FE;
        border: 1px solid #3E84FE;
        position: absolute;
        top: 19px;
        right: 0;
        text-align: center;
        line-height: 30px;
        font-size: 14px;
        font-family: 'Alibaba-PuHuiTi-B';
    }
}
</style>
