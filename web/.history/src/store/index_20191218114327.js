// vuex
import Vue from 'vue'
import Vuex from 'vuex'
import {getCategories} from '../axios/api'

Vue.use(Vuex)

// 创建vuex的store
const store = new Vuex.Store({
  state: {
    count: 5,
    getCategorie: {
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
    getCategorie (state) {
      console.log(state)
      getCategories().then(
        (result) => {
          console.log(result)
          this.getCategorie = result.data
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
      getCategories().then(
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
    getCategorie: state => state.getCategorie
  }
})

export default store
