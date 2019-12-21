// vuex
import Vue from 'vue'
import Vuex from 'vuex'
import * as types from '../mutation-types'
import * as api from './../../axios/api'
Vue.use(Vuex)

// 创建vuex的store

const state = {
  loginState: false,
  token: '',
  userMessage: null
}

// 更改store的状态
const mutations = {
  [types.SET_TOKEN] (state, token) {
    state.token = token
  }
}
// 有异步的时候， 需要action
const actions = {
  flashToken ({commit}, loginData) {
    return api.accountLogin(loginData).then(
      res => {
        if (res.code === 2600) {
          commit('SET_TOKEN', res.data)
        }
      }
    )
  }
}
// 通过getter 进行数据获取
const getters = {
  getToken: (state) => {
    return state.token
  }
}

export default {
  state,
  actions,
  getters,
  mutations
}
