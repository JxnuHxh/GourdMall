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
      sessionStorage.setItem('state', JSON.stringify(this.$store.state))
    }
  },
  created () {
    // 在页面加载时读取sessionStorage里的状态信息
    console.log('加载页面')
    if (window.sessionStorage.getItem('state')) {
      console.log('存在记录')
      this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(window.sessionStorage.getItem('state'))))
      console.log(this.$store.getters.getToken)
      // 在页面刷新时将vuex里的信息保存到sessionStorage里
      window.addEventListener('beforeunload', this.saveState)
    } else {
      console.log('第一次启动')
    }
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
