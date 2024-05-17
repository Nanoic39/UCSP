<template>
    <div>
        <TinymceEditor :value="formData.content" @update:value="updateContent" />
    </div>
</template>
<script setup lang="ts">
import TinymceEditor from "./TinymceEditor.vue";
import { reactive } from "vue";
const formData = reactive({
    content: "",
});
const updateContent = (v: string) => {
    formData.content = v;
};

</script>