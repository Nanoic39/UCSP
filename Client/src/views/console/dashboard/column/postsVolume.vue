<script setup>
import {
    CaretTop,
    Warning,
} from '@element-plus/icons-vue'
import elementResizeDetectorMaker from 'element-resize-detector';
import * as echarts from 'echarts';
import { ref, onMounted } from "vue";
//实现根据后端返回数据实时更改echarts

//以下用来加载ehcharts
const line = ref();
function chart() {
    // 折线图
    var lineChart = echarts.init(line.value);
    var lineOption = (lineOption = {
        tooltip: {
            trigger: "axis",
        },
        legend: {
            textStyle: {
                color: "#4c9bfd", // 图例文字颜色
            },
            top: '-5',
            right: "10", // 距离右边10%
        },
        grid: {
            top: "10%",
            left: "0%",
            right: "5%",
            bottom: "10%",
            show: true, //显示边框
            borderColor: "#012f4a", // 边框颜色
            containLabel: true,
        },
        xAxis: {
            type: "category",
            boundaryGap: true, // 去除轴内间距
            axisTick: {
                show: true, // 去除刻度线
            },
            axisLabel: {
                color: "#4c9bfd", // 文本颜色
            },
            axisLine: {
                show: true, // 去除轴线
            },
            data: [
                "1月",
                "2月",
                "3月",
                "4月",
                "5月",
                "6月",
                "7月",
                "8月",
                "9月",
                "10月",
                "11月",
                "12月",
            ],
        },
        yAxis: {
            type: "value",
            axisTick: {
                show: true, // 去除刻度
            },
            axisLabel: {
                color: "#4c9bfd", // 文字颜色
            },
            splitLine: {
                lineStyle: {
                    color: "#012f4a", // 分割线颜色
                },
            },
        },
        color: ["#00f2f1", "#ed3f35"], //两条曲线改变颜色
        series: [
            {
                name: '日被访问量',
                type: "bar",
                showBackground: true,
                data: [80, 60, 44, 63, 90, 131, 162, 70, 120, 230, 210, 120],
                backgroundStyle: {
                    color: 'rgba(180, 180, 180, 0.2)'
                }
                
            },
        ],
    });
    lineChart.setOption(lineOption);
    //动态检测盒子的宽高并给eharts的宽高进行赋值 ehcarts中resize()函数的功能
    //感觉需要加个防抖函数，但是不确定是否会影响其功能
    const erd = elementResizeDetectorMaker();
    erd.listenTo(line.value, function (element) {
        lineChart.resize();
    });
}
onMounted(() => {
    chart();
});


</script>
<template>
    <div class="statistic-card">
        <div id="countInfo" style="display: flex;flex-direction: row;">
            <el-statistic :value="1672">
                <template #title>
                    <div style="display: inline-flex; align-items: center">
                        帖子数量
                        <el-tooltip effect="dark" content="论坛发帖数量" placement="top">
                            <el-icon style="margin-left: 4px" :size="12">
                                <Warning />
                            </el-icon>
                        </el-tooltip>
                    </div>
                </template>
            </el-statistic>
        </div>
        <div ref='line' class='line'></div>
        <el-divider />
        <div class="statistic-footer">
            <div class="footer-item">
                <span>同日比</span>
                <span class="green">
                    12%
                    <el-icon>
                        <CaretTop />
                    </el-icon>
                </span>
            </div>
            <div class="footer-item">
                <span>同周比</span>
                <span class="green">
                    30%
                    <el-icon>
                        <CaretTop />
                    </el-icon>
                </span>
            </div>
        </div>

    </div>
</template>
<style scoped>
:global(h2#card-usage ~ .example .example-showcase) {
    background-color: var(--el-fill-color) !important;
}

.el-statistic {
    --el-statistic-content-font-size: 28px;
}

.statistic-card {
    height: 80%;
    width: 16%;
    padding: 20px;
    border-radius: 4px;
    background-color: var(--el-bg-color-overlay);
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
}

.statistic-footer {
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    font-size: 12px;
    color: var(--el-text-color-regular);
    margin-top: 16px;
}

.statistic-footer .footer-item {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.statistic-footer .footer-item span:last-child {
    display: inline-flex;
    align-items: center;
    margin-left: 4px;
}

.green {
    color: var(--el-color-success);
}

.red {
    color: var(--el-color-error);
}

.line {
    width: 170px;
    height: 110px;
}

.el-divider--horizontal {
    margin: 0;
}
</style>
