<template>
  <div>
    <el-button @click="login()">登录</el-button>
    <el-button @click="register()">注册</el-button>
  </div>
</template>
<script>
export default {
  name: 'Home',
  data () {
    return {

    }
  },
  methods: {
    login: function () {
      this.$router.push('/login')
    },
    register: function () {
      this.$router.push('/register')
    }
  }
}
</script>
<style scoped>

</style>
