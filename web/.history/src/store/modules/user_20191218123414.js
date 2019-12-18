// vuex
import Vue from 'vue'
import Vuex from 'vuex'
import {userMessage} from '../../axios/api'

Vue.use(Vuex)

// 创建vuex的store

const state = {
  token: '',
  message: {
    uid: 5,
    sno: '201726705003',
    password: 'af4de7c389dd71b5fa0658eb9c50a7ff',
    nickname: '周鹏武',
    email: null,
    telephone: null,
    createTime: '2019-12-17T03:24:19.000+0000',
    modifiedTime: '2019-12-17T03:24:40.000+0000',
    sex: null,
    state: 1,
    admin: 0
  }
}
// 更改store的状态
const mutations = {
  flashToken () {
    console.log('刷新token')
  }
}
// 有异步的时候， 需要action
const actions = {
  flashToken () {
    console.log('异步刷新token')
  }
}
// 通过getter 进行数据获取
const getters = {
  getToken (state) {
    state.token = window.sessionStorage.token

    return state.token
  },
  getMessage (state) {
    userMessage(state.getToken()).then(
      (result) => {
        console.log(result)
      }
    )
  }
}

export default {
  state,
  actions,
  getters,
  mutations
}
