<template>
  <div>
    <div>
      test...
      {{ msg }}<br/>
    </div>

    <div>
      获取值 --
      <!-- {{ getCount }} -->
      <!-- <p> {{getName}} </p>
      <p> {{getUserMessage}} </p>
      <p> {{categories}} </p> -->
      <!-- <p> {{cateGories[0].name}}</p> -->
      <!-- <p>{{prodList}}</p> -->
    <br/>
    </div>
    <!-- <el-button @click="flashToken">刷新Token</el-button>
    <el-button @click="getUserMsg">获取用户信息</el-button> -->
    <el-button @click="SET_CATE('111111')">同步刷新分类列表</el-button>
    <el-button @click="fetchCateList('222222222')">异步刷新分类列表</el-button>
    <el-button @click="flashProductList(1,)">异步刷新商品列表</el-button>
    <div class="echarts-demo">
    <!-- [1] 为 ECharts 准备一个具备大小 (宽高) 的 DOM -->
    <div id="chart" ref="chart" style="width: 300px; height: 300px"></div>
    </div>

  </div>
</template>

<script>
import {mapGetters, mapMutations, mapActions} from 'vuex'
export default {
  name: 'Test',
  data () {
    return {
      msg: 'hello',
      chart: ''
    }
  },
  created () {
  },
  mounted () {
    // [3] 基于准备好的 DOM，初始化 Echarts 实例
    // 使用 ref 访问 DOM, 也可以使用 document.getElementById('chart')
    this.chart = this.$echarts.init(this.$refs.chart)

    // [4] 设置 Echarts 图表数据
    this.chart.setOption({
      title: {
        text: 'ECharts 入门示例'
      },
      type: 'pie',
      tooltip: {},
      xAxis: {
        data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
      },
      yAxis: {},
      series: [{
        name: '销量',
        type: 'bar',
        data: [5, 20, 36, 10, 10, 20]
      }]
    })
  },
  // computed: mapGetters(['getCate']),
  computed: {
    ...mapGetters(
      {
        cateGories: 'getCate',
        prodList: 'getProductList'
      }
    )
  },

  // computed: {
  //   getCount () {
  //     return this.$store.getters.getCategorie
  //   },
  //   getName () {
  //     return this.$store.getters.getName
  //   },
  //   getToken () {
  //     return this.$store.getters.getToken
  //   },
  //   getUserMessage () {
  //     return this.$store.getters.getMessage
  //   }
  // },
  methods: {
    ...mapMutations(['SET_CATE']),
    // 获取store内异步方法
    ...mapActions({
      flashCateList: 'fetchCateList',
      flashProductList: 'fetchProductList'
    })
    // flashToken () {
    //   this.$store.commit('flashToken')
    // },
    // getUserMsg () {
    //   this.$store.commit('flashMessage')
    //   // window.sessionStorage.setItem('store', JSON.stringify(this.$store.state))
    //   // console.log(this.$store.getters.getMessage)
    // },
    // flshCategories () {
    //   this.$store.commit('flashCategories')
    // }
  }
}
</script>

<style scoped>

</style>
