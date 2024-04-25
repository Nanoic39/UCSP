<script setup>
import menus from './zujian/menu.vue'
<<<<<<< Updated upstream
import jieshao from './zujian/jieshao.vue'
import lunbo from './zujian/lunbo.vue'
import biaoti from './zujian/biaoti.vue'
</script>

<template>
  <div class="tops"><menus></menus></div>
  <el-row class="all">
    <el-col :span="24" class="main">
      <el-row>
        <el-col :span="24">
          <lunbo></lunbo>
        </el-col>
      </el-row>
      <biaoti>
        <template #first>主</template>
        <template #second>题</template>
        <template #third>介</template>
        <template #fourth>绍</template>
      </biaoti>
      <jieshao></jieshao>
    </el-col>
  </el-row>
</template>
<style lang="scss" scoped>
.tops {
  position: sticky;
  top: 0;
  left: 0;
  z-index: 100;
=======
import timer from './zujian/timer.vue'
import menuSecond from './zujian/menuSecond.vue'
import introduce from './zujian/intoduce.vue'
import '@/assets/font/font.css'
import imgs from './zujian/imgs.vue'
import littletalk from './zujian/littletalk.vue'
import classes from './zujian/classes.vue'
</script>

<template>
  <menus></menus>
  <div class="bgimg">
    <img src="/src/assets/layout/屏幕截图 2024-04-24 135620.png" alt="" />
  </div>
  <timer></timer>
  <menuSecond></menuSecond>
  <div class="introduceFirst">
    <introduce>热门活动</introduce>
    <div class="titles">Campus activities</div>
  </div>
  <imgs></imgs>
  <div class="talk">
    <div class="introduceSecond">
      <introduce>热论榜单</introduce>
      <div class="titles">Selected courses</div>
    </div>
    <div class="talking">
      <littletalk v-for="item in 6" :key="item">
        <template #first>
          壬戌之秋，七月既望，苏子与客泛舟游于赤壁之下。清风徐来，水波不兴。举酒属客，诵明月之诗，歌窈窕之章。少焉
        </template>
        <template #second>邱彬</template>
        <template #third>2024.4.1 12:30</template>
      </littletalk>
    </div>
  </div>
  <div class="select">
    <div class="introduceThird">
      <introduce>热论榜单</introduce>
      <div class="titles">Selected courses</div>
    </div>
    <div class="contentclass">
      <classes v-for="item in 3" :key="item">
        <template #first>编程</template>
        <template #second>python数据分析与展示</template>
        <template #third>嵩天</template>
        <template #fourth>https://www.icourse163.org/course/...</template>
      </classes>
    </div>
  </div>
</template>
<style lang="scss" scoped>
.bgimg {
  width: 100%;
  height: 581px;
  img {
    width: 100%;
    height: 581px;
  }
}
.introduceFirst {
  height: 122px;
  width: 100%;
  position: relative;
  top: -26px;
}
.titles {
  width: 421px;
  height: 65px;
  margin: auto;
  font-family: 'ADLaMDisplay-Regular';
  font-size: 50px;
  color: #3d3d3d;
}
.talk {
  width: 100%;
  height: 930px;
  background-color: #f6f9ff;
  position: relative;
  top: 80px;
  .introduceSecond {
    height: 122px;
    width: 100%;
    position: relative;
    top: 24px;
  }
  .talking {
    width: 1212px;
    height: 684px;
    position: absolute;
    bottom: 37px;
    left: 114px;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }
  .talking > div:nth-child(4) {
    margin-top: 24px;
  }
  .talking > div:nth-child(5) {
    margin-top: 24px;
  }
  .talking > div:nth-child(6) {
    margin-top: 24px;
  }
}
.select {
  width: 100%;
  height: 661px;
  position: relative;
  top: 80px;

  .introduceThird {
    height: 122px;
    width: 100%;
    position: absolute;
    top: 26px;
  }
  .contentclass {
    position: absolute;
    width: 1212px;
    height: 420px;
    left: 114px;
    bottom: 49px;
    display: flex;
    justify-content: space-between;
    border-radius: 10px;
  }
>>>>>>> Stashed changes
}
</style>
