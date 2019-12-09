<template>
  <div>
    <el-container>
      <home-header></home-header>
      <el-header id="header-bar">
        <nav-bar></nav-bar>
        <!-- Header content -->
      </el-header>
      <el-main>
        <!-- Main content -->
        <home-container></home-container>
      </el-main>

      <el-footer >
        底部部分
      </el-footer>
    </el-container>
  </div>
</template>
<script>
import HomeHeader from './components/Header'
import NavBar from './components/NavBar'
import HomeContainer from './components/Container'
export default {
  name: 'Home',
  data () {
    return {
      searchBarFixed: false,
      componentId: ''
    }
  },
  mounted () {
    window.addEventListener('scroll', this.handleScroll)
  },
  components: {
    HomeHeader: HomeHeader,
    NavBar: NavBar,
    HomeContainer: HomeContainer
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
      let offsetTop = 45
      console.log('offsetTop:' + offsetTop)
      if (scrollTop > offsetTop) {
      } else {
      }
      console.log(this.searchBarFixed)
    }
  }
}
</script>
<style scoped>
.el-footer {
  height: 1000px !important;
}

#header-bar {
  height: 80px !important;
  background: white;
  box-shadow:0px 15px 10px -15px #ccc;
  width: 100%;
}
.el-container {
  background: #ededed;
}
#header-bar2 {
  position: fixed
}
.el-main {
  position: relative
}
</style>
