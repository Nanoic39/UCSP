<script setup>
import '@/assets/font/font.css'
import { ref, onMounted } from 'vue'
import { fetchData } from '@/api/activeDay.js'
import { sign, readsign } from '@/api/signin';
function getFirstDayOfMonth(year, month) {
  // 创建一个新的 Date 对象，将年份和月份作为参数传入，日期设置为 1，表示该月的第一天
  const firstDayOfMonth = new Date(year, month - 1, 1) // 月份从 0 开始，所以要减去 1
  return firstDayOfMonth.getDay() // 返回该日期对应的星期几（0 表示星期日，1 表示星期一，以此类推）
}

const currentDate = new Date()

// 获取当前月份
const currentMonth = currentDate.getMonth() + 1 // 月份从0开始，所以要加1

const firstDayOfWeek = getFirstDayOfMonth(2024, currentMonth)
// console.log(firstDayOfWeek) // 输出每个月的第一天是星期几

// 获取指定年份和月份的总天数
function getDaysInMonth(year, month) {
  // 创建一个新的 Date 对象，将年份和月份作为参数传入，日期设置为 0，表示上一个月的最后一天
  const lastDayOfMonth = new Date(year, month, 0)
  return lastDayOfMonth.getDate() // 返回该月的总天数
}

// 获取 2024 年每个月的总天数，并输出结果
const daysInMonth = getDaysInMonth(2024, currentMonth)
// console.log(daysInMonth) // 输出每个月的总天数

const dayOfMonth = currentDate.getDate()
// console.log(dayOfMonth)

const calendars = ref(null)

const spanall = ref(null)


onMounted(() => {

  spanall.value = calendars['_rawValue']

  const clock = document.querySelector('.clock')

})
// 获取用户id
const userid = JSON.parse(localStorage.getItem('user-data')).uuid
console.log(userid)

const numbersString = ref(null)

const arrays = ref(null)

const handle = async () => {
  await sign(userid)
  clokins()
}



const newArray = [];
const continueday = ref(0)

const clokins = async () => {
  try {
    const res = await readsign({ id: userid })
    // console.log(res.data.data)

    numbersString.value = res.data.data.month_day;
    continueday.value = res.data.data.day

    const numbersArray = numbersString.value.split(",");

    const numbersAsNumbers = numbersArray.map(Number);

    for (let i = 0; i < numbersAsNumbers.length; i++) {
      numbersAsNumbers[i] = numbersAsNumbers[i] - 1
    }

    arrays.value = numbersAsNumbers

    const valuesArray = Object.values(arrays.value);

    valuesArray.forEach(value => {
      newArray.push(value);
    });
    console.log(newArray);
    for (let i = 0; i < newArray.length; i++) {
      spanall.value[newArray[i]].style.backgroundColor = 'skyblue'
    }
  } catch {
    console.log(1)
  }
}
clokins()

</script>

<template>
  <section class="calendars">
    <h1>2024 年 {{ currentMonth }} 月</h1>
    <div class="record">
      <div class="statistics">已经连续打卡<span>{{ continueday }}</span>天！</div>
      <el-button class="clock" @click="handle()">打卡</el-button>
    </div>
    <form action="#">
      <label class="weekday">日</label>
      <label class="weekday">一</label>
      <label class="weekday">二</label>
      <label class="weekday">三</label>
      <label class="weekday">四</label>
      <label class="weekday">五</label>
      <label class="weekday">六</label>
      <div class="days">
        <label class="day invalid" v-for="(item, index) in daysInMonth + firstDayOfWeek" :key="item" :data-day="index">
          <span ref="calendars" v-if="index >= firstDayOfWeek">{{
            index - firstDayOfWeek + 1
          }}</span>
        </label>
      </div>
    </form>
  </section>
</template>
<style lang="scss" scoped>
section.calendars {
  background: #ffffff;
  width: 261px;
  padding-bottom: 15px;
  border-radius: 5px;

  h1 {
    text-align: center;
    color: cadetblue;
    margin: 0 0 10px 0;
  }

  .record {
    width: 100%;
    height: 33px;
    position: relative;

    .statistics {
      min-width: 145px;
      height: 33px;
      position: absolute;
      left: 0;
      font-family: 'Alibaba-PuHuiTi-B';
      font-size: 16px;
      font-weight: 400;
      line-height: 33px;
      color: #3d3d3d;

      span {
        font-size: 24px;
        font-weight: 700;
        line-height: 33px;
        font-family: 'Alibaba-PuHuiTi-B';
        color: #3e84fe;
      }
    }

    .clock {
      width: 53px;
      height: 24px;
      position: absolute;
      top: 5px;
      right: 0;
      background-color: #3e84fe;
      color: #ffffff;
      font-size: 14px;
      font-weight: 500;
    }
  }

  form {
    position: relative;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-items: flex-start;
    align-content: flex-start;

    label.weekday {
      display: inline-block;
      width: 20px;
      margin: 8px;
      text-align: center;
      color: #999;
    }

    .days {
      width: 261px;
      height: 100%;
      padding-left: 5px;
    }

    form {
      margin: 0;
      padding: 0;
    }

    label.day span {
      display: inline-block;
      width: 20px;
      height: 20px;
      line-height: 20px;
      margin: -2px 0 0 -3px;
      border-radius: 50%;
      text-align: center;
      transition: all 0.2s linear;
      cursor: pointer;
    }

    label.day {
      display: inline-block;
      width: 20px;
      margin: 5px;

      span:hover {
        border-color: cadetblue;
      }
    }

    label.day.invalid {
      opacity: 1;
      width: 26px;
      height: 26px;
    }
  }
}
</style>
