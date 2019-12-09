<template>
  <div id="nav-container">
    <el-row :gutter="20">
      <el-col :span="14" :offset="5">
        <el-link :underline="false">首页</el-link>
        <el-link :underline="false">类别一</el-link>
        <el-link :underline="false">类别二</el-link>
        <el-link :underline="false">类别三</el-link>
        <el-link :underline="false">类别四</el-link>
        <el-input placeholder="请输入内容" v-model="search" class="inline-input">
          <template slot="append">
            <el-button slot="append" icon="el-icon-search">
          </el-button></template>
        </el-input>
      </el-col>
    </el-row>

  </div>
</template>

<script>
export default {
  name: 'NavBar',
  components: {},
  data () {
    return {
      search: ''
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
#nav-container {
  height: 100%;
  line-height: 80px;
  vertical-align: middle
}
.el-input {
  width: 300px;
  float: right;
  margin-top: 20px;

}
.el-input .el-input__inner {
    border-radius: 15px !important;
}
.el-link {
  margin: 0px 40px 0px 10px;
  font-size: 20px;
  font-weight: 100;
}
</style>
