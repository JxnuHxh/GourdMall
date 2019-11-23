<template>
  <el-main type="flex" align="middle">
    <el-row type="flex" class="row-bg" justify="center" align="middle">
      <el-col :xs="24" :md="24" :lg="24" :xl="12">
        <el-container>
          <el-header>
            <div>
              <el-image :src="logoUrl"></el-image>
              <br />
              <h1>注册葫芦帐号</h1>
            </div>
          </el-header>
          <!-- // 注册进度展示 -->
          <el-header>
            <el-steps :active="step" finish-status="success" align-center>
              <el-step
                title="验证码注册"
                description="进行手机号码验证"
              ></el-step>
              <el-step title="学号绑定" description="学号绑定"></el-step>
              <el-step title="完成注册"></el-step>
            </el-steps>
          </el-header>
          <!-- // 注册注册表单 -->
          <el-main
            type="flex"
            justify="center"
            align="middle"
            style="background: white"
          >

            <transition enter-active-class="animated bounceInDown">
                <component :is="componentName" @toStnBind="toStnBind" @StnBindSuccess="toSuccess"></component>
            </transition>
          </el-main>
          <el-footer
            style="font-size: 20px; margin-bottom: 40px; color: #9db8d9"
            >已阅读并同意:
            <span style="color: #000000">葫芦用户协议</span> 和<span
              style="color: #000000"
            >
              隐私政策</span
            >
          </el-footer>
        </el-container>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
import logo from '../../../common/images/mi-logo.png'
import FadeAnimation from '../../../common/fade/FadeAnimation'
import RegisterForm from './RegisterForm'
import StnBind from './StnbindForm'
import RegisterSuccess from './ResisterSuccess'
export default {
  name: 'RegisterContainer',
  data () {
    return {
      logoUrl: logo,
      step: 0,
      show: true,
      success: false,
      componentName: RegisterForm
    }
  },
  components: {
    RegisterForm: RegisterForm,
    FadeAnimation: FadeAnimation,
    StnBind: StnBind,
    RegisterSuccess: RegisterSuccess
  },
  methods: {
    toStnBind: function () {
      this.componentName = StnBind
      this.step++
      // 进行验证
    },
    toSuccess: function () {
      this.componentName = RegisterSuccess
      this.step++
    }
  }
}
</script>

<style  scoped>
.el-main {
  background: #f9f9f9;
}
.el-row {
  padding: 0 20px;
  margin-top: 5%;
}
.el-header {
  height: auto !important;
}
/* .el-main .el-row .el-col {
  background-color: #ffffff;
  height: 600px;
} */
.el-container {
  background: white;
}
h1 {
  font-size: 30px !important;
  font-weight: 200;
}

</style>
