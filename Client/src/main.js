/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-25 20:20:43
 * @LastEditTime: 2024-05-16 15:48:22
 * @FilePath: \Client\src\main.js
 * @Describe:
 */
import { createApp } from 'vue'
import { createPinia } from 'pinia'

import '@/assets/main.scss'

import App from './App.vue'
import router from './router'

//Element-Plus UI
import ElementPlus from 'element-plus'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import 'element-plus/dist/index.css'

// Vditor Style
import 'vditor/dist/index.css';

const app = createApp(App)
// app.use(pinia)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

app.use(ElementPlus)
app.use(createPinia())
app.use(router)

app.mount('#app')
