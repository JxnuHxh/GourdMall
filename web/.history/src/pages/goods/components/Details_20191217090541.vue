<template>
  <el-row >
    <el-col :span="24" >
      <el-container>
        <el-header height="">
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
  padding: 20px;
}
.el-row {
  background: white;
  height: 560px;
  border-radius: 10px;

}
</style>
