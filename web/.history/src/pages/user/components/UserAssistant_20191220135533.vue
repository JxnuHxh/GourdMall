<template>
  <el-container id="user-info-wrap">
    <el-header height="80">
      <!-- Header content -->
      专属客服
    </el-header>
    <el-main :height="140">
      <!-- Main content -->
      <div :style="userAssistantStyle">

      </div>
      <div class="tips">
        <span >
          你只是个普通人
        </span>
      </div>
    </el-main>

  </el-container>
</template>

<script>
import UserAssistant from '../../../common/images/user-assistant.png'
export default {
  name: 'UserAssistant',
  components: {},
  data () {
    return {
      userAssistantStyle: {
        backgroundImage: 'url(' + UserAssistant + ')',
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
  font-size: 30px
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
