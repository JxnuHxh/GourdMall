<template>
  <div>
    <el-progress
      type="dashboard"
      :percentage="percentage"
      :color="colors"
      status="success"
    >
    </el-progress>
    <div>
      <h1>{{time}} 后跳转至登录界面</h1>
      <el-button type="success" plain @click="toLogin">立即登录</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'RegisterSuccess',
  data () {
    return {
      percentage: 0,
      colors: '#5cb87a',
      time: 20
    }
  },
  mounted: function () {
    this.timer()
  },
  methods: {
    increase () {
      this.percentage += 10
      if (this.percentage > 100) {
        this.percentage = 100
      }
    },
    decrease () {
      this.percentage -= 10
      if (this.percentage < 0) {
        this.percentage = 0
      }
    },
    timer: function () {
      if (this.time > 0) {
        this.time--
        this.percentage += 5
        setTimeout(this.timer, 1000)
      } else {
        this.toLogin()
      }
    },
    toLogin: function () {
      this.$router.push('/login')
    }
  }
}
</script>

<style  scoped>
</style>
