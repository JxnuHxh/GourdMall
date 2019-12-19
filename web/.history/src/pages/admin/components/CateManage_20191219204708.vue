<template>
  <el-container>
    <el-header style="background: red; line-height: 60px">
      <!-- Header content -->
      <el-button type="primary" icon="el-icon-search">搜索</el-button>
      <el-button type="primary">新增分类<i class="el-icon-upload el-icon--right"></i></el-button>
    </el-header>
    <el-main height="">
      <!-- Main content -->
      <el-row>
        <el-col>
          <el-table
            :data="tableData"
            border
            show-summary
            style="width: 100%">
            <el-table-column
      type="selection"
      width="55">
            <el-table-column
              prop="id"
              label="分类ID"
              width="180">
            </el-table-column>
            <el-table-column
              prop="name"
              label="分类名称">
            </el-table-column>
            <el-table-column
              prop="amount1"
              sortable
              label="商品种数">
            </el-table-column>
            <el-table-column
              prop="amount2"
              sortable
              label="被浏览次数">
            </el-table-column>
            <el-table-column
              prop="amount3"
              sortable
              label="商品占比">
            </el-table-column>
            <el-table-column
              align="right">
              <template slot="header" slot-scope="scope">
                <el-input
                  v-model="search"
                  size="mini"
                  placeholder="输入关键字搜索"/>
              </template>
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
                <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
              </template>
            </el-table-column>
          </el-table>
          <div style="margin-top: 20px">
            <el-button @click="toggleSelection([tableData[1], tableData[2]])">切换第二、第三行的选中状态</el-button>
            <el-button @click="toggleSelection()">取消选择</el-button>
            <el-button type="primary" icon="el-icon-delete">删除</el-button>
          </div>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'CateManage',
  components: {},
  data () {
    return {
      search: '',
      tableData: [{
        id: '12987122',
        name: '王小虎',
        amount1: '234',
        amount2: '3.2',
        amount3: 10
      }, {
        id: '12987123',
        name: '王小虎',
        amount1: '165',
        amount2: '4.43',
        amount3: 12
      }, {
        id: '12987124',
        name: '王小虎',
        amount1: '324',
        amount2: '1.9',
        amount3: 9
      }, {
        id: '12987125',
        name: '王小虎',
        amount1: '621',
        amount2: '2.2',
        amount3: 17
      }, {
        id: '12987126',
        name: '王小虎',
        amount1: '539',
        amount2: '4.1',
        amount3: 15
      }]
    }
  },
  computed: {},
  watch: {},
  methods: {
    handleEdit (index, row) {
      console.log(index, row)
    },
    handleDelete (index, row) {
      console.log(index, row)
    },
    getSummaries (param) {
      const { columns, data } = param
      const sums = []
      columns.forEach((column, index) => {
        if (index === 0) {
          sums[index] = '总价'
          return
        }
        const values = data.map(item => Number(item[column.property]))
        if (!values.every(value => isNaN(value))) {
          sums[index] = values.reduce((prev, curr) => {
            const value = Number(curr)
            if (!isNaN(value)) {
              return prev + curr
            } else {
              return prev
            }
          }, 0)
          sums[index] += ' 元'
        } else {
          sums[index] = 'N/A'
        }
      })

      return sums
    }
  },
  created () {
  },
  mounted () {
  }
}
</script>
<style scoped>
</style>
