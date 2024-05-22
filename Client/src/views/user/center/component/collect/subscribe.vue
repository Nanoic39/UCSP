<script setup>
import '@/assets/font/font.css'
import { ref, inject } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { useRouter } from 'vue-router'
const router = useRouter()
const open = (index) => {
    ElMessageBox.confirm('你确定取消订阅吗?', '注意', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        draggable: true
    })
        .then(() => {
            subscribes.value.splice(index, 1);
            ElMessage({
                type: 'success',
                message: '取消订阅成功'
            })
        })
        .catch(() => {
            ElMessage({
                type: 'info',
                message: '取消成功'
            })
        })
}

const subscribes = ref([
    { id: 0, title: '技术文章1', author: '法助', mescount: 1, subcount: 1 },
    { id: 1, title: '技术文章2', author: '法助', mescount: 1, subcount: 1 },
    { id: 2, title: '技术文章3', author: '法助', mescount: 1, subcount: 1 },
    { id: 3, title: '技术文章4', author: '法助', mescount: 1, subcount: 1 },
    { id: 4, title: '技术文章5', author: '法助', mescount: 1, subcount: 1 },
])
</script>

<template>
    <div class="collection" @click="router.push('./personalcenter/collect')" v-for="(item, index) in subscribes"
        :key="index">
        <div class="mycollect">
            <div class="top">
                <div class="name">{{ item.title }}</div>
            </div>
            <div class="static">
                <div class="other">
                    <div class="headimg"></div>
                    <div class="name">{{ item.author }}</div>
                </div>
                <div class="message">{{ item.mescount }}篇文章</div>
                <div class="count">{{ item.subcount }}篇订阅</div>
            </div>
        </div>
        <div class="othercollect" @click="open(index)">已订阅</div>
    </div>
</template>
<style lang="scss" scoped>
.collection:hover {
    background-color: aliceblue;
    cursor: pointer;
}

.collection {
    width: 603px;
    height: auto;
    margin: auto;
    position: relative;

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
        }

        .static {
            min-width: 156px;
            height: 14px;
            position: absolute;
            bottom: 2px;
            left: 11px;
            display: flex;
            gap: 10px;

            .other {
                min-width: 50px;
                height: 15px;
                display: flex;
                gap: 5px;

                .headimg {
                    width: 14px;
                    height: 14px;
                    border-radius: 50%;
                    background-image: url('@/assets/studyhelp/屏幕截图 2024-05-04 125438.png');
                    background-repeat: no-repeat;
                    background-size: cover;
                }

                .name {
                    min-width: 30px;
                    height: 14px;
                    color: #717171;
                    font-size: 10px;
                    line-height: 14px;
                    font-family: 'Alibaba-PuHuiTi-B';
                }
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

    .othercollect {
        width: 70px;
        height: 30px;
        background-color: #F6F9FF;
        color: #3E84FE;
        border: 1px solid #3E84FE;
        position: absolute;
        top: 21px;
        right: 0;
        text-align: center;
        line-height: 30px;
        font-size: 14px;
        font-family: 'Alibaba-PuHuiTi-B';
    }
}
</style>
