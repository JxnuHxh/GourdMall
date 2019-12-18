// vuex
import Vue from 'vue'
import Vuex from 'vuex'
import {getUserMessage} from '../../axios/api'

Vue.use(Vuex)

// 创建vuex的store

const state = {
  login: false,
  token: '',
  message: null
}
// 更改store的状态
const mutations = {
  flashToken () {
    console.log('刷新token')
    state.token = window.sessionStorage.getItem('token')
  },
  flashMessage () {
    console.log('刷新用户信息')
    let params = {
      token: getters.getToken(state)
    }
    getUserMessage(params).then(
      (res) => {
        console.log(res)
        state.message = res
      }
    )
  }
}
// 有异步的时候， 需要action
const actions = {

  flashToken (context) {
    console.log('异步刷新token')
    context.commit('flashToken')
  },
  flashMessage (context) {
    console.log('异步刷新用户信息')
    context.commit('flashMessage')
  }
}
// 通过getter 进行数据获取
const getters = {
  getToken (state) {
    console.log('获取token')
    // state.token = window.sessionStorage.token
    return state.token
  },
  getMessage (state) {
    return state.message
  }
}

export default {
  state,
  actions,
  getters,
  mutations
}
