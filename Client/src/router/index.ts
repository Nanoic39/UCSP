/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-03-28 16:12:47
 * @LastEditTime: 2024-04-05 10:23:26
 * @FilePath: \Client\src\router\index.ts
 * @Describe: 
 */
import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/user/index.vue'
import LoginView from '../views/user/userLogin.vue'

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
    }
  ]
})

export default router
