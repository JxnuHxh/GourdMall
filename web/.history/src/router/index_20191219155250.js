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
      path: '/products',
      name: 'Products',
      component: () => import('@/pages/products/Products')
    },
    {
      path: '/goodsdetails',
      name: 'GoodsDetails',
      component: () => import('@/pages/goods/GoodsDetails')
    },
    {
      path: '/checkout',
      name: 'CheckOut',
      component: () => import('@/pages/checkout/CheckOut')
    },
    {
      path: '/cart',
      name: 'Cart',
      component: () => import('@/pages/cart/Cart')
    },
    {
      path: '/admin',
      name: 'Admin',
      component: () => import('@/pages/admin/Admin')
    },
    {
      path: '/adminlogin',
      name: 'AdminLogin',
      component: () => import('@/pages/admin/AdminLogin')
    },
    {
      path: '/test',
      name: 'Test',
      component: () => import('@/pages/test/Test')
    }
  ]
})
// 挂载路由守卫
router.beforeEach((to, from, next) => {
  // console.log(to.path)

  if (to.path === '/' || to.path === '/test' || to.path === 'adminlogin' || to.path === 'admin') {
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
    alert('请登录后进行访问')
    return next('/login')
  }
})

export default router
