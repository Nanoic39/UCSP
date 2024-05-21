<script setup>
import '@/assets/font/font.css'
import '@/assets/svg/center/lock/iconfont.css'
</script>

<template>
    <div class="collection">
        <div class="mycollect">
            <div class="top">
                <div class="name">我的收藏</div>
                <div class="iconfont icon-jiesuo"></div>
                <div class="defaults">默认</div>
            </div>
            <div class="static">
                <div class="time">2024-5-8更新</div>
                <div class="message">0篇文章</div>
                <div class="count">0篇订阅</div>
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
