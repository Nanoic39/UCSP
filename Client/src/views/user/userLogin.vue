<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-03-28 17:23:22
 * @LastEditTime: 2024-04-13 15:53:51
 * @FilePath: \UCSP\Client\src\views\user\userLogin.vue
 * @Describe: 
-->
<template>
  <div id="MainBody" class="mainBody">
    <div class="marginCenter contain">
      <div class="topBlock"></div>
      <div class="flex center" style="justify-content: space-between">
        <div class="flex_l" style="text-align: center"></div>
        <div class="flex_r">
          <div class="loginPanel">
            <h2 style="text-align: left; margin-bottom: 15px">{{ TypeTitle }}</h2>
            <div class="tipBox" v-show="error_info === '' ? 0 : 1">⚠：{{ error_info }}</div>
            <input
              v-model="data.email"
              type="text"
              class="input_type_default"
              placeholder="请输入邮箱"
            />
            <div v-show="type === 'login' ? 1 : 0" style="70%">
              <input
                v-model="data.password"
                type="password"
                class="input_type_default"
                placeholder="请输入密码"
              />
              <div>
                <input v-model="isConsentClause" type="checkbox" />
                我已阅读并同意
                <a href="#">用户隐私条款</a>
                和
                <a href="#">用户规范</a>
              </div>
              <div style="overflow: hidden; margin: 10px 0"></div>
              <button type="button" class="btn_type_default" @click="submitLogin()">登 录</button>
              <div style="text-align: right; width: 80%; margin: 4px auto 0 auto">
                <a href="#">忘记密码</a>
              </div>
              <div style="overflow: hidden; margin: 10px 0"></div>
              <div>
                已有帐号？
                <span
                  @click="
                    changeType('register')
                    TypeTitle = '注册'
                  "
                >
                  <a href="#">去注册</a>
                </span>
              </div>
            </div>
            <div v-show="type === 'register' ? 1 : 0" style="70%">
              <div class="inline-input-panel">
                <input
                  v-model="data.verifycode"
                  type="text"
                  class="input_type_inline"
                  placeholder="请输入验证码"
                  style="width: 60%"
                />
                <button
                  type="button"
                  class="btn_type_inline"
                  @click="checkEmail()"
                  style="width: 20%"
                >
                  {{ btn_verifycode }}
                </button>
              </div>
              <div v-show="data.verifycode != ''">
                <input
                  v-model="data.password"
                  type="password"
                  class="input_type_default"
                  placeholder="请设置密码(6-18位)"
                />
              </div>

              <div>
                <input v-model="isConsentClause" type="checkbox" />
                我已阅读并同意
                <a href="#">用户隐私条款</a>
                和
                <a href="#">用户规范</a>
              </div>
              <div style="overflow: hidden; margin: 10px 0"></div>
              <button type="button" class="btn_type_default" @click="submitRegister()">注册</button>
              <div style="overflow: hidden; margin: 10px 0"></div>
              <div>
                已有帐号？
                <span
                  @click="
                    changeType('login')
                    TypeTitle = '登录'
                  "
                >
                  <a href="#">去登陆</a>
                </span>
              </div>
            </div>
            <!-- <div style="position: absolute;bottom: 0px;right: 20px;height: 160px;">
                            <img height="160px" src="https://www.yuanshen.com/images/ys.96a55539.png">
                        </div> -->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
export default {
    onMounted(){//挂载

    }
}
</script>
<style scoped>
/*@import url(); 引入公共css类*/
</style>
