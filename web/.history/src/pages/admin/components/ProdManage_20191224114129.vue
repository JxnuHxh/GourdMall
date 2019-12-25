<template>
  <el-container>
    <el-header style=" line-height: 60px">
      <!-- Header content -->
      <el-button type="primary">新增商品<i class="el-icon-upload el-icon--right"></i></el-button>
      {{getProductList.total}}
    </el-header>
    <el-main height="">
      <!-- Main content -->
      <el-row>
        <el-col>
          <el-table
            :data="getProductList.data.slice(0, 10)"
            ref="multipleTable"
            border
            max-height="600"
            cell-class-name ="table-cell"
            :header-cell-style="headerCellStyle"
            :cell-style="cellStyle"
            style="width: 100%">
            <el-table-column
              type="selection"
              width="55">
            </el-table-column>
            <el-table-column
              type="index"
              label="序号"
              width="50">
            </el-table-column>
            <el-table-column
              prop="pid"
              label="商品ID"
              width="75">
            </el-table-column>
            <el-table-column
              prop="pname"
              width="200"
              label="商品名称">
            </el-table-column>
            <el-table-column
              prop="marketPrice"
              sortable
              width="140"
              label="商品进价(元)">
            </el-table-column>
            <el-table-column
              prop="shopPrice"
              sortable
              width="140"
              label="商品售价(元)">
            </el-table-column>
            <el-table-column
              prop="pimg"
              sortable
              width="280"
              label="展示图">
            </el-table-column>
            <el-table-column
              prop="isHot"
              sortable
              width="140"
              label="是否热门">
            </el-table-column>
            <el-table-column
              prop="cid"
              label="所属分类"
              width="100"
              :filters="tableFilters"
              :filter-method="filterTag"
              filter-placement="bottom-end">
              <template slot-scope="scope">
                <el-tag
                  type="primary"
                  disable-transitions>{{cate(scope.row)}}</el-tag>
              </template>
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
            <!-- <el-button @click="toggleSelection([tableData[1], tableData[2]])">切换第二、第三行的选中状态</el-button> -->
            <el-row>
              <el-col :span="12">
                <el-button @click="toggleSelection()">取消选择</el-button>
                <el-button type="primary" icon="el-icon-delete">删除</el-button>
              </el-col>
              <el-col :span="12">
                <el-pagination
                  @size-change="handleSizeChange"
                  @current-change="handleCurrentChange"
                  :current-page="1"
                  :page-sizes="[10, 20, 30, 40]"
                  :page-size="10"
                  layout="total, sizes, prev, pager, next, jumper"
                  :total="getProductList.total">
                </el-pagination>
              </el-col>

            </el-row>
          </div>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
import {mapGetters, mapActions} from 'vuex'
export default {
  name: 'ProductManage',
  components: {},
  data () {
    return {
      cellStyle: {
        textAlign: 'center'
      },
      currentPage: 1,
      headerCellStyle: {
        textAlign: 'center',
        background: '#545c64',
        color: 'white'
      },
      tableFilters: [{ text: '电脑', value: '1' }, { text: '手机', value: '2' }],
      search: '',
      multipleSelection: []
    }
  },
  computed: {
    ...mapGetters({
      getProductList: 'getProductList',
      getCate: 'getCate'
    }),
    cate () {
      return function (value) {
        let data = ''
        this.getCate.forEach((item) => {
          if (item.cid === value.cid) {
            // console.log(item.cid + ':' + value.cid)
            data = item.cname
          }
        })
        return data
      }
    }
  },
  watch: {},
  methods: {
    ...mapActions({
      flashAllProduct: 'flashAllProduct'
    }),
    handleSizeChange (val) {
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange (val) {
      console.log(`当前页: ${val}`)
    },
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
    }
  },
  created () {
    this.flashAllProduct()
  },
  mounted () {
  }
}
</script>
<style scoped>
th {
  text-align: center
}
.table-cell {
  background: red;
  text-align: center
}
.el-table td  .el-table th {
      text-align: center !important;
}
</style>
