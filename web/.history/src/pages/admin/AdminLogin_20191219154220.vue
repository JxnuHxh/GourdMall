<template>
  <el-container :style="wrapStyle" class="admin-login-wrap">
    <el-main  height="">
      <!-- Main content -->
      <el-row style="margin-top: 200px;">
        <el-col :span="6" :offset="9" style="text-align: center">
          <el-row style="margin-bottom:-85px">
              <el-avatar :size="150" :src="logoUrl"> </el-avatar>
          </el-row>
          <el-card shadow="always" style="border-radius: 10px">

            <el-row>
              <el-col :span="12" :offset="6">
                <el-form
                  ref="accountLoginForm"
                  label-position="top"
                  :model="accountForm"
                  class="login-box"
                  >
                  <el-form-item prop="adminNo">
                    <el-select v-model="accountForm.adminNo" style="margin-top: 70px" size="medium" placeholder="请选择管理员账号">
                      <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                      </el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item prop="password">
                    <el-input
                      style="margin-top: 20px;"
                      placeholder="请输入密码"
                      size="medium"
                      v-model="accountForm.password"
                      show-password></el-input>
                  </el-form-item>
                </el-form>

                <el-button
                  type="primary"
                  style="margin: 50px 0px 10px"
                  @click="accountLogin('accountLoginForm')"
                  >登录</el-button>
              </el-col>
            </el-row>
          </el-card>
        </el-col>
      </el-row>

    </el-main>
  </el-container>
</template>

<script>
import WrapBg from '../../common/images/adminLoginBg.png'
import LogoUrl from '../../common/images/logo.png'
import {accountLogin} from '../../axios/api.js'
export default {
  name: 'AdminLogin',
  components: {},
  data () {
    return {
      value: '',
      accountForm: {
        adminNo: '',
        password: ''
      },
      // 表单验证
      rules: {
        password: [
          {
            required: true,
            message: '密码不可以为空',
            trigger: 'blur'
          }
        ]
      },
      options: [{
        value: 'admin',
        label: '普通管理员'
      }, {
        value: 'superAdmin',
        label: '超级管理员'
      }],
      logoUrl: LogoUrl,
      wrapStyle: {
        height: '848px',
        backgroundImage: 'url(' + WrapBg + ')',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center'
      }
    }
  },
  computed: {},
  watch: {},
  methods: {
    accountLogin: function (formName) {
      console.log(formName)
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
                      window.sessionStorage.setItem('store', JSON.stringify(this.$store.state))
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
    }
  },
  created () {
  },
  mounted () {
  }
}
</script>
<style scoped>
.admin-login-wrap {
  /* background: #333333; */
  height: 933px;
}

</style>
