// vuex
import Vue from 'vue'
import Vuex from 'vuex'
import {getCategories} from '../axios/api'

Vue.use(Vuex)

// 创建vuex的store
const store = new Vuex.Store({
  state: {
    count: 5,
    getCategories: {
      categories: []
    }
  },
  // 更改store的状态
  mutations: {
    increment (state) {
      state.count++
    },
    decrement (state) {
      state.count--
    },
    getCategories (state) {
      alert('进入action')
      state.getCategories.then(
        (result) => {
          console.log(result)
        }
      )
    }
  },
  // 有异步的时候， 需要action
  actions: {
    increment (context) {
      context.commit('increment')
    },
    decrement (context) {
      setTimeout(function () {
        context.commit('decrement')
      }, 10)
    },
    getCategories () {
      alert('进入action')
      getCategories.then(
        (result) => {
          console.log(result)
        }
      )
    }
  },
  // 通过getter 进行数据获取
  getters: {
    getState (state) {
      return state.count > 0 ? state.count : 0
    },
    getCategories: state => state.getCategories
  }
})

export default store
