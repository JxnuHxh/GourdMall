// vuex
import Vue from 'vue'
import Vuex from 'vuex'
import {getUserMessage} from '../../axios/api'

Vue.use(Vuex)

// 创建vuex的store

const state = {
  loginState: false,
  token: '',
  userMessage: null
}

// 更改store的状态
const mutations = {

}
// 有异步的时候， 需要action
const actions = {

}
// 通过getter 进行数据获取
const getters = {

}

export default {
  state,
  actions,
  getters,
  mutations
}
