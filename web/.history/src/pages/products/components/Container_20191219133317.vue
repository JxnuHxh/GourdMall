<template>
  <el-row style="">
    <el-col :span="14" :offset="5">
      <el-container class="prod-wrap">
        <el-header >
          <!-- Header content -->
          <el-link :underline="false" @click="sortDefault">综合排序</el-link>
          <el-link :underline="false" @click="sortPriceAsc">价格从低到高排序</el-link>
          <el-link :underline="false" @click="sortPriceDesc">价格从高到低排序</el-link>
        </el-header>
        <el-main  style="padding: 0px 10px; overflow: hidden">
          <el-row :gutter="10" >
            <el-col v-for="(item, index) in showIndex" v-bind:key="index" :span="6" style="padding: 5px 5px;">
              <el-card class="product" shadow="never" :body-style="{ padding: '0px', height: '350px' }"  >
                <div   @click="login()" @mouseenter="prodEnter(index)" :id="index" @mouseleave="prodLeave" style="text-align: center">
                    <el-avatar
                      style="width: 200px; height: 200px; margin-top: 40px;"
                      shape="square"
                      src="https://resource.smartisan.com/resource/3a7522290397a9444d7355298248f197.jpg"
                      ></el-avatar>
                    <div style="padding: 14px;" >
                      <p class="product-name">{{item.name}}</p>
                      <p class="product-desc">{{item.desc}}</p>
                      <fade-animation :fadeIn="fadein" :fadeOut="fadeon">
                      <div class="bottom clearfix" style="position: absolute" v-if="btnShow !== index">
                        <span class="product-price">￥{{item.price}}</span>
                      </div>
                      </fade-animation>
                      <fade-animation :fadeIn="fadein" :fadeOut="fadeon">
                        <div class="buttons" v-if="btnShow === index" style="position: relative">
                          <el-button type="primary" size="mini" round plain @click="goDetails(pid)">
                            查看详情
                          </el-button>
                          <el-button type="info" size="mini" round>
                            加入购物车
                          </el-button>
                        </div>
                      </fade-animation>

                    </div>
                </div>
              </el-card>
            </el-col>

          </el-row>

        </el-main>
        <el-footer height="">
          <!-- Footer content -->
          <div id="pagination">
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :hide-on-single-page="false"
              :page-sizes="[16, 20]"
              :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="prodsTotal">
            </el-pagination>
          </div>
        </el-footer>

      </el-container>
    </el-col>
</el-row>
</template>

