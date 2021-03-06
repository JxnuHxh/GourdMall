import Vue from 'vue'
import Vuex from 'vuex'

import categories from './modules/categories'
import user from './modules/user'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    categories
  }
})
