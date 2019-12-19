<template>
  <el-row style="height: 1200px">
    <el-col :span="14" :offset="5">
      <el-container class="prod-wrap">
        <el-header >
          <!-- Header content -->
          <el-link :underline="false">综合排序</el-link>
          <el-link :underline="false">价格从低到高排序</el-link>
          <el-link :underline="false">价格从高到低排序</el-link>
        </el-header>
        <el-main  style="padding: 0px 10px; overflow: hidden">
          <el-row :gutter="10" >
            <el-col v-for="(item, index) in showIndex" v-bind:key="index" :span="6" style="padding: 5px 5px;">
              <el-card class="product" shadow="never" :body-style="{ padding: '0px' }" >
                <div @click="login()" style="text-align: center">
                    <el-avatar
                      style="width: 200px; height: 200px; margin-top: 40px;"
                      shape="square"
                      src="https://resource.smartisan.com/resource/3a7522290397a9444d7355298248f197.jpg"
                      ></el-avatar>
                    <div style="padding: 14px;">
                      <p class="product-name">{{item.name}}</p>
                      <p class="product-desc">{{item.desc}}</p>
                      <div class="bottom clearfix">
                        <span class="product-price">￥{{item.price}}</span>
                      </div>
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
              :hide-on-single-page="false"
              :page-sizes="[16, 20]"
              :page-size="17"
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
export default {
  name: 'ProductsWrap',
  components: {},
  data () {
    return {
      pageSize: 16,
      pageStart: 0,
      products: {
        total: 17,
        cid: 1,
        prodList: [
          {
            index: 1,
            name: '好吃的汉堡1号',
            desc: '这是汉堡1号',
            price: '100'
          },
          {
            index: 2,
            name: '好吃的汉堡2号',
            desc: '这是汉堡2号',
            price: '200'
          },
          {
            index: 3,
            name: '好吃的汉堡3号',
            desc: '这是汉堡3号',
            price: '300'
          },
          {
            index: 4,
            name: '好吃的汉堡4号',
            desc: '这是汉堡4号',
            price: '400'
          },
          {
            index: 5,
            name: '好吃的汉堡5号',
            desc: '这是汉堡5号',
            price: '500'
          },
          {
            index: 6,
            name: '好吃的汉堡6号',
            desc: '这是汉堡6号',
            price: '600'
          },
          {
            index: 7,
            name: '好吃的汉堡7号',
            desc: '这是汉堡7号',
            price: '700'
          },
          {
            index: 8,
            name: '好吃的汉堡8号',
            desc: '这是汉堡8号',
            price: '800'
          },
          {
            index: 9,
            name: '好吃的汉堡9号',
            desc: '这是汉堡9号',
            price: '900'
          },
          {
            index: 10,
            name: '好吃的汉堡10号',
            desc: '这是汉堡10号',
            price: '1000'
          },
          {
            index: 11,
            name: '好吃的汉堡11号',
            desc: '这是汉堡11号',
            price: '1100'
          },
          {
            index: 12,
            name: '好吃的汉堡12号',
            desc: '这是汉堡12号',
            price: '1200'
          },
          {
            index: 13,
            name: '好吃的汉堡13号',
            desc: '这是汉堡13号',
            price: '1300'
          },
          {
            index: 14,
            name: '好吃的汉堡14号',
            desc: '这是汉堡14号',
            price: '1400'
          },
          {
            index: 15,
            name: '好吃的汉堡15号',
            desc: '这是汉堡15号',
            price: '1500'
          },
          {
            index: 16,
            name: '好吃的汉堡16号',
            desc: '这是汉堡16号',
            price: '1600'
          },
          {
            index: 17,
            name: '好吃的汉堡17号',
            desc: '这是汉堡117号',
            price: '1700'
          }

        ]
      }
    }
  },
  computed: {
    showIndex () {
      return this.products.prodList.slice(this.pageStart, this.pageSize)
    },
    prodsTotal () {
      return this.products.total
    }
  },
  watch: {},
  methods: {
    login () {
      console.log('测试')
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

p {
  margin: 0px;
  font-weight: bolder
}

.product-desc {
  margin: 5px;
  font-size: 12px;
  color: #c0cedf
}

.product-price {
  color: red;
  font-weight: bolder
}
#pagination {
  margin-top: 20px;
  margin-right: 60px;
}

</style>
