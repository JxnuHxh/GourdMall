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

                  <el-row :gutter="15" v-for="(item,index) in ((Address.addresses.length) % 4 + 1)" v-bind:key="index">
                    <el-col :span="6" v-for="(cardItem,cardIndex) in 4" v-bind:key="cardIndex">
                      <div v-if="(((index * 4) + cardIndex) < (Address.addresses.length))">
                        <!-- {{Address.addresses[(index * 4) + cardIndex].name}} -->
                        <adr-card
                          @checked="change"
                          :checked="Address.default === ((index * 4) + cardIndex)"
                          :index="((index * 4) + cardIndex)"
                          :adr="Address.addresses[(index * 4) + cardIndex]"
                          ></adr-card>
                      </div>
                      <!-- {{Address.addresses[0].name}} -->
                      <div v-else-if="(((index * 4) + cardIndex) === (Address.addresses.length))">
                        <div id="new-card" >
                          添加新地址
                        </div>
                      </div>
                    </el-col>
                  </el-row>
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
import AdrCard from './components/AdrCard'
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
      },
      Address: {
        total: 10,
        default: 2,
        addresses: [
          {
            name: '周鹏武0',
            address: '江西师范大学',
            phone: '123456789'
          },
          {
            name: '周鹏武1',
            address: '江西师范大学',
            phone: '123456789'
          },
          {
            name: '周鹏武2',
            address: '江西师范大学',
            phone: '123456789'
          },
          {
            name: '周鹏武3',
            address: '江西师范大学',
            phone: '123456789'
          },
          {
            name: '周鹏武4',
            address: '江西师范大学',
            phone: '123456789'
          },
          {
            name: '周鹏武5',
            address: '江西师范大学',
            phone: '123456789'
          },
          {
            name: '周鹏武6',
            address: '江西师范大学',
            phone: '123456789'
          },
          {
            name: '周鹏武7',
            address: '江西师范大学',
            phone: '123456789'
          },
          {
            name: '周鹏武8',
            address: '江西师范大学',
            phone: '123456789'
          },
          {
            name: '周鹏武9',
            address: '江西师范大学',
            phone: '123456789'
          }

        ]
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
    FixedHeader: FixedHeader,
    AdrCard: AdrCard
    // OverView: OverView,
    // GoodDetails: GoodDetails
  },
  methods: {
    change (index) {
      console.log(index)
      this.Address.default = index
    },
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

#new-card {
  height: 150px;
  background: #dbdbdb;
  border-radius: 10px;
  padding: 2px 20px;
  line-height: 150px;
  text-align: center;
  border: 1px #626262 solid
}

#new-card:hover {
  background: white;
  border: 1px #626262 solid
}

#address .el-header {
  background: #f5f5f5;
  border-radius: 10px 10px 0px 0px;
  border: 1px #dbdbdb solid;
  line-height: 60px;
  padding-left: 20px;
  font-size: 18px;
  color: #626262
}

#products .el-header {
  background: #f5f5f5;
  border-radius: 10px 10px 0px 0px;
  border: 1px #dbdbdb solid;
  line-height: 60px;
  padding-left: 20px;
  font-size: 18px;
  color: #626262
}

#address .el-main {
  background: white;
  border: 1px #dbdbdb solid;
  border-radius: 0px 0px 10px 10px;
  padding: 20px 20px
}

#address .el-main .el-row {
  margin-top: 10px
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
