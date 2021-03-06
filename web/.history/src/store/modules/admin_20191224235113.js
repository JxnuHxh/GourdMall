import Vue from 'vue'
import Vuex from 'vuex'
import * as types from '../mutation-types'
// import * as api from './../../axios/api'
import axios from 'axios'
Vue.use(Vuex)

const state = sessionStorage.getItem('state') ? JSON.parse(sessionStorage.getItem('state')).cart : {
  weather: {

  }
}

const getters = {
  getWeatherData: (state) => {
    return state.weather
  }
}

const mutations = {
  [types.SET_WEATHER_DATA] (state, data) {
    state.weather = data
  }
}

const actions = {
  // flashCart ({commit}, uid)
  flashWeatherData ({commit}) {
    axios.get('http://wthrcdn.etouch.cn/weather_mini?city=' + '南昌')
      .then(response => {
        console.log(response)
        commit('SET_WEATHER_DATA', response.data)
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
