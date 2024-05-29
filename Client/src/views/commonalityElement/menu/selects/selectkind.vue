<script setup>
import '@/assets/font/font.css'
import { inject, ref } from 'vue';
const { isCarouselVisible } = inject('isCarouselVisibles')
const statics = ref([
    {
        id: 1, kindfirst: [
            {
                id: 1, name: '数学', url: ''
            },
            {
                id: 2, name: '英语', url: ''
            },
            {
                id: 3, name: '计算机', url: ''
            },
            {
                id: 4, name: '大学生竞赛', url: ''
            }
        ]
    },
    {
        id: 2, kindfirst: [
            {
                id: 1, name: '数学', url: ''
            },
            {
                id: 2, name: '英语', url: ''
            },
            {
                id: 3, name: '计算机', url: ''
            },
            {
                id: 4, name: '大学生竞赛', url: ''
            }
        ]
    },
])
</script>

<template>
    <div class="selectSubjects">
        <el-carousel v-if="isCarouselVisible" ref="carouselRef" class="lunbo" height="auto" :autoplay="false"
            indicator-position="none">
            <el-carousel-item class="contain" style="height: 38px" v-for="item in statics" :key="item.id">
                <router-link to="/study" v-for="items in item.kindfirst" :key="items.id">
                    {{ items.name }}
                </router-link>
            </el-carousel-item>
        </el-carousel>
    </div>
</template>
<style lang="scss" scoped>
.selectSubjects {
    width: 100%;
    height: 27px;

    :deep(.lunbo) {
        font-size: 16px;
        position: relative;

        .contain {
            a:hover {
                background-color: #3e84fe !important;
                color: #ffffff !important;
            }

            a {
                text-decoration: none;
                color: #3d3d3d;
                min-width: 45px;
                height: 26px;
                background-color: #f6f9ff;
                border-radius: 30px;
                font-size: 16px;
                font-weight: 500;
                font-family: 'Alibaba-PuHuiTi-B';
                color: #3d3d3d;
                text-align: center;
                line-height: 26px;
                padding-left: 15px;
                padding-right: 15px;
            }

            display: flex;
            gap: 30px;
            margin-left: 25px;
            margin-top: 2px;
        }

        .el-carousel__arrow--left {
            width: 18px;
            height: 18px;
            position: absolute;
            left: 5px;
            background-color: #83f1f1;
        }

        .el-carousel__arrow--right {
            width: 18px;
            height: 18px;
            position: absolute;
            right: 5px;
            background-color: #83f1f1;
        }
    }
}
</style>
