<script setup>
import '@/assets/font/font.css'
</script>

<template>
    <div class="show">
        <img src="@/assets/activity/202452119343.png" alt="">
        <div class="title">
            <div class="top">WELCOME TO</div>
            <div class="foot">SCHOOL ACTIVITIES!</div>
        </div>
    </div>
</template>

<style lang="scss" scoped>
.show {
    width: 100%;
    height: 570px;
    position: relative;

    .title {
        min-width: 692px;
        height: 200px;
        display: flex;
        flex-wrap: wrap;
        gap: 50px;
        position: absolute;
        top: 169px;
        left: 52px;

        .top,
        .foot {
            min-width: 100%;
            height: 75px;
            font-weight: 500;
            font-size: 72px;
            line-height: 75px;
            font-family: 'Alibaba-PuHuiTi-B';
            color: #FFFFFF;
        }
    }
}

.show::before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 570px;
    background: linear-gradient(90deg, rgba(32, 85, 168, 0.8) 2%, rgba(97, 146, 223, 0.5753) 70%, rgba(108, 164, 253, 0.3553) 100%, rgba(166, 197, 246, 0) 100%);
}

.show img {
    display: block;
    width: 100%;
    height: 570px;
}
</style>
