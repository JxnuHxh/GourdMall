<template>
  <el-container id="user-info-wrap">
    <el-header height="80">
      <!-- Header content -->
      账户资料
    </el-header>
    <el-main :height="140">
      <!-- Main content -->
      <el-row >
        <el-col :span="4">
          <el-avatar :src="avatarUrl" :size="100" shape="square"></el-avatar>
        </el-col>
        <el-col :span="3" style="line-height: 15px; text-align: center">
          <p>修改头像</p>
          <!-- <el-button type="primary">上传头像</el-button> -->
          <el-upload
            action="https://jsonplaceholder.typicode.com/posts/"
            list-type="picture-card"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove">
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-col>
      </el-row>

    </el-main>

  </el-container>
</template>

<script>
export default {
  name: 'UserInfo',
  components: {},
  data () {
    return {
      fileList: [
        {
          name: 'food.jpeg',
          url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
        }
      ],
      avatarUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    }
  },
  computed: {},
  watch: {},
  methods: {
    handleRemove (file, fileList) {
      console.log(file, fileList)
    },
    handlePreview (file) {
      console.log(file)
    }
  },
  created () {
  },
  mounted () {
  }
}
</script>
<style scoped>

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
