<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-05 09:52:02
 * @LastEditTime: 2024-04-06 13:00:54
 * @FilePath: \Client\src\views\user\index.vue
 * @Describe: 
-->
<script setup lang="ts">
import templateCarousel from '../../components/carousel/templateCarousel.vue'
import Footer from '@/components/footer/footer_user.vue'
</script>
<template>
  <div class="carousel">
    <templateCarousel Radius="5px" Height=""></templateCarousel>
  </div>
  <div class=""></div>
  <Footer></Footer>
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
.carousel {
  width: 1200px;
  margin: 15px auto;
  min-height: 400px;
}
</style>
