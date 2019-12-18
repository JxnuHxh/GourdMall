// vuex
import Vue from 'vue'
import Vuex from 'vuex'
import {getCategories} from '../../axios/api'

Vue.use(Vuex)

// 创建vuex的store

const state = {
  count: 0,
  code: 0,
  message: '',
  categories: []
}
// 更改store的状态
const mutations = {
  flashCategories () {
    getCategories().then(
      (res) => {
        console.log('分类信息')
        state.categories = res
      }
    )
  }
}
// 有异步的时候， 需要action
const actions = {
  flashCategories (context) {
    console.log('异步刷新分类信息')
    context.commit('flashCategories')
  }
}
// 通过getter 进行数据获取
const getters = {
  getCategories (state) {
    return state.categories
  }
}

export default {
  state,
  actions,
  getters,
  mutations
}
