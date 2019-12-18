// vuex
import Vue from 'vue'
import Vuex from 'vuex'
import {getUserMessage} from '../../axios/api'

Vue.use(Vuex)

// 创建vuex的store

const state = {
  loginState: false,
  token: '',
  userMessage: null
}

// 更改store的状态
const mutations = {
  flashToken (state) {
    console.log('更新token')
    state.token = window.sessionStorage.getItem('token')
    console.log(state.token)
    console.log('更新完毕')
  },
  flashMessage (state) {
    // console.log('刷新用户信息')
    let params = {
      token: getters.getToken(state)
    }
    let res = getUserMessage(params).then(
      (result) => {
        if (result.code === 2300) {
          console.log('登录成功')
          return result
        } else {
          return false
        }
      }
    )
    Promise.all([res]).then(values => {
      if (values[0] !== false) {
        state.userMessage = values[0].data
        state.loginState = true
      } else {
        state.userMessage = values[0].data
        state.loginState = true
      }
    })
  }
}
// 有异步的时候， 需要action
const actions = {

  flashToken (context) {
    // console.log('异步刷新token')
    state.token = window.sessionStorage.getItem('token')
    console.log(state.token)
    context.commit('flashToken')
  },
  flashMessage (context) {
    // console.log('异步刷新用户信息')
    context.commit('flashMessage')
  }
}
// 通过getter 进行数据获取
const getters = {
  getLoginState (state) {
    // console.log('获取登录状态')
    return state.loginState
  },
  getToken (state) {
    // console.log('获取token' + state.token)
    // state.token = window.sessionStorage.token
    // state.token = window.sessionStorage.getItem('token')
    return state.token
  },
  getMessage (state) {
    return state.userMessage
  }
}

export default {
  state,
  actions,
  getters,
  mutations
}
