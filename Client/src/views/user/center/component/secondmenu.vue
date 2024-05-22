<script setup>
import '@/assets/font/font.css'
import { ref, inject } from 'vue'
// const { state } = inject('states')
import { usecountStore } from '@/stores/count'
const usecount = usecountStore()
const statics = ref([
    {
        id: 1, name: '动态'
    },
    {
        id: 2, name: '文章'
    },
    {
        id: 3, name: '问题'
    },
    {
        id: 4, name: '收藏集'
    },
    {
        id: 5, name: '赞'
    },
    {
        id: 6, name: '关注'
    },
    {
        id: 7, name: '好友'
    }
])
const activeIndex = ref(usecount.index)

const changestate = (index) => {
    usecount.setindex(index)
    activeIndex.value = usecount.index
    usecount.removecollect()
}
</script>

<template>
    <div class="secondmenu">
        <div class="content">
            <div class="static" v-for="(item, index) in statics" :key="index" :class="{ Color: index === activeIndex }"
                @click="changestate(index)">{{ item.name }}</div>
        </div>
    </div>
</template>
<style lang="scss" scoped>
.secondmenu {
    width: 800px;
    height: 36px;
    position: relative;
    border-bottom: 1px solid #b5b3b3;

    .content {
        min-width: 434px;
        height: 100%;
        position: absolute;
        left: 148px;
        display: flex;
        gap: 49px;

        .static {
            padding-top: 11px;
            min-width: 20px;
            height: 25px;
            font-size: 10px;
            color: #3D3D3D;
            line-height: 14px;
            font-family: 'Alibaba-PuHuiTi-B';
            cursor: pointer;
        }
    }
}

.Color {
    border-bottom: 2px solid #3E84FE !important;
}
</style>
