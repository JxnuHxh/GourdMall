// vuex
import Vue from 'vue'
import Vuex from 'vuex'
import {getCategories} from '../../axios/api'

Vue.use(Vuex)

// 创建vuex的store

const state = {
  cate: [
  ]
}

export default {
  state,
  actions,
  getters,
  mutations
}
