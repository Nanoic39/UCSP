<template>
  <div class="searchBar">
    <div class="icon">
      <el-icon><Search /></el-icon>
    </div>
    <div class="textInput">
      <el-input type="text" placeholder="请输入搜索关键字" clearable>
        <template #prefix>
          <el-button class="clear">
            <el-icon><Search /></el-icon>
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
  width: 40px;
  height: 40px;
  background-color: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);
  border-radius: 40px;
  position: relative;
  overflow: hidden;
  transition: 0.5s;
  .icon {
    width: 40px;
    height: 40px;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
  }
  .icon i {
    color: dodgerblue;
    font-size: 30px;
  }
  .textInput {
    width: 145px;
    height: 40px;
    display: flex;
    justify-content: center;
    align-items: center;
    // background-color: blue;
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
  // border-radius: 30px;
  position: absolute;
  right: -40px;
  top: 50%;
  transform: translateY(-50%);
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
}

.searchBar:hover {
  width: 230px;
}
</style>
