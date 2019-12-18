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
    <el-button @click="flash">刷新Token</el-button>
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
    flash () {
      console.log('刷新Token')
      this.$store.commit('flashToken')
      console.log(this.$store.getters.getToken)
    },
    getUserMsg () {
      this.$store.commit('flashMessage')
    },
    flshCategories () {
      this.$store.commit('flashCategories')
    }
  }
}
</script>

<style scoped>

</style>
