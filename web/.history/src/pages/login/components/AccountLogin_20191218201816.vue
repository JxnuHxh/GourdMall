<template>
  <el-form
    label-position="top"
    ref="accountLoginForm"
    :rules="rules"
    :model="accountForm"
    class="login-box"
  >
    <el-form-item prop="studentNo">
      <el-input
        v-model="accountForm.studentNo"
        placeholder="请输入学号"
      >
      <template slot="prepend"
          >20</template
        >
      </el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input
        v-model="accountForm.password"
        type="password"
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
import { accountLogin } from '../../../axios/api.js'

export default {
  mounted () {
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
        studentNo: '',
        password: ''
      },
      // 表单验证
      rules: {
        studentNo: [
          {
            required: true,
            message: '学号不可以为空',
            trigger: 'blur'
          },
          {
            validator: (rule, value, callback) => {
              const reg = 10 && /^((13|14|15|17|18|19){1}\d{8})$/
              if (!reg.test(this.accountForm.studentNo)) {
                callback(new Error('学号格式错误'))
              } else {
                callback()
              }
            }
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
          let data = {
            studentNo: '20' + this.accountForm.studentNo,
            password: this.accountForm.password
          }
          accountLogin(data).then(
            (result) => {
              if (result) {
                switch (result.code) {
                  // 登录成功
                  case 2300: {
                    this.$message({
                      message: '登录成功',
                      type: 'success'
                    })
                    window.sessionStorage.setItem('token', result.data.token)
                    this.$store.commit('flashToken')
                    this.$store.commit('flashMessage')
                    setTimeout(() => {
                      console.log('定时器')
                      window.sessionStorage.setItem('store', this.$store.state)
                    }, 500)
                    this.$router.push('/')
                    break
                  }
                  case 4300: {
                    this.$message({
                      message: '账号或者密码错误',
                      type: 'error'
                    })
                    break
                  }
                  case 4400: {
                    this.$message({
                      message: '该用户不存在',
                      type: 'info'
                    })
                    break
                  }
                };
              }
            }
          )
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
