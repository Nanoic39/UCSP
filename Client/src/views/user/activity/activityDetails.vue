<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-17 19:32:20
 * @LastEditTime: 2024-05-24 19:18:07
 * @FilePath: \Client\src\views\user\activity\activityDetails.vue
 * @Describe: 
-->
<script setup>
import menus from '@/views/commonalityElement/menu.vue'
import { useRoute, useRouter } from 'vue-router'
import { ref } from 'vue'
import request from '@/utils/request'
import { ElMessage } from 'element-plus'
import background from './component/background.vue'
import screen from './component/screen.vue'
import Footer from '@/views/user/layout/component/footer/Footer.vue'

import { debounceFunc } from '@/utils/debounce/debounce'



//路由
const route = useRoute()
const router = useRouter()

//通过路由获取id
const activeId = ref('')

const postTips = (msg) => {
  ElMessage({ message: msg, type: 'warning' })
}


activeId.value = route?.params.activeId
</script>
<template>
  <menus></menus>
  <background></background>
  <RouterView></RouterView>
  <div style="width: 100%" class="mainContent">
    <div class="contain info">
      <div class="title">南京邮电大学通达学院第十六届计算机设计大赛</div>
      <div class="information">
        <div><span class="info_item">活动编码：</span>1145141919810</div>
        <div><span class="info_item">报名时间：</span>2024.4.1-2024.4.15</div>
        <div><span class="info_item">活动时间：</span>2024.5.1-2024.5.3</div>
        <div><span class="info_item">活动院系：</span>计算机工程学院</div>
        <div><span class="info_item">活动年级：</span>全部</div>
        <div><span class="info_item">活动编码：</span>114514</div>
        <div><span class="info_item">活动编码：</span>114514</div>
        <div><span class="info_item">活动编码：</span>114514</div>
        <div><span class="info_item">活动编码：</span>114514</div>
      </div>
    </div>

    <div class="contain detail">
      <div class="content">
        且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。故九万里则风斯在下矣，而后乃今培风；背负青天而莫之夭阏者，而后乃今将图南。且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。故九万里则风斯在下矣，而后乃今培风；背负青天而莫之夭阏者，而后乃今将图南。且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。故九万里则风斯在下矣，而后乃今培风；背负青天而莫之夭阏者，而后乃今将图南。且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。故九万里则风斯在下矣，而后乃今培风；背负青天而莫之夭阏者，而后乃今将图南。且夫水
        之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。故九万里则风斯在下矣，而后乃今培风；背负青天而莫之夭阏者，而后乃今将图南。且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。故九万里则风斯在下矣，而后乃今培风；背负青天而莫之夭阏者，而后乃今将图南。且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负在下矣，而后乃今培风；背负青天而莫之夭阏者，而后乃今将图南。且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。故九万里则风斯在下矣，而后乃今培风；背负青天而莫之夭阏者，而后乃今将图南。且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水、
        其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。故九万里则风斯在下矣，而后乃今培风；背负青天而莫之夭阏者，而后乃今将图南。且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。故九万里则风斯在下矣，而后乃今培风；背负青天而莫之夭阏者，而后乃今将图南。且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。故九万里则风斯在下矣，而后乃今培风；背负青天而莫之夭阏者，而后乃今将图南。且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。故九万里则风斯在下矣，而后乃今培风；背负青天而莫之夭阏者，而后乃今将图南。且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。故九万里则风斯在下矣，而后乃今培风；背负青天而莫之夭阏者，而后乃今将图南。且夫水之积也不厚，则其负大舟也无力。覆杯水于坳堂之上，则芥为之舟。置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力。
      </div>
    </div>
    <div class="contain button">
      <div class="flex">
        <div class="buttonItem">
          报名
          <svg
            xmlns="http://www.w3.org/2000/svg"
            xmlns:xlink="http://www.w3.org/1999/xlink"
            fill="none"
            version="1.1"
            width="24.349687576293945"
            height="18.945938110351562"
            viewBox="0 0 24.349687576293945 18.945938110351562"
          >
            <g>
              <path
                d="M21.0759,0L24.3497,3.35625L8.37656,18.9459L0,10.9472L3.23813,7.55719L8.34094,12.4303L21.0759,0Z"
                fill="#FEFEFE"
                fill-opacity="1"
              />
            </g>
          </svg>
        </div>
        <div class="barrier"></div>
        <div class="buttonItem">
          心动
          <svg
            xmlns="http://www.w3.org/2000/svg"
            xmlns:xlink="http://www.w3.org/1999/xlink"
            fill="none"
            version="1.1"
            width="28.125028610229492"
            height="23.048954010009766"
            viewBox="0 0 28.125028610229492 23.048954010009766"
          >
            <g>
              <path
                d="M0.00000290573,8.19139C-0.0000738166,4.85776,2.0202,1.85665,5.10882,0.602263C8.19744,-0.652127,11.7382,0.0904776,14.0625,2.48014C16.3868,0.0904767,19.9276,-0.652127,23.0162,0.602264C26.1047,1.85654,28.125,4.85765,28.125,8.19139C28.1314,10.786,26.9017,13.2286,24.8138,14.7689L15.5447,22.4067C14.4801,23.2842,12.9362,23.26,11.8997,22.3495L2.87156,14.4192C1.0476,12.8647,-0.00216935,10.5879,0.00000290573,8.19139Z"
                fill="#FFFFFF"
                fill-opacity="1"
              />
            </g>
          </svg>
        </div>
      </div>
    </div>
    
  </div>

  <Footer class="footer"></Footer>
</template>

<style lang="scss" scoped>
.info {
  z-index: 1;
  position: relative;
  margin-top: -90px;
  width: 80%;
  min-height: 240px;
  background-color: white;

  .title {
    padding-top: 23px;
    /* margin-top: 23px; */
    text-align: center;

    font-family: AlibabaPuHuiTi;
    font-size: 40px;
    font-weight: 500;
    line-height: normal;
    letter-spacing: 0em;

    font-feature-settings: 'kern' on;
    color: #3d3d3d;
  }

  .information {
    display: grid;
    grid-template-columns: repeat(3, 300px);
    grid-template-rows: repeat(3, 50px);
    line-height: 50px;

    justify-content: center;

    color: #818181;
    font-size: 18px;
    font-family: AlibabaPuHuiTi;

    .info_item {
      padding-left: 15px;
    }
  }
}

.detail {
  width: 80%;
  margin-top: 40px;
  background: #fefefe;
  min-height: 800px;
  font-family: AlibabaPuHuiTi;
  font-size: 18px;

  .content {
    padding: 40px;
    text-indent: 2em;
  }
}

.button {
  width: 80%;
  margin: auto;
  height: 50px;
  margin-top: 40px;

  .barrier {
    width: 45px;
  }

  .buttonItem {
    padding: 5px 0;
    cursor: pointer;
    color: #fefefe;
    border-radius: 10px;
    opacity: 0.5;
    background: #3e84fe;
    box-sizing: border-box;
    border: 5px solid #fefefe;
    text-align: center;
    font-size: 36px;
    line-height: 50px;
    width: 50%;
  }

  .buttonItem:hover {
    opacity: 0.8;
  }
}

.mainContent{
  margin-bottom: 50vh;
}

.footer {
  margin-top: 80px;
}

</style>
