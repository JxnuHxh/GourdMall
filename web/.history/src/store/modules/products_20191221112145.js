import Vue from 'vue'
import Vuex from 'vuex'
import * as types from '../mutation-types'
import * as api from './../../axios/api'

Vue.use(Vuex)

const state = sessionStorage.getItem('state') ? JSON.parse(sessionStorage.getItem('state')).products : {
  products: {
    loadedCate: [],
    loadedNums: [],
    lodaedProducts: []
  },
  productList: {
    cid: 0,
    prodCount: 1,
    data: [{
      pid: '-1',
      pname: '测试商品',
      pdesc: '这是一个测试商品',
      imgUrl: 'https://fuss10.elemecdn.com/d/e6/c4d93a3805b3ce3f323f7974e6f78jpeg.jpeg',
      marketPrice: 100
    }]
  },
  product: {
    pid: '-1',
    pname: '测试商品',
    pdesc: '这是一个测试商品',
    imgUrl: 'https://fuss10.elemecdn.com/d/e6/c4d93a3805b3ce3f323f7974e6f78jpeg.jpeg',
    marketPrice: 100
  }
}

const mutations = {
  [types.SET_PRODUCT_LIST] (state, [cid, productList]) {
    state.productList = productList
  },
  [types.SET_PRODUCT_INFO] (state, productInfo) {
    state.productInfo = productInfo
  }
}

const getters = {
  getProductList: (state) => {
    return state.productList
  },
  getProduct: (state) => {
    return state.product
  }
}

const actions = {
  flashProductList ({commit}, {cid = 1, pageNum = 1, pageSize = 10}) {
    // for ()
    console.log('cid' + cid)
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
  },
  flashProductInfo ({commit}, pid) {
    let data = {
      pid: pid
    }
    console.log(data)
  }
}

export default {
  state,
  actions,
  getters,
  mutations
}
