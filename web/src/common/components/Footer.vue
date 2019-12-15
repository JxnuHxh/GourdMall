<template>
  <el-row >
    <el-col :span="24" >
      <div id="footer">
        <div>
            <span>预约维修</span>
            <el-divider direction="vertical"></el-divider>
            <span>退换货通道</span>
            <el-divider direction="vertical"></el-divider>
            <span>专属客服</span>
            <el-divider direction="vertical"></el-divider>
            <span>附近售后</span>
        </div>
        <div>
            <span>订单服务</span>
            <span>服务支持</span>
            <span>媒体中心</span>
            <span>关注我们</span>
            <br>
            <span>订单服务</span>
            <span>服务支持</span>
            <span>媒体中心</span>
            <span>关注我们</span>
            <br>
            <span>订单服务</span>
            <span>服务支持</span>
            <span>媒体中心</span>
            <span>关注我们</span>
        </div>
        <div id="copyright">
          <span>Copyright © 2019 gourdmall.com 版权归葫芦商城所有 </span>
        </div>
        <div id="tip">
          <span @click="top()">葫芦商城，为童年而生</span>
        </div>

      </div>
    </el-col>
  </el-row>

</template>

<script>
export default {
  name: 'Footer',
  components: {},
  data () {
    return {
    }
  },
  computed: {},
  watch: {},
  methods: {
    top: function () {
      // window.scrollTo(0, 0)
      console.log(document.documentElement.scrollTop)
      // document.documentElement.scrollTop = 0
      // window.pageYOffset = 0
      var doc = document.documentElement
      doc.animate({
        scrollTop: 0
      }, 500)
    }
  },
  created () {
  },
  mounted () {
  }
}
</script>
<style scoped>
#footer {
  text-align: center;
  font-size: 25px;
  font-family: '楷体';
  color: #7aa494;
  background: #333333;
  height: 300px;
  text-align: center
}
#tip {
  position: absolute;
  bottom: 10px;
  width: 300px;
  left: 50%;
  margin-left: -150px;
  background: transparent;

}
.el-divider {
  margin: 30px 30px;
}

#copyright {
  font-size: 18px;
  margin-top: 40px;
}
</style>
