<template>
  <el-row >
    <el-col :span="24" >
      <el-container>
        <el-header height="80px">
          <!-- Header content -->
            2
        </el-header>
        <el-main height="">
          <!-- Main content -->
          3
        </el-main>
      </el-container>

    </el-col>
  </el-row>
</template>

<script>
export default {
  name: 'GoodDetails',
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
.el-container {
  background: red;
  padding-left: 30px;
  border-radius: 10px;
}
.el-row {
  background: white;
  height: 560px;
  border-radius: 10px;
}

.el-header {
  height: 100px;
  background: #f4f4f4
}
</style>
