<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-26 20:23:51
 * @LastEditTime: 2024-04-26 23:43:36
 * @FilePath: \Client\src\views\user\layout\component\footer\Footer.vue
 * @Describe: 
-->
<template>
  <div>
    <div class="baseInfoBox">
      <div class="friendList">
        <div class="title">!友链！</div>
        <div class="item">?友链？</div>
        <div class="item">?友链？</div>
        <div class="item">?友链？</div>
        <div class="item">?友链？</div>
        <div class="item">?友链？</div>
      </div>
      <div class="LicenseList">
        <div class="title">!许可！</div>
        <div class="item">?许可？</div>
        <div class="item">?许可？</div>
        <div class="item">?许可？</div>
        <div class="item">?许可？</div>
        <div class="item">?许可？</div>
        <div class="item">?许可？</div>
        <div class="item">?许可？</div>
      </div>
      <div class="idkList">
        <div class="title">！？？！</div>
        <div class="item">？？</div>
        <div class="item">？？</div>
        <div class="item">？？</div>
        <div class="item">？？</div>
        <div class="item">？？</div>
      </div>
    </div>
    <div class="extraInfoBox">
      <div class="left">
        <div class="companyBox">Copyright © By 2023 - 2024</div>
        <span style="padding: 0 10px">|</span>
        <div class="company">异次元重工</div>
      </div>
      <div class="right">
        <div class="aboutBox"><div class="about">关于</div></div>
        <div class="ICPBox">
          <a class="ICP" href="https://beian.miit.gov.cn/">
            <div>下北泽ICP备1919114514号</div>
          </a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { onMounted, onActivated, ref } from 'vue'
onMounted(() => {
  const date = new Date()
  year = date.getFullYear()
})
</script>

<style lang="scss" scoped>
.baseInfoBox {
  color: white;
  padding: 20px 0;
  position: relative;
  display: flex;
  justify-content: space-around;

  .friendList,
  .LicenseList,
  .idkList {
    display: flex;
    flex-direction: column;
    text-align: center;
    .title {
      font-size: 20px;
      color: darkgray;
      cursor: default;
    }
    .item {
      cursor: pointer;
    }
    .item:hover {
      color: #425aef;
    }
  }
}
.extraInfoBox {
  background-color: white;
  padding: 1rem;
  display: flex;
  justify-content: space-between;
  //左
  .left {
    display: flex;
    align-items: center;
    .company {
        cursor: pointer;
    }
  }
  //右
  .right {
    display: flex;
    .ICPBox,
    .aboutBox {
      /* margin: 20px; */
      margin-left: 10px;
      cursor: pointer;
      padding: 10px;
      width: fit-content;
      border-radius: 12px;
      transition: all 0.3s ease;
      a.ICP {
        color: black;
        display: block;
        text-decoration: none;
      }
    }
    .ICPBox:hover {
      background-color: #425aef23;
      a.ICP {
        color: #425aef;
      }
    }
    .aboutBox:hover {
      background-color: #425aef23;
      .about {
        color: #425aef;
      }
    }
  }
}
</style>
