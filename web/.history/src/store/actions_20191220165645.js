import * as types from './mutation-types.js'
import * as api from './../axios/api'
export default {
  nameAsyn ({commit}, {age, name}) {
    commit(types.SET_NAME, name)
    commit(types.SET_AGE, age)
  },
  fetchCateList ({commit}, data) {
    console.log(data)
    return api.getCategories().then(
      res => {
        // console.log('这是结果')
        if (res.code === 2600) {
          commit('SET_CATE', res.data)
          console.log(res.data)
        }
      }
    )
  },
  fetchProductList ({commit}, cid, pageNum = 1, pageSize = 10) {
    let data = {
      cid: cid,
      pageNum: pageNum,
      pageSize: pageSize

    }
    return api.productByCate(data).then(
      res => {
        console.log('商品查询结果')
        console.log(res)
        if (res.code === 2600) {
          commit('SET_PRODUCT_LIST', res.data)
          console.log(res.data)
        }
      }
    )
  }
}
