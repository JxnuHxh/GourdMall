<template>
  <el-row style="height: 1000px">
    <el-col :span="14" :offset="5">
      <el-container class="prod-wrap">
        <el-header height="">
          <!-- Header content -->
          操作栏
        </el-header>
        <el-main height="">
          商品列表
        </el-main>
        <el-footer height="">
          <!-- Footer content -->
          <div class="pagination">
            <el-pagination

              :page-sizes="[100, 200, 300, 400]"
              :page-size="100"
              layout="total, sizes, prev, pager, next, jumper"
              :total="400">
            </el-pagination>
          </div>
        </el-footer>

      </el-container>
    </el-col>
</el-row>
</template>

<script>
export default {
  name: 'ProductsWrap',
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
.prod-wrap {
  padding: 0px
}
.prod-wrap .el-header {
  line-height: 60px;
  height: 60px;
  background: #ededed
}
.prod-wrap .el-main {
  background: white
}
.prod-wrap .el-footer {
  background: #ededed;
  height: 80px;
  line-height: 80px;
  text-align: right
}
</style>
