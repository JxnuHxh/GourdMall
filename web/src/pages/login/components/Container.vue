<template>
  <div class="container">
    <div :style="styleObj">
      <div class="formHeader">

        <el-row  size="small">
          <el-button type="text" :style=loginAccountBtnStyl >用户登录</el-button>
          <!-- <el-button type="text" :disabled=!show :style=loginCodeBtnStyl @click="changeLogin('wechat')">手机号登录</el-button> -->
        </el-row>
        <!-- <transition name="el-zoom-in-center" > -->
        <account-login v-show="show"></account-login>
        <!-- </transition> -->
        <!-- <transition name="el-zoom-in-center"  v-show="!show">
          <phone-login v-show="!show" ></phone-login>
        </transition> -->

      </div>
    </div>
  </div>
</template>
<script>
import loginBg from '../../../common/images/login-bg.jpg'
import FadeAnimation from '../../../common/fade/FadeAnimation'
// import PhoneLogin from '../components/PhoneLogin'
import AccountLogin from '../components/AccountLogin'
export default {
  name: 'HomeContainer',
  data () {
    return {
      show: true,
      loginBgUrl: loginBg,
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
      }
    }
  },
  components: {
    FadeAnimation: FadeAnimation,
    AccountLogin: AccountLogin
    // PhoneLogin: PhoneLogin
  },
  methods: {
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
