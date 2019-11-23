<template>
  <el-form label-position="top" ref="bindForm" :rules="rules" :model="bindForm">
    <el-form-item prop="stunum">
      <el-input v-model="bindForm.stunum" placeholder="请输入学号"> </el-input>
    </el-form-item>

    <el-form-item prop="password">
      <el-input
        type="password"
        v-model="bindForm.password"
        placeholder="请输入密码"
      ></el-input>
    </el-form-item>
    <el-form-item prop="ckpassword">
      <el-input
        type="password"
        v-model="bindForm.ckpassword"
        placeholder="确认密码"
      ></el-input>
    </el-form-item>

    <el-button type="warning" @click="stnBind('bindForm')">立即绑定</el-button>
  </el-form>
</template>

<script>
export default {
  name: 'StnBind',
  data () {
    return {
      bindForm: {
        stunum: '',
        password: '',
        ckpassword: ''
      },
      rules: {
        stunum: [
          {
            required: true,
            message: '请输入学号',
            trigger: 'blur'
          }
        ],
        password: [
          {
            required: true,
            message: '请输入密码',
            trigger: 'blur'
          }
        ],
        ckpassword: [
          {
            required: true,
            message: '请再次输入密码',
            trigger: 'blur'
          }, {
            validator: (rule, value, callback) => {
              if (value !== this.bindForm.password) {
                callback(new Error('两次输入密码不一致'))
              } else {
                callback()
              }
            },
            trigger: 'blur'
          }

        ]
      }
    }
  },
  methods: {
    // 绑定学号
    stnBind: function (formName) {
      console.log('绑定学号')
      this.$refs[formName].validate((valid) => {
        if (valid) {
          // 后端交互
          this.$emit('StnBindSuccess')
        } else {
          return false
        }
      })
    }

    // 手机发送验证码
    // sendCode: function () {
    //   const reg = 11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/
    //   if (!reg.test(this.registerForm.phoneNumber)) {
    //     this.$message({
    //       message: '请输入正确的手机号码',
    //       center: true
    //     })
    //     return false
    //   } else {
    //     this.$message({
    //       message: '发送成功',
    //       type: 'success',
    //       center: true
    //     })
    //     this.time = 60
    //     this.disabled = true
    //     this.timer()
    //   }
    // },
    // // 倒计时
    // timer: function () {
    //   if (this.time > 0) {
    //     this.time--
    //     this.btnTxt = '重新获取(' + this.time + ')'
    //     setTimeout(this.timer, 1000)
    //   } else {
    //     this.time = 0
    //     this.btnTxt = '获取验证码'
    //     this.disabled = false
    //   }
    // }
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
