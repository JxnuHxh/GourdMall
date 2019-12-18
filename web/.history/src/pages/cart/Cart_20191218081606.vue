<template>
  <div >
    <we-chat :custom-style="myBackToTopStyle" :visibility-height="1" :back-position="0" transition-name="fade"></we-chat>
    <el-backtop :bottom="90" :visibility-height="300">
    </el-backtop>
    <el-container>
      <page-header :login="login"></page-header>
      <el-main>
        <el-row>
          <el-col :span="14" :offset="5">
            <!-- 商品列表 -->
            <!-- 购物车不空展示 -->
            <el-container class="cart-wrap" v-if="products.total !== 0">
              <el-header>
                购物清单
              </el-header>
              <el-main style="padding: 0px">
                <el-row id="wrap-header">
                  <el-col :span="8">商品信息</el-col>
                  <el-col :span="5">单价</el-col>
                  <el-col :span="5">数量</el-col>
                  <el-col :span="3">小计</el-col>
                  <el-col :span="3">操作</el-col>
                </el-row>
                <div id="wrap-container">
                <el-row class="good">
                  <el-col :span="8">商品信息</el-col>
                  <el-col :span="5">单价</el-col>
                  <el-col :span="5">
                    <div class="change-nums">
                      <change-num
                        :nextNum=1
                        :maxNum=100
                        :miniNum = 1
                      ></change-num>
                    </div>

                  </el-col>
                  <el-col :span="3">小计</el-col>
                  <el-col :span="3">
                    <el-button>
                      删除
                    </el-button>

                  </el-col>
                </el-row>
                </div>
              </el-main>
              <el-main style="padding: 0px">

              </el-main>
              <el-footer class="cart-footer">
                <el-row id="wrap-footer">
                  <el-col :span="8">
                    <input type="checkbox" > <span class="chooseAll">全选</span>
                    <span style="font-size: 14px; color: #bbbbbb" @click="delChecked()">删除选择的商品</span>
                  </el-col>
                  <el-col :span="7">已选中件商品</el-col>
                  <el-col :span="4">共￥元</el-col>
                  <el-col :span="5">
                      <el-button type="primary">立即下单</el-button>
                  </el-col>
                </el-row>
              </el-footer>
            </el-container>
            <!-- 空购物车展示 -->
            <el-container class="cart-wrap" v-else>
              <el-header>
                空购物车
              </el-header>
              <el-main style="background: white">
                <el-row :style="cartStyle">
                  <el-col :span="24"></el-col>
                </el-row>

                <img :src="imgUrl" alt="">
                图片
              </el-main>
            </el-container>
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
import WeChat from '../../common/wechat/Wechat'
import ChangeNum from '../../common/changenum/ChangeNum'
import CartEmpty from '../../common/images/cart-empty.png'

export default {
  name: 'Cart',
  data () {
    return {
      imgUrl: CartEmpty,
      cartStyle: {
        backgroundImage: 'url(' + CartEmpty + ')',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center',
        width: '500px'
      },
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      products: {
        total: 0,
        sum: 700,
        goods: [
          {
            name: '周鹏武',
            price: 100,
            total: 1,
            imgUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
            checked: false
          },
          {
            name: '黄小华',
            price: 200,
            total: 1,
            imgUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
            checked: true
          },
          {
            name: '黄小华1',
            price: 200,
            total: 1,
            imgUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
            checked: true
          },
          {
            name: '黄小华2',
            price: 200,
            total: 1,
            imgUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
            checked: true
          }
        ]
      },
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
    WeChat: WeChat,
    FixedHeader: FixedHeader,
    ChangeNum: ChangeNum
  },
  methods: {
    product () {
      this.$router.push('/goodsdetails')
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

.change-nums{
  margin-top: 40px !important;
  margin-left: 53px
}

.cart-wrap {
  background: #ededed;
  border-radius: 0px 0px 10px 10px;
}
#wrap-header {
  /* background: red; */
  height: 30px !important;
  line-height: 30px;
  border:  2px #dbdbdb solid;
  border-top: 0px;
  /* padding-left: 10px */
}

#wrap-header .el-col {
  /* border-right: 2px #dbdbdb solid; */
  color: #9c9c9c;
  text-align: center
}

#wrap-container {
  background: white;
  text-align: center;
}

#wrap-container .el-row{
  height: 140px;
  line-height: 140px;
}

.cart-footer {
  line-height: 60px;
  border-radius: 0px 0px 10px 10px;
  padding: 0px;
  /* background: red */
}

#wrap-footer {
  border-radius: 0px 0px 10px 10px;
  border:  1px #dbdbdb solid;

}
#wrap-footer .el-col {
  text-align: center;

}
p {
  max-width: 100%;
  overflow:hidden;
  text-overflow:ellipsis;
  /*禁止换行显示*/
  white-space:nowrap;
  /* background-color:#ffe51a; */
  margin: 0px;
}

#products-wrap .el-header {
  background: #f5f5f5;
  border-radius: 10px 10px 0px 0px;
  border: 1px #dbdbdb solid;
  line-height: 60px;
  padding-left: 20px;
  font-size: 18px;
  color: #626262;
  margin-top: 40px
}

#products-wrap .el-main {
  background: white;
  border: 1px #dbdbdb solid;
  border-radius: 0px 0px 10px 10px;
  /* padding: 20px 20px */
}

#products {
  padding: 0px;
  margin-bottom: 60px;
}

#products .header {
  background: #eeeeee;
  height: 30px;
  line-height: 30px;
  color: #9c9c9c
}

#products .header .el-col {
  text-align: center;
  border: 11px 0px #dbdbdb solid;
}

#products .container {
  height: 140px;
  line-height: 140px;
  text-align: center;
  border: 1px #dbdbdb solid
}

#products .container .info {
  /* background: red; */
  height: 80px;
  margin: 30px 60px;
  text-align: left;
  vertical-align: middle;
  line-height: 80px;

}

#products .footer {
  color: #9c9c9c;
  background: #eeeeee;
}

#products .footer .el-col {
  text-align: center;
  border: 11px 0px #dbdbdb solid;
  height: 60px;
  margin-top: -6px
}

#btn-pay {
  margin-left: 30px
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
