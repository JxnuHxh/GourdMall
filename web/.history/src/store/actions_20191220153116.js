import * as types from './mutation-types.js'
export default {
  nameAsyn ({commit}, {age, name}) {
    commit(types.SET_NAME, name)
    commit(types.SET_AGE, age)
  },
  fetchCate ({commit}, data) {

  }
}
