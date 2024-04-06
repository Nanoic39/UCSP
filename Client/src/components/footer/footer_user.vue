<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-03-30 01:10:05
 * @LastEditTime: 2024-04-06 15:01:43
 * @FilePath: \Client\src\components\footer\footer_user.vue
 * @Describe: 底部footer区域
-->
<!--  -->
<template>
  <div class="footerBox">
    <div class="textCenter footerHeader">
      <div class="footerHeaderItem">Design Dev By <name>Nanoic</name> & <name>随遇</name></div>
    </div>
    <div class="textCenter footerHeader">
      <div class="footerHeaderItem">萌ICP备案号</div>
      <div class="footerHeaderPart">|</div>
      <div class="footerHeaderItem">ICP备案号</div>
      <div class="footerHeaderPart">|</div>
      <div class="footerHeaderItem">公安备案号</div>
    </div>
    <div class="Box"></div>
  </div>
</template>

<script lang="ts">
export default {
  data() {
    //这里存放数据
    return {}
  },
  //监听属性 类似于data概念
  computed: {},
  //监控data中的数据变化
  watch: {},
  //方法集合
  methods: {},
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
.footerBox {
  background-color: rgb(243, 243, 243);
  margin-top: 25px;
  min-height: 150px;
  position: relative;
  bottom: 0;
}

.footerHeader {
  width: 80%;
  margin: 0 auto;
  font-size: 18px;
  font-family: 'consolas';
  display: flex;
  justify-content: center;
}

.footerHeader .footerHeaderPart {
  margin: 0 10px;
}

name {
  color: blue;
  font-weight: 60;
}
</style>
