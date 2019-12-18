<template>
  <div>
    <div>
      test...
      {{ msg }}<br/>
    </div>

    <div>
      获取值 --
      <!-- {{ getCount }} -->
      <!-- <p> {{getToken}} </p> -->
      <p> {{getUserMessage}} </p>
    <br/>
      <button @click="add">inc</button>
      <button @click="des">decri</button>
    </div>

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
      return this.$store.getters.getUserMessage
    }
  },
  methods: {
    add () {
      // this.$store.commit('increment')
      this.$store.commit('getCategorie')
    },
    des () {
      // 使用 action中的异步方法
      this.$store.dispatch('decrement')
    }
  }
}
</script>

<style scoped>

</style>
