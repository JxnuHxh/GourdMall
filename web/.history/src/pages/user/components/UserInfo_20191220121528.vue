<template>
  <el-container id="order-list-wrap">
    <el-header height="">
      <!-- Header content -->
      我的订单
    </el-header>
  </el-container>
</template>

<script>
export default {
  name: 'UserInfo',
  components: {},
  data () {
    return {
      avatarUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    }
  },
  computed: {},
  watch: {},
  methods: {
    handleSizeChange (val) {
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange (val) {
      console.log(`当前页: ${val}`)
    }
  },
  created () {
  },
  mounted () {
  }
}
</script>
<style scoped>

.prod-wrap {
  border-bottom: 1px #dbdbdb solid;
  border-top: 1px #dbdbdb solid
}

.order-main {
  text-align: center;
  height: 80px;
  line-height: 80px;
  background: #f3f3f3
}

.order-main .el-col {
  background: #f3f3f3
}

.order-header {
  height: 40px;
  line-height: 40px
}

.order-header .el-col {
  text-align: center
}

#order-list-wrap {
  background: white;
  background: #f4f4f4;
}

#order-list-wrap .el-header {
  background: #f0f0f0;
  height: 70px;
  line-height: 70px;
  font-size: 19px;
  padding-left: 40px
}

#order-list-wrap .el-main {
  background: #ffffff
}
</style>
