<script setup>
import Vditor from 'vditor'
import { ref, onMounted } from 'vue'

// 2. 获取DOM引用
const vditor = ref()
//第三方文档
//https://blog.csdn.net/weixin_55697693/article/details/131618403
// 3. 在组件初始化时，就创建Vditor对象，并引用
onMounted(() => {
  vditor.value = new Vditor('vditor', {
    // 编辑器中默认展示的文本
    value: '请输入文本',
    // 设置编辑器的宽高
    height: '100vh',
    width: '100%',
    // 设置工具栏中展示的工具
    //toolbar: ['emoji', 'br', 'bold', '|', 'line', 'quote', 'list', 'check'],
    // 编辑器失去焦点后的回调函数
    blur(value) {
      // 保存文档....
      console.log('保存成功')
    }
  })
})
</script>

<template>
  <div id="vditor"></div>
</template>
