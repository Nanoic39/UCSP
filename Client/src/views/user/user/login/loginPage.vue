<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-27 13:51:57
 * @LastEditTime: 2024-05-18 13:23:35
 * @FilePath: \Client\src\views\user\user\login\loginPage.vue
 * @Describe: 
-->
<script setup>
import '@/assets/font/font.css'
import { ArrowDown } from '@element-plus/icons-vue'
import { userRegisterService,userLoginService } from '@/api/user.js'
import { ref } from 'vue'
import { ElMessage } from 'element-plus'
import menus from '@/views/commonalityElement/menu.vue'
import { saveUserInfo } from '@/utils/infoSave'

import { useRouter } from 'vue-router'
const router = useRouter()
const inputs = ref('')
const forms = ref('')
const phoneloginform = ref('')
const phoneform = ref('')
const check = ref(false)
const selectWay = ref(1)
const activeIndex = ref(1)
const changePassword = () => {
  activeIndex.value = 3
  selectWay.value = 3
}
const changeVerify = () => {
  activeIndex.value = 1
  selectWay.value = 1
}
const changephone = () => {
  activeIndex.value = 2
  selectWay.value = 2
}

const logining = ref({
  account: '',
  password: '',
})

const Verify = ref({
  account: '',
  password: '',
  phone:'',
  repassword:''
})

const local = ref({
  uuid:'',
  token:''
})

const phonelogin = ref({
  phone:'',
  repassword:''
})

const rules = {
  account: [
    { required: true, message: '请输入您的用户名', trigger: 'blur' },
    {
      pattern: /^[\w]{6,18}$/,
      message: '用户名必须是6-18位的数字字母下划线',
      trigger: 'blur'
    }
  ],
  password: [
    { required: true, message: '请输入您的密码', trigger: 'blur' },
    {
      pattern: /^[\w]{6,18}$/,
      message: '密码必须是6-18位的数字字母及下划线',
      trigger: 'blur'
    }
  ],
  phone: [
    { required: true, message: '请输入您的手机号', trigger: 'blur' },
    {
      pattern: /^1(3\d|4[5-9]|5[0-35-9]|6[56]|7[0135-8]|8\d|9[189])\d{8}$/,
      message: '请填写正确的手机号',
      trigger: 'blur'
    }
  ],
}

const loginfuntion = async () =>{
  await forms.value.validate()
  if(check.value == true){
    const userdata = await userLoginService(logining.value)
    if(userdata.data.statusCode == '200'){
      saveUserInfo(userdata.data.data?.id, userdata.data.data?.token, userdata.data.data?.account)
      ElMessage({
        message: '登录成功',
        type: 'success',
      })
      router.push('/')
    }  
  }else{
    ElMessage({
      message: '您必须同意用户协议和隐私政策才能登录',
      type: 'warning',
    })
  }
}

const Verifyfunction = async () =>{
  await phoneform.value.validate()
  if(check.value == true){
    const verifys = await userRegisterService(Verify.value)
    console.log(verifys.data)
    if(verifys.data.statusCode == '200'){
      ElMessage({
        message: '注册成功',
        type: 'success',
      })
      selectWay.value = 1
      activeIndex.value = 1
    }  
  }else{
    ElMessage({
      message: '您必须同意用户协议和隐私政策才能登录',
      type: 'warning',
    })
  }
}

