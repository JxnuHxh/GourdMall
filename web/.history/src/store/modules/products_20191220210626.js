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
  },
  productList: {
    cid: 0,
    prodCount: 1,
    data: []
  },
  product: {
    pid: '-1',
    pname: '测试商品',
    pdesc: '这是一个测试商品',
    imgUrl: ''
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
  getProductList: (state) => {
    return state.productList
  }
}

const actions = {
  flashProductList ({commit}, {cid, pageNum, pageSize}) {
    // for ()
    let data = {
      cid: cid,
      pageNum: pageNum,
      pageSize: pageSize

    }

    // console.log(data)
    return api.productByCate(data).then(
      res => {
        // console.log('商品查询结果')
        // console.log(res)
        if (res.code === 2600) {
          // console.log('商品查询成功')
          commit('SET_PRODUCT_LIST', [cid, res.data])
          // console.log(res.data)
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
