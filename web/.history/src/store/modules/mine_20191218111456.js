import api from '../../axios/api'
import * as types from './../types.js'

const state = {
  getMineBaseMsg: {
    errno: 1,
    msg: {}
  }
}

const actions = {
  getMineBaseApi ({commit}) {
    alert('进入action')
    api.mineBaseMsgApi()
      .then(res => {
        alert('action中调用封装后的axios成功')
        console.log('action中调用封装后的axios成功')
        commit(types.GET_BASE_API, res)
      })
  }
}

const getters = {
  getMineBaseMsg: state => state.getMineBaseMsg
}

const mutations = {
  [types.GET_BASE_API] (state, res) {
    alert('进入mutation')
    state.getMineBaseMsg = { ...state.getMineBaseMsg, msg: res.data.msg }
    alert('进入mutations修改state成功')
  }
}

export default {
  state,
  actions,
  getters,
  mutations
}
