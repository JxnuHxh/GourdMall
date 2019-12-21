<!--  -->
<template>
  <el-header style="border-radius: 0px; background: #333333">
    <el-row >
      <el-col :offset="5" :xs="24" :sm="24" :md="24" :lg="14" :xl="14"  id="nav-bar">
        <el-link :underline="false" :disabled="true">葫芦商城</el-link>
        <el-link :underline="false" ></el-link>
        <el-link :underline="false" >葫芦商城</el-link>
        <el-link :underline="false" >葫芦商城</el-link>
        <el-link :underline="false" >葫芦商城</el-link>
        <!--- 购物车 -->
        <el-popover
          placement="bottom"
          width="500"
          trigger="click" empty-text="tips">
          <el-table
          style="width: 100%"
          height="250">
          <el-table-column
            fixed
            prop="number"
            label="序号"
            width="50">
          </el-table-column>
          <el-table-column
            prop="god"
            label="商品"
            width="200">
          </el-table-column>
          <el-table-column
            prop="price"
            label="价格"
            width="120">
          </el-table-column>
          <el-table-column
            prop="action"
            label="操作"
            width="120">
          </el-table-column>
        </el-table>
          <el-link slot="reference" :underline="false" class="right-links" @click="shopCart()"> 购物车</el-link>
        </el-popover>
        <!-- 用户下拉菜单， 只在登录后才显示-->
        <el-dropdown v-if="login && this.$route.name !== 'User'" class="right-links">
          <span class="el-dropdown-link">
            {{userName}}<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu  slot="dropdown">

            <router-link style="text-decoration: none;" :to="{name:'User',params:{action:'OrderList'}}"><el-dropdown-item >  我的订单 </el-dropdown-item> </router-link>
            <router-link style="text-decoration: none;" :to="{name:'User',params:{action:'UserInfo'}}"><el-dropdown-item> 账号资料</el-dropdown-item> </router-link>
            <router-link style="text-decoration: none;" :to="{name:'User',params:{action:'UserAdr'}}"><el-dropdown-item> 收货地址</el-dropdown-item> </router-link>
            <el-dropdown-item divided  > <div @click="LogOut()"><span >退出登录</span></div>  </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <el-link v-if="!login" :underline="false" class="right-links" @click="Register()">注册</el-link>
        <el-link v-if="!login"  :underline="false" class="right-links" @click="Login()">登录</el-link>

      </el-col>
      <el-col id="user" :xs="24" :sm="24" :md="24" :lg="4" :xl="6">
      </el-col>
    </el-row>

  </el-header>
</template>

<script>
// 例如：import 《组件名称》 from '《组件路径》';
import logo from '../images/index-logo.png'
import {mapGetters} from 'vuex'
export default {
  name: 'PageHeader',
  components: {},
  data () {
    return {
      activeName: '',
      show: true,
      tips: '购物车中没有商品',
      styleLogo: {
        backgroundImage: 'url(' + logo + ')'
      }
    }
  },

  // props: ['login'],
  // 计算属性
  watch: {

  },
  computed: {
    ...mapGetters[{
      getLoginStae: 'getLoginState'
    }],
    getToken () {
      return this.$store.getters.getToken
    },
    login () {
      return this.$store.getters.getLoginState
    },
    userName () {
      return this.$store.getters.getMessage.nickname
    }

  },
  // 监控data中的数据变化
  // 方法集合
  methods: {
    handleClick (row) {
      console.log(row)
    },
    handleUser () {
      this.$router.push('/login')
    },
    Register: function () {
      this.$router.push('/register')
    },
    Login: function () {
      this.$router.push('/login')
    },
    shopCart () {
      this.$router.push('/cart')
    },
    LogOut () {
      // console.log('退出登录')
      window.sessionStorage.removeItem('token')
      window.sessionStorage.removeItem('store')

      // console.log()
      // this.$router.push('/login')
    }
  },
  // 生命周期 - 创建完成（可以访问当前this实例）
  created () {
    // let data = {
    //   pageSize: 1,
    //   pageNum: 10
    // }
    // console.log('路由：' + this.$route)
    // console.log(this.$route.name)
  },
  // 生命周期 - 挂载完成（可以访问DOM元素）
  mounted () {

  },
  beforeCreate () {}, // 生命周期 - 创建之前
  beforeMount () {}, // 生命周期 - 挂载之前
  beforeUpdate () {}, // 生命周期 - 更新之前
  updated () {}, // 生命周期 - 更新之后
  beforeDestroy () {}, // 生命周期 - 销毁之前
  destroyed () {}, // 生命周期 - 销毁完成
  activated () {
    console.log('激活状态')
  } // 如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style scoped>
#logo {
  height: 20px;
}
.el-header{
  background-color: #333333;
  width: 100%;
  height: 45px !important;
}
.el-row {
  height: 100%;
}
.el-tag{
  background-color: transparent;
  padding-top: 5px;
  border: none;
  height: 45px;
}
#nav-bar {
  height: 100%;
  line-height: 45px;
}
.el-link {
  color: #84a4b0;
  margin: 0px 10px;
}
.el-icon-s-goods {
  color: #919192;
  font-size: 20px;
  line-height: 42px;
}
#user .el-link {
    float: right;
    margin: 0px;
}
.el-button {
  padding: 16px 5px;
}
.right-links {
  float: right;
  margin-left: 20px;
}
.right-links:hover {
  color: white
}
</style>
