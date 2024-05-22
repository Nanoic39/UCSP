<script setup>
import { menuToTree } from '@/utils/menu/toTree'
import request from '@/utils/request'
import { ref, defineProps } from 'vue'

//使用props将父组件index中切换按钮点击后改变的CollapseInf传入子组件ConsoleMenu中改变侧边栏的伸缩状态
const props = defineProps({
    CollapseInf: Boolean,
    sendFnToMenu:Function
})
//给每个子菜单设置的点击事件，item：当前菜单的对象
//根据当前子菜单的id更新IndexRouter的值，从而更新右侧main中的组件
const handleMenuItemClick = (Item) => {
    props.sendFnToMenu(Item.id)
}
//定义从后端获取的menu对象中键值对属性
const menu = ref([
    {
        id: 0,
        parent_id: 0,
        name: 'string',
        path: 'string',
        file_path: null,
        icon: 'string',
        auth: 'string',
        level: 'string',
        sort: 'string',
        status: 'string',
        creat_time: 0,
        update_time: 0
    }])
const newMenu = ref({})
//从后端获取菜单数据并根据menuToTree方法依据菜单的层级顺序将子菜单放到children中
request.get('/get/console/menu').then((res) => {
    if (res.data?.statusCode == '200') {
        menu.value = res.data?.data
        newMenu.value = menuToTree(res.data.data)
        console.log(res.data.data)
    } else {
        console.error('ERsROR', res.data)
    }
})
</script>

<template>
    <div>
        <el-menu default-active="2" class="el-menu-vertical-demo " :collapse="props.CollapseInf" id="menu" :collapse-transition="true" >
            <template v-for="item in newMenu " :key="item.id">
                <!-- 单个 -->
                <template v-if='item.children.length === 0 ? true : false'>
                    <el-menu-item :index="item.path" @click="handleMenuItemClick(item)">
                        <el-icon>
                            <component :is='item.icon'> </component>
                        </el-icon>
                        <span>{{ item.name }}</span>
                    </el-menu-item>
                </template>
                <!-- 嵌套 -->
                <template v-if="item.level == 1">
                    <el-sub-menu v-if='item.children.length !== 0 ? true : false' :index="item.path">
                        <template #title>
                            <el-icon>
                                <component :is='item.icon'> </component>
                            </el-icon>
                            <span>{{ item.name }}</span>
                        </template>
                        <template v-for="subItem in item.children" :key="subItem.id">
                            <el-menu-item :index="subItem.path" @click="handleMenuItemClick(subItem)">
                                <template #title>
                                    <el-icon>
                                        <component :is='subItem.icon'> </component>
                                    </el-icon>
                                    <span>{{ subItem.name }}</span>
                                </template>
                            </el-menu-item>
                        </template>
                    </el-sub-menu>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<style>
</style>