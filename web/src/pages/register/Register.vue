<template>
  <el-container style="width: 100%; height: 100%;">
    <register-container></register-container>
  </el-container>
</template>
<script>
import RegisterContainer from './components/Container'

export default {
  name: 'Register',

  components: {
    RegisterContainer: RegisterContainer
  }
}
</script>
<style  scoped>

</style>