</script>
<template>
  <menus></menus>
  <el-row class="loginPage">
    <el-col :span="12" class="loginImg">
      <div class="title">Welcome to E Tongda!</div>
    </el-col>
    <el-col :span="12" class="loginContent">
      <el-form v-if="selectWay == 1" :model="logining"
          :rules="rules" ref="forms"> 
        <div class="passwordLogin" @click="changeVerify()" :class="{ active: 1 === activeIndex }">
          登录
        </div>
        <div class="phoneLogin" @click="changephone()" :class="{ active: 2 === activeIndex }">
          手机号登录
        </div>
        <div class="verifyLogin" @click="changePassword()" :class="{ active: 3 === activeIndex }">
          注册
        </div>
        <el-form-item class="loginaccount" prop="account">
          <el-input
            placeholder="用户名"
            autocomplete="off"
            v-model="logining.account"
            class="inputPhoneNumbers"
            type="text"
          ></el-input>
        </el-form-item>
        <el-form-item class="loginpassword" prop="password">
          <el-input
            placeholder="密码"
            autocomplete="off"
            v-model="logining.password"
            class="inputPhoneNumbers"
            type="text"
            show-password
          ></el-input>
        </el-form-item>
        <el-form-item class="forget">忘记密码？</el-form-item>
        <el-checkbox v-model="check" class="agrees"
          >登录即表示同意<span>用户协议</span>和<span>隐私政策</span></el-checkbox
        >
        <el-button class="logins" @click="loginfuntion()">登录</el-button>
      </el-form>
      <el-form  v-if="selectWay == 2" :model="phonelogin"
          :rules="rules" ref="phoneloginform">
        <div class="passwordLogin" @click="changeVerify()" :class="{ active: 1 === activeIndex }">
          登录
        </div>
        <div class="phoneLogin" @click="changephone()" :class="{ active: 2 === activeIndex }">
          手机号登录
        </div>
        <div class="verifyLogin" @click="changePassword()" :class="{ active: 3 === activeIndex }">
          注册
        </div>
        <el-form-item class="phoneNumbers" prop="phone">
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
                <el-dropdown-item disabled>不支持其他国家的手机号哦😀</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
          <el-input
            placeholder="手机号"
            autocomplete="off"
            v-model="phonelogin.phone"
            class="inputPhoneNumber"
            type="text"
          ></el-input>
        </el-form-item>
        <el-form-item class="messageNumbers">
          <el-input
            placeholder="输入6位短信验证码"
            autocomplete="off"
            v-model="phonelogin.repassword"
            class="inputMessageNumber"
            type="text"
            @input="(v) => (inputs = v.replace(/[^\d]/g, ''))"
          ></el-input>
          <el-button class="getMessage">获取短信验证码</el-button>
        </el-form-item>
        <!-- 必须让用户手动勾选 -->
        <el-checkbox v-model="check" class="loginagree"
          >注册登录即表示同意<span>用户协议</span>和<span>隐私政策</span></el-checkbox
        >
        <el-button class="phonelogins">手机号登录</el-button>
      </el-form>
      <el-form  v-if="selectWay == 3" :model="Verify"
          :rules="rules" ref="phoneform">
        <div class="passwordLogin" @click="changeVerify()" :class="{ active: 1 === activeIndex }">
          登录
        </div>
        <div class="phoneLogin" @click="changephone()" :class="{ active: 2 === activeIndex }">
          手机号登录
        </div>
        <div class="verifyLogin" @click="changePassword()" :class="{ active: 3 === activeIndex }">
          注册
        </div>
        <el-form-item class="verifyaccount" prop="account">
          <el-input
            placeholder="用户名"
            autocomplete="off"
            v-model="Verify.account"
            class="verifyNumbers"
            type="text"
          ></el-input>
        </el-form-item>
        <el-form-item class="verifypassword" prop="password">
          <el-input
            placeholder="密码"
            autocomplete="off"
            v-model="Verify.password"
            class="verifyNumbers"
            type="text"
            show-password
          ></el-input>
        </el-form-item>
        <el-form-item class="phoneNumber" prop="phone">
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
                <el-dropdown-item disabled>不支持其他国家的手机号哦😀</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
          <el-input
            placeholder="手机号"
            autocomplete="off"
            v-model="Verify.phone"
            class="inputPhoneNumber"
            type="text"
          ></el-input>
        </el-form-item>
        <el-form-item class="messageNumber">
          <el-input
            placeholder="输入6位短信验证码"
            autocomplete="off"
            v-model="Verify.repassword"
            class="inputMessageNumber"
            type="text"
            @input="(v) => (inputs = v.replace(/[^\d]/g, ''))"
          ></el-input>
          <el-button class="getMessage">获取短信验证码</el-button>
        </el-form-item>
        <!-- 必须让用户手动勾选 -->
        <el-checkbox v-model="check" class="verifyagree"
          >注册登录即表示同意<span>用户协议</span>和<span>隐私政策</span></el-checkbox
        >
        <el-button class="verifys" @click="Verifyfunction()">注册</el-button>
      </el-form>

      
    </el-col>
  </el-row>
