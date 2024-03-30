import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/user/userLogin.vue'
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
