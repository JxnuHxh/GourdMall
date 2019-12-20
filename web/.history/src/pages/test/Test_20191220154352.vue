<template>
  <div>
    <div>
      test...
      {{ msg }}<br/>
    </div>

    <div>
      获取值 --
      <!-- {{ getCount }} -->
      <p> {{getName}} </p>
      <p> {{getUserMessage}} </p>
      <p> {{categories}} </p>
      <p> {{getCate}}</p>
    <br/>
    </div>
    <el-button @click="flashToken">刷新Token</el-button>
    <el-button @click="getUserMsg">获取用户信息</el-button>
    <el-button @click="SET_CATE('111111')">同步刷新分类信息</el-button>
    <el-button @click="fetchCate()">异步刷新分类信息</el-button>
  </div>
</template>

<script>
import {mapGetters, mapMutations, mapActions} from 'vuex'
export default {
  name: 'Test',
  data () {
    return {
      msg: 'hello'
    }
  },
  created () {
  },
  computed: mapGetters(['getCate']),

  // computed: {
  //   getCount () {
  //     return this.$store.getters.getCategorie
  //   },
  //   getName () {
  //     return this.$store.getters.getName
  //   },
  //   getToken () {
  //     return this.$store.getters.getToken
  //   },
  //   getUserMessage () {
  //     return this.$store.getters.getMessage
  //   }
  // },
  methods: {
    ...mapMutations(['SET_CATE']),
    // 获取store内异步方法
    ...mapActions(['fetchCate']),
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
