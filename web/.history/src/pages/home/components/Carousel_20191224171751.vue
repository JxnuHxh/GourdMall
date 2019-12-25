<template>
  <el-row :gutter="5">
    <el-col :span="5">
      <el-card :body-style="{ padding: '0px', height: '450px' }">
        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>

        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-breadcrumb style="height: 25px; line-height: 25px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>

      </el-card>

    </el-col>
    <el-col :span="15">
      <div class="block">
        <el-carousel height="350px">
          <el-carousel-item v-for="item in urls" :key="item">
              <div>
                <img :src="item" height="450px" width="100%" alt="">
              </div>
          </el-carousel-item>
        </el-carousel>
      </div>
    </el-col>
    <el-col :span="4">
      <el-carousel  height="350px" direction="vertical" :autoplay="true">
        <el-carousel-item v-for="(item, index) in showVerImg.slice(0, -2)" :key="index">
          <div>
            <img :src="item" indicator-position="none" height="180px" width="100%" alt="">
          </div>
          <div>

            <img :src="showVerImg[index+1]" indicator-position="none" height="180px" width="100%" alt="">
          </div>
        </el-carousel-item>
      </el-carousel>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: 'Carousel',
  components: {},
  data () {
    return {
      urls: [
        'https://resource.smartisan.com/resource/1/1220858shoujilouceng.jpg',
        'https://resource.smartisan.com/resource/z/zhoubianshangpin1220858web.jpg',
        'https://resource.smartisan.com/resource/a/acillouceng1220856.jpg'
      ],
      showVerImg: [
        'https://resource.smartisan.com/resource/a1c53b5f12dd7ef790cadec0eaeaf466.jpg',
        'https://resource.smartisan.com/resource/2b05dbca9f5a4d0c1270123f42fb834c.jpg',
        'https://resource.smartisan.com/resource/804edf579887b3e1fae4e20a379be5b5.png',
        'https://resource.smartisan.com/resource/10525c4b21f039fc8ccb42cd1586f5cd.jpg',
        'https://resource.smartisan.com/resource/5e4b1feddb13639550849f12f6b2e202.jpg'
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
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 450px;
  margin: 0 auto;
  text-align: center
}
.el-carousel {
  border-radius: 5px;
}
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}
.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>
