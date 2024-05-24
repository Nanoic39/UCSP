<script setup>
import menus from '@/views/commonalityElement/menu.vue'
import '@/assets/font/font.css'
import search from './search.vue'
import { ref } from 'vue'

const states = ref([
    { id: 1, name: '全部' },
    { id: 2, name: '进行中' },
    { id: 3, name: '已结束' },
    { id: 4, name: '报名中' }
])

const activeIndex = ref(0)
const changestate = (index) => {
    activeIndex.value = index
}

const options = ref([
    {
        value: '1',
        label: '全部'
    },
    {
        value: '2',
        label: '前端'
    },
    {
        value: '3',
        label: 'javaScript'
    },
    {
        value: '4',
        label: 'Vue.js'
    },
    {
        value: '5',
        label: 'React.js'
    },
    {
        value: '6',
        label: '面试'
    },

    {
        value: '7',
        label: 'css'
    },
    {
        value: '8',
        label: 'java'
    },
    {
        value: '9',
        label: 'python'
    }
])

const value = ref([])
const limit = ref(1)
</script>

<template>
    <div class="screen">
        <div class="state">
            <div v-for="(item, index) in states" :key="index" :class="{ Color: index === activeIndex }"
                @click="changestate(index)">{{ item.name }}</div>
        </div>
        <div class="sort">
            <search></search>
            <div class="screens">
                <el-select-v2 v-model="value" filterable :options="options" placeholder="全部"
                    style="width: 100%; height: 25px" :multiple-limit=limit />
            </div>
            <div class="screena">
                <el-select-v2 v-model="value" filterable :options="options" placeholder="全部"
                    style="width: 100%; height: 25px" :multiple-limit=limit />
            </div>
        </div>
    </div>
</template>

<style lang="scss" scoped>
.screen {
    width: 100%;
    height: 37px;
    padding-top: 37px;
    padding-bottom: 63px;
    background-color: #FFFFFF;

    .state {
        margin-left: 50px;
        width: 373px;
        height: 37px;
        display: flex;
        gap: 20px;
        float: left;

        div {
            width: 111px;
            height: 37px;
            border-radius: 100px;
            background-color: #EFEFEF;
            color: #818181;
            font-size: 18px;
            line-height: 37px;
            font-family: 'Alibaba-PuHuiTi-B';
            text-align: center;
            cursor: pointer;
        }
    }

    .sort {
        margin-right: 50px;
        width: 585px;
        height: 37px;
        float: right;
        position: relative;

        .screens {
            top: 3px;
            width: 162px;
            height: 37px;
            position: absolute;
            left: 240px;
        }

        .screena {
            top: 3px;
            width: 162px;
            height: 37px;
            position: absolute;
            right: 0;
        }
    }
}

.Color {
    background-color: #F6F9FF !important;
    color: #3E84FE !important;
}
</style>
