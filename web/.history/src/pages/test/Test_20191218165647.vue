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
    // 避免编程负数， 需要通过方法进行获取
    getCount () {
      // return this.$store.state.count
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
      this.$store.commit('flashToken')
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
