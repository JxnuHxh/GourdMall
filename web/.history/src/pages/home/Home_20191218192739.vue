<template>
  <div >
    <div id="fixed-header" v-if="fixed">
      <fixed-header :login="login"></fixed-header>
    </div>
    <!-- <back-to-top :custom-style="myBackToTopStyle" :visibility-height="300" :back-position="0" transition-name="fade"/> -->
    <we-chat :custom-style="myBackToTopStyle" :visibility-height="1" :back-position="0" transition-name="fade"></we-chat>
    <shop-cart :custom-style="shopCartStyle" :visibility-height="200" :back-position="0" transition-name="fade"></shop-cart>
    <el-backtop :bottom="40" :visibility-height="300">
    <!-- <i class="iconfont el-icon-ali-xiaochengxu" @mouseover="log()"></i> -->
    </el-backtop>
    <el-container>
      <home-header :login="login"></home-header>
      <el-header id="header-bar">
        <nav-bar :cid="true"></nav-bar>
        <!-- Header content -->
      </el-header>
      <el-main>
        <!-- Main content -->
        <home-container></home-container>

      </el-main>

      <el-footer >
        <home-footer></home-footer>
      </el-footer>
    </el-container>
  </div>

</template>
<script>
import HomeHeader from '../../common/components/Header'
import NavBar from '../../common/components/NavBar'
import HomeContainer from './components/Container'
import HomeFooter from '../../common/components/Footer'
import FixedHeader from '../../common/components/FixedHeader'
import BackToTop from '../../common/backtop/BackToTop'
import ShopCart from '../../common/shopcart/ShopCart'
import WeChat from '../../common/wechat/Wechat'

export default {
  name: 'Home',
  data () {
    return {
      searchBarFixed: false,
      fixed: false,
      componentId: '',
      state: false,
      login: false,
      myBackToTopStyle: {
        right: '40px',
        bottom: '140px',
        width: '40px',
        height: '40px',
        borderRadius: '20px',
        lineHeight: '40px', // 请保持与高度一致以垂直居中
        background: 'white', // 按钮的背景颜色
        'z-index': '200',
        color: '#409eff',
        'font-size': '20px'
      },
      shopCartStyle: {
        right: '40px',
        bottom: '90px',
        width: '40px',
        height: '40px',
        borderRadius: '20px',
        lineHeight: '40px', // 请保持与高度一致以垂直居中
        background: 'white', // 按钮的背景颜色
        'z-index': '200',
        color: '#409eff',
        'font-size': '20px'
      }
    }
  },
  created () {
    // console.log('主页创建')
    console.log(window.sessionStorage.getItem('token'))
    if (window.sessionStorage.getItem('token') === null || window.sessionStorage.getItem('token') === '' || window.sessionStorage.getItem('token') === undefined) {
      this.login = false
    } else {
      this.login = true
    }
    // 进行token验证, 并且获取用户信息
  },
  mounted () {
    window.addEventListener('scroll', this.handleScroll)
  },
  components: {
    HomeHeader: HomeHeader,
    NavBar: NavBar,
    HomeContainer: HomeContainer,
    HomeFooter: HomeFooter,
    BackToTop: BackToTop,
    ShopCart: ShopCart,
    WeChat: WeChat,
    FixedHeader: FixedHeader
  },
  methods: {
    register: function () {
      this.$router.push('/register')
    },
    handleScroll: function () {
      let scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
      // console.log('scrollTop:' + scrollTop)
      let offsetTop = 145
      // console.log('offsetTop:' + offsetTop)
      if (scrollTop > offsetTop) {
        this.fixed = true
      } else {
        this.fixed = false
      }
      // console.log(this.searchBarFixed)
    },
    log: function () {
      // console.log('ssssssss')
      window.pageYOffset = 0
    }
  }
}
</script>
<style scoped>
.el-header {
  padding: 0px
}
#header-bar {
  height: 80px !important;
  background: white;
  box-shadow:0px 15px 10px -15px #ccc;
  width: 100%;
}
.el-container {
  background: #ededed;
}
#header-bar2 {
  position: fixed
}
.el-main {
  position: relative
}
.el-footer {
  padding: 0px;
  height: 330px;
}
.shop-cart {
  position: fixed;
  z-index: 200;
  bottom: 40px;
  right: 40px;
  height: 40px;
  width: 40px;
  background: #ededed;
  text-align: center;
  vertical-align: middle;
  border-radius: 20px;
  /* padding-top: 10px; */
  line-height: 20px;
}

#fixed-header {
  width: 100%;
  height: 70px;
  position: fixed;
  background: #333333;
  z-index: 20;
  margin-top: -10px;
  margin-bottom: -10px
}

</style>
