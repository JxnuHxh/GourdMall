<template>
  <div >
    <we-chat :custom-style="myBackToTopStyle" :visibility-height="1" :back-position="0" transition-name="fade"></we-chat>
    <el-backtop :bottom="90" :visibility-height="300">
    </el-backtop>
    <el-container>
      <page-header :login="login"></page-header>
      <el-main style="margin-bottom: 80px">
        <el-row style="margin-top: 30px">
          <el-col :span="14" :offset="5">
            <el-page-header @back="goBack" content="个人中心">
            </el-page-header>
          </el-col>
        </el-row>
        <el-row :gutter="30"  style="margin-top: 30px; ">
          <el-col class="left-wrap" :span="3" :offset="5">
            <el-card :body-style="{ padding: '20px 0px 0px 0px' }">
              <el-avatar :size="150"  :src="avatarUrl"></el-avatar>
              <el-row style="margin-bottom: 20px">
                <el-col>
                  <el-link :underline="false"><span id="nick-name">周鹏武</span></el-link>
                </el-col>
              </el-row>
              <el-row class="menu-item" style="padding: 0px; line-height: 60px"  v-for="(item, index) in menuLinks" :key="index">
                <el-col >
                  <div  @click="change(item.links)" :class="activeItem === item.links ? 'active' : ''">
                      <span id="nick-name">{{item.title}}</span>
                  </div>

                </el-col>
              </el-row>

            </el-card>
          </el-col>
          <el-col class="right-wrap" :span="10">
            <el-card style="border-radius: 10px;background: #f4f4f4;   border: 1px #dbdbdb solid" :body-style="{ padding: '0px', borderRadius: '10px' }">
              <order-list></order-list>
            </el-card>
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
import BackToTop from '../../common/backtop/BackToTop'
import WeChat from '../../common/wechat/Wechat'
import OrderList from './components/OrderList'

export default {
  name: 'Cart',
  data () {
    return {
      avatarUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      login: true,
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
      },
      menuLinks: [
        {
          title: '我的订单',
          links: 'orderList'
        }, {
          title: '账号资料',
          links: 'userInfo'
        }, {
          title: '收获地址',
          links: 'userAdr'
        }, {
          title: '我的特权',
          links: 'userPower'
        }, {
          title: '专属客服',
          links: 'userAssis'
        }, {
          title: '以旧换新',
          links: 'oldToNew'
        }
      ],
      activeItem: ''
    }
  },
  created () {
  },
  mounted () {
  },
  components: {
    PageHeader: PageHeader,
    NavBar: NavBar,
    PageFooter: PageFooter,
    BackToTop: BackToTop,
    WeChat: WeChat,
    OrderList: OrderList
  },
  methods: {
    change (index) {
      console.log(index)
      this.activeItem = index
    },
    order () {
      this.$router.push('/checkout')
    },

    goBack () {
      console.log('go back')
    },

    register: function () {
      this.$router.push('/register')
    },
    log: function () {
      // console.log('ssssssss')
      window.pageYOffset = 0
    }
  }
}
</script>
<style scoped>

.menu-item {
  /* background: red; */
  padding: 20px 0px;
  border-top: 1px #dbdbdb solid;
  color: #333333
}

.active {
  background: #333333;
  color: white;
}

.menu-item:hover {
  background: #333333;
  color: white;
  cursor: pointer;
}

.left-wrap {
  /* background: red; */
  text-align: center
}

.left-wrap .el-card {
  border-radius: 10px
}

.left-wrap .el-link {
  font-size: 20px;
  margin: 10px 0px
}

.right-wrap {
  /* background: #dbdbdb */
}
.el-header {
  padding: 0px;
  border:  2px #dbdbdb solid;
  line-height: 60px;
  padding-left: 30px;
  border-radius: 10px 10px 0px 0px;
  background: #f5f5f5
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

.info:hover {
  cursor: pointer;
}
</style>