<script>
import FadeAnimation from '../../../common/fade/FadeAnimation'
export default {
  name: 'ProductsWrap',
  components: {
    FadeAnimation: FadeAnimation
  },
  data () {
    return {
      fadein: 'animated bounceInLeft',
      fadeon: 'animated bounceOutRight',
      btnShow: -1,
      pageSize: 16,
      pageStart: 0,
      products: {
        total: 17,
        cid: 1,
        prodList: [
          {
            Index: 1,
            name: '好吃的汉堡1号',
            desc: '这是汉堡1号',
            price: 100
          },
          {
            index: 2,
            name: '好吃的汉堡2号',
            desc: '这是汉堡2号',
            price: 200
          },
          {
            index: 3,
            name: '好吃的汉堡3号',
            desc: '这是汉堡3号',
            price: 30
          },
          {
            index: 4,
            name: '好吃的汉堡4号',
            desc: '这是汉堡4号',
            price: 100
          },
          {
            index: 5,
            name: '好吃的汉堡5号',
            desc: '这是汉堡5号',
            price: 50
          },
          {
            index: 6,
            name: '好吃的汉堡6号',
            desc: '这是汉堡6号',
            price: 600
          },
          {
            index: 7,
            name: '好吃的汉堡7号',
            desc: '这是汉堡7号',
            price: 700
          },
          {
            index: 8,
            name: '好吃的汉堡8号',
            desc: '这是汉堡8号',
            price: 800
          },
          {
            index: 9,
            name: '好吃的汉堡9号',
            desc: '这是汉堡9号',
            price: 900
          },
          {
            index: 10,
            name: '好吃的汉堡10号',
            desc: '这是汉堡10号',
            price: 1000
          },
          {
            index: 11,
            name: '好吃的汉堡11号',
            desc: '这是汉堡11号',
            price: 1100
          },
          {
            index: 12,
            name: '好吃的汉堡12号',
            desc: '这是汉堡12号',
            price: 1200
          },
          {
            index: 13,
            name: '好吃的汉堡13号',
            desc: '这是汉堡13号',
            price: 1300
          },
          {
            index: 14,
            name: '好吃的汉堡14号',
            desc: '这是汉堡14号',
            price: 1400
          },
          {
            index: 15,
            name: '好吃的汉堡15号',
            desc: '这是汉堡15号',
            price: 1500
          },
          {
            index: 16,
            name: '好吃的汉堡16号',
            desc: '这是汉堡16号',
            price: 1600
          },
          {
            index: 17,
            name: '好吃的汉堡17号',
            desc: '这是汉堡117号',
            price: 1700
          }

        ]
      }
    }
  },
  computed: {
    showIndex () {
      if (this.pageSize >= this.products.total) {
        return this.products.prodList.slice(this.pageStart, this.prodsTotal)
      } else {
        if (this.pageStart + this.pageSize >= this.prodsTotal) {
          return this.products.prodList.slice(this.pageStart, this.prodsTotal)
        } else {
          return this.products.prodList.slice(this.pageStart, this.pageStart + this.pageSize)
        }
      }
    },
    sortstudents: function () {
      return this.sortByKey(this.prodList, 'price')
    },
    prodsTotal () {
      return this.products.total
    }
  },
  watch: {},
  methods: {
    prodEnter (index) {
      // if (event.srcElement.id === index.toString()) {
      //   this.btnShow = true
      // }
      this.btnShow = index
    },
    prodLeave () {
      this.btnShow = -1
    },
    login () {
      console.log('测试')
    },
    handleSizeChange (val) {
      this.pageSize = val
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange (page) {
      this.pageStart = (page - 1) * this.pageSize
      console.log(`当前页: ${this.pageStart}`)
    },
    sortDefault () {
      this.sortByKeyAsc(this.products.prodList, 'index')
    },
    sortPriceAsc () {
      this.sortByKeyAsc(this.products.prodList, 'price')
    },
    sortPriceDesc () {
      this.sortByKeyDesc(this.products.prodList, 'price')
    },
    sortByKeyAsc (array, key) {
      return array.sort(function (a, b) {
        var x = a[key]
        var y = b[key]
        console.log(x + y)
        return ((x < y) ? -1 : ((x > y) ? 1 : 0))
      })
    },
    sortByKeyDesc (array, key) {
      return array.sort(function (a, b) {
        var x = a[key]
        var y = b[key]
        return ((x > y) ? -1 : ((x < y) ? 1 : 0))
      })
    }
  },
  created () {
  },
  mounted () {
  }
}
</script>
<style scoped>
.prod-wrap {
  padding: 0px
}
.prod-wrap .el-header {
  line-height: 60px;
  height: 60px;
  background: #ededed
}

.prod-wrap .el-header .el-link {
  margin-left: 20px;
}

.product:hover {
  box-shadow: 0px 0px 20px#7d7d7d;
  z-index: 200;
}

.prod-wrap .el-main {
  background: white
}
.prod-wrap .el-footer {
  background: #ededed;
  height: 80px;
  line-height: 80px;
  text-align: right
}

.el-card:hover {
  cursor: pointer;
}

p {
  margin: 0px;
  font-weight: bolder
}

.product-desc {
  margin: 5px;
  font-size: 12px;
  color: #c0cedf
}
.clearfix {
    margin-top: 15px;
    margin-left: 90px;
    position: absolute
}
.product-price {
  color: red;
  font-weight: bolder
}
#pagination {
  margin-top: 20px;
  margin-right: 60px;
}

.buttons {
  margin-top: 14px;
  /* background: white */
}

</style>
