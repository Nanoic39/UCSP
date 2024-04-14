<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-07 13:36:54
 * @LastEditTime: 2024-04-13 15:34:53
 * @FilePath: \UCSP\Client\src\views\controller\consoleLogin.vue
 * @Describe: 
-->
<script setup lang="ts">
import request from '@/script/request'
</script>

<template>
  <div class="panelBox">
    <h1 class="title">后台管理系统登录</h1>
    <input type="text" placeholder="账号" /><br />
    <input type="password" placeholder="密码" />
    <div>登录</div>
  </div>
</template>

<script lang="ts">
export default {
  data() {
    //这里存放数据
    return {
      userinfo: {
        username: '',
        password: ''
      }
    }
  },
  //监听属性 类似于data概念
  computed: {},
  //监控data中的数据变化
  watch: {},
  //方法集合
  methods: {
    /* login() {
      request
        .get('/consoleLogin')
        .then((res) => {})
        .catch((err) => {})
    } */
  },
  //生命周期 - 创建完成（可以访问当前this实例）
  created() {},
  //生命周期 - 挂载完成（可以访问DOM元素）
  mounted() {}
  //beforeCreate() {}, //生命周期 - 创建之前
  //beforeMount() {}, //生命周期 - 挂载之前
  //beforeUpdate() {}, //生命周期 - 更新之前
  //updated() {}, //生命周期 - 更新之后
  //beforeDestroy() {}, //生命周期 - 销毁之前
  //destroyed() {}, //生命周期 - 销毁完成
  //activated() {}, //如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style scoped>
/*@import url(); 引入公共css类*/

.panelBox {
  height: 500px;
  margin: calc((100vh - var(--height-nav) - 500px) / 2) auto;
  background-color: var(--color-white-alpha-07);
  width: 1200px;

  backdrop-filter: blur(2px);
  box-shadow: var(--shadow-level-1);
  border-radius: 5px;
}

.title {
  padding: 15px 0;
  text-align: center;
}
</style>
