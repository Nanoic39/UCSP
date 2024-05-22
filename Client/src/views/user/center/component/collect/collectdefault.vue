<script setup>
import '@/assets/font/font.css'
import '@/assets/svg/center/lock/iconfont.css'
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
const collects = ref([
    { id: 1, name: '我的收藏', time: '2024-5-8', message: 0, count: 0 },
    { id: 2, name: '前端进阶', time: '2024-5-8', message: 0, count: 0 },
    { id: 3, name: '前端进阶', time: '2024-5-8', message: 0, count: 0 },
    { id: 4, name: '前端进阶', time: '2024-5-8', message: 0, count: 0 },
    { id: 5, name: '前端进阶', time: '2024-5-8', message: 0, count: 0 }
])
</script>

<template>
    <div class="collection" @click="router.push('./personalcenter/collect')" v-for="(item, index) in collects"
        :key="item.id">
        <div class="mycollect">
            <div class="top">
                <div class="name">{{ item.name }}</div>
                <div class="iconfont icon-jiesuo" v-if="index == 0"></div>
                <div class="defaults" v-if="index == 0">默认</div>
            </div>
            <div class="static">
                <div class="time">{{ item.time }}更新</div>
                <div class="message">{{ item.message }}篇文章</div>
                <div class="count">{{ item.count }}篇订阅</div>
            </div>
        </div>
        <div class="othercollect"></div>
    </div>
</template>
<style lang="scss" scoped>
.collection {
    width: 603px;
    height: auto;
    margin: auto;

    .mycollect:hover {
        background-color: aliceblue;
        cursor: pointer;
    }

    .mycollect {
        width: 100%;
        height: 68px;
        position: relative;
        border-bottom: 1px solid #9c9898;

        .top {
            min-width: 105px;
            height: 16px;
            position: absolute;
            top: 21px;
            left: 11px;
            display: flex;

            .name {
                padding-top: 2px;
                min-width: 51px;
                height: 14px;
                font-weight: 500;
                font-size: 12px;
                color: #3D3D3D;
                line-height: 14px;
                font-family: 'Alibaba-PuHuiTi-B';
            }

            .iconfont {
                width: 12px;
                height: 12px;
            }

            .defaults {
                width: 33px;
                height: 16px;
                margin-left: 9px;
                border: 1px solid #3E84FE;
                background-color: #FFFFFF;
                font-size: 10px;
                color: #3E84FE;
                line-height: 16px;
                font-family: 'Alibaba-PuHuiTi-B';
                text-align: center;
            }
        }

        .static {
            min-width: 156px;
            height: 14px;
            position: absolute;
            bottom: 2px;
            left: 11px;
            display: flex;
            gap: 10px;

            .time {
                min-width: 63px;
                height: 14px;
                font-size: 10px;
                color: #717171;
                line-height: 14px;
                font-family: 'Alibaba-PuHuiTi-B';
            }

            .message {
                min-width: 36px;
                height: 14px;
                font-size: 10px;
                color: #717171;
                line-height: 14px;
                font-family: 'Alibaba-PuHuiTi-B';
            }

            .count {
                min-width: 36px;
                height: 14px;
                font-size: 10px;
                color: #717171;
                line-height: 14px;
                font-family: 'Alibaba-PuHuiTi-B';
            }
        }
    }
}
</style>
