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
          <el-avatar  style="margin: 20px 20px 0px 10px" :src="avatarUrl" :size="100" shape="square"></el-avatar>
        </el-col>
        <el-col :span="20" style="line-height: 15px; text-align: left">
          <!-- <p>修改头像</p> -->
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
      <el-row>
        <el-col :span="14">
          <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="用户名称" prop="name">
              <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="默认地址" prop="region">
              <el-select v-model="ruleForm.region" placeholder="请选择收货地址">
                <el-option label="收货地址一" value="shanghai"></el-option>
                <el-option label="收货地址二" value="beijing"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="收货时间" required>
              <el-col :span="11">
                <el-form-item prop="date1">
                  <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.date1" style="width: 100%;"></el-date-picker>
                </el-form-item>
              </el-col>
              <el-col class="line" :span="2">-</el-col>
              <el-col :span="11">
                <el-form-item prop="date2">
                  <el-time-picker placeholder="选择时间" v-model="ruleForm.date2" style="width: 100%;"></el-time-picker>
                </el-form-item>
              </el-col>
            </el-form-item>
            <el-form-item label="即时配送" prop="delivery">
              <el-switch v-model="ruleForm.delivery"></el-switch>
            </el-form-item>
            <el-form-item label="喜爱分类" prop="type">
              <el-checkbox-group v-model="ruleForm.type">
                <el-checkbox label="食品" name="type"></el-checkbox>
                <el-checkbox label="数码" name="type"></el-checkbox>
                <el-checkbox label="服装" name="type"></el-checkbox>
                <el-checkbox label="运动户外" name="type"></el-checkbox>
              </el-checkbox-group>
            </el-form-item>
            <el-form-item label="特殊癖好" prop="resource">
              <el-radio-group v-model="ruleForm.resource">
                <el-radio label="游戏"></el-radio>
                <el-radio label="学习"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="个人签名" prop="desc">
              <el-input type="textarea" v-model="ruleForm.desc"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm')">立即修改</el-button>
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </el-form>
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
      dialogImageUrl: '',
      dialogVisible: false,
      avatarUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      ruleForm: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入用户名称', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        region: [
          { required: true, message: '请选择收货地址', trigger: 'change' }
        ],
        date1: [
          { type: 'date', required: true, message: '请选择收货日期', trigger: 'change' }
        ],
        date2: [
          { type: 'date', required: true, message: '请选择收货时间', trigger: 'change' }
        ],
        type: [
          { type: 'array', required: true, message: '请至少选择一个喜爱分类', trigger: 'change' }
        ],
        resource: [
          { required: true, message: '请选择特殊癖好', trigger: 'change' }
        ],
        desc: [
          { required: true, message: '请填写个人签名', trigger: 'blur' }
        ]
      }

    }
  },
  computed: {},
  watch: {},
  methods: {
    handleRemove (file, fileList) {
      console.log(file, fileList)
    },
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!')
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    handlePictureCardPreview (file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
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
