<script lang="ts" setup>
import '@/assets/font/font.css'
import type { ImageProps } from 'element-plus'
import { ref, onMounted } from 'vue'
import '@/assets/svg/helpeach/share/iconfont.css'
import '@/assets/svg/helpeach/review/iconfont.css'
import '@/assets/svg/helpeach/agree/iconfont.css'
import '@/assets/svg/helpeach/collect/iconfont.css'

const ask = ref([
    {
        id: 1,
        url: 'iconfont icon-fenxiang',
        names: '分享'
    },
    {
        id: 2,
        url: 'iconfont icon-pinglun',
        names: '评论'
    },
    {
        id: 3,
        url: 'iconfont icon-damuzhi',
        names: '点赞'
    },
    {
        id: 4,
        url: 'iconfont icon-shoucang',
        names: '收藏'
    }
])

const getClass = (items: string) => {
    return items
}

const fits = ['contain'] as ImageProps['fit'][]
const url = 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'

const statics = ref([{
    id: 1, head: 'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg', names: '费振宇', profession: '计算机科学与技术', time: '18小时前', content: '表白今天在二食堂看到的一位小姐姐呀，尊嘟好好看，捞捞~', imgs: [{
        id: 1, url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    }, {
        id: 1, url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    }, {
        id: 1, url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    }, {
        id: 1, url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    }, {
        id: 1, url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    }, {
        id: 1, url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    }]
},
{
    id: 1, head: 'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg', names: '费振宇', profession: '计算机科学与技术', time: '18小时前', content: '表白今天在二食堂看到的一位小姐姐呀，尊嘟好好看，捞捞~', imgs: [{
        id: 1, url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    }, {
        id: 1, url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    }, {
        id: 1, url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    }]
},
{
    id: 1, head: 'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg', names: '费振宇', profession: '计算机科学与技术', time: '18小时前', content: '表白今天在二食堂看到的一位小姐姐呀，尊嘟好好看，捞捞~', imgs: null
}
    ,
{
    id: 1, head: 'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg', names: '费振宇', profession: '计算机科学与技术', time: '18小时前', content: '表白今天在二食堂看到的一位小姐姐呀，尊嘟好好看，捞捞~,表白今天在二食堂看到的一位小姐姐呀，尊嘟好好看，捞捞~,表白今天在二食堂看到的一位小姐姐呀，尊嘟好好看，捞捞~,表白今天在二食堂看到的一位小姐姐呀，尊嘟好好看，捞捞~，表白今天在二食堂看到的一位小姐姐呀，尊嘟好好看，捞捞~', imgs: null
}
])

const srcList = [
    'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
    'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
    'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
    'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
    'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
    'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg'
]

const iconfonts = ref(null)
const iconState = ref(null)

onMounted(() => {
    iconState.value = iconfonts['_rawValue']
    const iconfont = document.querySelectorAll('.specific .iconfont')

    iconfont.forEach((element, index) => {
        element.addEventListener('click', () => changeState(index))
    })
})

const changeState = (index: number) => {
    if (index == 0 || index % 4 === 0) {
        if (iconState.value[index].style.color != 'skyblue') {
            iconState.value[index].style.color = 'skyblue'
        } else {
            iconState.value[index].style.color = 'black'
        }
    } else if (index == 1 || index % 4 === 1) {
        if (iconState.value[index].style.color != 'pink') {
            iconState.value[index].style.color = 'pink'
        } else {
            iconState.value[index].style.color = 'black'
        }
    } else if (index == 2 || index % 4 === 2) {
        if (iconState.value[index].style.color != 'red') {
            iconState.value[index].style.color = 'red'
        } else {
            iconState.value[index].style.color = 'black'
        }
    } else if (index == 3 || index % 4 === 3) {
        if (iconState.value[index].style.color != 'orange') {
            iconState.value[index].style.color = 'orange'
        } else {
            iconState.value[index].style.color = 'black'
        }
    }
}

</script>