</template>

<style lang="scss" scoped>
.loginPage {
  width: 992px;
  height: 578px;
  position: relative;
  top: 50px;
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
  .passwordLogin {
    min-width: 35px;
    height: 33px;
    position: absolute;
    top: 52px;
    left: 52px;
    color: #3d3d3d;
    font-size: 23px;
    font-weight: 500;
    font-family: 'Alibaba-PuHuiTi-B';
    cursor: pointer;
  }
  .phoneLogin{
    min-width: 35px;
    height: 33px;
    position: absolute;
    top: 52px;
    left: 122px;
    color: #3d3d3d;
    font-size: 23px;
    font-weight: 500;
    font-family: 'Alibaba-PuHuiTi-B';
    cursor: pointer;
  }
  .phoneLogin.active {
    border-bottom: 6px solid #3e84fe;
  }
  .verifyLogin{
    min-width: 35px;
    height: 33px;
    position: absolute;
    top: 52px;
    left: 260px;
    color: #3d3d3d;
    font-size: 23px;
    font-weight: 500;
    font-family: 'Alibaba-PuHuiTi-B';
    cursor: pointer;
  }
  .verifyLogin.active {
    border-bottom: 6px solid #3e84fe;
  }
  .passwordLogin.active {
    border-bottom: 6px solid #3e84fe;
  }
  .loginaccount,.loginpassword{
    width: 406px;
    height: 73px;
    border-bottom: 2px solid #d8d8d8;

    :deep(.inputPhoneNumbers) {
      width: 406px;
      height: 27px;
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
        padding: 0;
      }
    }
  }

  .loginaccount{
    position: absolute;
    top: 128px;
    left: 52px;
  }

  .loginpassword{
    position: absolute;
    top: 208px;
    left: 52px;
  }

  .verifyaccount,.verifypassword{
    width: 406px;
    height: 73px;
    border-bottom: 2px solid #d8d8d8;
    :deep(.verifyNumbers) {
      width: 406px;
      height: 27px;
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
        padding: 0;
      }
    }
    
  }

  .verifyaccount{
    position: absolute;
    top: 100px;
    left: 52px;
  }

  .verifypassword{
    position: absolute;
    top: 180px;
    left: 52px;
  }

  .phoneNumbers {
    width: 406px;
    height: 73px;
    border-bottom: 2px solid #d8d8d8;
    position: absolute;
    top: 128px;
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

    :deep(.inputPhoneNumbers) {
      width: 406px;
      height: 27px;
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
        padding: 0;
      }
    }
  }
  .phoneNumber {
    width: 406px;
    height: 73px;
    border-bottom: 2px solid #d8d8d8;
    position: absolute;
    top: 260px;
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

    :deep(.inputPhoneNumbers) {
      width: 406px;
      height: 27px;
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
        padding: 0;
      }
    }
  }
  .messageNumber {
    width: 406px;
    height: 73px;
    border-bottom: 2px solid #d8d8d8;
    position: absolute;
    top: 340px;
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
  .messageNumbers {
    width: 406px;
    height: 73px;
    border-bottom: 2px solid #d8d8d8;
    position: absolute;
    top: 208px;
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
  .forget {
    width: 71px;
    height: 19px;
    position: absolute;
    top: 305px;
    right: 35px;
    font-size: 14px;
    color: #818181;
    font-family: 'Alibaba-PuHuiTi-B';
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

  .agrees,.verifyagree,.loginagree {
    width: 289px;
    height: 20px;
    color: #999999;
    font-size: 10px;
    line-height: 20px;
    span {
      color: #3e84fe;
    }
  }

  .agrees,.loginagree{
    position: absolute;
    top: 332px;
    left: 52px;
  }

  .verifyagree{
    position: absolute;
    top: 432px;
    left: 52px;
  }

  .logins,.verifys,.phonelogins {
    width: 406px;
    height: 58px;
    background-color: #3e84fe;
    color: #ffffff;
    font-size: 23px;
    font-family: 'Alibaba-PuHuiTi-B';
  }

  .logins,.phonelogins{
    position: absolute;
    bottom: 157px;
    left: 52px;
  }

  .verifys{
    position: absolute;
    bottom: 57px;
    left: 52px;
  }
}
</style>
