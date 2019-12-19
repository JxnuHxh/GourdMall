<template>
  <el-container>
    <el-header style=" line-height: 60px">
      <!-- Header content -->
      <!-- <el-button type="primary"><i class="el-icon-upload el-icon--right"></i></el-button> -->
    </el-header>
    <el-main height="">
      <!-- Main content -->
      <el-row>
        <el-col>
          <el-table
            :data="tableData"
            ref="multipleTable"
            border
            show-summary
            style="width: 100%">
            <el-table-column
              align="center"
              type="selection"
              width="55">
            </el-table-column>
            <el-table-column
              align="center"
              prop="id"
              label="订单号"
              width="110">
            </el-table-column>
            <el-table-column
              align="center"
              prop="name"
              width="100"
              label="购买用户">
            </el-table-column>
            <el-table-column
              align="center"
              prop="amount1"
              width="100"
              sortable
              label="物流号">
            </el-table-column>
            <el-table-column
              prop="amount1"
              sortable
              align="center"
              label="收货地址">
            </el-table-column>
            <el-table-column
              prop="amount2"
              sortable
              align="center"
              width="100"
              label="收货人">
            </el-table-column>
            <el-table-column
              prop="amount3"
              sortable
              align="center"
              width="120"
              label="收货电话">
            </el-table-column>
            <el-table-column
              align="center"
              prop="cate"
              label="订单状态"
              width="90"
              :filters="[{ text: '电脑', value: '电脑' }, { text: '手机', value: '手机' }]"
              :filter-method="filterTag"
              filter-placement="bottom-end">
              <template slot-scope="scope">
                <el-tag
                  :type="scope.row.cate === '电脑' ? 'primary' : 'success'"
                  disable-transitions>{{scope.row.cate}}</el-tag>
              </template>
            </el-table-column>
            <el-table-column
              align="center"
              prop="amount3"
              sortable
              label="下单时间">
            </el-table-column>
            <el-table-column
              align="center"
              prop="amount3"
              sortable
              width="110"
              label="商品数量">
            </el-table-column>
            <el-table-column
              align="center"
              prop="amount3"
              sortable
              width="110"
              label="总金额">
            </el-table-column>
            <el-table-column
              align="center"
              prop="amount3"
              label="备注">
            </el-table-column>
            <el-table-column
              align="center">
              <template slot="header" >
                <el-input
                  v-model="search"
                  size="mini"
                  placeholder="输入关键字搜索"/>
              </template>
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">删除</el-button>
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
  name: 'OrderManage',
  components: {},
  data () {
    return {
      search: '',
      tableData: [{
        id: '12987122',
        name: '王小虎',
        amount1: '234',
        amount2: '3.2',
        amount3: 10,
        cate: '电脑'
      }, {
        id: '12987123',
        name: '王小虎',
        amount1: '165',
        amount2: '4.43',
        amount3: 12,
        cate: '手机'
      }, {
        id: '12987124',
        name: '王小虎',
        amount1: '324',
        amount2: '1.9',
        amount3: 9,
        cate: '手机'
      }, {
        id: '12987125',
        name: '王小虎',
        amount1: '621',
        amount2: '2.2',
        amount3: 17,
        cate: '手机'
      }, {
        id: '12987126',
        name: '王小虎',
        amount1: '539',
        amount2: '4.1',
        amount3: 15,
        cate: '手机'
      }],
      multipleSelection: []
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
    toggleSelection (rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    formatter (row, column) {
      return row.name
    },
    filterTag (value, row) {
      return row.cate === value
    },
    filterHandler (value, row, column) {
      const property = column['property']
      return row[property] === value
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
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
