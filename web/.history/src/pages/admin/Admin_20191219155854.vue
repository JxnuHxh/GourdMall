<template>
<el-container class="admin-wrap">
  <el-aside >
    <!-- Aside content -->

    <el-tabs tab-position="left" style="height: 200px;">
      <el-tab-pane label="用户管理">
        用户管理
      </el-tab-pane>
      <el-tab-pane label="配置管理">配置管理</el-tab-pane>
      <el-tab-pane label="角色管理">角色管理</el-tab-pane>
      <el-tab-pane label="定时任务补偿">定时任务补偿</el-tab-pane>
    </el-tabs>
  </el-aside>
  <el-container>
    <el-header height="">
      <!-- Header content -->
      顶部
    </el-header>
    <el-main height="">
      <!-- Main content -->
      住孔板
    </el-main>
  </el-container>
</el-container>

</template>

<script>
export default {
  name: 'Admin',
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
.admin-wrap {
  background: #ededed
}
.admin-wrap .el-aside {
  background: white
}
</style>
