<template>
    <div class="searchBar">
        <div class="icon">
            <el-icon>
                <Search />
            </el-icon>
        </div>
        <div class="textInput">
            <el-input type="text" placeholder="请输入搜索关键字" clearable>
                <template #prefix>
                    <el-button class="clear">
                        <el-icon>
                            <Search />
                        </el-icon>
                    </el-button>
                </template>
            </el-input>
        </div>
    </div>
</template>

<script setup>
import { Search } from '@element-plus/icons-vue'
</script>

<style lang="scss" scoped>
.searchBar {
    width: 230px;
    height: 37px;
    background-color: #fff;
    // box-shadow: 0 0 5px rgba(0, 0, 0, 0.4);
    border-radius: 37px;
    position: absolute;
    left: 0px;
    overflow: hidden;
    transition: width 0.5s;

    .icon {
        width: 37px;
        height: 37px;
        display: flex;
        justify-content: center;
        align-items: center;
        cursor: pointer;
    }

    .icon i {
        color: dodgerblue;
        font-size: 27px;
    }

    .textInput {
        width: 145px;
        height: 37px;
        display: flex;
        justify-content: center;
        align-items: center;
        position: absolute;
        top: 0;
        left: 40px;
    }

    .textInput input {
        width: 100%;
        height: 100%;
        border: none;
        outline: none;
        font-size: 12px;
    }
}

.clear {
    width: 30px;
    height: 30px;
    position: absolute;
    right: -40px;
    border: none;
    top: 50%;
    transform: translateY(-50%);
    cursor: pointer;
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>