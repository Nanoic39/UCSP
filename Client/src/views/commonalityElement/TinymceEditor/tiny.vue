<!--
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-16 06:13:54
 * @LastEditTime: 2024-05-24 16:56:51
 * @FilePath: \Client\src\views\commonalityElement\TinymceEditor\tiny.vue
 * @Describe: 
-->
<template>
    <div>
        <TinymceEditor @update:statics="handleCounterUpdate" />
    </div>
</template>
<script setup lang="ts">
import TinymceEditor from "./TinymceEditor.vue";
import { reactive, watch, ref } from "vue";
const formData = reactive({
    content: "",
});

const childCounter = ref(null);

const handleCounterUpdate = (newValue: any) => {
    childCounter.value = newValue;
    // console.log(childCounter.value)
};

const emits = defineEmits(['update:Values', 'setHtml'])
//监听富文本中的数据变化
watch(
    childCounter, (newValue) => {
        emits('update:Values', newValue)
    }, { deep: true }
)
</script>