<template>
<el-container style="height: 940px; border: 1px solid #eee">

  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">

    <el-menu >
      <el-button @click="addTab('打开商品列表', '商品列表')">测试按钮</el-button>
      <el-avatar   :size="100" :src="LogoUrl" style="margin-left: 40px;margin-top: 20px"> </el-avatar>
      <el-submenu index="1">
        <template slot="title" >
          <i class="el-icon-message"></i>商城管理
        </template>
        <el-menu-item-group>
          <el-submenu index="1-1">
            <template slot="title">分类管理</template>
            <el-menu-item index="1-1-1" @click="addTab(editableTabsValue)">分类列表</el-menu-item>
          </el-submenu >
          <el-submenu index="1-2">
            <template slot="title">商品管理</template>
            <el-menu-item index="1-2-1" @click="addTab('1-1', '商品列表', 'ProductManage')">商品列表</el-menu-item>
          </el-submenu>
        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>用户管理</template>
        <el-menu-item index="2-1">角色列表</el-menu-item>
        <el-submenu index="2-2">
          <template slot="title">角色管理</template>
          <el-menu-item index="2-2-1">选项2</el-menu-item>
        </el-submenu>
        <el-submenu index="2-3">
          <template slot="title">权限管理</template>
          <el-menu-item index="2-3-1">权限配置</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-submenu index="3">
        <template slot="title"><i class="el-icon-setting"></i>订单管理</template>
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
        <el-menu-item index="3">锁屏</el-menu-item>
      </el-menu>
    </el-header>
    <el-main style="background: #efeef0">
      <el-tabs v-model="TabsValue" type="card" closable @tab-remove="removeTab" style="background:white" >
        <el-tab-pane  name="dash" :closable="true" label="sss" >
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
                <el-col :span="8">
                  <el-card shadow="hover" style="height: 400px">
                    留着画月份交易图
                  </el-card>
                </el-col>
                <el-col :span="6">
                  <el-card shadow="hover" style="height: 400px">
                    滚动弹幕
                  </el-card>
                </el-col>
                <el-col :span="10">
                  <el-card shadow="hover" style="height: 400px">
                    <el-tabs  v-model="activeName2" type="card">
                      <el-tab-pane label="公告" name="first">一堆的公告</el-tab-pane>
                      <el-tab-pane label="通知" name="second">一堆的通知</el-tab-pane>
                    </el-tabs>
                  </el-card>
                </el-col>
              </el-row>

            </el-main>
            <el-main style="padding-top:0px">
              <el-row :gutter="10">
                <el-col :span="6">
                  <el-card shadow="hover" body-style="{ padding: 0px  }" style="height:160px">
                    天气预报
                  </el-card>
                </el-col>
                <el-col :span="12">
                  <el-card shadow="hover" body-style="{ padding: 0px  }" style="height:160px">
                    热门商品轮播
                  </el-card>
                </el-col>
                <el-col :span="6">
                  <el-card shadow="hover" body-style="{ padding: 0px  }" style="height:160px">
                    制作团队
                  </el-card>
                </el-col>
              </el-row>
            </el-main>
          </el-container>
        </el-tab-pane>
        <el-tab-pane
          v-for="(item) in openTabs"
          :label="item.title"
          :name="item.name"
          :key="item.index"
        >
          <component :is="item.conent"></component>
        </el-tab-pane>
      </el-tabs>
    </el-main>
  </el-container>
</el-container>

</template>

<script>
import LogoUrl from '../../common/images/logo.png'
import ProductManage from './components/ProdManage'
export default {
  name: 'Admin',
  components: {
    ProductManage: ProductManage
  },
  data () {
    return {
      TabsValue: 'dash',
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
      LogoUrl: LogoUrl
    }
  },
  computed: {},
  watch: {},
  methods: {
    addTab (targetIndex, tabTitle, componentName) {
      console.log('菜单索引：' + targetIndex)
      console.log('标签页名称：' + tabTitle)
      console.log('组件名称:' + componentName)
      if (this.openTabs.length === 0) {
        console.log('空标签页')
        this.openTabs.push({
          title: tabTitle,
          name: targetIndex,
          content: componentName
        })
      } else {
        let res = this.openTabs.find(
          function (value, index, arr) {
            if (value.name === targetIndex) {
              return false
            } else {
              return true
            }
          }
        )
        console.log(res)
      }

      // console.log(this.openTabs)
    },
    open2 () {
      this.$notify({
        title: '提示',
        message: '这是一条不会自动关闭的消息',
        duration: 0
      })
    },
    removeTab (targetName) {
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
      console.log('删除标签页：' + targetName)
    }

  },
  created () {
  },
  mounted () {
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
