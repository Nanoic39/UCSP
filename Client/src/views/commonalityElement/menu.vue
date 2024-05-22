<script setup>
import { Search, Bell, User } from '@element-plus/icons-vue'
import '@/assets/font/font.css'
import selection from './menu/selection.vue'
import panels from './menu/panel.vue'
import { usecountStore } from '@/stores/count'
import { ref, onMounted, provide } from 'vue'
const usecount = usecountStore()

const totalmenu = ref(null)
const activeIndex = ref(usecount.firstmenu)

console.log(usecount.firstmenu)
provide('indexs', { activeIndex })
const arr = ref([])
const numbersAsNumbers = ref([])
onMounted(() => {
  const children = totalmenu.value.childNodes
  // console.log(children[0])
  children.forEach((child, index) => {
    child.setAttribute('data-index', index);
    child.addEventListener('mouseenter', () => handleMouseEnter(index))
    child.addEventListener('click', () => handleclick(index))
  });
  for (let i = 0; i < children.length; i++) {
    arr.value.push(children[i].getAttribute('data-index'))
  }
  const numbersArray = arr.value.join(",").split(",");

  numbersAsNumbers.value = numbersArray.map(Number);

})


const handleMouseEnter = (index) => {
  activeIndex.value = numbersAsNumbers.value[index]
}

const handleclick = (index) => {
  if (index == 3) {
    return
  } else {
    usecount.setfirstmenu(numbersAsNumbers.value[index])
  }
}
const deactivates = () => {
  if (usecount.firstmenu) {
    activeIndex.value = usecount.firstmenu
  } else {
    activeIndex.value = 0
  }
}
</script>

<template>
  <div class="topmenu">
    <div class="logo">
      <img src="/src/assets/layout/One-stop campus website.png" alt="" />
    </div>
    <div class="menus" ref="totalmenu" @mouseleave="deactivates">
      <router-link class="menuHomePage" :class="{ Color: 0 === activeIndex }" to="/home">首页</router-link>
      <router-link class="menuHomePage" :class="{ Color: 1 === activeIndex }"
        to="/activity/:activeId">校园活动</router-link>
      <router-link :class="{ Color: 2 === activeIndex }" ref="mytongda" class="menuTongda"
        to="/tongda">通达论坛</router-link>
      <selection></selection>
      <router-link :class="{ Color: 4 === activeIndex }" class="menuTeach" to="/teach">教务大厅</router-link>
      <router-link :class="{ Color: 5 === activeIndex }" class="menuHelp" to="/help">跑腿互助</router-link>
    </div>
    <el-input class="search">
      <template #prefix>
        <el-button class="clear">
          <el-icon>
            <Search />
          </el-icon>
        </el-button>
      </template>
    </el-input>

    <el-dropdown>
      <router-link class="message" to="/message">
        <el-icon>
          <Bell />
        </el-icon>
      </router-link>
      <template #dropdown>
        <el-dropdown-menu class="options">
          <el-dropdown-item>评论</el-dropdown-item>
          <el-dropdown-item>赞和收藏</el-dropdown-item>
          <el-dropdown-item>新增粉丝</el-dropdown-item>
          <el-dropdown-item>私信</el-dropdown-item>
          <el-dropdown-item>系统通知</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>

    <panels></panels>
  </div>
</template>
<style lang="scss" scoped>
.Color {
  border-bottom: 3px solid #3e84fe;
  color: #3e84fe !important;
}

:deep(.el-tooltip__trigger:focus-visible) {
  outline: unset;
}

.options {
  width: 121px;
  height: 161px;
}

.topmenu {
  height: 74px;
  width: 100%;
  background-color: #ffffff;

  .logo {
    width: 138px;
    height: 45px;
    position: absolute;
    left: 51px;
    top: 19px;

    img {
      width: 138px;
      height: 45px;
    }
  }

  .menus {
    min-width: 720px;
    height: 27px;
    position: absolute;
    top: 26px;
    left: 247px;
    font-size: 20px;
    display: flex;
    gap: 57px;

    a {
      text-decoration: none;
      color: #3d3d3d;
    }

    .router-link {
      min-width: 40px;
      height: 27px;
    }
  }

  :deep(.search) {
    width: 245px;
    height: 36px;
    position: absolute;
    left: 1018px;
    top: 21px;
    border-radius: 100px;
    border: 1px solid #d8d8d8;

    .el-input-group__prepend {
      border-radius: 100px;
      box-shadow: 0 0 0 0px;
    }

    .el-input__wrapper {
      border-radius: 100px;
      box-shadow: 0 0 0 0px;
    }

    .el-input-group__append {
      border-radius: 100px;
      box-shadow: 0 0 0 0px;
    }

    .clear {
      border: 0;
      width: 20px;
      height: 20px;
      border-radius: 30px;
      position: absolute;
      right: 0;
      cursor: pointer;
    }
  }

  .message {
    width: 35px;
    height: 29px;
    position: absolute;
    left: 1286px;
    top: 22px;
    font-size: 33px;
    color: #a6c5f6;
  }
}

.menuHomePage:hover {
  border-bottom: 3px solid #3e84fe;
  color: #3e84fe !important;
}

.menuTongda:hover {
  border-bottom: 3px solid #3e84fe;
  color: #3e84fe !important;
}

.menuTeach:hover {
  border-bottom: 3px solid #3e84fe;
  color: #3e84fe !important;
}

.menuHelp:hover {
  border-bottom: 3px solid #3e84fe;
  color: #3e84fe !important;
}

.blueBackground {
  color: #3e84fe !important;
  border-bottom: 3px solid #3e84fe;
}
</style>
