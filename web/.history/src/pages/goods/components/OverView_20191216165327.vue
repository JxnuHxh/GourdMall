<template>
  <el-row :gutter="20">
    <el-col :span="4" id="left">
      <el-row style="height: 80px;" class="mini-pic"   v-for="item in 5" :key="item">
        <el-col :class="[ item === 1 ? 'isActive' : '' ]" >
            <el-avatar shape="square" :size="65" fit="cover" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"></el-avatar>
        </el-col>
      </el-row>
    </el-col>
    <el-col :span="8" id="center">大图</el-col>
    <el-col :span="12" id="right">详细信息</el-col>
  </el-row>
</template>

<script>
export default {
  name: 'OverView',
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
.el-row {
  background: white;
  height: 560px;
  border-radius: 10px;
  border: 1px #dbdbdb solid;
}
.el-col {
  height: 100%;
  vertical-align: middle;
  text-align: center;
  /* border:1px azure solid; */
  /* background: red */
}

#left {
  /* background: red; */
  padding-top: 30px;
}
.mini-pic {
  border-radius: 5px;
  margin: 15px 40px;
}

.block {
  /* background: red; */
  margin-top: 4px;
  height: 65px;
}

.el-avatar {
  /* border-radius: 5px; */
  border: 2px #f7f7f7 solid;
  margin-top: 6px;
}

.isActive {
  /* margin-top: -2px; */
  border: 2px #dbdbdb solid;
  border-radius: 5px;
}

</style>
