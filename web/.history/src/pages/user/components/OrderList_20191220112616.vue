<template>
  <el-container id="order-list-wrap">
    <el-header height="">
      <!-- Header content -->
      我的订单
    </el-header>
    <el-main height="">
      <!-- Main content -->
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'OrderList',
  components: {},
  data () {
    return {
    }
  },
  computed: {},
  watch: {},
  methods: {
  },
  created () {
  },
  mounted () {
  }
}
</script>
<style scoped>
#order-list-wrap {
  background: white;
  background: #f4f4f4;
}

#order-list-wrap .el-header {
  background: #f0f0f0;
  height: 80px;
  line-height: 80px;
  font-size: 19px;
  font-weight: bolder
}

#order-list-wrap .el-main {
  background: #ffffff
}
</style>
