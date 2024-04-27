<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-26 17:34:53
 * @LastEditTime: 2024-04-26 21:38:22
 * @FilePath: \Client\src\views\user\layout\component\time\time.vue
 * @Describe: 
-->
<script setup>
import '@/assets/font/font.css'
</script>

<template>
  <div class="firstTimer">
    <el-row class="titleFirst">
      <el-col :span="7" class="text">距离</el-col>
      <el-col :span="10" class="holidayName"><slot name="holidayName"></slot></el-col>
      <el-col :span="7" class="text">还有</el-col>
    </el-row>
    <div class="imga">
      <img src="/src/assets/layout/屏幕截图 2024-04-24 150915.png" alt="" />
    </div>
    <el-row class="times">
      <el-col :span="6">
        <el-row>
          <el-col :span="12" class="time"><slot name="day"></slot></el-col>
          <el-col :span="12" class="intro">天</el-col>
        </el-row>
      </el-col>
      <el-col :span="6">
        <el-row>
          <el-col :span="12" class="time"><slot name="hour"></slot></el-col>
          <el-col :span="12" class="intro">时</el-col>
        </el-row>
      </el-col>
      <el-col :span="6">
        <el-row>
          <el-col :span="12" class="time"><slot name="minute"></slot></el-col>
          <el-col :span="12" class="intro">分</el-col>
        </el-row>
      </el-col>
      <el-col :span="6">
        <el-row>
          <el-col :span="12" class="time"><slot name="second"></slot></el-col>
          <el-col :span="12" class="intro">秒</el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>
<style lang="scss" scoped>
.text {
  font-size: 36px;
  line-height: 68px;
}
.holidayName {
  font-size: 50px;
  line-height: 57px;
}
.times {
  width: 423px;
  height: 44px;
  position: relative;
  left: 22px;
  top: 113px;
  .time {
    font-size: 50px;
    line-height: 44px;
    font-family: 'DS-DIGI';
  }
  .intro {
    font-size: 32px;
    color: #595959;
    font-family: 'ZhanKuKuaiLeTi2016XiuDingBan-1';
    line-height: 58px;
  }
}
.firstTimer {
  width: 470px;
  height: 307px;
  float: left;
  border-right: 1px solid #dcdbdb;
  color: #3d3d3d;

  .titleFirst {
    width: 248px;
    height: 57px;
    position: relative;
    top: 54px;
    left: 30px;
    font-family: 'ZhanKuKuaiLeTi2016XiuDingBan-1';
  }
  .imga {
    width: 30px;
    height: 30px;
    position: absolute;
    top: 39px;
    left: 276px;
    img {
      width: 30px;
      height: 30px;
    }
  }
}
</style>