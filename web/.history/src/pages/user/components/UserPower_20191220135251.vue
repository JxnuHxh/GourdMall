<template>
  <el-container id="user-info-wrap">
    <el-header height="80">
      <!-- Header content -->
      用户特权
    </el-header>
    <el-main :height="140" style="text-align: center">
      <!-- Main content -->
      <div :style="userPowerStyle">

      </div>
      <div> <span class="tips"> 没有特权</span></div>

    </el-main>

  </el-container>
</template>

<script>
import UserPower from '../../../common/images/user-power.png'
export default {
  name: 'UserPower',
  components: {},
  data () {
    return {
      userPowerStyle: {
        backgroundImage: 'url(' + UserPower + ')',
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
  background: red
}

#user-info-wrap {
  background: white;
  background: #f4f4f4;
}

#user-info-wrap .el-header {
  background: #f0f0f0;
  height: 70px;
  line-height: 70px;
  font-size: 19px;
  padding-left: 40px
}

#user-info-wrap .el-main {
  background: #ffffff
}
</style>
