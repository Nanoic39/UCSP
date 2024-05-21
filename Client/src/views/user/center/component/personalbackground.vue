<script setup>
import '@/assets/font/font.css'
import { ref } from 'vue'
const statics = ref([
    {
        id: 1, name: '关注', number: 19
    },
    {
        id: 2, name: '粉丝', number: 16
    },
    {
        id: 3, name: '好友', number: 18
    },
    {
        id: 4, name: '赞过', number: 17
    },
    {
        id: 5, name: '收藏', number: 3
    }
])
</script>

<template>
    <div class="personalbackground">
        <div class="headimg"></div>
        <div class="name">法助男娘</div>
        <div class="profession">计算机科学与技术</div>
        <div class="static">
            <div class="anys" v-for="item in statics" :key="item">
                <div class="title">{{ item.name }}</div>
                <div class="num">{{ item.number }}</div>
            </div>
        </div>
    </div>
</template>
<style lang="scss" scoped>
.personalbackground {
    width: 100%;
    height: 150px;
    background-color: aqua;
    position: relative;
    background-image: url('@/assets/center/20245181447.png');
    background-repeat: no-repeat;
    background-size: cover;

    .headimg {
        z-index: 10;
        width: 100px;
        height: 100px;
        border-radius: 50%;
        background-color: rgb(61, 77, 77);
        position: absolute;
        top: 67px;
        left: 36px;
        background-image: url('@/assets/layout/211540yrmp8w0prt8opzm0.jpg');
        background-repeat: no-repeat;
        background-size: cover;

    }

    .name {
        min-width: 54px;
        height: 25px;
        position: absolute;
        top: 84px;
        left: 148px;
        font-size: 18px;
        color: #FFFFFF;
        line-height: 25px;
        font-family: 'Alibaba-PuHuiTi-B';
    }

    .profession {
        min-width: 79px;
        height: 14px;
        position: absolute;
        bottom: 15px;
        left: 148px;
        font-size: 10px;
        color: #FFFFFF;
        line-height: 14px;
        font-family: 'Alibaba-PuHuiTi-B';
    }

    .static {
        width: 213px;
        height: 14px;
        position: absolute;
        bottom: 12px;
        right: 22px;
        display: flex;
        gap: 10px;

        .anys {
            min-width: 35px;
            height: 14px;
            display: flex;
            gap: 3px;

            .title {
                width: 20px;
                height: 14px;
                font-size: 10px;
                color: #FFFFFF;
                line-height: 14px;
                font-family: 'Alibaba-PuHuiTi-B';
            }

            .num {
                min-width: 12px;
                height: 14px;
                font-size: 10px;
                color: #FFFFFF;
                line-height: 14px;
                font-family: 'Alibaba-PuHuiTi-B';
            }
        }
    }
}
</style>
