<template>
  <el-container id="order-list-wrap">
    <el-header height="">
      <!-- Header content -->
      我的订单
    </el-header>
    <el-main height="" style="padding: 0px" v-for="item in 10" :key="item">
      <!-- Main content -->
      <el-row   class="order-header" >
        <el-col  :span="2">时间</el-col>
        <el-col :span="6">订单号</el-col>
        <el-col :span="4">单价</el-col>
        <el-col :span="2">数量</el-col>
        <el-col :span="4" style="border-right: 2px #dbdbdb solid">商品操作</el-col>
        <el-col :span="3">实付金额</el-col>
        <el-col :span="3">查看详情</el-col>
      </el-row>
      <el-row class="order-main" >
        <el-col :span="18">
          <el-row class="prod-wrap">
            <el-col :span="11" style="text-align: left;">
                <el-avatar :src="avatarUrl" class="prod-avatar" style="margin:0px 20px -15px 20px;"></el-avatar>
              <el-link :underline="false"><span>商品信息</span></el-link>
            </el-col>
            <el-col :span="5">
              ￥100.00
            </el-col>
            <el-col :span="3">
              1
            </el-col>
            <el-col :span="5" style="border-right: 2px #dbdbdb solid"><el-button type="danger">删除订单</el-button></el-col>
          </el-row>
          <el-row class="prod-wrap">
            <el-col :span="11" style="text-align: left;">
                <el-avatar :src="avatarUrl" class="prod-avatar" style="margin:0px 20px -15px 20px;"></el-avatar>
              <el-link :underline="false"><span>商品信息</span></el-link>
            </el-col>
            <el-col :span="5">
              ￥100.00
            </el-col>
            <el-col :span="3">
              1
            </el-col>
            <el-col :span="5" style="border-right: 2px #dbdbdb solid"><el-button type="danger">删除订单</el-button></el-col>
          </el-row>
          <el-row class="prod-wrap">
            <el-col :span="11" style="text-align: left;">
                <el-avatar :src="avatarUrl" class="prod-avatar" style="margin:0px 20px -15px 20px;"></el-avatar>
              <el-link :underline="false"><span>商品信息</span></el-link>
            </el-col>
            <el-col :span="5">
              ￥100.00
            </el-col>
            <el-col :span="3">
              1
            </el-col>
            <el-col :span="5" style="border-right: 2px #dbdbdb solid"><el-button type="danger">删除订单</el-button></el-col>
          </el-row>
          <el-row class="prod-wrap">
            <el-col :span="11" style="text-align: left;">
                <el-avatar :src="avatarUrl" class="prod-avatar" style="margin:0px 20px -15px 20px;"></el-avatar>
              <el-link :underline="false"><span>商品信息</span></el-link>
            </el-col>
            <el-col :span="5">
              ￥100.00
            </el-col>
            <el-col :span="3">
              1
            </el-col>
            <el-col :span="5" style="border-right: 2px #dbdbdb solid"><el-button type="danger">删除订单</el-button></el-col>
          </el-row>
        </el-col>
        <el-col :span="3">￥2000</el-col>
        <el-col :span="3"><el-button type="primary" size="mini" round >现在付款</el-button></el-col>
      </el-row>
    </el-main>
    <el-footer>
      <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage4"
      :page-sizes="[100, 200, 300, 400]"
      :page-size="100"
      layout="total, sizes, prev, pager, next, jumper"
      :total="400">
      </el-pagination>
    </el-footer>
  </el-container>
</template>

<script>
export default {
  name: 'OrderList',
  components: {},
  data () {
    return {
      avatarUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
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
