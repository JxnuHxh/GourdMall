<template>
  <el-form
    label-position="top"
    ref="phoneLoginForm"
    :rules="rules"
    :model="phoneForm"
    class="login-box"
  >
    <el-form-item prop="phoneNumber">
      <el-input
        v-model="phoneForm.phoneNumber"
        placeholder="请输入手机号码"
      ></el-input>
    </el-form-item>

    <el-form-item prop="checkCode">
      <el-input
        style="width: 180px"
        v-model="phoneForm.checkCode"
        placeholder="请输入验证码"
      ></el-input>

      <el-button
        type="button"
        @click="sendCode"
        :disabled="disabled"
        vif
        v-if="disabled == false"
        >发送验证码
      </el-button>

      <el-button
        type="button"
        @click="sendCode"
        :disabled="disabled"
        v-if="disabled == true"
        >{{ btnTxt }}
      </el-button>
    </el-form-item>

    <el-button
      plain
      type="primary"
      :style="submitBtnStyl"
      @click="phoneLogin('phoneLoginForm')"
      >登录</el-button
    >
  </el-form>
</template>
<script>
export default {
  name: 'PhoneLogin',
  data () {
    return {
      disabled: false,
      time: 0,
      btnTxt: '重新发送',
      submitBtnStyl: {
        width: '300px',
        background: '#ff6700',
        color: 'white',
        marginTop: '20px'
      },
      phoneForm: {
        phoneNumber: '',
        checkCode: ''
      },
      rules: {
        phoneNumber: [
          {
            required: true,
            message: '请输入手机号码',
            trigger: 'blur'
          }
        ],
        checkCode: [
          {
            required: true,
            message: '请输入验证码',
            trigger: 'blur'
          }
        ]
      }

    }
  },
  methods: {
    // 手机发送验证码
    sendCode: function () {
      const reg = 11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/
      if (!reg.test(this.phoneForm.phoneNumber)) {
        this.$message({
          message: '请输入正确的手机号',
          center: true
        })
        return false
      } else {
        this.$message({
          message: '发送成功',
          type: 'success',
          center: true
        })
        this.time = 60
        this.disabled = true
        this.timer()
      }
    },
    // 60秒倒计时
    timer () {
      if (this.time > 0) {
        this.time--
        this.btnTxt = '重新获取(' + this.time + ')'
        setTimeout(this.timer, 1000)
      } else {
        this.time = 0
        this.btnTxt = '获取验证码'
        this.disabled = false
      }
    },
    phoneLogin: function (formName) {
      // 表单验证
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$router.push('/main')
        } else {
          return false
        }
      })
    }
  }
}
</script>
<style scoped>
.el-form {
  margin: 10px 10px;
  position: absolute;
}
.el-form-item {
  margin-top: 20px;
}
.el-button {
  width: 110px
}
</style>
