import Vue from 'vue'
import Vuex from 'vuex'
import * as types from '../mutation-types'
// import * as api from './../../axios/api'
Vue.use(Vuex)

const state = sessionStorage.getItem('state') ? JSON.parse(sessionStorage.getItem('state')).cart : {
  data: {

  }
}

const getters = {
  getCartData: (state) => {
    return state.cart
  }
}

const mutations = {
  [types.SET_WEATHER_DATA] (state, data) {
    state.data = data
  }
}

const actions = {
  // flashCart ({commit}, uid)
}

export default {
  state,
  actions,
  getters,
  mutations
}
