<template>
  <!--四个展示商品-->
  <el-row :gutter="20" >
    <el-col :span="14" :offset="5">
      <carousel></carousel>
    </el-col>
    <el-col :span="14" :offset="5">
      <el-row>
        <el-col :span="6" v-for="item in urls" :key="item">
          <el-card shadow="hover" class="left">
              <el-image :src="item"  @click="Login()">
                <div slot="error" class="image-slot">
                  <i class="el-icon-picture-outline" @click="Login()"></i>
                </div>
              </el-image>
          </el-card>
        </el-col>

      </el-row>
    </el-col>
    <el-col :span="14" :offset="5">
      <!-- 热门商品 -->
      <el-container id="hot-sale" class="gods-list">
        <el-header>
          <div id="block">
            <span>热门商品</span>
            <!-- <span id="buttons">
              <el-button icon="el-icon-arrow-left" circle size="mini" disabled></el-button>
              <el-button icon="el-icon-arrow-right" circle size="mini"></el-button>
            </span> -->
          </div>
        </el-header>
        <el-main>
          <!-- Main content -->
          <el-row>
            <el-col v-for="(item, index) in hotSale" :key="index" :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }">
                <el-image
                  style="width: 200px; height: 200px"
                  :src="urls[3 - index]"
                  fit="cover"></el-image>
                <div style="padding: 14px;">
                  <span>{{item.pname}}</span>
                  <div class="bottom clearfix">
                    <span class="price">￥{{item.marketPrice}}</span>
                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-main>
      </el-container>

      <!-- 手机首页展示 -->
      <el-container id="phone-list" class="gods-list" style="overflow: auto;">
        <el-header>
          <div id="block">
            <span>手机</span>

          </div>
        </el-header>
        <el-main>
          <!-- Main content -->
          <el-row>
            <el-col :span="12">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" class="big-img">
                <el-image :src="urls[0]"  fit="fill" >
                  <div slot="error" class="image-slot">
                    <i class="el-icon-picture-outline" @click="Login()"></i>
                  </div>
                </el-image>
              </el-card>
            </el-col>
            <el-col :span="6" v-for="(item, index) in phoneShow" :key="index">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" >
                <div @mouseenter="cardenter(index)" @mouseleave="cardleave()">
                  <el-image @click="Login()"
                    style="width: 200px; height: 200px"
                    src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                    ></el-image>
                    <div style="padding: 5px;">
                      <span>{{item.pname}}</span>
                      <div></div>
                      <el-link class="price" :underline="false" v-show="card !== index">
                        <span >￥{{item.marketPrice}}</span>
                      </el-link>
                        <el-button-group v-show="card === index">
                          <el-button class="left">查看详情</el-button>
                          <el-button type="primary" class="right"> 加入购物车</el-button>
                        </el-button-group>
                    </div>
                </div>
              </el-card>
            </el-col>
          </el-row>

        </el-main>

      </el-container>

      <!-- 电脑首页展示 -->
      <el-container id="computer-list" class="gods-list" style="overflow: auto;">
        <el-header>
          <div id="block">
            <span>电脑</span>
            <span id="buttons">
              <el-button icon="el-icon-arrow-left" circle size="mini" disabled></el-button>
              <el-button icon="el-icon-arrow-right" circle size="mini"></el-button>
            </span>
          </div>
        </el-header>
        <el-main>
          <!-- Main content -->
          <el-row>
            <el-col :span="12">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" class="big-img">
                <el-image :src="urls[0]"  fit="fill" >
                  <div slot="error" class="image-slot">
                    <i class="el-icon-picture-outline" @click="Login()"></i>
                  </div>
                </el-image>
              </el-card>
            </el-col>
            <el-col :span="6" v-for="(item, index) in phoneShow" :key="index">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" >
                <div @mouseenter="cardenter(index)" @mouseleave="cardleave()">
                  <el-image @click="Login()"
                    style="width: 200px; height: 200px"
                    src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                    ></el-image>
                    <div style="padding: 5px;">
                      <span>{{item.pname}}</span>
                      <div></div>
                      <el-link class="price" :underline="false" v-show="card !== index">
                        <span >￥{{item.marketPrice}}</span>
                      </el-link>
                        <el-button-group v-show="card === index">
                          <el-button class="left">查看详情</el-button>
                          <el-button type="primary" class="right"> 加入购物车</el-button>
                        </el-button-group>
                    </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-main>
      </el-container>

      <!-- 家具首页展示 -->
      <el-container id="computer-list" class="gods-list" style="overflow: auto;">
        <el-header>
          <div id="block">
            <span>数码配件</span>
            <span id="buttons">
              <el-button icon="el-icon-arrow-left" circle size="mini" disabled></el-button>
              <el-button icon="el-icon-arrow-right" circle size="mini"></el-button>
            </span>
          </div>
        </el-header>
        <el-main>
          <!-- Main content -->
          <el-row>
            <el-col :span="12">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" class="big-img">
                <el-image :src="urls[0]"  fit="fill" >
                  <div slot="error" class="image-slot">
                    <i class="el-icon-picture-outline" @click="Login()"></i>
                  </div>
                </el-image>
              </el-card>
            </el-col>
            <el-col :span="6" v-for="(item, index) in phoneShow" :key="index">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" >
                <div @mouseenter="cardenter(index)" @mouseleave="cardleave()">
                  <el-image @click="Login()"
                    style="width: 200px; height: 200px"
                    src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                    ></el-image>
                    <div style="padding: 5px;">
                      <span>{{item.pname}}</span>
                      <div></div>
                      <el-link class="price" :underline="false" v-show="card !== index">
                        <span >￥{{item.marketPrice}}</span>
                      </el-link>
                        <el-button-group v-show="card === index">
                          <el-button class="left">查看详情</el-button>
                          <el-button type="primary" class="right"> 加入购物车</el-button>
                        </el-button-group>
                    </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-main>
      </el-container>

      <!-- 服饰首页展示 -->
      <el-container id="clothes-list" class="gods-list" style="overflow: auto;">
        <el-header>
          <div id="block">
            <span>服饰</span>
            <span id="buttons">
              <el-button icon="el-icon-arrow-left" circle size="mini" disabled></el-button>
              <el-button icon="el-icon-arrow-right" circle size="mini"></el-button>
            </span>
          </div>
        </el-header>
        <el-main>
          <!-- Main content -->
          <el-row>
            <el-col :span="12">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" class="big-img">
                <el-image :src="src"  fit="fill" >
                  <div slot="error" class="image-slot">
                    <i class="el-icon-picture-outline" @click="Login()"></i>
                  </div>
                </el-image>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" >
                <div @click="Login()">
                    <el-avatar
                    style="width: 200px; height: 200px;margin-top: 40px;"
                    shape="square"
                    src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                    ></el-avatar>
                    <div style="padding: 14px;">
                      <span>好吃的汉堡333</span>
                      <div class="bottom clearfix">
                        <span class="price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" >
                <div @click="Login()">
                    <el-avatar
                    style="width: 200px; height: 200px;margin-top: 40px;"
                    shape="square"
                    src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                    ></el-avatar>
                    <div style="padding: 14px;">
                      <span>好吃的汉堡333</span>
                      <div class="bottom clearfix">
                        <span class="price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" >
                <div @click="Login()">
                    <el-avatar
                    style="width: 200px; height: 200px;margin-top: 40px;"
                    shape="square"
                    src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                    ></el-avatar>
                    <div style="padding: 14px;">
                      <span>好吃的汉堡333</span>
                      <div class="bottom clearfix">
                        <span class="price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" >
                <div @click="Login()">
                    <el-avatar
                    style="width: 200px; height: 200px;margin-top: 40px;"
                    shape="square"
                    src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                    ></el-avatar>
                    <div style="padding: 14px;">
                      <span>好吃的汉堡333</span>
                      <div class="bottom clearfix">
                        <span class="price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" >
                <div @click="Login()">
                    <el-avatar
                    style="width: 200px; height: 200px;margin-top: 40px;"
                    shape="square"
                    src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                    ></el-avatar>
                    <div style="padding: 14px;">
                      <span>好吃的汉堡333</span>
                      <div class="bottom clearfix">
                        <span class="price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" >
                <div @click="Login()">
                    <el-avatar
                    style="width: 200px; height: 200px;margin-top: 40px;"
                    shape="square"
                    src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                    ></el-avatar>
                    <div style="padding: 14px;">
                      <span>好吃的汉堡333</span>
                      <div class="bottom clearfix">
                        <span class="price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-main>
      </el-container>
    </el-col>

  </el-row>
