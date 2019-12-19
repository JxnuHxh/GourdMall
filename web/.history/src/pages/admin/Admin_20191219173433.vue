<template>
<el-container style="height: 930px; border: 1px solid #eee">

  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">

    <el-menu :default-openeds="['1', '3']" >
      <el-avatar :size="100" :src="LogoUrl" style="margin-left: 40px"> </el-avatar>
      <el-submenu index="1">
        <template slot="title" >
          <i class="el-icon-message"></i>商品管理
        </template>
        <el-menu-item-group>
          <template slot="title" >分组一</template>
          <el-menu-item index="1-1" @click="addTab(editableTabsValue)">选项1</el-menu-item>
          <el-menu-item index="1-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="1-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="1-4">
          <template slot="title">选项4</template>
          <el-menu-item index="1-4-1">选项4-1</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>用户管理</template>
        <el-menu-item-group>
          <template slot="title">分组一</template>
          <el-menu-item index="2-1">选项1</el-menu-item>
          <el-menu-item index="2-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="2-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="2-4">
          <template slot="title">选项4</template>
          <el-menu-item index="2-4-1">选项4-1</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-submenu index="3">
        <template slot="title"><i class="el-icon-setting"></i>订单管理</template>
        <el-menu-item-group>
          <template slot="title">分组一</template>
          <el-menu-item index="3-1">选项1</el-menu-item>
          <el-menu-item index="3-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="3-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="3-4">
          <template slot="title">选项4</template>
          <el-menu-item index="3-4-1">选项4-1</el-menu-item>
        </el-submenu>
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
      <el-tabs v-model="editableTabsValue" type="card" closable @tab-remove="removeTab" style="background:white" >
        <el-tab-pane key="-1" :closable="true" label="sss" >
          <span slot="label"><i class="el-icon-date"></i> 主控板</span>

          <el-container >
            <el-header style="height:90px; ">
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
              <el-row>
                <el-col :span="12">
                  <el-calendar>
                    <template
                      slot="dateCell"
                      slot-scope="{date, data}">
                      <p :class="data.isSelected ? 'is-selected' : ''">
                        {{ data.day.split('-').slice(1).join('-') }} {{ data.isSelected ? '✔️' : ''}}
                      </p>
                    </template>
                  </el-calendar>
                </el-col>
                <el-col :span="12"></el-col>
              </el-row>

            </el-main>
            <el-footer>
              底部
            </el-footer>
          </el-container>
        </el-tab-pane>
        <el-tab-pane
          v-for="(item) in editableTabs"
          :label="item.title"
          :name="item.name"
          :key="item.index"
        >
          {{item.content}}
        </el-tab-pane>
      </el-tabs>
    </el-main>
  </el-container>
</el-container>

</template>

<script>
import LogoUrl from '../../common/images/logo.png'
export default {
  name: 'Admin',
  components: {},
  data () {
    const item = {
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    }
    return {
      editableTabsValue: '0',
      editableTabs: [{
        title: 'Tab 1',
        name: '1',
        content: 'Tab 1 content'
      }, {
        title: 'Tab 2',
        name: '2',
        content: 'Tab 2 content'
      }],
      tabIndex: 2,
      LogoUrl: LogoUrl,
      tableData: Array(20).fill(item)
    }
  },
  computed: {},
  watch: {},
  methods: {
    addTab (targetName) {
      let newTabName = ++this.tabIndex + ''
      this.editableTabs.push({
        title: '新标签页',
        name: newTabName,
        content: 'New Tab content'
      })
      this.editableTabsValue = newTabName
    },
    removeTab (targetName) {
      let tabs = this.editableTabs
      let activeName = this.editableTabsValue
      if (activeName === targetName) {
        tabs.forEach((tab, index) => {
          if (tab.name === targetName) {
            let nextTab = tabs[index + 1] || tabs[index - 1]
            if (nextTab) {
              activeName = nextTab.name
            }
          }
        })
      }

      this.editableTabsValue = activeName
      this.editableTabs = tabs.filter(tab => tab.name !== targetName)
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
