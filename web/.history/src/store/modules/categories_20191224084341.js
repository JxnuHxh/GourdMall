// vuex
import Vue from 'vue'
import Vuex from 'vuex'
import * as types from '../mutation-types'
import * as api from './../../axios/api'

Vue.use(Vuex)

// 创建vuex的store

const state = sessionStorage.getItem('state') ? JSON.parse(sessionStorage.getItem('state')).categories : {
  cate: [
  ]
}

const mutations = {
  [types.SET_CATE] (state, cate) {
    state.cate = cate
  }
}

const getters = {
  getCate: (state) => {
    return state.cate
  }
}

const actions = {
  flashCateList ({commit}) {
    // console.log(data)
    return api.getCategories().then(
      res => {
        // console.log('这是结果')
        if (res.code === 2600) {
          commit('SET_CATE', res.data)
          // console.log(res.data)
        }
      }
    )
  },
  deleteCategory ({dispatch}, {cid}) {
    let data = {
      cid: cid
    }
    return api.deleteCategory(data).then(
      (res) => {
        // console.log(res)
        dispatch('flashCateList')
      }
    )
  },
  updateCategory ({dispatch}, {cid, cname}) {
    let data = {
      cid: cid,
      cname: cname
    }
    return api.updateCategory(data).then(
      (res) => {
        console.log(res)
        dispatch('flashCateList')
      }
    )
  },
  addCategory ({dispatch}, {cid, cname}) {
    let data = {
      cid: cid,
      cname: cname
    }
    return api.addCategory(data).then(
      (res) => {
        if (res.code === 4600) {

        }
        dispatch('flashCateList')
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
