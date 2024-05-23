<script setup>
import tinys from '@/views/commonalityElement/TinymceEditor/tiny.vue'
import drawers from './drawer.vue'
import { upload } from '@/api/upload';
import { onMounted, ref } from 'vue'
import { formData } from '../../../../public/tinymce/modules/jax/src/main/ts/ephox/jax/core/HttpData';
import request from '@/utils/request';

const uploading = async () => {
    const res = await upload('src / assets / center / 20245181447.png')
    console.log(res)
}
// uploading()

onMounted(() => {

});

const fileInput = ref(null)
const handleFileChange = async () => {
    const file = fileInput.value.files[0];

    if (file) {
        // 将文件转换为Blob类型
        const reader = new FileReader();
        reader.onloadend = async function () {
            const blob = new Blob([reader.result], { type: file.type });
            console.log(blob)
            // 在这里可以将blob对象用于进一步处理
            // 例如，将其作为请求体发送给服务器
            const res = await upload(blob);
            console.log(res);
        };
        reader.readAsArrayBuffer(file);
    }
};

const handleSubmit = async () => {
    const file = fileInput.value.files[0];

    if (file) {
        const formData = new FormData();
        formData.append('file', file);

        // 在这里可以将formData对象用于进一步处理
        // 例如，通过Ajax发送请求给服务器
        const res = await upload(formData);
        console.log(res);
    }
};

const uploadFile = async () => {
    // const file = fileInput.value.files[0];
    // console.log(file)
    // const formData = new FormData();
    // formData.append('file', file);
    // var xhr = new XMLHttpRequest()
    // xhr.open("POST", "http://146.56.193.5:4514/upload/image", true)
    // xhr.onreadystatechange = function () {
    //     if (xhr.readyState === 4 && xhr.status === 200) {
    //         console.log(JSON.parse(xhr.response))
    //     }
    // }
    // xhr.send(formData)
    const file = fileInput.value.files[0];
    console.log(file)
    const formData = new FormData();
    formData.append('image', file);
    console.log(formData)

    try {
        const response = await request.get('/upload/image', { files: formData });
        console.log(response.data);
    } catch (error) {
        console.error(error);

        if (error.response && error.response.status === 500) {
            // 处理500错误的逻辑
            console.log("服务器发生错误");
        } else {
            // 处理其他错误的逻辑
            console.log("请求发生错误");
        }
    }
}

</script>

<template>
    <tinys></tinys>
    <drawers></drawers>
    <!-- <form @submit.prevent="handleSubmit"> -->
    <input type="file" ref="fileInput" @change="handleFileChange()">
    <!-- <button type="submit">上传</button> -->
    <!-- </form> -->
    <!-- <form action="/demo/uploadFile" method="post" enctype="multipart/form-data">
        <input type="file" name="meFile" />

        <input type="submit" value="提交" />

        <input type="reset" value="清空" />

    </form> -->
</template>
<style lang="scss" scoped></style>
