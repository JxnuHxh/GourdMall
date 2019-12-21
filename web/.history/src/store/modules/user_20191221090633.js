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
  },
  [types.SET_USER_INFO] (state, userMessage) {
    state.userMessage = userMessage
  },
  [types.SET_LOGIN_STATE] (state, loginState) {
    state.loginState = loginState
  }
}
// 有异步的时候， 需要action
const actions = {
  flashToken ({commit}, loginData) {
    console.log(loginData)
    let data = null
    if (loginData === null || loginData === undefined) {
      data = {
        studentNo: '201726705003',
        password: 'zpw19991123'
      }
    } else {
      data = loginData
    }
    console.log(data)
    return api.accountLogin(data).then(
      res => {
        if (res.code === 2300) {
          commit('SET_TOKEN', res.data.token)
          // console.log(res.data.token)
          let data = {
            token: res.data.token
          }
          api.getUserMessage(data).then(
            (result) => {
              // console.log('结果')
              // console.log(result)
              if (result.code === 2300) {
                commit('SET_USER_INFO', result.data)
              }
            }
          )
        }
      }
    )
  }
}
// 通过getter 进行数据获取
const getters = {
  getToken: (state) => {
    return state.token
  },
  getUserMessage: (state) => {
    return state.userMessage
  }
}

export default {
  state,
  actions,
  getters,
  mutations
}
