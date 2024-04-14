<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-07 13:39:42
 * @LastEditTime: 2024-04-07 22:26:29
 * @FilePath: \UCSP\Client\src\components\form\templateForm.vue
 * @Describe: 
-->
<template>
  <div class="panelBox">
    <div class="titleBox"></div>
    <slot name="title"></slot>
    <slot name="content"></slot>
    <slot name="controller"></slot>
  </div>
</template>

<script lang="ts">
export default {
  props: ['Width', 'Height'],
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
</style>
