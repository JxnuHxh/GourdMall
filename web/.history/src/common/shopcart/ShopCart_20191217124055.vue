<template>
  <transition :name="transitionName">
    <div>
      <div v-show="visible" :style="customStyle" class="back-to-ceiling" @click="drawer = true" >
      <!-- <svg width="16" height="16" viewBox="0 0 17 17" xmlns="http://www.w3.org/2000/svg" class="Icon Icon--backToTopArrow" aria-hidden="true" style="height: 16px; width: 16px;">
        <title>回到顶部</title>
        <g>
          <path d="M12.036 15.59c0 .55-.453.995-.997.995H5.032c-.55 0-.997-.445-.997-.996V8.584H1.03c-1.1 0-1.36-.633-.578-1.416L7.33.29c.39-.39 1.026-.385 1.412 0l6.878 6.88c.782.78.523 1.415-.58 1.415h-3.004v7.004z" fill-rule="evenodd"/>
        </g>
      </svg> -->
      <i class="el-icon-shopping-cart-2" ></i>
      <!-- <el-button @click="drawer = true" type="primary" style="margin-left: 16px;">
      </el-button> -->
    </div>
    <el-drawer
        :modal=false
        title="我是标题"
        :visible.sync="drawer"
        :with-header="false"
        :close-on-press-escape = true

        >
      <el-container class="shop-cart-wrap">
        <el-header>
          购物清单
        </el-header>
        <el-main style="padding: 0px">
          <el-row id="wrap-header">
            <el-col :span="2">选择</el-col>
            <el-col :span="9">商品名称</el-col>
            <el-col :span="5">数量</el-col>
            <el-col :span="5">小计</el-col>

            <el-col :span="3">操作</el-col>
          </el-row>
          <el-row class="shop-good" v-for="(item, index) in 6" :key="index">
            <el-col :span="2"> <el-checkbox  ></el-checkbox>
            </el-col>
            <el-col :span="9">商品名称</el-col>
            <el-col :span="5">
                <change-num :nextNum=1 :maxNum=100 :miniNum = 1 :tip='""'></change-num>
            </el-col>
            <el-col :span="5">￥0</el-col>
            <el-col :span="3"> <button class="del-good" ><i class="el-icon-delete"></i></button> </el-col>
          </el-row>
        </el-main>
        <el-footer class="shop-cart-footer">
          <el-row id="wrap-footer">
            <el-col :span="2">选择</el-col>
            <el-col :span="9">商品名称</el-col>
            <el-col :span="5">数量</el-col>
            <el-col :span="5">小计</el-col>
            <el-col :span="3">操作</el-col>
          </el-row>
        </el-footer>
      </el-container>
    </el-drawer>
    </div>
  </transition>
</template>

<script>
import ChangeNum from '../changenum/ChangeNum'
export default {
  name: 'BackToTop',
  components: {
    ChangeNum: ChangeNum
  },
  props: {
    visibilityHeight: {
      type: Number,
      default: 400
    },
    backPosition: {
      type: Number,
      default: 0
    },
    customStyle: {
      type: Object,
      default: function () {
        return {
          right: '50px',
          bottom: '50px',
          width: '40px',
          height: '40px',
          'border-radius': '4px',
          'line-height': '45px',
          background: '#e7eaf1'
        }
      }
    },
    transitionName: {
      type: String,
      default: 'fade'
    }
  },
  data () {
    return {
      drawer: false,
      visible: false,
      interval: null,
      isMoving: false
    }
  },
  mounted () {
    window.addEventListener('scroll', this.handleScroll)
  },
  beforeDestroy () {
    window.removeEventListener('scroll', this.handleScroll)
    if (this.interval) {
      clearInterval(this.interval)
    }
  },
  methods: {
    handleScroll () {
      this.visible = window.pageYOffset > this.visibilityHeight
    },
    backToTop () {
      if (this.isMoving) return
      const start = window.pageYOffset
      let i = 0
      this.isMoving = true
      this.interval = setInterval(() => {
        const next = Math.floor(this.easeInOutQuad(10 * i, start, -start, 500))
        if (next <= this.backPosition) {
          window.scrollTo(0, this.backPosition)
          clearInterval(this.interval)
          this.isMoving = false
        } else {
          window.scrollTo(0, next)
        }
        i++
      }, 16.7)
    },
    easeInOutQuad (t, b, c, d) {
      if ((t /= d / 2) < 1) return c / 2 * t * t + b
      return -c / 2 * (--t * (t - 2) - 1) + b
    }
  }
}
</script>

<style scoped>
.shop-cart-footer {
  line-height: 60px;
  border-radius: 0px 0px 10px 10px;
  padding: 0px;
  /* background: red */
}
#wrap-footer {
  border-radius: 0px 0px 10px 10px;
}
#wrap-footer .el-col {
  text-align: center;
  /* border:  1px #dbdbdb solid; */
}
.del-good {
  box-shadow: 0px 0px 10px#7d7d7d;
  height: 26px;
  border-radius: 13px;
  width: 26px;
  /* background: red; */
  background: white;
  border: 0px;
}

.del-good:hover {
  cursor: pointer;
  background: #e2e2e2
}

.back-to-ceiling {
  position: fixed;
  display: inline-block;
  text-align: center;
  cursor: pointer;
}
.back-to-ceiling:hover {
  background: #d5dbe7;
}
.fade-enter-active,
.fade-leave-active {
  transition: opacity .5s;
}
.fade-enter,
.fade-leave-to {
  opacity: 0
}
.back-to-ceiling .Icon {
  fill: #9aaabf;
  background: none;
}

.shop-cart-wrap {
  background: #ededed;
  border-radius: 0px 0px 10px 10px;
}

* :focus {
    border: 0px;
    outline:none;
}

.shop-cart-wrap .el-header {
  background: #f3f3f3;
  margin-top: 20px;
  border-radius: 10px 10px 0px 0px;
  border: 2px #dbdbdb solid;
  line-height: 60px;
  font-size: 20px;
  box-shadow: 0px 0px 10px #dbdbdb
}

#wrap-header {
  /* background: red; */
  height: 30px !important;
  line-height: 30px;
  border:  2px #dbdbdb solid;
  border-top: 0px;
  /* padding-left: 10px */
}

#wrap-header .el-col {
  border-right: 2px #dbdbdb solid;
  text-align: center
}

.shop-good {
  height: 60px !important;
  line-height: 60px;
  border:  2px #dbdbdb solid;
  border-top: 0px;
  /* padding-left: 10px; */
  background: #ffffff
}
.shop-good .el-col {
  border-right: 2px #dbdbdb solid;
  text-align: center;
  height: 100%;
}

</style>
