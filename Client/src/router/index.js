/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-04-25 20:20:43
 * @LastEditTime: 2024-05-20 20:54:14
 * @FilePath: \Client\src\router\index.js
 * @Describe:
 */
import { createRouter, createWebHistory } from 'vue-router'
import { usecountStore } from '@/stores/count'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    //用户登录页
    {
      path: '/login',
      meta: {
        title: '登录'
      },
      component: () => import('@/views/user/user/login/loginPage.vue'),
      beforeEnter: (to, from, next) => {
        const usecount = usecountStore()
        usecount.setfirstmenu(null)
        usecount.removeindex()
        next()
      }
    }, 
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
          component: () => import('@/views/user/layout/PageIndex.vue'),
          beforeEnter: (to, from, next) => {
            const usecount = usecountStore()
            usecount.setfirstmenu(0)
            usecount.removeindex()
            next()
          }
        },
        {
          path: '/activitys',
          redirect: '/activity',
          children: [
            {
              path: '/activity',
              meta: {
                title: '活动页'
              },
              component: () => import('@/views/user/activity/activity.vue'),
              beforeEnter: (to, from, next) => {
                const usecount = usecountStore()
                usecount.setfirstmenu(1)
                usecount.removeindex()
                next()
              }
            },
            {
              path: '/activity/activityDetails',
              meta: {
                title: '活动详情页'
              },
              component: () => import('@/views/user/activity/activityDetails.vue')
            }
          ]
        },
        {
          path: '/help',
          meta: {
            title: '帮助'
          },
          component: () => import('@/views/user/help/helpContainer.vue'),
          beforeEnter: (to, from, next) => {
            const usecount = usecountStore()
            usecount.setfirstmenu(5)
            usecount.removeindex()
            next()
          }
        },
        {
          path: '/study',
          meta: {
            title: '数学'
          },
          component: () => import('@/views/user/study/studyMath.vue'),
          beforeEnter: (to, from, next) => {
            const usecount = usecountStore()
            usecount.removeCount()
            usecount.removeAsks()
            usecount.removeindex()
            usecount.setfirstmenu(3)
            next()
          }
        },
        {
          path: '/study',
          redirect: '/studyHelp',
          children: [
            {
              path: '/studyHelp',
              meta: {
                title: '互助室'
              },
              component: () => import('@/views/user/studyHelp/studyHelp.vue'),
              beforeEnter: (to, from, next) => {
                const usecount = usecountStore()
                usecount.removeAsks()
                usecount.setfirstmenu(3)
                usecount.removeindex()
                next()
              }
            },
            {
              path: '/studyHelp/shareContent',
              meta: {
                title: '经验分享'
              },
              component: () => import('@/views/user/studyHelp/shareContent.vue'),
              beforeEnter: (to, from, next) => {
                const usecount = usecountStore()
                usecount.setfirstmenu(3)
                usecount.removeindex()
                next()
              }
            }
          ]
        },
        {
          path: '/editor',
          meta: {
            title: '编辑页'
          },
          component: () => import('@/views/user/editor/editor.vue')
        },
        {
          path: '/teach',
          meta: {
            title: '教务'
          },
          component: () => import('@/views/user/teach/teachContainer.vue'),
          beforeEnter: (to, from, next) => {
            const usecount = usecountStore()
            usecount.setfirstmenu(4)
            usecount.removeindex()
            next()
          }
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
          redirect: '/personalcenter',
          children: [
            {
              path: '/personalcenter',
              meta: {
                title: '个人中心'
              },
              component: () => import('@/views/user/center/centerContainer.vue'),
              beforeEnter: (to, from, next) => {
                const usecount = usecountStore()
                next()
              }
            },
            {
              path: '/personalcenter/collect',
              meta: {
                title: '收藏集'
              },
              component: () => import('@/views/user/center/collectpage/collectpage.vue'),
              beforeEnter: (to, from, next) => {
                const usecount = usecountStore()
                next()
              }
            }
          ]
        },
        {
          path: '/tongda',
          meta: {
            title: '论坛'
          },
          component: () => import('@/views/user/tongda/tongdaContainer.vue'),
          beforeEnter: (to, from, next) => {
            const usecount = usecountStore()
            usecount.setfirstmenu(2)
            usecount.removeindex()
            next()
          }
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
      path: '/console/login',
      meta: {
        title: '后台管理系统登录'
      },
      component: () => import('@/views/console/login/login.vue'),
      beforeEnter: (to, from, next) => {
        const usecount = usecountStore()
        usecount.removeindex()
        next()
      }
    },
    {
      path: '/console',
      meta: {
        title: '后台管理系统登录'
      },
      component: () => import('@/views/console/index.vue'),
      beforeEnter: (to, from, next) => {
        const usecount = usecountStore()
        usecount.removeindex()
        next()
      },
      children: [
        {
          path: '/console/dashboard',
          meta: {
            title: '后台管理系统首页'
          },
          component: () => import('@/views/console/dashboard/panel.vue'),
          beforeEnter: (to, from, next) => {
            const usecount = usecountStore()
            usecount.removeindex()
            next()
          },
        },
        {
          path: '/console/user/userSelect',
          meta: {
            title: '用户查询'
          },
          component: () => import('@/views/console/user/userSelect.vue'),
          beforeEnter: (to, from, next) => {
            const usecount = usecountStore()
            usecount.removeindex()
            next()
          },
        },
        {
          path: '/console/user/userDelete',
          meta: {
            title: '用户删除'
          },
          component: () => import('@/views/console/user/userDelete.vue'),
          beforeEnter: (to, from, next) => {
            const usecount = usecountStore()
            usecount.removeindex()
            next()
          },
        }
      ]
    },

    //后台管理页面路径（动态注入）
  ]
})

router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('user-data');
  const token2 = localStorage.getItem('user-level')
  if (token && !token2) {
    if (to.path == '/console') {
      next('/console/login')
    } else {
        next()
    }
  } else if (!token) {
    if (to.path !== '/login') {
      next('/login');
    } else {
      // 否则直接跳转
      next();
    }
  } else if (token && token2) {
      next()
  }
});


router.afterEach((to, from) => {

  if (to.meta?.title) {
    document.title = to.meta?.title + ' - UCSP'
  } else {
    document.title = '- U C S P | 校园综合服务平台 -'
  }
})

export default router
