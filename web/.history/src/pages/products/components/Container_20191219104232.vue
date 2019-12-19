<template>
  <el-row style="height: 1000px">
    <el-col :span="14" :offset="5">
      <el-container class="prod-wrap">
        <el-header >
          <!-- Header content -->
          <el-link :underline="false">综合排序</el-link>
          <el-link :underline="false">价格从低到高排序</el-link>
          <el-link :underline="false">价格从高到低排序</el-link>
        </el-header>
        <el-main  style="padding: 0px 10px; overflow: hidden">
          <el-row :gutter="10" style="padding: 10px 0px;">
            <el-col :span="6">
              <el-card class="product" shadow="never" :body-style="{ padding: '0px' }" >
                <div @click="login()" style="text-align: center">
                    <el-avatar
                      style="width: 200px; height: 200px; margin-top: 40px;"
                      shape="square"
                      src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                      ></el-avatar>
                    <div style="padding: 14px;">
                      <p class="product-name">好吃的汉堡</p>
                      <p class="product-desc">这是一个好吃的汉堡</p>
                      <div class="bottom clearfix">
                        <span class="product-price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card class="product" shadow="never" :body-style="{ padding: '0px' }" >
                <div @click="login()" style="text-align: center">
                    <el-avatar
                      style="width: 200px; height: 200px; margin-top: 40px;"
                      shape="square"
                      src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                      ></el-avatar>
                    <div style="padding: 14px;">
                      <p class="product-name">好吃的汉堡</p>
                      <p class="product-desc">这是一个好吃的汉堡</p>
                      <div class="bottom clearfix">
                        <span class="product-price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card class="product" shadow="never" :body-style="{ padding: '0px' }" >
                <div @click="login()" style="text-align: center">
                    <el-avatar
                      style="width: 200px; height: 200px; margin-top: 40px;"
                      shape="square"
                      src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                      ></el-avatar>
                    <div style="padding: 14px;">
                      <p class="product-name">好吃的汉堡</p>
                      <p class="product-desc">这是一个好吃的汉堡</p>
                      <div class="bottom clearfix">
                        <span class="product-price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card class="product" shadow="never" :body-style="{ padding: '0px' }" >
                <div @click="login()" style="text-align: center">
                    <el-avatar
                      style="width: 200px; height: 200px; margin-top: 40px;"
                      shape="square"
                      src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                      ></el-avatar>
                    <div style="padding: 14px;">
                      <p class="product-name">好吃的汉堡</p>
                      <p class="product-desc">这是一个好吃的汉堡</p>
                      <div class="bottom clearfix">
                        <span class="product-price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card class="product" shadow="never" :body-style="{ padding: '0px' }" >
                <div @click="login()" style="text-align: center">
                    <el-avatar
                      style="width: 200px; height: 200px; margin-top: 40px;"
                      shape="square"
                      src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                      ></el-avatar>
                    <div style="padding: 14px;">
                      <p class="product-name">好吃的汉堡</p>
                      <p class="product-desc">这是一个好吃的汉堡</p>
                      <div class="bottom clearfix">
                        <span class="product-price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card class="product" shadow="never" :body-style="{ padding: '0px' }" >
                <div @click="login()" style="text-align: center">
                    <el-avatar
                      style="width: 200px; height: 200px; margin-top: 40px;"
                      shape="square"
                      src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                      ></el-avatar>
                    <div style="padding: 14px;">
                      <p class="product-name">好吃的汉堡</p>
                      <p class="product-desc">这是一个好吃的汉堡</p>
                      <div class="bottom clearfix">
                        <span class="product-price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card class="product" shadow="never" :body-style="{ padding: '0px' }" >
                <div @click="login()" style="text-align: center">
                    <el-avatar
                      style="width: 200px; height: 200px; margin-top: 40px;"
                      shape="square"
                      src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                      ></el-avatar>
                    <div style="padding: 14px;">
                      <p class="product-name">好吃的汉堡</p>
                      <p class="product-desc">这是一个好吃的汉堡</p>
                      <div class="bottom clearfix">
                        <span class="product-price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card class="product" shadow="never" :body-style="{ padding: '0px' }" >
                <div @click="login()" style="text-align: center">
                    <el-avatar
                      style="width: 200px; height: 200px; margin-top: 40px;"
                      shape="square"
                      src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                      ></el-avatar>
                    <div style="padding: 14px;">
                      <p class="product-name">好吃的汉堡</p>
                      <p class="product-desc">这是一个好吃的汉堡</p>
                      <div class="bottom clearfix">
                        <span class="product-price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card class="product" shadow="never" :body-style="{ padding: '0px' }" >
                <div @click="login()" style="text-align: center">
                    <el-avatar
                      style="width: 200px; height: 200px; margin-top: 40px;"
                      shape="square"
                      src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                      ></el-avatar>
                    <div style="padding: 14px;">
                      <p class="product-name">好吃的汉堡</p>
                      <p class="product-desc">这是一个好吃的汉堡</p>
                      <div class="bottom clearfix">
                        <span class="product-price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card class="product" shadow="never" :body-style="{ padding: '0px' }" >
                <div @click="login()" style="text-align: center">
                    <el-avatar
                      style="width: 200px; height: 200px; margin-top: 40px;"
                      shape="square"
                      src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                      ></el-avatar>
                    <div style="padding: 14px;">
                      <p class="product-name">好吃的汉堡</p>
                      <p class="product-desc">这是一个好吃的汉堡</p>
                      <div class="bottom clearfix">
                        <span class="product-price">￥2,899.00</span>
                      </div>
                    </div>
                </div>
              </el-card>
            </el-col>
            <el-col :span="6">
              <el-card class="product" shadow="never" :body-style="{ padding: '0px' }" >
                <div @click="login()" style="text-align: center">
                    <el-avatar
                      style="width: 200px; height: 200px; margin-top: 40px;"
                      shape="square"
                      src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                      ></el-avatar>
                    <div style="padding: 14px;">
                      <p class="product-name">好吃的汉堡</p>
                      <p class="product-desc">这是一个好吃的汉堡</p>
                      <div class="bottom clearfix">
                        <span class="product-price">￥2,899.00</span>
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

              :page-sizes="[100, 200, 300, 400]"
              :page-size="100"
              layout="total, sizes, prev, pager, next, jumper"
              :total="400">
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
    }
  },
  computed: {},
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
