import * as types from './mutation-types.js'
import * as api from './../axios/api'
export default {
  nameAsyn ({commit}, {age, name}) {
    commit(types.SET_NAME, name)
    commit(types.SET_AGE, age)
  },
  fetchCate ({commit}, data) {
    console.log('获取分类列表')
    return api.getCategories().then(
      res => {
        console.log('这是结果')
        commit('SET_CATE', res)
        console.log(res)
      }
    ).then(data => {
      console.log(data)
      commit('SET_CATE', data)
    })
  }
}
