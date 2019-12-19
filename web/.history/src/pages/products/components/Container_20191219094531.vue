<template>
    <el-container>
      <el-header height="">
        <!-- Header content -->
      </el-header>
      <el-main height="">
        <!-- Main content -->
        <el-row>
          <el-col :span="14" offset="5">

              <el-container>
                <el-header height="">
                  <!-- Header content -->
                </el-header>
                <el-main height="">
                  <!-- Main content -->
                </el-main>
            </el-container>

          </el-col>
        </el-row>
      </el-main>
    </el-container>
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
</style>
