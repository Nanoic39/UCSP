import { createRouter, createWebHistory } from 'vue-router'

// createRouter 创建路由实例，===> new VueRouter()
// 1. history模式: createWebHistory()   http://xxx/user
// 2. hash模式: createWebHashHistory()  http://xxx/#/user

// vite 的配置 import.meta.env.BASE_URL 是路由的基准地址，默认是 ’/‘
// https://vitejs.dev/guide/build.html#public-base-path

// 如果将来你部署的域名路径是：http://xxx/my-path/user
// vite.config.ts  添加配置  base: my-path，路由这就会加上 my-path 前缀了

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
<<<<<<< Updated upstream
    { path: '/login', component: () => import('@/views/login/loginPage.vue') }, //登录页
=======
    { path: '/login', component: () => import('@/views/user/user/login/loginPage.vue') }, //登录页
>>>>>>> Stashed changes
    {
      path: '/',
      redirect: '/home',
      children: [
        {
          path: '/home',
          component: () => import('@/views/layout/layoutContainer.vue')
        },
        {
          path: '/help',
          component: () => import('@/views/help/helpContainer.vue')
        },
        {
          path: '/study',
          component: () => import('@/views/study/studyContainer.vue')
        },
        {
          path: '/teach',
          component: () => import('@/views/teach/teachContainer.vue')
        },
        {
          path: '/message',
          component: () => import('@/views/message/messageContainer.vue')
        },
        {
          path: '/center',
          component: () => import('@/views/center/centerContainer.vue')
        },
        {
          path: '/tongda',
          component: () => import('@/views/tongda/tongdaContainer.vue')
        },
        { path: '/user', component: () => import('@/views/user/userPage.vue') }
      ]
    }
  ]
})

export default router
