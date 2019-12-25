import Vue from 'vue'
import Vuex from 'vuex'
import state from './state.js'
import * as getters from './getters.js'
import mutations from './mutations.js'
import actions from './actions.js'
import categories from './modules/categories'
import products from './modules/products'
import user from './modules/user'
import admin from './modules/admin'
// import categories from './modules/categories'
// import user from './modules/user'

Vue.use(Vuex)

export default new Vuex.Store({
  state,
  getters,
  mutations,
  actions,
  modules: {
    categories,
    products,
    user,
    admin
  }
})
