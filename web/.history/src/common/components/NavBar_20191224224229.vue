<template>
  <div id="nav-container" @mouseleave="navleave()">
    <el-row :gutter="20">
      <el-col :span="14"  :offset="5">
        <div id="nav-bar-links"  >
          <el-link :underline="false" :disabled = "index === '0'" @click="change('0')"><div > 首页</div></el-link>
          <span v-for="item in cateGories" v-bind:key="item.cid">
            <el-link :underline="false" :disabled = "index === item.cid" @click="change(item.cid)"><div @mouseenter="naventer(item)">{{item.cname}}</div></el-link>
          </span>
          <el-input placeholder="请输入内容" v-model="search" class="inline-input" >>
          <template slot="append">
            <el-button slot="append"  icon="el-icon-search">
            </el-button>
          </template>
          </el-input>
        </div>
      </el-col>
    </el-row>
    <fade-animation :fadeIn="fadein" :fadeOut="fadeon">
      <el-row id="float-bar" v-show="in_nav" >
        <el-col :span="blank" > <div style="width:10px; color: white">1</div></el-col>
        <el-col :span="2"  v-for="(product, index) in navProducts" :key="index">
          <el-card :body-style="{ padding: '0px' }" shadow="never">
            <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" height="150px" width="120px" class="image">
              <div style="padding: 0px;">
                <div class="bottom clearfix" style="padding: 0px; height: 20px; margin-top: -52px;" >
                    {{product.pname}}
                </div>
              </div>
          </el-card>
          <span class="price">￥{{product.price}}</span>
        </el-col>
      </el-row>
    </fade-animation>
  </div>
</template>

<script>
import FadeAnimation from '../fade/FadeAnimation'
import {mapGetters, mapActions} from 'vuex'
export default {
  name: 'NavBar',
  components: {
    FadeAnimation: FadeAnimation
  },
  props: ['cid'],
  data () {
    return {
      search: '',
      index: '-1',
      inTime: 0,
      in_nav: false,
      in_bar: false,
      fadein: 'animated fadeIn',
      fadeon: 'animated zoomOut',
      src: 'https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png'
    }
  },
  computed: {
    blank: function () {
      return 12 - this.navProducts.length
    },
    ...mapGetters({
      cateGories: 'getCate',
      productList: 'getProductList'
    }),
    navProducts () {
      console.log(this.productList)
      // if (this.productList.data.length > 9) {
      //   return this.productList.data.slice(0, 9)
      // } else if (this.productList.data.length !== 0) {
      //   return this.productList.data
      // } else {
      //   return []
      // }
      return []
    }
  },
  watch: {},
  methods: {
    ...mapActions({
      flashCateList: 'flashCateList'
      // flashProductList: 'flashProductList'
    }),
    naventer: function (category) {
      this.in_nav = false
      if (this.index !== category.cid) {
        this.item = category.cname
        window.event.srcElement.style.cursor = 'hand'
        this.in_nav = true
      }
    },
    navleave: function () {
      this.in_nav = false
    },
    change: function (index) {
      // console.log(this.$route.name)
      console.log(index)
      // if (this.$route.name !== 'Products') {
      //   this.index = index
      //   this.$router.push({
      //     name: 'Products',
      //     query: {
      //       cid: index
      //     }
      //   })
      // }
      // this.flashProductList({
      //   cid: index,
      //   pageSize: 40,
      //   pageNum: 1
      // })
      // this.$router.push({
      //   name: 'Products',
      //   query: {
      //     cid: index
      //   }
      // })
      if (index === '0') {
        this.$router.push('/')
      }
      this.in_nav = false
    }
  },
  created () {
    // if (this.cid) {
    //   this.index = '0'
    // }
    this.flashCateList()
    // this.flashProductList({
    // })
    // console.log(this.cateGories)
  },
  mounted () {
  }
}
</script>
<style scoped>
#nav-container {
  height: 100%;
  line-height: 80px;
  vertical-align: middle;
  background: #f7f7f7
}
.el-input {
  width: 300px;
  float: right;
  margin-top: 20px;
}
.el-input .el-input__inner {
    border-radius: 15px !important;
}
.el-link {
  margin: 0px 10px 0px 10px;
  font-size: 20px;
  font-weight: 100;
}
#float-bar {
  width: 100%;
  height: 300px;
  background: #f7f7f7;
  z-index: 20;
  position: absolute;
  margin-left: -20px;
  margin-top: -1px;
  border-top: 1px #c1c1c1 solid;
  align-content: center;
  text-align: center
}

#float-bar .el-card:hover {
  cursor: pointer;
  margin-top: 20px;
  box-shadow: 0 0 20px #eaeaea;
  /* border:1px solid green */
  /* box-shadow: */
}

#float-bar .el-card {
  height: 210px;
  margin: 25px 5px -15px 5px;
  padding-top: 10px;
  border-radius: 5px;
}
#float-bar .price {
  margin-top: -20px;
  color: red;
  display: block;
  /* height: 30px; */
}

.price:hover {
  cursor: pointer;
}
.clearfix {
    padding: 32px 15px !important;
    /* height: 20px; */
    /* margin-top: -20px; */
    white-space: normal !important;
    width: 119px !important;
    line-height: 20px !important;
    font-size: 12px !important;
    align-content: center !important;
    text-align: center !important;
}

.clearfix:hover {
  color: red
}
</style>
