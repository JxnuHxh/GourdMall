<template>
  <el-container id="old-new-wrap">
    <el-header height="80">
      <!-- Header content -->
      以旧换新
    </el-header>
    <el-main :height="140">
      <!-- Main content -->
      <div :style="oldToNewStyle">

      </div>
      <div class="tips">
        <span >
          你拿什么和我换??
        </span>
      </div>
    </el-main>

  </el-container>
</template>

<script>
import OldToNew from '../../../common/images/old-to-new.png'
export default {
  name: 'OldToNew',
  components: {},
  data () {
    return {
      oldToNewStyle: {
        backgroundImage: 'url(' + OldToNew + ')',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'center',
        width: '100%',
        height: '300px',
        marginTop: '40px'
      }
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

.tips {
  height: 100px;
  font-size: 30px;
  text-align: center
}

#old-new-wrap {
  background: white;
  background: #f4f4f4;
}

#old-new-wrap .el-header {
  background: #f0f0f0;
  height: 70px;
  line-height: 70px;
  font-size: 19px;
  padding-left: 40px
}

#old-new-wrap .el-main {
  background: #ffffff
}
</style>
