<template>
  <el-row>
    <el-col :span="1" offset="5">小图</el-col>
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
}
.el-col {
  height: 100%;
  vertical-align: middle;
  text-align: center
}
</style>
