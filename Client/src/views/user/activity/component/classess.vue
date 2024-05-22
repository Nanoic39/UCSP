<script setup>
import '@/assets/font/font.css'
import tagstwo from './tagstwo.vue'
</script>

<template>
    <div class="classes">
        <div class="imgs">
            <tagstwo>
                <slot name="first">编程</slot>
            </tagstwo>
        </div>
        <div class="names">
            python数据分析与展示
        </div>
        <div class="starttime">报名时间：2024.4.1-2024.4.15</div>
        <div class="overtime">活动时间：2024.5.1-2024.5.3</div>
        <div class="more">
            <div class="morecollect">查看详情</div>
            <div class="iconfont">
                <el-icon>
                    <ArrowRight />
                </el-icon>
            </div>
        </div>
    </div>
</template>
<style lang="scss" scoped>
.classes {
    width: 390px;
    height: 420px;
    border-radius: 10px;
    border: 2px solid #efefef;
    box-shadow: 0px 1px 0px 0px #e6e6e6;
    position: relative;
    font-family: 'ADLaMDisplay-Regular';

    .imgs {
        width: 390px;
        height: 252px;
        background-image: url('/src/assets/layout/屏幕截图 2024-04-25 190303.png');
        background-repeat: no-repeat;
        background-size: cover;
        border-radius: 10px 10px 0px 0px;
    }

    .names {
        width: 350px;
        height: 27px;
        position: absolute;
        left: 19px;
        bottom: 119px;
        font-weight: 700;
        font-size: 20px;
        color: #3d3d3d;
        line-height: 27px;
    }

    .starttime {
        min-width: 240px;
        height: 25px;
        position: absolute;
        bottom: 84px;
        left: 19px;
        font-size: 18px;
        color: #CBCBCB;
        line-height: 25px;
    }

    .overtime {
        min-width: 240px;
        height: 25px;
        position: absolute;
        bottom: 52px;
        left: 19px;
        font-size: 18px;
        color: #CBCBCB;
        line-height: 25px;
    }

    .more {
        min-width: 81px;
        height: 22px;
        position: absolute;
        bottom: 20px;
        left: 19px;
        display: flex;
        gap: 2px;
        cursor: pointer;

        .morecollect {
            min-width: 63px;
            height: 22px;
            color: #818181;
            font-size: 16px;
            line-height: 22px;
            font-family: 'Alibaba-PuHuiTi-B';
        }

        .iconfont {
            width: 22px;
            height: 22px;
            font-size: 16px;
            padding-top: 4px;
            color: #818181;
        }
    }

}
</style>
