<template>
  <div id="app" style="height: 100%">
    <router-view/>
  </div>
</template>

<script>
import {mapActions} from 'vuex'
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
    ...mapActions({
      flashProductList: 'flashProductList'
    })
  },
  created () {
    this.flashProductList()
  },
  mounted () {
    // if (sessionStorage.getItem('store')) {
    //   this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(sessionStorage.getItem('store'))))
    // }
    // this.$store.commit('flashToken')
    // this.$store.commit('flashMessage')
    // setTimeout(() => {
    //   console.log(1111111111111111111)
    //   console.log(this.$store.getters.getMessage)
    //   window.sessionStorage.setItem('store', JSON.stringify(this.$store.state))
    //   this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(sessionStorage.getItem('store'))))
    // }, 500)
    // window.addEventListener('beforeunload', () => {
    //   window.sessionStorage.setItem('store', JSON.stringify(this.$store.state))
    // })
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
