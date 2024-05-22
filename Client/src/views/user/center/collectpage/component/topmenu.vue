<script setup>
import menus from '@/views/commonalityElement/menu.vue'
import { ref, inject } from 'vue'
import '@/assets/svg/helpeach/share/iconfont.css'
import { usecountStore } from '@/stores/count'
const usecount = usecountStore()
import { useRouter } from 'vue-router'
const router = useRouter()
const more = ref({
    collect: '更多收藏集',
    share: '更多订阅集'
})
</script>

<template>
    <div class="topmenu">
        <div class="title">前端</div>
        <div class="headimg"></div>
        <div class="name">法助男娘</div>
        <div class="more">
            <div class="morecollect" @click="router.go(-1)" v-if="usecount.collect === 1">{{ more.share }}</div>
            <div class="morecollect" @click="router.go(-1)" v-else>{{ more.collect }}</div>
            <div class="iconfont">
                <el-icon>
                    <ArrowRight />
                </el-icon>
            </div>
        </div>
        <div class="share">
            <div class="iconfont icon-fenxiang"></div>
            <div class="shares">分享</div>
        </div>
    </div>
</template>
<style lang="scss" scoped>
.topmenu {
    width: 800px;
    height: 195px;
    background: linear-gradient(180deg, #A6C5F6 0%, rgba(216, 216, 216, 0) 100%);
    position: relative;

    .title {
        min-width: 48px;
        height: 33px;
        position: absolute;
        top: 29px;
        left: 110px;
        font-family: 'Alibaba-PuHuiTi-B';
        line-height: 33px;
        font-weight: 700;
        font-size: 24px;
        color: #3D3D3D;
    }

    .headimg {
        width: 35px;
        height: 35px;
        position: absolute;
        bottom: 58px;
        left: 110px;
        border-radius: 50%;
        background-image: url('@/assets/layout/211540yrmp8w0prt8opzm0.jpg');
        background-repeat: no-repeat;
        background-size: cover;
    }

    .name {
        min-width: 36px;
        height: 16px;
        font-size: 12px;
        color: #3D3D3D;
        line-height: 16px;
        font-family: 'Alibaba-PuHuiTi-B';
        position: absolute;
        top: 102px;
        left: 153px;
    }

    .more {
        min-width: 50px;
        height: 14px;
        position: absolute;
        left: 153px;
        top: 120px;
        display: flex;
        gap: 1px;
        cursor: pointer;

        .morecollect {
            min-width: 50px;
            height: 14px;
            color: #3D3D3D;
            font-size: 10px;
            line-height: 14px;
            font-family: 'Alibaba-PuHuiTi-B';
        }

        .iconfont {
            width: 14px;
            height: 14px;
            font-size: 12px;
            padding-top: 2px;
        }
    }

    .share {
        min-width: 34px;
        height: 14px;
        position: absolute;
        bottom: 61px;
        right: 93px;
        display: flex;
        gap: 2px;
        cursor: pointer;

        .iconfont {
            width: 14px;
            height: 14px;
            font-size: 13px;
            padding-top: -1px;
        }

        .shares {
            width: 20px;
            height: 14px;
            color: #3D3D3D;
            font-size: 10px;
            line-height: 14px;
            font-family: 'Alibaba-PuHuiTi-B';
        }
    }
}
</style>
