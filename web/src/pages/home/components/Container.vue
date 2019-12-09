<template>
  <!--四个展示商品-->
  <el-row :gutter="20">
    <el-col :span="14" :offset="5">
      <carousel></carousel>
    </el-col>
    <el-col :span="14" :offset="5">
      <el-row>
        <el-col :span="6">
          <el-card shadow="hover" class="left">
            <el-image :src="src"></el-image>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card shadow="hover" class="center">
            <el-image :src="src"></el-image>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card shadow="hover" class="center">
          <el-image :src="src"></el-image>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card shadow="hover" class="right">
          <el-image :src="src"></el-image>
          </el-card>
        </el-col>
      </el-row>
    </el-col>
    <el-col :span="14" :offset="5">
      <el-container id="hot-sale">
        <el-header>
          <div id="block">
            <span>热门商品</span>
            <span id="buttons">
              <el-button icon="el-icon-arrow-left" circle size="mini" disabled></el-button>
              <el-button icon="el-icon-arrow-right" circle size="mini"></el-button>
            </span>
          </div>
        </el-header>
        <el-main>
          <!-- Main content -->
          <el-row>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }">
                <el-image
                  style="width: 200px; height: 200px"
                  src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                  fit="cover"></el-image>
                <div style="padding: 14px;">
                  <span>好吃的汉堡</span>
                  <div class="bottom clearfix">
                    <span class="price">￥2,899.00</span>
                  </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }">
                <el-image
                  style="width: 200px; height: 200px"
                  src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                  fit="cover"></el-image>
                <div style="padding: 14px;">
                  <span>好吃的汉堡</span>
                  <div class="bottom clearfix">
                    <span class="price">￥2,899.00</span>
                  </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }">
                <el-image
                  style="width: 200px; height: 200px"
                  src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                  fit="cover"></el-image>
                <div style="padding: 14px;">
                  <span>好吃的汉堡</span>
                  <div class="bottom clearfix">
                    <span class="price">￥2,899.00</span>
                  </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }">
                <el-image
                  style="width: 200px; height: 200px"
                  src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                  fit="cover"></el-image>
                <div style="padding: 14px;">
                  <span>好吃的汉堡</span>
                  <div class="bottom clearfix">
                    <span class="price">￥2,899.00</span>
                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-main>
      </el-container>
      <el-container id="hot-sale">
        <el-header>
          <div id="block">
            <span>手机</span>
            <span id="buttons">
              <el-button icon="el-icon-arrow-left" circle size="mini" disabled></el-button>
              <el-button icon="el-icon-arrow-right" circle size="mini"></el-button>
            </span>
          </div>
        </el-header>
        <el-main>
          <!-- Main content -->
          <el-row>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }">
                <el-image
                  style="width: 200px; height: 200px"
                  src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                  fit="cover"></el-image>
                <div style="padding: 14px;">
                  <span>好吃的汉堡</span>
                  <div class="bottom clearfix">
                    <span class="price">￥2,899.00</span>
                  </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }">
                <el-image
                  style="width: 200px; height: 200px"
                  src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                  fit="cover"></el-image>
                <div style="padding: 14px;">
                  <span>好吃的汉堡</span>
                  <div class="bottom clearfix">
                    <span class="price">￥2,899.00</span>
                  </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }">
                <el-image
                  style="width: 200px; height: 200px"
                  src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                  fit="cover"></el-image>
                <div style="padding: 14px;">
                  <span>好吃的汉堡</span>
                  <div class="bottom clearfix">
                    <span class="price">￥2,899.00</span>
                  </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }">
                <el-image
                  style="width: 200px; height: 200px"
                  src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                  fit="cover"></el-image>
                <div style="padding: 14px;">
                  <span>好吃的汉堡</span>
                  <div class="bottom clearfix">
                    <span class="price">￥2,899.00</span>
                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-main>
      </el-container>
    </el-col>

  </el-row>

  <!--热门商品-->

</template>
<script>
import Carousel from './Carousel'
export default {
  name: 'HomeContainer',
  components: {
    Carousel: Carousel
  },
  data () {
    return {
      src: 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg'
    }
  },
  computed: {

  },
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
.el-card {
  margin: 10px 0px;
  height: 150px;
  border-radius: 5px;
  text-align: center;
}
.center {
  margin: 10px 10px;
}
.left {
  margin-right: 10px;
}
.right {
  margin-left: 10px;
}
.el-image {
  margin: -20px -20px 0px -20px;
}
.el-main {
  padding: 0px;
}

.bottom{
  margin-top: 5px;
}

.price {
  color: #d74d44;
  font-weight: bolder;

}

#hot-sale {
  background-color: #fafafa;
  border-radius: 5px;
  border: 1px solid;
  border-color: #e1e1e1
}

#hot-sale .el-header{
  line-height: 60px;
  border-bottom: 1px solid;
  border-color: #e1e1e1
}

#hot-sale .el-header span {
  font-size: 18px;
  font-weight: bolder;
}

#hot-sale .el-main {
  background: #ffffff;

}

#hot-sale .el-card {
  margin: 5px;
  border-radius: 5px;
  height: auto;
}

#hot-sale .el-card .el-image {
  margin-top: 40px;
}
#buttons {
  float: right
}
</style>
