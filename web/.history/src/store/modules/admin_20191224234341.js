import Vue from 'vue'
import Vuex from 'vuex'
import * as types from '../mutation-types'
// import * as api from './../../axios/api'
import axios from 'axios'
Vue.use(Vuex)

const state = sessionStorage.getItem('state') ? JSON.parse(sessionStorage.getItem('state')).cart : {
  data: {

  }
}

const getters = {
  getWeatherData: (state) => {
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
  flashWeatherData () {
    axios.get('http://wthrcdn.etouch.cn/weather_mini?city=' + '南昌')
      .then(response => {
        console.log(response)
      }).catch(error => {
        console.log(error.response)
      })
  }
}

export default {
  state,
  actions,
  getters,
  mutations
}
