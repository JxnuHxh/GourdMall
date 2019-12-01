<template>
  <div>
    <el-container>
      <home-header  ></home-header>
        <fixed-header id="fixed-header" :class="searchBarFixed == true ? 'isFixed' :''"></fixed-header>

      <el-footer style=" height: 10000px"></el-footer>
    </el-container>
  </div>
</template>
<script>
import HomeHeader from './components/Header'
import FixedHeader from './components/FixedHeader'
export default {
  name: 'Home',
  data () {
    return {
      show: false,
      searchBarFixed: false
    }
  },
  mounted () {
    window.addEventListener('scroll', this.handleScroll)
  },
  components: {
    HomeHeader: HomeHeader,
    FixedHeader: FixedHeader
  },
  methods: {
    login: function () {
      this.$router.push('/login')
    },
    register: function () {
      this.$router.push('/register')
    },
    handleScroll: function () {
      let scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
      console.log('scrollTop:' + scrollTop)
      let offsetTop = document.querySelector('#fixed-header').offsetTop + 1000
      console.log('offsetTop:' + offsetTop)
      if (scrollTop > offsetTop) {
        this.show = true
        this.searchBarFixed = true
      } else {
        this.searchBarFixed = false
        this.show = false
      }
      console.log(this.searchBarFixed)
    }
  }
}
</script>
<style scoped>
.isFixed{
    position:fixed;
    background-color:#ffffff;
    top:0;
    z-index:999;
  }
</style>
