<script setup>
import '@/assets/font/font.css'
</script>

<template>
  <div class="firstTimer">
    <el-row class="titleFirst">
      <el-col :span="7" class="first">距离</el-col>
      <el-col :span="10" class="middle">暑假</el-col>
      <el-col :span="7" class="floor">还有</el-col>
    </el-row>
    <div class="imga">
      <img src="/src/assets/layout/屏幕截图 2024-04-24 150915.png" alt="" />
    </div>
    <el-row class="times">
      <el-col :span="6">
        <el-row>
          <el-col :span="12" class="one"><slot name="first"></slot></el-col>
          <el-col :span="12" class="two">天</el-col>
        </el-row>
      </el-col>
      <el-col :span="6">
        <el-row>
          <el-col :span="12" class="one"><slot name="second"></slot></el-col>
          <el-col :span="12" class="two">时</el-col>
        </el-row>
      </el-col>
      <el-col :span="6">
        <el-row>
          <el-col :span="12" class="one"><slot name="third"></slot></el-col>
          <el-col :span="12" class="two">分</el-col>
        </el-row>
      </el-col>
      <el-col :span="6">
        <el-row>
          <el-col :span="12" class="one"><slot name="fourth"></slot></el-col>
          <el-col :span="12" class="two">秒</el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>
<style lang="scss" scoped>
.first {
  font-size: 36px;
  line-height: 68px;
}
.middle {
  font-size: 50px;
  line-height: 57px;
}
.floor {
  font-size: 36px;
  line-height: 68px;
}
.times {
  width: 423px;
  height: 44px;
  position: relative;
  left: 22px;
  top: 113px;
  .one {
    font-size: 50px;
    line-height: 44px;
    font-family: 'DS-DIGI';
  }
  .two {
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