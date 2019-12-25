<template>
<el-container style="height: 940px; border: 1px solid #eee">

  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">

    <el-menu >
      <!-- <el-button @click="addTab('打开商品列表', '商品列表')">测试按钮</el-button> -->
      <el-avatar   :size="100" :src="LogoUrl" style="margin-left: 40px;margin-top: 20px"> </el-avatar>
      <el-submenu index="1">
        <template slot="title" >
          <i class="el-icon-s-shop"></i>商城管理
        </template>
        <el-menu-item-group>
          <el-submenu index="1-1">
            <template slot="title">分类管理</template>
            <el-menu-item index="1-1-1" @click="addTab('1-1-1', '查看分类列表', 'CateManage')">分类列表</el-menu-item>
            <!-- <el-menu-item index="1-2-1" @click="addTab('1-2-1', '分类操作', 'ProductManage')">分类操作</el-menu-item> -->
          </el-submenu >
          <el-submenu index="1-2">
            <template slot="title">商品管理</template>
            <el-menu-item index="1-2-1" @click="addTab('1-1', '商品列表', 'ProductManage')">商品列表</el-menu-item>
          </el-submenu>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-s-custom"></i>用户管理</template>
        <el-menu-item index="2-1" @click="addTab('2-1', '角色列表', 'UserManage')" >角色列表</el-menu-item>
        <el-submenu index="2-2">
          <template slot="title">角色管理</template>
          <el-menu-item index="2-2-1" @click="addTab('2-2-1', '角色管理-待开发', 'ProductManage')">角色管理-待开发</el-menu-item>
        </el-submenu>
        <el-submenu index="2-3">
          <template slot="title">权限管理</template>
          <el-menu-item index="2-3-1" @click="addTab('2-3-1', '权限配置', 'ProductManage')" >权限配置</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-submenu index="3">
        <template slot="title" ><i class="el-icon-tickets"></i>订单管理</template>
        <el-menu-item index="3-1" @click="addTab('3-1', '订单列表', 'OrderManage')" >订单列表</el-menu-item>
      </el-submenu>
      <el-submenu index="4">
        <template slot="title" ><i class="el-icon-s-marketing"></i>统计报表</template>
        <el-menu-item index="4-1" @click="addTab('3-1', '销量统计', 'OrderManage')" >销量统计</el-menu-item>
      </el-submenu>
      <el-submenu index="5">
        <template slot="title" ><i class="el-icon-s-tools"></i>系统设置</template>
        <el-menu-item index="5-1" @click="addTab('5-1', '基本设置', 'OrderManage')" >基本设置（不开发）</el-menu-item>
        <el-menu-item index="5-1" @click="addTab('5-2', '快递管理', 'OrderManage')" >快递管理</el-menu-item>
        <el-menu-item index="5-1" @click="addTab('5-3', '系统日志', 'OrderManage')" >系统日志</el-menu-item>
      </el-submenu>
    </el-menu>
  </el-aside>

  <el-container >
    <el-header class="dashBord" style="text-align: right;padding:0px; background:#545c64">
      <el-menu
        class="header-menu"
        mode="horizontal"
        text-color="#fff"
        background-color="#545c64"
        active-text-color="#fff">
        <el-submenu index="1">
          <template slot="title">超级管理员</template>
          <el-menu-item index="2-1">个人资料</el-menu-item>
          <el-menu-item index="2-2">切换账号</el-menu-item>
          <el-menu-item index="2-3">登出后台</el-menu-item>
        </el-submenu>
        <el-menu-item index="2">消息中心</el-menu-item>
        <el-menu-item index="3"> <i class="el-icon-lock"></i> </el-menu-item>
      </el-menu>
    </el-header>
    <el-main style="background: #efeef0">
      <el-tabs v-model="activeTab" type="card" closable @tab-remove="removeTab" style="background:white" >
        <el-tab-pane  name="dash" :closable="false" label="sss" >
          <span slot="label"><i class="el-icon-date"></i> 主控板</span>
          <el-container >
            <el-header style="height:120px; ">
              <el-row style="text-align: center">
                <el-col :span="6" style="height:80px; line-height: 80px;">
                  <el-card body-style="{padding:0px; }" shadow="hover">
                    <span style="font-size:30px; ">用户总数<i class="el-icon-user-solid"></i></span>
                    <span style="font-size:30px; color:#c9cdd8"> 1000</span>
                  </el-card>
                </el-col>
                <el-col :span="6" style="height:80px; line-height: 80px;">
                  <el-card body-style="{padding:0px}" shadow="hover">
                    <span style="font-size:30px; ">商品总数<i class="el-icon-user-solid"></i></span>
                    <span style="font-size:30px; color:#c9cdd8"> 1000</span>
                  </el-card>
                </el-col>
                <el-col :span="6" style="height:80px; line-height: 80px;">
                  <el-card body-style="{padding:0px}" shadow="hover">
                    <span style="font-size:30px; ">订单总数<i class="el-icon-user-solid"></i></span>
                    <span style="font-size:30px; color:#c9cdd8"> 1000</span>
                  </el-card>
                </el-col>
                <el-col :span="6" style="height:80px; line-height: 80px;">
                  <el-card body-style="{padding:0px}" shadow="hover">
                    <span style="font-size:30px; ">浏览人数<i class="el-icon-user-solid"></i></span>
                    <span style="font-size:30px; color:#c9cdd8"> 1000</span>
                  </el-card>
                </el-col>
              </el-row>
            </el-header>
            <el-main>
              <el-row :gutter="20">
                <el-col :span="14">
                  <el-card shadow="hover" style="height: 400px">
                    <div id="chartCircle" ref="chartCircle" style="  height: 400px"></div>
                  </el-card>
                </el-col>
                <!-- <el-col :span="6">
                  <el-card shadow="hover" style="height: 400px">
                    滚动弹幕
                  </el-card>
                </el-col> -->
                <el-col :span="10">
                  <el-card shadow="hover" style="height: 400px">
                    <!-- <el-tabs  v-model="activeName2" type="card">
                      <el-tab-pane label="公告" name="first">一堆的公告</el-tab-pane>
                      <el-tab-pane label="通知" name="second">一堆的通知</el-tab-pane>
                    </el-tabs> -->
                    <div id="chartWeather" ref="chartWeather" style="  height: 350px"></div>
                  </el-card>
                </el-col>
              </el-row>

            </el-main>
            <el-main style="padding-top:0px">
              <el-row :gutter="10">
                <el-col :span="6">
                  <el-card shadow="hover" body-style="{ padding: 0px  }" style="height:160px">

                  </el-card>
                </el-col>
                <el-col :span="12">
                  <el-card shadow="hover" body-style="{ padding: 0px  }" style="height:160px">
                    热门商品轮播
                  </el-card>
                </el-col>
                <el-col :span="6">
                  <el-card shadow="hover" body-style="{ padding: 0px  }" style="height:160px">
                    {{getWeatherData}}
                  </el-card>
                </el-col>
              </el-row>
            </el-main>
          </el-container>
        </el-tab-pane>
        <!-- <el-tab-pane name="dash2" :label="分类管理" > -->

        <!-- </el-tab-pane> -->
        <el-tab-pane
          v-for="(item) in openTabs"
          :label="item.title"
          :name="item.name"
          :key="item.name"
        >
        <!-- <component :is="CateManage"></component> -->
          <component :is="item.content"></component>
        </el-tab-pane>
      </el-tabs>
    </el-main>
  </el-container>
