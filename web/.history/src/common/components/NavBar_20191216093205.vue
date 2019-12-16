<template>
  <div id="nav-container" @mouseleave="navleave()">
    <el-row :gutter="20">
      <el-col :span="14"  :offset="5">

        <div id="nav-bar-links"  >
          <el-link :underline="false" :disabled = "this.cid === '0'" @click="change('0')"><div > 首页</div></el-link>
          <span v-for="item in cateGories" v-bind:key="item.cid">
            <el-link :underline="false" :disabled = "cid === item.cid" @click="change(item.cid)"><div @mouseenter="naventer(item)">{{item.cid}} {{item.cname}}</div></el-link>
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
        <el-col :span="2" :offset="5">
          <el-card :body-style="{ padding: '0px' }" shadow="never">
            <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" height="20px" width="20px" class="image">
              <div style="padding: 0px;">
                <span>好吃的汉堡</span>
                <div class="bottom clearfix">
                  <time class="time">{{ currentDate }}</time>
                  <el-button type="text" class="button">操作按钮</el-button>
                </div>
              </div>
          </el-card>
          <span class="price">￥1234</span>
        </el-col>
        <el-col :span="2" >
          <el-card :body-style="{ padding: '0px' }" shadow="never">
            <el-image src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"></el-image>
          </el-card>
          <span class="price">{{item}}</span>
        </el-col>

      </el-row>
    </fade-animation>
  </div>
</template>

<script>
import FadeAnimation from '../fade/FadeAnimation'
import { getCategories, productByCate } from '../../axios/api.js'
export default {
  name: 'NavBar',
  components: {
    FadeAnimation: FadeAnimation
  },
  data () {
    return {
      search: '',
      in_nav: false,
      in_bar: false,
      cateGories: [],
      cid: '0',
      fadein: 'animated fadeIn',
      fadeon: 'animated zoomOut',
      item: '',
      src: 'https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png'
    }
  },
  computed: {},
  watch: {},
  methods: {
    showFloat: function () {
      console.log('显示')
    },
    naventer: function (category) {
      this.item = category.cname
      console.log(category)

      let data = {
        cid: category.cid,
        pageNum: 1,
        pageSize: 10
      }

      productByCate(data).then(
        (result) => {
          console.log(result)
        }
      )
      this.in_nav = true
    },
    navleave: function () {
      this.in_nav = false
    },

    click: function () {
      this.float_show = !this.float_show
    },

    change: function (index) {
      console.log(index)
      this.cid = index
    }
  },
  created () {
    getCategories().then(
      (result) => {
        if (result) {
          if (result.code === 2600) {
            this.cateGories = result.data.data
          }
        }
      }
    )
  },
  mounted () {
  }
}
</script>
<style scoped>
#nav-container {
  height: 100%;
  line-height: 80px;
  vertical-align: middle
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
  background: white;
  z-index: 20;
  position: absolute;
  margin-left: -20px;
  margin-top: -1px;
  border-top: 1px #c1c1c1 solid;
  align-content: center;
  text-align: center
}

#float-bar .el-card {
  height: 210px;
  /* margin: 35px 5px -15px 5px; */
}
#float-bar .price {
  color: red
}
</style>