</template>
<script>
import Carousel from './Carousel'
import FadeAnimation from '../../../common/fade/FadeAnimation'
import {mapGetters} from 'vuex'

export default {
  name: 'HomeContainer',
  inject: ['reload'],
  components: {
    Carousel: Carousel,
    FadeAnimation: FadeAnimation
  },
  data () {
    return {
      urls: [
        'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
        'https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg',
        'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg',
        'https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg'
      ],
      src: 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg',
      card: -1,
      fadein: 'animated fadeIn',
      fadeon: 'animated fadeOut'
    }
  },
  computed: {
    ...mapGetters({
      productList: 'getProductList'
    }),
    hotSale () {
      console.log(this.productList)
      return this.productList.data.slice(0, 4)
    },
    phoneShow () {
      return this.productList.data.slice(0, 6)
    }
  },
  watch: {},
  methods: {
    Login: function () {
      this.$router.push('/goodsdetails')
    },
    Log: function () {
      // console.log('已删除')
    },
    cardenter (index) {
      console.log(index)
      this.card = index
    },
    cardleave () {
      this.card = -1
    }
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

.gods-list {
  background-color: #fafafa;
  border-radius: 5px;
  border: 1px solid;
  border-color: #e1e1e1;
  margin-top: 20px;
}

.gods-list .el-header{
  line-height: 60px;
  border-bottom: 1px solid;
  border-color: #e1e1e1
}

.gods-list .el-header span {
  font-size: 18px;
  font-weight: bolder;
}

.gods-list .el-main {
  background: #ffffff;
}

.gods-list .el-card {
  margin: 5px;
  border-radius: 5px;
  height: auto;
}

.gods-list .el-card .el-image {
  margin-top: 40px;
}
#block #buttons {
  float: right
}
.big-img .el-image {
  margin: 0px !important;
  padding: 0px;
  height: 319px;
}
.big-img {
  height: 319px !important;
}

.el-footer {
  text-align: center;
  border-top: 1px #e1e1e1 solid;
  padding: 10px 0px;
}

#hot-gods-footer {
  height: 40px !important;
  padding-top: 15px;
}
.el-button-group {
  margin-left: -5px;
  margin-top: 6px;
}
.el-button-group .el-button {
  margin: 5px;
  width: 80px;
  border-radius: 5px;
  height: 30px;
  line-height: 30px;
  font-size: 10px;
  padding: 0px;

}

.el-button-group .left {
  border: darkgrey 1px solid
}

.price {
  margin-top: 13px;
  margin-bottom: 10px;
  font-size: 18px;
  color: #d74d44;
  font-weight: bolder;
}
</style>
