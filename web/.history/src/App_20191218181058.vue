<template>
  <div id="app" style="height: 100%">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  provide () {
    return {
      reload: this.reload
    }
  },
  data () {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload () {
      console.log('刷新')
      this.$store.commit('flashToken')
      this.$store.commit('flashMessage')
    },
    saveState () {
      console.log('刷新')
      this.$store.commit('flashToken')
      this.$store.commit('flashMessage')
      sessionStorage.setItem('state', JSON.stringify(this.$store.state))
    }
  },
  created () {
    // 在页面加载时读取sessionStorage里的状态信息
    if (sessionStorage.getItem('state')) {
      this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(window.sessionStorage.getItem('store'))))
    }

    // 在页面刷新时将vuex里的信息保存到sessionStorage里
    window.addEventListener('beforeunload', this.saveState)
  }
}
</script>
<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
