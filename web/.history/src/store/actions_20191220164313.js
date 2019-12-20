import * as types from './mutation-types.js'
import * as api from './../axios/api'
export default {
  nameAsyn ({commit}, {age, name}) {
    commit(types.SET_NAME, name)
    commit(types.SET_AGE, age)
  },
  fetchCate ({commit}, data) {
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
  fetchProducts ({commit}, data) {
    console.log(data)
    return api.productByCate().then(
      res => {
        if (res.code === 2600) {
          commit('SET_PRODUCT_LIST', res.data)
          console.log(res.data)
        }
      }
    )
  }
}
