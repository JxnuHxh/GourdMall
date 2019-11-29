<template>
  <el-form
    label-position="top"
    ref="registerForm"
    :rules="rules"
    :model="registerForm"
    class="login-box"
  >
    <el-form-item prop="studentNo">
      <div class="sub-title">学号(20不用输入)</div>
      <el-input v-model="registerForm.studentNo" placeholder="请输入学号">
        <template slot="prepend"
          >20</template
        >
      </el-input>
    </el-form-item>
    <el-form-item prop="studnetName">
      <el-input
        v-model="registerForm.studentName"
        placeholder="请输入学生姓名"
    ></el-input>
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

    <el-button type="warning" @click="confirmCheckCode('registerForm')">立即注册</el-button>
  </el-form>
</template>

<script>
import { sendCheckCode, confirmCheckCode } from '../../../axios/api.js'
export default {
  name: 'RegisterForm',
  data () {
    return {
      disabled: false,
      time: 0,
      btnTxt: '重新发送',
      registerForm: {
        studentNo: '',
        studentName: '',
        checkCode: ''
      },
      rules: {
        studentNo: [
          {
            required: true,
            message: '请输入手机号码',
            trigger: 'blur'
          },
          {
            validator: (rule, value, callback) => {
              const reg = 10 && /^((13|14|15|17|18|19){1}\d{8})$/
              if (!reg.test(this.registerForm.studentNo)) {
                callback(new Error('学号格式错误'))
              } else {
                callback()
              }
            }
          }
        ],
        studentName: [
          {
            required: true,
            message: '请输入学生姓名'
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
    // 发送验证码
    sendCode: function () {
      const reg = 10 && /^((13|14|15|17|18|19){1}\d{8})$/
      if (!reg.test(this.registerForm.studentNo)) {
        this.$message({
          message: '请输入正确的学号',
          center: true
        })
        return false
      } else {
        let data = {
          studentNo: this.registerForm.studentNo,
          studentName: this.registerForm.studentName
        }
        sendCheckCode(data).then(
          (result) => {
            if (!result) {
              console.log('返回了null')
              this.time = 60
              this.disabled = true
              this.timer()
            } else {
              console.log(result)
              this.$message({
                message: '发送成功，请进入教务在线的短信平台查看',
                type: 'success',
                center: true
              })
            }
          }
        )
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
    confirmCheckCode: function (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let data = {
            studentNo: '20' + this.registerForm.studentNo,
            checkCode: this.registerForm.checkCode
          }
          confirmCheckCode(data).then(
            result => {
              // console.log('result:::::' + result)
              if (result.code === 2100) {
                console.log('验证码正确')
                this.$emit('toSetPassword', data.studentNo)
              } else if (result === 'Error: timeout of 20000ms exceeded') {
                this.$message({
                  message: '发送失败，网络错误',
                  center: true
                })
              }
            }
          )
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
