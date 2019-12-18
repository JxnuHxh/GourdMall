// vuex
import Vue from 'vue'
import Vuex from 'vuex'
import {getUserMessage} from '../../axios/api'

Vue.use(Vuex)

// 创建vuex的store

const state = {
  token: '',
  message: {
    uid: null,
    sno: '',
    password: '',
    nickname: '',
    email: null,
    telephone: null,
    createTime: '',
    modifiedTime: '',
    sex: null,
    state: null,
    admin: null
  }
}
// 更改store的状态
const mutations = {
  flashToken () {
    console.log('刷新token')
  },
  flashMessage () {
    console.log('刷新用户信息')
  }
}
// 有异步的时候， 需要action
const actions = {

  flashToken (context) {
    console.log('异步刷新token')
    context.commit('flashToken')
  },
  flashMessage (context) {
    console.log('异步刷新用户信息')
    context.commit('flashMessage')
  }
}
// 通过getter 进行数据获取
const getters = {
  getToken (state) {
    state.token = window.sessionStorage.token
    return state.token
  },
  getUserMessage (state) {
    console.log('获取用户信息')
    // state.message = {
    //   username: '没有'
    // }
    getUserMessage(state.token).then(
      (result) => {
        if (result.code === 2600) {
          console.log(result)
        }
      }
    )
    return state.message
  }
}

export default {
  state,
  actions,
  getters,
  mutations
}
