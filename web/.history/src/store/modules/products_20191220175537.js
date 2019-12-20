import Vue from 'vue'
import Vuex from 'vuex'
import * as types from '../mutation-types'
import * as api from './../../axios/api'

Vue.use(Vuex)

const state = {
  products: {
    loadedCate: [],
    loadedNums: [],
    lodaedProducts: []
  }
}

const mutations = {
  [types.SET_PRODUCT_LIST] (state, [cid, productList]) {
    // console.log(productList)
    // state.products.loadedCate.push(cid)
    // state.products.loadedNums.push(productList.length)
    // state.products.loadedProducts.push(productList.length)
    state.productList = productList
  }
}

const getters = {
  getCate: (state) => {
    return state.cate
  }
}

const actions = {
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
  }
}

export default {
  state,
  actions,
  getters,
  mutations
}
