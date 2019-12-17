<template>
  <el-row class="details-wrap">
    <el-col :span="24" >
      <el-container>
        <el-header >
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
  border-radius: 10px;
}
.details-wrap {
  margin-top: 30px;
  background: white;
  height: 560px;
  border-radius: 10px;
}

.el-header {
  /* height: 100px; */
  background: #f4f4f4;
  border-radius: 10px 10px 0px 0px;
  line-height: 60px;
}
</style>
