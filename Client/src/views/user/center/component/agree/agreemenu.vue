<script setup>
import '@/assets/font/font.css'
import { ref, inject } from 'vue'

const menucontent = ref([
    { id: 0, title: '动态1', },
    { id: 1, title: '文章2', },
    { id: 2, title: '问题3', },
])

const activeIndexes = ref(0)

const selectagree = (index) => {
    activeIndexes.value = index
    agrees.value = index
}

const { agrees } = inject('agree')
</script>

<template>
    <div class="selection">
        <div class="agreemenu">
            <div v-for="(item, index) in menucontent" :key="item.id" @click="selectagree(index)"
                :class="{ blueBackground: index == activeIndexes }">{{ item.title }}</div>
        </div>
    </div>
</template>
<style lang="scss" scoped>
.selection {
    width: 647px;
    height: 27px;
    margin: auto;
    position: relative;

    .agreemenu {
        min-width: 212px;
        height: 27px;
        position: absolute;
        left: 0;
        display: flex;
        gap: 10px;

        div {
            min-width: 64px;
            height: 27px;
            border-radius: 100px;
            background-color: #EFEFEF;
            color: #818181;
            font-size: 14px;
            line-height: 27px;
            font-family: 'Alibaba-PuHuiTi-B';
            text-align: center;
        }

        div:hover {
            background-color: #F2F7FF;
            color: #3E84FE;
            cursor: pointer;
        }

        .blueBackground {
            background-color: #F2F7FF;
            color: #3E84FE;
        }
    }
}
</style>
