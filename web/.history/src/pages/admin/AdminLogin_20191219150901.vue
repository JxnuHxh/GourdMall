<template>
  <el-container :style="wrapStyle" class="admin-login-wrap">
    <el-main  height="">
      <!-- Main content -->
      <el-row style="margin-top: 200px;">
        <el-col :span="6" :offset="9">

          <el-card shadow="always" style="text-align: center">
            <el-avatar :size="200" :src="logoUrl"> </el-avatar>
            <el-select v-model="value" size="medium" placeholder="请选择管理员账号">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-card>
        </el-col>
      </el-row>

    </el-main>
  </el-container>
</template>

<script>
import WrapBg from '../../common/images/adminLoginBg.png'
import LogoUrl from '../../common/images/logo.png'
export default {
  name: 'AdminLogin',
  components: {},
  data () {
    return {
      options: [{
        value: 'admin',
        label: '普通管理员'
      }, {
        value: 'superAdmin',
        label: '超级管理员'
      }],
      logoUrl: LogoUrl,
      wrapStyle: {
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
.admin-login-wrap .el-main .el-row .el-col{
  background: white
}
</style>
