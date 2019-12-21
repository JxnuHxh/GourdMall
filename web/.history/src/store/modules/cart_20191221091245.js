import Vue from 'vue'
import Vuex from 'vuex'
import * as types from '../mutation-types'
import * as api from './../../axios/api'
Vue.use(Vuex)

const state = {
  cart: null
}

const getters = {
  getCartData: (state) => {
    return state.cart
  }
}

const mutations = {

}

const actions = {

}

export default {
  state,
  actions,
  getters,
  mutations
}
