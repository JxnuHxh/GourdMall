<template>
  <el-row :gutter="20">
    <el-col :span="4" id="left">小图
      <el-row style="height: 80px;" class="mini-pic" v-for="item in 4" :key="item">
        <el-col >{{item}}</el-col>
      </el-row>
    </el-col>
    <el-col :span="8" id="center">大图</el-col>
    <el-col :span="12" id="right">详细信息</el-col>
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
  height: 560px;
  border-radius: 10px;
  border: 1px #dbdbdb solid;
}
.el-col {
  height: 100%;
  vertical-align: middle;
  text-align: center;
  /* border:1px azure solid; */
  /* background: red */
}

#left {
  background: red
}
.mini-pic {
  margin: 30px 20px;
}

</style>
