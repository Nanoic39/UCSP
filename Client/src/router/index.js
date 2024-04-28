/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-25 20:20:43
 * @LastEditTime: 2024-04-28 22:05:02
 * @FilePath: \Client\src\router\index.js
 * @Describe:
 */
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    //未知路径404
    {
      path: '/:catchAll(.*)',
      name: 'undefined',
      component: () => import('@/views/user/exception/NotFound.vue'),
      meta: {
        title: '未知路径',
        AuthLevel: 0
      }
    },
    //用户登录页
    {
      path: '/login',
      meta: {
        title: '登录'
      },
      component: () => import('@/views/user/user/login/loginPage.vue')
    }, 
    //用户页面路径
    {
      path: '/',
      redirect: '/home',
      children: [
        {
          path: '/home',
          meta: {
            title: '首页'
          },
          component: () => import('@/views/user/layout/PageIndex.vue')
        },
        {
          path: '/activity',
          meta: {
            title: '活动'
          },
          component: () => import('@/views/user/activity/activityContainer.vue')
        },
        {
          path: '/help',
          meta: {
            title: '帮助'
          },
          component: () => import('@/views/user/help/helpContainer.vue')
        },
        {
          path: '/study',
          meta: {
            title: '学习'
          },
          component: () => import('@/views/user/study/studyContainer.vue')
        },
        {
          path: '/teach',
          meta: {
            title: '教务'
          },
          component: () => import('@/views/user/teach/teachContainer.vue')
        },
        {
          path: '/message',
          meta: {
            title: '消息'
          },
          component: () => import('@/views/user/message/messageContainer.vue')
        },
        {
          path: '/center',
          meta: {
            title: '个人中心'
          },
          component: () => import('@/views/user/center/centerContainer.vue')
        },
        {
          path: '/tongda',
          meta: {
            title: '论坛'
          },
          component: () => import('@/views/user/tongda/tongdaContainer.vue')
        },
        {
          path: '/user/:id',
          meta: {
            title: '用户中心'
          },
          component: () => import('@/views/user/user/userPage.vue')
        }
      ]
    },
    //后台管理登录页
    {
      path: '/conosle/login',
      meta: {
        title: '后台管理系统登录'
      },
      component: () => import('@/views/console/login/login.vue')
    }
    //后台管理页面路径（动态注入）
  ]
})

router.afterEach((to, from) => {
  if (to.meta?.title) {
    document.title = to.meta?.title + " - UCSP"
  } else {
    document.title = '- U C S P | 校园综合服务平台 -'
  }
})

export default router
