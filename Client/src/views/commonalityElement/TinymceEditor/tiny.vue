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
        <TinymceEditor :value="formData.content" @update:value="updateContent" />
    </div>
</template>
<script setup lang="ts">
import TinymceEditor from "./TinymceEditor.vue";
import { reactive, watch } from "vue";
const formData = reactive({
    content: "",
});
const updateContent = (v: string) => {
    formData.content = v;
};

const emit = defineEmits(['handleUpdate'])
watch(formData, (newValue, oldValue) => {
    emit("handleUpdate", formData.content)
})
</script>