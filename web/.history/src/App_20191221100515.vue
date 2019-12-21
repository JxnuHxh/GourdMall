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
    // message () {
    //   this.$store.commit('flashToken')
    //   this.$store.commit('flashMessage')
    //   // console.log(this.$store.getters.getMessage)
    //   return this.$store.state
    // }
  },
  methods: {
    ...mapActions({
      flashProductList: 'flashProductList'
    }),
    saveState () {
      sessionStorage.setItem('state', JSON.stringify(this.$store.state))
    }
  },
  created () {
    this.flashProductList({cid: 1, pageNum: 1, pageSize: 10})
  },
  mounted () {
    window.addEventListener('unload', this.saveState)
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
