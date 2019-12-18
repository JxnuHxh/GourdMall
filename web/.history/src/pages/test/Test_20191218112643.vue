<template>
  <div>
    <div>
      test...
      {{ msg }}<br/>
    </div>

    <div>
      获取值 --
      {{ getCount }}
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
      return this.$store.getters.getState
    }
  },
  methods: {
    add () {
      this.$store.commit('increment')
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
