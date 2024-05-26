<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-16 06:13:54
 * @LastEditTime: 2024-05-24 21:18:59
 * @FilePath: \Client\src\views\commonalityElement\menu\panel.vue
 * @Describe: 
-->
<script setup>
import { onMounted, ref } from 'vue'
import { User } from '@element-plus/icons-vue'
import '@/assets/font/font.css'
import { useRouter } from 'vue-router'
const router = useRouter()
import { ElMessage } from 'element-plus'
import request from '@/utils/request'
const removetoken = () => {
  localStorage.removeItem('user-data')
  localStorage.removeItem('user-level')
  ElMessage({
    message: '退出登录成功',
    type: 'success'
  })
  router.push('./login')
}

const user_info = ref({
  avatar: '', //头像
  age: '', //年龄
  sex: '', //性别
  age: '', //爱好
  email: '', //邮箱
  nickname: '' //昵称
})

const token = JSON.parse(localStorage.getItem('user-data')).token;

onMounted(() => {
  console.log(token)
  if (token) {
    request.post('/userInfo/avatar').then((res) => {
      user_info.value.avatar = res.data.data
    })
    request.post('/userInfo/nickname').then((res) => {
      user_info.value.avatar = res.data.data
    })
  }
})
</script>

<template>
  <el-dropdown>
    <router-link class="headimg" to="/login" v-if="!token">
      <img src="/src/assets/layout/211540yrmp8w0prt8opzm0.jpg" alt="头像" />
    </router-link>
    <router-link class="headimg" to="/center">
      <img :src="user_info.avatar" alt="头像" />
    </router-link>
    <template #dropdown v-if="token">
      <el-dropdown-menu class="optiones">
        <div class="top">
          <div class="avatar">
            <img src="/src/assets/layout/211540yrmp8w0prt8opzm0.jpg" alt="" />
          </div>
          <div class="names">{{ user_info.nickname }}</div>
          <div class="identity">
            <span>大二</span>&nbsp;
            <span>计算机科学与技术</span>
          </div>
        </div>
        <div class="neck">
          <div class="attention" v-for="item in 3" :key="item">
            <div class="number">0</div>
            <div class="letter">关注</div>
          </div>
        </div>
        <div class="body">
          <div class="lable" v-for="item in 5" :key="item">
            <div class="avatars">
              <el-icon>
                <User />
              </el-icon>
            </div>
            <router-link class="titles" to="/center">我的主页</router-link>
          </div>
        </div>
        <div class="foot">
          <div class="set">我的设置</div>
          <div class="quit" @click="removetoken()">退出登录</div>
        </div>
      </el-dropdown-menu>
    </template>
  </el-dropdown>
</template>
<style lang="scss" scoped>
:deep(.el-tooltip__trigger:focus-visible) {
  outline: unset;
}

.headimg {
  width: 50px;
  height: 50px;
  position: absolute;
  left: 1341px;
  top: 14px;
  border-radius: 50px;

  img {
    width: 50px;
    height: 50px;
    border-radius: 50px;
  }
}

.optiones {
  width: 164px;
  height: 239px;
  margin-left: 15px;
  margin-right: 19px;

  .top {
    width: 142px;
    height: 30px;
    margin: auto;
    position: relative;

    .avatar {
      width: 30px;
      height: 30px;
      border-radius: 30px;

      img {
        width: 30px;
        height: 30px;
        border-radius: 30px;
      }
    }

    .names {
      width: 56px;
      height: 16px;
      position: absolute;
      left: 38px;
      top: 3px;
      color: #3d3d3d;
      font-size: 12px;
      line-height: 16px;
      font-family: 'Alibaba-PuHuiTi-B';
    }

    .identity {
      width: 131px;
      height: 11px;
      position: absolute;
      left: 38px;
      bottom: 0;
      font-size: 8px;
      font-family: 'Alibaba-PuHuiTi-B';
      line-height: 11px;
      color: #818181;
    }
  }

  .neck {
    width: 130px;
    height: 40px;
    margin: auto;
    display: flex;
    margin-top: 12px;
    justify-content: space-between;
    border-bottom: 1px solid #efefef;

    .attention {
      width: 16px;
      height: 31px;
      padding-bottom: 9px;

      .number {
        width: 9px;
        height: 19px;
        margin: auto;
        color: #3d3d3d;
        font-size: 14px;
        line-height: 19px;
        font-family: 'Alibaba-PuHuiTi-B';
      }

      .letter {
        width: 16px;
        height: 11px;
        color: #818181;
        font-size: 8px;
        line-height: 11px;
        font-family: 'Alibaba-PuHuiTi-B';
      }
    }
  }

  .body > div:nth-child(3),
  .body > div:nth-child(4),
  .body > div:nth-child(5) {
    margin-top: 6px;
  }

  .body {
    width: 142px;
    height: 84px;
    margin: auto;
    padding-top: 7px;
    padding-bottom: 19px;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;

    .lable {
      width: 56px;
      height: 36px;
      position: relative;

      .avatars {
        width: 14px;
        height: 24px;
        position: absolute;
        top: 6px;
        font-size: 16px;
      }

      .titles {
        width: 42px;
        height: 21px;
        position: absolute;
        top: 8px;
        left: 17px;
        color: #3d3d3d;
        font-size: 10px;
        font-family: 'Alibaba-PuHuiTi-B';
        line-height: 11px;
      }
    }
  }

  .foot {
    width: 142px;
    height: 35px;
    margin: auto;
    position: absolute;
    bottom: 0;
    left: 11px;
    color: #818181;
    font-size: 10px;
    font-family: 'Alibaba-PuHuiTi-B';
    line-height: 10px;
    border-top: 2px solid #efefef;

    .set {
      width: 42px;
      height: 18px;
      position: absolute;
      top: 10px;
      left: 0;
    }

    .quit {
      width: 42px;
      height: 18px;
      position: absolute;
      top: 10px;
      right: 0;
      cursor: pointer;
    }
  }
}
</style>
