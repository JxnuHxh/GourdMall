<template>
  <el-form
    label-position="top"
    ref="registerForm"
    :rules="rules"
    :model="registerForm"
    class="login-box"
  >
    <el-form-item prop="phoneNumber">
      <div class="sub-title">手机号码</div>
      <el-input v-model="registerForm.phoneNumber" placeholder="请输入手机号码">
        <template slot="prepend"
          >+86</template
        >
      </el-input>
    </el-form-item>

    <el-form-item prop="checkCode">
      <el-input
        style="width: 178px"
        v-model="registerForm.checkCode"
        placeholder="请输入验证码"
      ></el-input>

      <el-button
        type="button"
        @click="sendCode"
        :disabled="disabled"
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

    <el-button type="warning" @click="toStnBind('registerForm')">立即注册</el-button>
  </el-form>
</template>

<script>

export default {
  name: 'RegisterForm',
  data () {
    return {
      disabled: false,
      time: 0,
      btnTxt: '重新发送',
      registerForm: {
        phoneNumber: '',
        checkCode: ''
      },
      rules: {
        phoneNumber: [
          {
            required: true,
            message: '请输入手机号码',
            trigger: 'blur'
          },
          {
            validator: (rule, value, callback) => {
              const reg = 11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/
              if (!reg.test(this.registerForm.phoneNumber)) {
                callback(new Error('手机号格式错误'))
              } else {
                callback()
              }
            }
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
      if (!reg.test(this.registerForm.phoneNumber)) {
        this.$message({
          message: '请输入正确的手机号码',
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
    // 倒计时
    timer: function () {
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
    toStnBind: function (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$emit('toStnBind')
        } else {
          return false
        }
      })
    }
  }
}
</script>

<style  scoped>
.el-form {
  width: 300px;
  margin: 0 auto;
  padding: 40px;
}
.el-button {
  width: 116px;
}
.el-button--warning {
  width: 300px;
  margin-top: 20px;
}
.el-form-item {
  margin-bottom: 20px;
}
.sub-title {
  line-height: 20px;
  font-size: 15px;
  margin-bottom: 5px;
  text-align: left;
}
</style>
