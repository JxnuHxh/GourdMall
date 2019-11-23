<template>
  <el-container>
    <el-header type="flex" justify="center">
      <home-header></home-header>
    </el-header>
    <el-main>
      <home-container></home-container>
    </el-main>
  </el-container>
</template>
<script>
import HomeHeader from './components/Header'
import HomeContainer from './components/Container'

export default {
  name: 'Login',
  data () {
    return {

    }
  },
  components: {
    HomeHeader: HomeHeader,
    HomeContainer: HomeContainer
  }
}
</script>

<style scoped>
.el-container {
  height: 100%;
}
.el-header {
  height: 98px !important;
  width: 100%;
}
.el-main {
  width: 100% !important;
  /* background: red; */
  padding: 0 !important;
  height: 100%;
}
</style>
