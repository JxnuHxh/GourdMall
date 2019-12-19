<template>
  <el-container class="admin-login-wrap">
    <el-header height="">
      <!-- Header content -->
      管理员登录
    </el-header>
    <el-main  height="">
      <!-- Main content -->
      <el-row>
        <el-col :span="12"></el-col>
        <el-col :span="12"></el-col>
      </el-row>

    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'AdminLogin',
  components: {},
  data () {
    return {
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
  background: #333333;
  height: 933px;
}
.admin-login-wrap .el-main {
  background: white
}
</style>
