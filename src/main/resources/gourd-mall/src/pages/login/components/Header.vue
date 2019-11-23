<template>
  <div class="header">
    <el-image :src="logoUrl"></el-image>
  </div>
</template>
<script>
import logo from '../../../common/images/mistore_logo.png'

export default {
  name: 'HomeHeader',
  data () {
    return {
      logoUrl: logo
    }
  }
}
</script>
<style scoped>
.header {
  width: 60%;
  height: 100%;
  margin: 0 auto;
}
.img {
  width: 200px;
  height: 98px;
}
</style>