</el-container>

</template>

<script>
import LogoUrl from '../../common/images/logo.png'
import ProductManage from './components/ProdManage'
import CateManage from './components/CateManage'
import UserManage from './components/UserManage'
import OrderManage from './components/OrderManage'
import {mapGetters, mapActions} from 'vuex'
export default {
  name: 'Admin',
  components: {
    ProductManage: ProductManage,
    CateManage: CateManage,
    UserManage: UserManage,
    OrderManage: OrderManage
  },
  data () {
    return {
      activeTab: 'dash',
      activeName2: 'first',
      editableTabsValue: '0',
      openTabs: [],
      editableTabs: [{
        title: 'Tab 1',
        name: '1',
        content: 'Tab 1 content'
      }, {
        title: 'Tab 2',
        name: '2',
        content: 'Tab 2 content'
      }],
      LogoUrl: LogoUrl,
      chartCircle: '',
      chartWeather: ''
    }
  },
  computed: {
    ...mapGetters({
      getWeatherData: 'getWeatherData'
    })
  },
  watch: {},
  methods: {
    ...mapActions({
      flashWeatherData: 'flashWeatherData'
    }),

    addTab (targetIndex, tabTitle, componentName) {
      // console.log('菜单索引：' + targetIndex)
      // console.log('标签页名称：' + tabTitle)
      // console.log('组件名称:' + componentName)
      if (this.openTabs.length === 0) {
        // console.log('空标签页')
        this.openTabs.push({
          title: tabTitle,
          name: targetIndex,
          content: componentName
        })
        this.activeTab = targetIndex
      } else {
        if (this.check(targetIndex)) {
          this.openTabs.push({
            title: tabTitle,
            name: targetIndex,
            content: componentName
          })
          this.activeTab = targetIndex
        } else {
          this.open2()
        }
      }

      // console.log(this.openTabs)
    },
    check (targetIndex) {
      for (let item of this.openTabs) {
        if (item.name === targetIndex) {
          return false
        }
      }
      return true
    },
    open2 () {
      this.$notify.error({
        title: '错误',
        message: '无法重复打开同一个标签页'
      })
    },
    removeTab (targetIndex) {
      // console.log('目前所在标签页：' + this.activeTab)
      if (targetIndex === 'dash' || this.openTabs.length === 0) {
        this.$message.error('禁止删除主控板')
      } else {
        let list = this.openTabs.filter(item => item.name !== targetIndex)
        this.openTabs = list
        if (this.openTabs.length < 1) {
          this.activeTab = 'dash'
        } else {
          this.activeTab = this.openTabs[(this.openTabs.length - 1)].name
        }
      }
      // let tabs = this.editableTabs
      // let activeName = this.editableTabsValue
      // if (activeName === targetName) {
      //   tabs.forEach((tab, index) => {
      //     if (tab.name === targetName) {
      //       let nextTab = tabs[index + 1] || tabs[index - 1]
      //       if (nextTab) {
      //         activeName = nextTab.name
      //       }
      //     }
      //   })
      // }

      // this.editableTabsValue = activeName
      // this.editableTabs = tabs.filter(tab => tab.name !== targetName)
    }

  },
  created () {
    // this.chartCircle = this.$echarts.init(this.$refs.chartCircle)
    this.flashWeatherData()
  },
  mounted () {
    this.chartCircle = this.$echarts.init(this.$refs.chartCircle)
    this.chartWeather = this.$echarts.init(this.$refs.chartWeather)
    this.chartCircle.setOption({
      tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b}: {c} ({d}%)'
      },
      legend: {
        orient: 'vertical',
        x: 'left',
        data: ['手机', '电脑', '数码配件', '服饰', '家具', '图书', '食品', '其他']
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
            {value: 335, name: '手机', selected: true},
            {value: 679, name: '电脑'},
            {value: 1548, name: '数码配件'}
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
            {value: 335, name: '手机'},
            {value: 310, name: '电脑'},
            {value: 234, name: '数码配件'},
            {value: 135, name: '服饰'},
            {value: 1048, name: '家具'},
            {value: 251, name: '图书'},
            {value: 147, name: '食品'},
            {value: 102, name: '其他'}
          ]
        }
      ]
    })
    this.chartWeather.setOption({
      title: {
        text: '一周天气'
      },
      tooltip: {
        trigger: 'axis',
        axisPointer: {
          type: 'cross',
          label: {
            backgroundColor: '#6a7985'
          }
        }
      },
      legend: {
        data: ['高温', '低温', '空气清新指数', '舒适度', '风力']
      },
      toolbox: {
        feature: {
          saveAsImage: {}
        }
      },
      grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
      },
      xAxis: [
        {
          type: 'category',
          boundaryGap: false,
          data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        }
      ],
      yAxis: [
        {
          type: 'value'
        }
      ],
      series: [
        {
          name: '高温',
          type: 'line',
          stack: '总量',
          areaStyle: {},
          data: [120, 132, 101, 134, 90, 230, 210]
        },
        {
          name: '湿度',
          type: 'line',
          stack: '总量',
          areaStyle: {},
          data: [220, 182, 191, 234, 290, 330, 310]
        },
        {
          name: '空气清新指数',
          type: 'line',
          stack: '总量',
          areaStyle: {},
          data: [150, 232, 201, 154, 190, 330, 410]
        },
        {
          name: '舒适度',
          type: 'line',
          stack: '总量',
          areaStyle: {normal: {}},
          data: [320, 332, 301, 334, 390, 330, 320]
        },
        {
          name: '风力',
          type: 'line',
          stack: '总量',
          label: {
            normal: {
              show: true,
              position: 'top'
            }
          },
          areaStyle: {normal: {}},
          data: [820, 932, 901, 934, 1290, 1330, 1320]
        }
      ]
    })
  }
}
</script>
<style scoped>
.admin-wrap {
  background: #ededed
}
.admin-wrap .el-aside {
  background: white
}
.dashBord {
  background: #333333;
  line-height: 60px;
  color: white
}
.dashBord span {
  color: white
}
.header-menu {
  float: right
}
.el-tabs {
  height: 830px;
}
.is-selected {
    color: #1989FA;
}
</style>
