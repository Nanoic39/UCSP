<script setup>
import menus from '../../../commonalityElement/menu.vue'
import '@/assets/font/font.css'
import { ArrowDown } from '@element-plus/icons-vue'
import { ref } from 'vue'
const inputs = ref('')
const check = ref(true)
</script>
<template>
  <menus></menus>
  <el-row class="loginPage">
    <el-col :span="12" class="loginImg">
      <div class="title">Welcome to E Tongda!</div>
    </el-col>
    <el-col :span="12" class="loginContent">
      <div class="verifyLogin">验证码登录</div>
      <div class="passwordLogin">密码登录</div>
      <div class="phoneNumber">
        <el-dropdown class="selects">
          <span class="el-dropdown-link">
            中国 +86
            <el-icon class="el-icon--right">
              <arrow-down />
            </el-icon>
          </span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>中国 +86</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
        <el-input
          placeholder="手机号"
          autocomplete="off"
          v-model="inputs"
          class="inputPhoneNumber"
          type="text"
          @input="(v) => (inputs = v.replace(/[^\d]/g, ''))"
        ></el-input>
      </div>
      <div class="messageNumber">
        <el-input
          placeholder="输入6位短信验证码"
          autocomplete="off"
          v-model="inputs"
          class="inputMessageNumber"
          type="text"
          @input="(v) => (inputs = v.replace(/[^\d]/g, ''))"
        ></el-input>
        <el-button class="getMessage">获取短信验证码</el-button>
      </div>
      <el-checkbox v-model="check" class="agree"
        >注册登录即表示同意<span>用户协议</span>和<span>隐私政策</span></el-checkbox
      >
      <el-button class="login">登录/注册</el-button>
    </el-col>
  </el-row>
</template>

<style lang="scss" scoped>
.loginPage {
  width: 992px;
  height: 578px;
  position: relative;
  top: 90px;
  left: 229px;
  background-color: #fafafa;
}
.loginImg {
  background-image: url('/src/assets/login/屏幕截图 2024-04-26 222543.png');
  background-repeat: no-repeat;
  background-size: cover;
  .title {
    width: 450px;
    height: 95px;
    font-size: 42px;
    color: #ffffff;
    font-family: 'RubikMonoOne-Regular';
    line-height: 47px;
    position: relative;
    top: 52px;
    left: 21px;
  }
}
.loginContent {
  position: relative;
  .verifyLogin {
    width: 119px;
    height: 33px;
    position: absolute;
    top: 52px;
    left: 52px;
    color: #3d3d3d;
    font-size: 23px;
    font-weight: 500;
    font-family: 'Alibaba-PuHuiTi-B';
    border-bottom: 6px solid #3e84fe;
  }
  .passwordLogin {
    width: 95px;
    height: 33px;
    position: absolute;
    top: 52px;
    right: 200px;
    color: #3d3d3d;
    font-size: 23px;
    font-weight: 500;
    font-family: 'Alibaba-PuHuiTi-B';
  }
  .phoneNumber {
    width: 406px;
    height: 73px;
    border-bottom: 2px solid #d8d8d8;
    position: absolute;
    top: 138px;
    left: 52px;
    .selects {
      width: 110px;
      height: 26px;
      position: absolute;
      bottom: 12px;
      font-size: 19px;
      line-height: 26px;
      color: #818181;
      font-family: 'Alibaba-PuHuiTi-B';
    }
    :deep(.selects:focus-visible) {
      outline: none;
    }

    :deep(.inputPhoneNumber) {
      width: 286px;
      height: 27px;
      border-left: 2px solid #d8d8d8;
      position: absolute;
      bottom: 12px;
      right: 0;
      font-size: 19px;
      line-height: 26px;
      color: #818181;
      font-family: 'Alibaba-PuHuiTi-B';
      .el-input__wrapper {
        border: none !important;
        box-shadow: none !important;
        background-color: #fafafa;
      }
    }
  }
  .messageNumber {
    width: 406px;
    height: 73px;
    border-bottom: 2px solid #d8d8d8;
    position: absolute;
    top: 224px;
    left: 52px;

    :deep(.inputMessageNumber) {
      width: 286px;
      height: 27px;
      position: absolute;
      bottom: 12px;
      left: 0;
      font-size: 19px;
      line-height: 26px;
      color: #818181;
      font-family: 'Alibaba-PuHuiTi-B';
      .el-input__wrapper {
        border: none !important;
        box-shadow: none !important;
        background-color: #fafafa;
        padding: 0;
      }
    }
    .getMessage {
      width: 133px;
      height: 26px;
      position: absolute;
      right: 0;
      bottom: 12px;
      color: #3e84fe;
      font-size: 19px;
      line-height: 26px;
      font-family: 'Alibaba-PuHuiTi-B';
    }
  }
  .agree {
    width: 289px;
    height: 20px;
    position: absolute;
    top: 310px;
    left: 52px;
    color: #999999;
    font-size: 10px;
    line-height: 20px;
    span {
      color: #3e84fe;
    }
  }
  .login {
    width: 406px;
    height: 58px;
    background-color: #3e84fe;
    position: absolute;
    bottom: 179px;
    left: 52px;
    color: #ffffff;
    font-size: 23px;
    font-family: 'Alibaba-PuHuiTi-B';
  }
}
</style>