<template>
  <el-form label-position="top" ref="bindForm" :rules="rules" :model="bindForm">
    <el-form-item prop="studentNo">
      <el-input v-model="bindForm.studentNo" :disabled="true"> </el-input>
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

    <el-button type="warning" @click="setPassword('bindForm')">立即绑定</el-button>
  </el-form>
</template>

<script>
import { setPassword } from '../../../axios/api.js'
export default {
  name: 'SetPassword',
  props: [
    'studentNo'
  ],
  data () {
    return {
      bindForm: {
        studentNo: '',
        password: '',
        ckpassword: ''
      },
      rules: {
        studentNo: [
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
  created () {
    this.bindForm.studentNo = this.studentNo
  },
  methods: {
    // 绑定学号
    setPassword: function (formName) {
      console.log('设置密码')
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let data = {
            studentNo: this.bindForm.studentNo,
            password: this.bindForm.password
          }
          setPassword(data).then(
            (result) => {
              console.info(result)
              if (result.code === 2200) {
                this.$message.success('设置密码成功')
                this.$emit('setPasswordSuccess')
              } else {
                this.$message.error('设置密码失败，请重新设置')
              }
            }
          )
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
