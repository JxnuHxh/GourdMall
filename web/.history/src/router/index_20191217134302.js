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
    },
    {
      path: '/GoodsDetails',
      name: 'GoodsDetails',
      component: () => import('@/pages/goods/GoodsDetails')
    }
  ]
})
// 挂载路由守卫
router.beforeEach((to, from, next) => {
  // console.log(to.path)

  if (to.path === '/') {
    return next()
  }

  if (to.path === '/login' || to.path === '/register') {
    window.sessionStorage.removeItem('token')
    return next()
  }
  // if (to.path == )
  // if (to.path === '/login' || to.path === '/register' || to.path === '/forget' || to.path === '/admin' || to.path === '/GoodsDetails' || to.path === '/') return next()
  // 获取token
  const token = window.sessionStorage.getItem('token')
  if (token) {
    // console.log('已登路')
    return next()
  } else {
    // console.log('未登路')
    this.$message('请登录后访问')
    return next('/login')
  }
})

export default router
