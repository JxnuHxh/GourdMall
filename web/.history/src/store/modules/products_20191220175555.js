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
          console.log('商品查询成功')
          commit('SET_PRODUCT_LIST', [cid, res.data])
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
