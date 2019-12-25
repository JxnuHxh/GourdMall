<template>
  <div id="nav-container" @mouseleave="navleave()">
    <el-row :gutter="20">
      <el-col :span="14"  :offset="5">
        <div id="nav-bar-links">
          <el-link :underline="false" :disabled = true>首页</el-link>
          <el-link :underline="false" ><div @mouseenter="naventer('手机')"> 手机</div></el-link>
          <el-link :underline="false"><div @mouseenter="naventer('电脑')"> 电脑</div></el-link>
          <el-link :underline="false"><div @mouseenter="naventer('家具')"> 家具</div></el-link>
          <el-link :underline="false"><div @mouseenter="naventer('服饰')"> 服饰</div></el-link>
          <el-link id="right-part" :underline="false">
            <el-dropdown v-if="login" class="right-links">
              <span class="el-dropdown-link">
                周鹏武 <i class="el-icon-arrow-down el-icon--right"></i>
              </span>
              <el-dropdown-menu  slot="dropdown" style="margin-top: -15px">
                <el-dropdown-item> 我的订单</el-dropdown-item>
                <el-dropdown-item> 账号资料</el-dropdown-item>
                <el-dropdown-item> 收货地址</el-dropdown-item>
                <el-dropdown-item divided> 退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
            <el-link v-if="!login" :underline="false" class="right-links" >注册</el-link>
            <!-- <el-divider direction="vertical"></el-divider> -->
            <el-link v-if="!login"  :underline="false" class="right-links" >登录</el-link>
          </el-link >
        </div>
      </el-col>
    </el-row>
    <fade-animation :fadeIn="fadein" :fadeOut="fadeon">
      <el-row id="float-bar" v-show="in_nav">
        <el-col :span="2" :offset="5">
          <el-card :body-style="{ padding: '0px' }" shadow="never">
            <el-image src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"></el-image>
          </el-card>
          <span class="price">￥1234</span>
        </el-col>
        <el-col :span="2" >
          <el-card :body-style="{ padding: '0px' }" shadow="never">
            <el-image src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"></el-image>
          </el-card>
          <span class="price">{{item}}</span>
        </el-col>
        <el-col :span="2" >
        </el-col>
        <el-col :span="2" >
        </el-col>
        <el-col :span="2" >
        </el-col>
        <el-col :span="2">
        </el-col>
        <el-col :span="2" >
        </el-col>
      </el-row>
    </fade-animation>
  </div>
</template>

<script>
import FadeAnimation from '../fade/FadeAnimation'
import {mapGetters} from 'vuex'
export default {
  name: 'FixedHeader',
  components: {
    FadeAnimation: FadeAnimation
  },
  data () {
    return {
      loin: true,
      search: '',
      in_nav: false,
      in_bar: false,
      fadein: 'animated fadeIn',
      fadeon: 'animated zoomOut',
      item: '',
      src: 'https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png'
    }
  },
  computed: {
    ...mapGetters({
      getCate: 'getCate',
      getLoginState: 'getLoginState'
    })
  },
  watch: {},
  methods: {
    showFloat: function () {
      console.log('显示')
    },
    naventer: function (type) {
      this.item = type
      this.in_nav = true
    },
    navleave: function () {
      this.in_nav = false
    },
    click: function () {
      this.float_show = !this.float_show
    }
  },
  created () {
  },
  mounted () {
  }
}
</script>
<style scoped>
#nav-container {
  height: 100%;
  line-height: 80px;
  vertical-align: middle;
  box-shadow: 5px 5px 10px #888888;
}
.el-input {
  width: 300px;
  float: right;
  margin-top: 20px;
}
.el-input .el-input__inner {
    border-radius: 15px !important;
}
.el-link {
  margin: 0px 40px 0px 10px;
  font-size: 20px;
  font-weight: 100;
}
#float-bar {
  width: 100%;
  height: 300px;
  background: white;
  z-index: 20;
  position: absolute;
  /* margin-left: -20px; */
  margin-top: -11px;
  border-top: 1px #c1c1c1 solid;
  align-content: center;
  text-align: center
}
#float-bar .el-card {
  float: center;
  height: 210px;
  margin: 35px 10px -15px 5px;
}
#float-bar .el-image {
  margin: 10px 5px;
}
#float-bar .price {
  color: red
}
#right-part {
  /* background: #c1c1c1; */
  height: 50px !important;
  font-size: 12px;
  margin-left: 400px;
  text-align: center
}
#right-part .el-link {
  margin: 0px;
  /* color: white; */
    color: #437ba4;
}
</style>
