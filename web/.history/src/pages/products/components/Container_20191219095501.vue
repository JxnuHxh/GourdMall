<template>
  <el-row>
    <el-col :span="14" :offset="5">
      <el-container class="prod-wrap">
        <el-header height="">
          <!-- Header content -->
          操作栏
        </el-header>
        <el-main height="">
          <!-- Main content -->
          <el-container>
            <el-header height="">
              <!-- Header content -->
              顶部
            </el-header>
            <el-main height="">
              <!-- Main content -->
              商品列表
            </el-main>
          </el-container>
        </el-main>
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
  background: red;
  padding: 0px
}
.prod-wrap .el-header {
  line-height: 60px;
  height: 60px;
  background: #ededed
}
</style>