<template>
    <div class="essays">
        <div class="container" v-for="(item, index) in statics" :key="index">
            <div class="top">
                <div class="head">
                    <img :src="item.head" alt="">
                </div>
                <div class="right">
                    <div class="name">{{ item.names }}</div>
                    <div class="tags">
                        <div class="profession">{{ item.profession }}</div>
                        <div class="time">{{ item.time }}</div>
                    </div>
                    <div class="content">{{ item.content }}</div>
                    <div class="imgs" v-if="item.imgs != null">
                        <div class="demo-image">
                            <div v-for="item in statics[index].imgs" class="block">
                                <el-image fit="cover" :preview-src-list="srcList" style="width: 150px; height: 150px"
                                    :src="item.url" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="static">
                <div class="specific" v-for="item in ask" :key="item.id">
                    <div ref="iconfonts" class="iconfont" :class="getClass(item.url)"></div>
                    <div class="text">{{ item.names }}</div>
                </div>
            </div>
        </div>
    </div>
</template>
<style lang="scss" scoped>
.demo-image .block {
    padding: 5px 0;
    text-align: center;
    border-right: solid 1px var(--el-border-color);
    display: inline-block;
    width: 30%;
    box-sizing: border-box;
    vertical-align: top;
}

.demo-image .block:last-child {
    border-right: none;
}

.demo-image .demonstration {
    display: block;
    color: var(--el-text-color-secondary);
    font-size: 14px;
    margin-bottom: 20px;
}

.essays {
    width: 800px;
    min-height: 325px;
    display: flex;
    flex-wrap: wrap;
    gap: 14px;


    .container {
        width: 100%;
        min-height: 146px;
        padding-top: 20px;
        background-color: #ffffff;

        .top {
            width: 630px;
            min-height: 100px;
            display: flex;
            gap: 19px;
            margin-left: 73px;

            .head {
                width: 50px;
                height: 50px;
                border-radius: 50%;

                img {
                    width: 50px;
                    height: 50px;
                    border-radius: 50%;
                }
            }

            .right {
                width: 454px;
                min-height: 100px;

                .name {
                    min-width: 42px;
                    max-width: 90px;
                    height: 19px;
                    margin-top: 6px;
                    font-size: 14px;
                    color: #3d3d3d;
                    line-height: 19px;
                    font-family: 'Alibaba-PuHuiTi-B';
                }

                .tags {
                    min-width: 152px;
                    max-width: 200px;
                    height: 16px;
                    margin-top: 8px;
                    display: flex;
                    gap: 7px;

                    .profession {
                        min-width: 95px;
                        max-width: 143px;
                        height: 16px;
                        font-size: 12px;
                        color: #717171;
                        line-height: 16px;
                        font-family: 'Alibaba-PuHuiTi-B';
                    }

                    .time {
                        width: 52px;
                        height: 16px;
                        font-size: 12px;
                        color: #717171;
                        line-height: 16px;
                        font-family: 'Alibaba-PuHuiTi-B';
                    }
                }

                .content {
                    width: 454px;
                    min-height: 30px;
                    margin-top: 8px;
                    font-size: 12px;
                    color: #3d3d3d;
                    line-height: 16px;
                    font-family: 'Alibaba-PuHuiTi-B';
                }

                .imgs {
                    width: 100%;
                    min-height: 140px;
                    // background-color: antiquewhite;
                }
            }
        }

        .static {
            width: 500px;
            height: 27px;
            padding-left: 140px;
            padding-right: 61px;
            padding-top: 12px;
            border-top: 1px solid #efefef;
            display: flex;
            gap: 110px;

            .specific {
                width: 45px;
                height: 16px;
                display: flex;
                gap: 4px;

                .iconfont {
                    width: 16px;
                    height: 16px;
                }

                .icon-pinglun {
                    margin-top: 1px;
                    font-weight: 600;
                }

                .icon-fenxiang {
                    margin-top: -2px;
                }

                .text {
                    width: 24px;
                    height: 16px;
                    font-size: 12px;
                    color: #3d3d3d;
                    line-height: 16px;
                    font-family: 'Alibaba-PuHuiTi-B';
                }
            }
        }
    }
}
</style>
