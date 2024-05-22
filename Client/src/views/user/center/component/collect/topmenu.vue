<script setup>
import '@/assets/font/font.css'
import { ref, inject } from 'vue'
const { station } = inject('stations')
import { usecountStore } from '@/stores/count'
const usecount = usecountStore()

const selectcreate = () => {
    station.value = 0
    usecount.setcollect(0)
}

const selectsubscribe = () => {
    station.value = 1
    usecount.setcollect(1)
}
</script>

<template>
    <div class="topmenu">
        <el-button class="create" @click="selectcreate()" :class="{ blueBackground: usecount.collect == 0 }">我创建的
            2</el-button>
        <el-button class="subscribe" @click="selectsubscribe()" :class="{ blueBackground: usecount.collect == 1 }">我订阅的
            2</el-button>
        <div class="newcreate">+新建收藏夹</div>
    </div>
</template>
<style lang="scss" scoped>
.blueBackground {
    color: #3E84FE;
    background-color: #F2F7FF;
}

.topmenu {
    width: 603px;
    height: 59px;
    margin: auto;
    position: relative;

    .create {
        min-width: 95px;
        height: 26px;
        background-color: #F2F7FF;
        border-radius: 100px;
        position: absolute;
        top: 25px;
        left: 0;
    }

    .subscribe {
        min-width: 95px;
        height: 26px;
        background-color: #F2F7FF;
        border-radius: 100px;
        position: absolute;
        top: 25px;
        left: 115px;
    }

    .newcreate {
        min-width: 77px;
        height: 19px;
        position: absolute;
        right: 0;
        top: 25px;
        font-size: 14px;
        color: #3E84FE;
        cursor: pointer;
    }
}
</style>
