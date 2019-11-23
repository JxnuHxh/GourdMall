<template>
  <div class="container">
    <div :style="styleObj">
      <div class="formHeader">

        <el-row  size="small">
          <el-button type="text" :disabled=show :style=loginAccountBtnStyl @click="changeLogin('account')">学号登录</el-button><label style="font-size: 24px; color: #e0e0e0">|</label>
          <el-button type="text" :disabled=!show :style=loginCodeBtnStyl @click="changeLogin('wechat')">手机号登录</el-button>
        </el-row>
        <transition name="el-zoom-in-center" >
          <account-login v-show="show"></account-login>
        </transition>
        <transition name="el-zoom-in-center"  v-show="!show">
          <phone-login v-show="!show" ></phone-login>
        </transition>

      </div>
    </div>
  </div>
</template>
<script>
import loginBg from '../../../common/images/login-bg.jpg'
import FadeAnimation from '../../../common/fade/FadeAnimation'
import PhoneLogin from '../components/PhoneLogin'
import AccountLogin from '../components/AccountLogin'
export default {
  name: 'HomeContainer',
  data () {
    return {
      active: true,
      value2: true,
      show: true,
      loginType: AccountLogin,
      loginBgUrl: loginBg,
      animationIn: 'animated flipInY',
      animationOut: 'animated flipOutY',
      styleObj: {
        height: '588px',
        width: '100%',
        backgroundImage: 'url(' + loginBg + ')',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center'
      },
      loginAccountBtnStyl: {
        fontSize: '24px',
        marginRight: '25px'

      },
      loginCodeBtnStyl: {
        fontSize: '24px',
        marginLeft: '25px'
      }
    }
  },
  components: {
    FadeAnimation: FadeAnimation,
    AccountLogin: AccountLogin,
    PhoneLogin: PhoneLogin
  },
  methods: {
    changeLogin: function (type) {
      this.show = !this.show
    }

  }
}
</script>
<style scoped>
.container {
  width: 100%;
  height: 100%;
  overflow: hidden;
  text-align: center;
}
.el-image {
  height: inherit;
}
.formHeader{
  background: white;
  width: 320px; height:
  526px;
  padding: 27px 20px 0px;
  float: right;
  margin-right: 430px;
  margin-top: 35px
}
</style>
