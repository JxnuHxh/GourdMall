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
  computed: {
    message () {
      this.$store.commit('flashToken')
      this.$store.commit('flashMessage')
      // console.log(this.$store.getters.getMessage)
      return this.$store.state
    }
  },
  methods: {
    reload () {
      // console.log('刷新')
      this.$store.commit('flashToken')
      this.$store.commit('flashMessage')
    }
  },
  created () {
    // if (sessionStorage.getItem('store')) {
    //   this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(sessionStorage.getItem('store'))))
    // }

  },
  mounted () {
    window.addEventListener('beforeunload', () => {
      sessionStorage.setItem('store', 1)
      console.log('定时器')
      this.$store.commit('flashToken')
      this.$store.commit('flashMessage')
      setTimeout(() => {
        console.log('定时器')
      }, 5000)
    })
  },
  destroyed () {
    // console.log('销毁了')
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
