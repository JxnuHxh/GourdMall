import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

const router = new Router({
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
// 挂载路由守卫
router.beforeEach((to, from, next) => {
  console.log(to.path)
  if (to.path === '/login' || to.path === '/register' || to.path === '/forget' || to.path === '/admin' || to.path === '/') return next()
  // 获取token
  const token = window.localStorage.getItem('token')
  if (!token) return next('/login')
  next()
}
)

export default router
