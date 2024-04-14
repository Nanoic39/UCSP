/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-03-28 16:12:47
 * @LastEditTime: 2024-04-12 20:56:06
 * @FilePath: \UCSP\Client\src\router\index.ts
 * @Describe: 
 */
import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/user/index.vue'
import LoginView from '@/views/user/userLogin.vue'
import consoleLogin from '@/views/controller/consoleLogin.vue'
import testView from '@/views/test/testView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/login',
      name: 'login',
     component:  LoginView,
    },
    {
      path: '/console/login',
      name: 'consoleLogin',
     component:  consoleLogin,
    },
    {
      path: '/test',
      name: 'testView',
     component:  testView,
    }
  ]
})

export default router
