<template>
  <!--四个展示商品-->
  <el-row :gutter="20" >
    <el-col :span="14" :offset="5">
      <carousel></carousel>
    </el-col>
    <el-col :span="14" :offset="5">
      <el-row>
        <el-col :span="6" v-for="item in urls" :key="item">
          <el-card shadow="hover" class="left" style="height: 170px">
              <el-image :src="item"  @click="Login()" >
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
                  :src="item.coverImg"
                  fit="cover"></el-image>
                <div style="padding: 14px;">
                  <span>{{item.pname}}</span>
                  <div class="bottom clearfix">
                    <span class="price">￥{{item.price}}</span>
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
            <el-col :span="6" v-for="(item, index) in getProductList.data" :key="index">
              <el-card shadow="hover" :body-style="{ padding: '0px' }" >
                <div @mouseenter="cardenter(index)" @mouseleave="cardleave()">
                  <el-image @click="Login()"
                    style="width: 200px; height: 200px"
                    :src="item.coverImg"
                    ></el-image>
                    <div style="padding: 5px;">
                      <span>{{item.pname}}</span>
                      <div></div>
                      <el-link class="price" :underline="false" v-show="card !== index">
                        <span >￥{{item.price}}</span>
                      </el-link>
                        <el-button-group v-show="card === index">
                          <el-button class="left" @click="detail(item.pid)">查看详情</el-button>
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
                        <span >￥{{item.price}}</span>
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
      hotSale: [
        {
          pname: '坚果 3 前屏钢化玻璃保护膜',
          pdesc: '超强透光率、耐刮花、防指纹',
          price: '49.00',
          coverImg: 'https://resource.smartisan.com/resource/3a7522290397a9444d7355298248f197.jpg'
        },
        {
          pname: '坚果 3 绒布国旗保护套',
          pdesc: '质感精良、完美贴合、周到防护',
          price: '79.00',
          coverImg: 'https://resource.smartisan.com/resource/63ea40e5c64db1c6b1d480c48fe01272.jpg'
        },
        {
          pname: '坚果 3 TPU 软胶透明保护套',
          pdesc: '轻薄透明、完美贴合、TPU 环保材质',
          price: '29.00',
          coverImg: 'https://resource.smartisan.com/resource/5e4b1feddb13639550849f12f6b2e202.jpg'
        },
        {
          pname: 'Smartisan 半入耳式耳机',
          pdesc: '经典配色、专业调音、高品质麦克风',
          price: '89.00',
          coverImg: 'https://resource.smartisan.com/resource/10525c4b21f039fc8ccb42cd1586f5cd.jpg'
        }
      ],
      urls: [
        'https://resource.smartisan.com/resource/6/610400xinpinpeijian.jpg',
        'https://resource.smartisan.com/resource/6/610400yijiuhuanxin.jpg',
        'https://resource.smartisan.com/resource/4/489673079577637073.png',
        'https://resource.smartisan.com/resource/fe6ab43348a43152b4001b4454d206ac.jpg'
      ],
      src: 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg',
      card: -1,
      fadein: 'animated fadeIn',
      fadeon: 'animated fadeOut'
    }
  },
  computed: {
    ...mapGetters({
      getProductList: 'getProductList'
    }),
    // hotSale () {
    //   // console.log(this.productList)
    //   return this.productList.data.slice(0, 4)
    // },
    phoneShow () {
      return []
    }
  },
  watch: {},
  methods: {
    detail (pid) {
      console.log(pid)
      this.$router.push({
        name: 'GoodsDetails',
        query: {
          pid: pid
        }
      })
    },
    Login: function () {
      this.$router.push('/goodsdetails')
    },
    Log: function () {
      // console.log('已删除')
    },
    cardenter (index) {
      // console.log(index + '1')

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
