<template>
  <el-row :gutter="20">
    <el-col :span="2" >小图</el-col>
    <el-col :span="6">大图</el-col>
    <el-col :span="7">详细信息</el-col>
  </el-row>
</template>

<script>
export default {
  name: 'OverView',
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
.el-row {
  background: white;
  height: 300px;
  border-radius: 5px;
  border:2px azure solid;
}
.el-col {
  height: 100%;
  vertical-align: middle;
  text-align: center;
  border:1px azure solid;
  background: red
}
</style>
