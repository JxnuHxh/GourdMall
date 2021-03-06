// vuex
import Vue from 'vue'
import Vuex from 'vuex'
import {getCategories} from '../../axios/api'

Vue.use(Vuex)

// 创建vuex的store

const state = {
  token: ''
}
// 更改store的状态
const mutations = {
  flashToken () {
    console.log('刷新token')
  }
}
// 有异步的时候， 需要action
const actions = {
  flashToken () {
    console.log('异步刷新token')
  }
}
// 通过getter 进行数据获取
const getters = {
  getToken (state) {
    state.token = window.sessionStorage.token

    return state.token
  }
}

export default {
  state,
  actions,
  getters,
  mutations
}
