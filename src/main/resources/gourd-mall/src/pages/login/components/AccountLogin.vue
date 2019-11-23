<template>
  <el-form
    label-position="top"
    ref="accountLoginForm"
    :rules="rules"
    :model="accountForm"
    class="login-box"
  >
    <el-form-item prop="username">
      <el-input
        v-model="accountForm.username"
        placeholder="请输入学号"
      ></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input
        v-model="accountForm.password"
        placeholder="请输入密码"
      ></el-input>
    </el-form-item>
    <el-button
      plain
      type="primary"
      :style="submitBtnStyl"
      @click="accountLogin('accountLoginForm')"
      >登录</el-button
    >
    <el-form-item style="line-height: 14px !important">
      <el-button type="text" @click="Register()"> 立即注册</el-button
      ><label>/</label>
      <el-button type="text" @click="Forget()"> 忘记密码</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
import { getCookie } from '../../../assets/js/cookie'
import { loginTest } from '../../../axios/api.js'

export default {
  mounted () {
    if (getCookie('username')) {
      console.getCookie('username')
      this.$router.push('/register')
    } else {
      console.log('未登录')
    }
  },
  name: 'AccountLogin',
  data () {
    return {
      submitBtnStyl: {
        width: '300px',
        background: '#ff6700',
        color: 'white',
        marginTop: '20px'
      },
      accountForm: {
        username: '',
        password: ''
      },
      // 表单验证
      rules: {
        username: [
          {
            required: true,
            message: '学号不可以为空',
            trigger: 'blur'
          }
        ],
        password: [
          {
            required: true,
            message: '密码不可以为空',
            trigger: 'blur'
          }
        ]
      }
      // 对话框显示隐藏
      // dialogVisible: false
    }
  },
  methods: {
    accountLogin: function (formName) {
      // 表单验证
      this.$refs[formName].validate((valid) => {
        if (valid) {
          // this.$router.push('/main')
          this.testLogin()
        } else {
          // this.dialogVisible = true
          return false
        }
      })
    },
    Register: function () {
      this.$router.push('/register')
    },

    Forget: function () {
      console.log('打开路由：/forget')
    },
    testLogin: function () {
      let data = {
        sno: this.accountForm.password,
        sname: this.accountForm.username
      }
      // 验证
      loginTest(data).then(
        (result) => {
          console.log(result)
        }
      )
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
</style>
