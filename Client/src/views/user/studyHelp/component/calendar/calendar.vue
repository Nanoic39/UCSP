<script setup>
import '@/assets/font/font.css'
</script>

<template>
  <section class="calendars">
    <h1>May 2024</h1>
    <div class="record">
      <div class="statistics">已经连续打卡<span>7</span>天！</div>
      <el-button class="clock">打卡</el-button>
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
        <label class="day invalid" v-for="(item, index) in 34" :key="item" :data-day="index">
          <span>{{ index - 2 }}</span>
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
