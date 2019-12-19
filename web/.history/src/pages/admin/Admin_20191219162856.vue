<template>
<el-container style="height: 840px; border: 1px solid #eee">

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

  <el-container>
    <el-main>
      <el-tabs v-model="editableTabsValue" type="card" closable @tab-remove="removeTab" >
        <el-tab-pane key="-1" :closable="false">
          <span slot="label"><i class="el-icon-date"></i> 我的行程</span>
          我的行程
        </el-tab-pane>
        <el-tab-pane
          v-for="(item, index) in editableTabs"
          :label="item.title"
          :name="item.name"
          :key="item.index"
        >
          {{item.content}} {{index}}
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
      editableTabsValue: '2',
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
        title: 'New Tab',
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
.el-tabs {
}
</style>
