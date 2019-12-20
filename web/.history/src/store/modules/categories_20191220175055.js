// vuex
import Vue from 'vue'
import Vuex from 'vuex'
import * as types from '../mutation-types'
import {getCategories} from '../../axios/api'

Vue.use(Vuex)

// 创建vuex的store

const state = {
  cate: [
  ]
}

const mutations = {

}

export default {
  state,
  actions,
  getters,
  mutations
}
