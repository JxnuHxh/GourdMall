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

      <p> {{categories}} </p> -->
      <!-- <p> {{cateGories[0].name}}</p> -->
      <!-- <p>{{prodList}}</p> -->
      <p>{{token}}</p>
      <p> {{userMessage}} </p>
      <p>{{loginState}}</p>
    <br/>
    </div>
    <!-- <el-button @click="flashToken">刷新Token</el-button>
    <el-button @click="getUserMsg">获取用户信息</el-button> -->
    <el-button @click="SET_CATE('111111')">同步刷新分类列表</el-button>
    <el-button @click="fetchCateList('222222222')">异步刷新分类列表</el-button>
    <el-button @click="flashProductList(1,)">异步刷新商品列表</el-button>
    <el-button @click="flashToken()">异步刷新用户信息</el-button>
    <div class="echarts-demo">
    <!-- [1] 为 ECharts 准备一个具备大小 (宽高) 的 DOM -->
      <div id="chart" ref="chart" style="width: 300px; height: 300px"></div>

    </div>
    <div >
      <div id="chartCircle" ref="chartCircle" style=" width: 800px; height: 800px"></div>
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
      chart: '',
      chartCircle: ''
    }
  },
  created () {
  },
  mounted () {
    // [3] 基于准备好的 DOM，初始化 Echarts 实例
    // 使用 ref 访问 DOM, 也可以使用 document.getElementById('chart')
    this.chart = this.$echarts.init(this.$refs.chart)
    this.chartCircle = this.$echarts.init(this.$refs.chartCircle)
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

    this.chartCircle.setOption({
      tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b}: {c} ({d}%)'
      },
      legend: {
        orient: 'vertical',
        x: 'left',
        data: ['直达', '营销广告', '搜索引擎', '邮件营销', '联盟广告', '视频广告', '百度', '谷歌', '必应', '其他']
      },
      series: [
        {
          name: '访问来源',
          type: 'pie',
          selectedMode: 'single',
          radius: [0, '30%'],

          label: {
            normal: {
              position: 'inner'
            }
          },
          labelLine: {
            normal: {
              show: false
            }
          },
          data: [
            {value: 335, name: '直达', selected: true},
            {value: 679, name: '营销广告'},
            {value: 1548, name: '搜索引擎'}
          ]
        },
        {
          name: '访问来源',
          type: 'pie',
          radius: ['40%', '55%'],
          label: {
            normal: {
              formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
              backgroundColor: '#eee',
              borderColor: '#aaa',
              borderWidth: 1,
              borderRadius: 4,
              // shadowBlur:3,
              // shadowOffsetX: 2,
              // shadowOffsetY: 2,
              // shadowColor: '#999',
              // padding: [0, 7],
              rich: {
                a: {
                  color: '#999',
                  lineHeight: 22,
                  align: 'center'
                },
                // abg: {
                //     backgroundColor: '#333',
                //     width: '100%',
                //     align: 'right',
                //     height: 22,
                //     borderRadius: [4, 4, 0, 0]
                // },
                hr: {
                  borderColor: '#aaa',
                  width: '100%',
                  borderWidth: 0.5,
                  height: 0
                },
                b: {
                  fontSize: 16,
                  lineHeight: 33
                },
                per: {
                  color: '#eee',
                  backgroundColor: '#334455',
                  padding: [2, 4],
                  borderRadius: 2
                }
              }
            }
          },
          data: [
            {value: 335, name: '直达'},
            {value: 310, name: '邮件营销'},
            {value: 234, name: '联盟广告'},
            {value: 135, name: '视频广告'},
            {value: 1048, name: '百度'},
            {value: 251, name: '谷歌'},
            {value: 147, name: '必应'},
            {value: 102, name: '其他'}
          ]
        }
      ]
    })
  },
  // computed: mapGetters(['getCate']),
  computed: {
    ...mapGetters(
      {
        cateGories: 'getCate',
        prodList: 'getProductList',
        token: 'getToken',
        userMessage: 'getUserMessage',
        loginState: 'getLoginState'
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
      flashProductList: 'fetchProductList',
      flashToken: 'flashToken'
    }),
    // flashToken () {
    //   this.$store.commit('flashToken')
    // },
    getUserMsg () {
      this.flashToken()
      if (this.loginState) {
        this.$message({
          showClose: true,
          message: '恭喜你，这是一条成功消息',
          type: 'success'
        })
      }
    }
    // flshCategories () {
    //   this.$store.commit('flashCategories')
    // }
  }
}
</script>

<style scoped>

</style>
