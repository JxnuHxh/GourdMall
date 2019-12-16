<template>
  <el-row :gutter="20">
    <el-col :span="4" id="left">
      <el-row style="height: 80px;" class="mini-pic"   v-for="item in urls" :key="item">
        <el-col :class="[ item === 1 ? 'isActive' : '' ]" class="pic-wrap" >
            <el-avatar shape="square" :size="65" fit="cover" :src="item"></el-avatar>
        </el-col>
      </el-row>
    </el-col>
    <el-col :span="8" id="center">
      <el-row>
        <el-col :span="24" class="big-pic-wrap">
          <img class="big-pic" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" width="300px"  alt="">
        </el-col>
      </el-row>
    </el-col>
    <el-col :span="11" id="right" >
      <el-row class="info-wrap">
        <el-col :span="24">
          <div class="info-header">
            商品名称及简介
          </div>
          <div class="info-middle">
            购买数量
          </div>
          <div class="info-footer">
            加入购物车或者现在购买
          </div>
        </el-col>
      </el-row>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: 'OverView',
  components: {},
  data () {
    return {
      urls: [
        'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
        'https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg',
        'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg',
        'https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg',
        'https://fuss10.elemecdn.com/d/e6/c4d93a3805b3ce3f323f7974e6f78jpeg.jpeg'
      ]
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
  border: 1px #dbdbdb solid;
}

.block {
  /* background: red; */
  margin-top: 4px;
  height: 65px;
}

.el-avatar {
  /* border-radius: 5px; */
  border: 2px #f7f7f7 solid;
  /* margin-top: 6px; */
}

.pic-wrap {
  padding-top: 6px;
}

.isActive {
  /* margin-top: -2px; */
  border: 3px #dbdbdb solid;
  border-radius: 5px;
  padding-top: 4px;
}

.big-pic-wrap {
  /* background: red; */
  border-radius: 5px;
  padding-top: 145px;

}

.big-pic {
  border-radius: 5px;
}

.demo-image__lazy {
  overflow: auto;
  height: 300px;
  border-radius: 5px;
}

.info-wrap {
  margin-left: 40px;
  /* background: red */
}

.info-header{
  margin-top: 40px;
  height: 100px;
  /* background: red; */
  text-align: left;
  margin-right: 50px;
  border-bottom: 1px #dbdbdb solid;
}

.info-middle {
  margin-top: 40px;
  height: 60px;
  /* background: red; */
  color: #8d8d8d;
  text-align: left;
  margin-right: 50px;
  border-bottom: 1px #dbdbdb solid;
}

.info-footer {
  margin-top: 20px;
  height: 120px;
  background: red
}

</style>
