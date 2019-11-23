import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: () => import('@/pages/home/Home')
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('@/pages/login/Login')
    },
    {
      path: '/register',
      name: 'Register',
      component: () => import('@/pages/register/Register')
    }
  ]
})
