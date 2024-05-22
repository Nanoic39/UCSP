<script setup>
import menus from '@/views/commonalityElement/menu.vue'
import '@/assets/svg/helpeach/share/iconfont.css'
import essays from './component/essay.vue'
import topmenu from './component/topmenu.vue'
</script>

<template>
    <menus></menus>
    <div class="personal">
        <topmenu></topmenu>
        <div class="trends">
            <essays v-for="item in 10" :key="item"></essays>
        </div>
    </div>
</template>
<style lang="scss" scoped>
.personal {
    width: 800px;
    height: auto;
    background-color: #ffffff;
    position: relative;
    left: 319px;
    top: 21px;
    padding-bottom: 30px;

    .trends {
        width: 100%;
        height: auto;

    }
}
</style>
