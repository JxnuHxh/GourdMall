<template>
  <div>
    <div>
      test...
      {{ msg }}<br/>
    </div>

    <div>
      获取值 --
      <!-- {{ getCount }} -->
      <p> {{getToken}} </p>
      <p> {{getUserMessage}} </p>
      <p> {{getCategories}} </p>
    <br/>
    </div>
    <el-button @click="flashToken">刷新Token</el-button>
    <el-button @click="getUserMsg">获取用户信息</el-button>
    <el-button @click="flshCategories">刷新分类信息</el-button>
  </div>
</template>

<script>
export default {
  name: 'Test',
  data () {
    return {
      msg: 'hello'
    }
  },
  created () {
  },
  computed: {
    getCount () {
      return this.$store.getters.getCategorie
    },
    getToken () {
      return this.$store.getters.getToken
    },
    getUserMessage () {
      return this.$store.getters.getMessage
    },
    getCategories () {
      return this.$store.getters.getCategories
    }
  },
  methods: {
    flashToken () {
      this.$store.commit('flashToken')
    },
    getUserMsg () {
      this.$store.commit('flashMessage')
      // window.sessionStorage.setItem('store', JSON.stringify(this.$store.state))
      // console.log(this.$store.getters.getMessage)
    },
    flshCategories () {
      this.$store.commit('flashCategories')
    }
  }
}
</script>

<style scoped>

</style>
