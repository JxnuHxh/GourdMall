import * as types from './mutation-types.js'
import * as api from './../axios/api'
export default {
  nameAsyn ({commit}, {age, name}) {
    commit(types.SET_NAME, name)
    commit(types.SET_AGE, age)
  },
  fetchCate ({commit}, data) {
    return api.getCategories().then(
      res => {
        console.log(res)
      }
    )
  }
}
