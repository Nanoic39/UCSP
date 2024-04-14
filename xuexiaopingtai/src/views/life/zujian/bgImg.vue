<script setup>
</script>

<template>
  <el-row>
    <el-col :span="24" class="bg">
      <el-row>
        <el-col :span="4"></el-col>
        <el-col :span="16">
          <div class="heads">
            <img src="@/assets/211540yrmp8w0prt8opzm0.jpg" alt="" />
          </div>
          <div class="name">法助</div>
          <div class="total">
            <el-row>
              <el-col :span="8" class="eyes"></el-col>
              <el-col :span="16" class="content">
                <div>
                  <span class="today">今日访客：</span>
                  <span>300</span>
                </div>
                <div>
                  <span class="allday">总访客量：</span>
                  <span>10000</span>
                </div>
              </el-col>
            </el-row>
          </div>
        </el-col>
        <el-col :span="4"></el-col>
      </el-row>
    </el-col>
  </el-row>
  <el-row class="menutwo"></el-row>
</template>



<style lang="scss" scoped>
.bg {
  height: 300px;
  background: linear-gradient(to bottom, pink, rgb(247, 206, 213), rgb(246, 206, 213));

  .heads {
    width: 120px;
    height: 120px;
    border: 5px solid rgb(252, 251, 251);
    position: relative;
    bottom: -210px;
    z-index: 10;
    img {
      width: 120px;
      height: 120px;
    }
  }
  .name {
    width: 80px;
    height: 40px;
    position: relative;
    right: -130px;
    bottom: -125px;
    color: rgb(177, 50, 93);
    font-size: 18px;
    text-align: center;
    line-height: 40px;
  }
  .total {
    // border: 1px solid red;
    position: relative;
    right: -870px;
    bottom: -65px;
    width: 230px;
    height: 60px;
    .eyes {
      background-image: url('@/assets/earth_small1.jpg');
      background-repeat: no-repeat;
      background-size: contain;
      z-index: 20;
    }
    .content {
      font-size: 18px;
      line-height: 30px;
    }
  }
}
.menutwo {
  width: 100%;
  height: 60px;
  background-color: bisque;
}
</style>