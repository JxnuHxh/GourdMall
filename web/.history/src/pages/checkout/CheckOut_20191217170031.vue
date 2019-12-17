<template>
  <div >
    <div id="fixed-header" v-if="fixed">
      <fixed-header :login="login"></fixed-header>
    </div>
    <we-chat :custom-style="myBackToTopStyle" :visibility-height="1" :back-position="0" transition-name="fade"></we-chat>
    <el-backtop :bottom="90" :visibility-height="300">
    </el-backtop>
    <el-container>
      <page-header :login="login"></page-header>
      <el-header id="header-bar">
        <nav-bar :cid="false"></nav-bar>
        <!-- Header content -->
      </el-header>
      <el-main>
        <!-- Main content -->
        <el-row>
          <el-col :span="14" :offset="5">
              <!-- 收货信息 -->
              <el-container id="address">
                <el-header >
                  <!-- Header content -->
                  收货信息
                </el-header>
                <el-main height="">
                  <!-- Main content -->
                  卡片地址
                </el-main>
              </el-container>
              <!-- 商品列表 -->
              <el-container id="products">
                <el-header height="">
                  <!-- Header content -->
                  商品列表
                </el-header>
                <el-main height="">
                  <!-- Main content -->
                  商品
                </el-main>
              </el-container>
            <!-- <div style="height: 1000px; background:red"></div> -->
          </el-col>
        </el-row>
      </el-main>

      <el-footer >
        <page-footer></page-footer>
      </el-footer>
    </el-container>
  </div>

</template>
<script>
import PageHeader from '../../common/components/Header'
import NavBar from '../../common/components/NavBar'
import PageFooter from '../../common/components/Footer'
import FixedHeader from '../../common/components/FixedHeader'
import BackToTop from '../../common/backtop/BackToTop'
import ShopCart from '../../common/shopcart/ShopCart'
import WeChat from '../../common/wechat/Wechat'
// import OverView from './components/OverView'
// import GoodDetails from './components/Details'

export default {
  name: 'GoodsDetails',
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
    console.log('主页创建')
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
    PageHeader: PageHeader,
    NavBar: NavBar,
    PageFooter: PageFooter,
    BackToTop: BackToTop,
    ShopCart: ShopCart,
    WeChat: WeChat,
    FixedHeader: FixedHeader
    // OverView: OverView,
    // GoodDetails: GoodDetails
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
#address .el-header {
  height: 80px;
  background: #f5f5f5;
  border-radius: 10px 10px 0px 0px;
  border-radius: 1px #dbdbdb solid
}

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

.el-main {
  position: relative
}

.el-footer {
  padding: 0px;
  height: 330px;
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
