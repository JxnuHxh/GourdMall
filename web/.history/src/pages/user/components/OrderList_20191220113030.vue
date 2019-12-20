<template>
  <el-container id="order-list-wrap">
    <el-header height="">
      <!-- Header content -->
      我的订单
    </el-header>
    <el-main height="">
      <!-- Main content -->
      <el-row style="text-align: center">
        <el-col :span="2">时间</el-col>
        <el-col :span="4">订单号</el-col>
        <el-col :span="2">单价</el-col>
        <el-col :span="2">数量</el-col>
        <el-col :span="4">商品操作</el-col>
        <el-col :span="4">实付金额</el-col>
        <el-col :span="2">查看详情</el-col>
      </el-row>
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
  height: 70px;
  line-height: 70px;
  font-size: 19px;
  padding-left: 40px
}

#order-list-wrap .el-main {
  background: #ffffff
}
</style>
