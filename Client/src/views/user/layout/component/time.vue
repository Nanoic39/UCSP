<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-26 17:34:53
 * @LastEditTime: 2024-04-26 21:38:31
 * @FilePath: \Client\src\views\user\layout\component\time.vue
 * @Describe: 
-->
<script setup>
import timer from './time/time.vue'
import { fetchData } from '@/api/activeDay.js'
import { ref } from 'vue'

const queryName = '暑假'; // 替换成你的查询名称
const accurateday = ref(null)
const blurday = ref(null)
const accuratecount = ref({
  day: '88',
  hour: '88',
  minute: '88',
  second: '88'
})

const blurcount = ref({
  day: '88',
  hour: '88',
  minute: '88',
  second: '88'
})

const holiday = ref(null)

const activeDay = async () => {



  const blur = await fetchData({ type: 'blur', name: '' })

  holiday.value = blur.data.data.name
  const accurate = await fetchData({ type: 'accurate', name: queryName })
  // console.log(res.data.data.date)

  accurateday.value = accurate.data.data.date


  // 将毫秒数转换为天、小时、分钟和秒

  function padWithZero(num) {
    if (num < 10) {
      return "0" + num;
    } else {
      return "" + num; // 将数字转换为字符串
    }
  }

  blurday.value = blur.data.data.date

  setInterval(() => {
    // 获取当前时间的时间戳
    const currentTimestamp = new Date().getTime();

    const blurcountdown = blurday.value - currentTimestamp;

    // 最近的节日
    const blurdays = padWithZero(Math.floor(blurcountdown / (1000 * 60 * 60 * 24)));
    const blurhours = padWithZero(Math.floor((blurcountdown % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)));
    const blurminutes = padWithZero(Math.floor((blurcountdown % (1000 * 60 * 60)) / (1000 * 60)));
    const blurseconds = padWithZero(Math.floor((blurcountdown % (1000 * 60)) / 1000));

    blurcount.value = {
      day: blurdays,
      hour: blurhours,
      minute: blurminutes,
      second: blurseconds
    }
  }, 1000);


  setInterval(() => {
    // 获取当前时间的时间戳
    const currentTimestamp = new Date().getTime();

    const accuratecountdown = accurateday.value - currentTimestamp;
    // 使用替代方法计算倒计时并格式化输出
    // 暑假
    const accuratedays = padWithZero(Math.floor(accuratecountdown / (1000 * 60 * 60 * 24)));
    const accuratehours = padWithZero(Math.floor((accuratecountdown % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)));
    const accurateminutes = padWithZero(Math.floor((accuratecountdown % (1000 * 60 * 60)) / (1000 * 60)));
    const accurateseconds = padWithZero(Math.floor((accuratecountdown % (1000 * 60)) / 1000));
    accuratecount.value = {
      day: accuratedays,
      hour: accuratehours,
      minute: accurateminutes,
      second: accurateseconds
    }
  }, 1000);

}


activeDay()
</script>

<template>
  <div class="timer">
    <timer>
      <template #holidayName>暑假</template>
      <template #img><img src="/src/assets/layout/屏幕截图 2024-04-24 150915.png" alt="" /></template>
      <template #day>{{ accuratecount.day }}</template>
      <template #hour>{{ accuratecount.hour }}</template>
      <template #minute>{{ accuratecount.minute }}</template>
      <template #second>{{ accuratecount.second }}</template>
    </timer>
    <timer>
      <template #holidayName>{{ holiday }}</template>
      <template #img><img src="/src/assets/layout/屏幕截图 2024-04-24 150953.png" alt="" /></template>
      <template #day>{{ blurcount.day }}</template>
      <template #hour>{{ blurcount.hour }}</template>
      <template #minute>{{ blurcount.minute }}</template>
      <template #second>{{ blurcount.second }}</template>
    </timer>
  </div>
</template>
<style lang="scss" scoped>
.timer {
  width: 940px;
  height: 329px;
  background: #ffffff;
  position: relative;
  left: 250px;
  top: -202px;
  padding-top: 11px;
  box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
}


img {
  width: 30px;
  height: 30px;
}
</style>
