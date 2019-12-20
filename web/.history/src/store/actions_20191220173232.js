import * as types from './mutation-types.js'
import * as api from './../axios/api'
export default {
  nameAsyn ({commit}, {age, name}) {
    commit(types.SET_NAME, name)
    commit(types.SET_AGE, age)
  },
  flashCateList ({commit}, data) {
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
  flashProductList ({commit}, cid, pageNum = 1, pageSize = 10) {
    // for ()
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
          commit('SET_PRODUCT_LIST', [cid, res.data])
          console.log(res.data)
        }
      }
    )
  }
}

function check (list, temp) {
  for (let item of list) {
    if (item === temp) {
      return true
    }
    return false
  }
}
