import * as types from './mutation-types.js'
export default {
  [types.SET_NAME] (state, name) {
    state.name = name
  },
  [types.SET_AGE] (state, age) {
    state.age = age
  },
  [types.SET_PRODUCT_LIST] (state, [cid, productList]) {
    // console.log(productList)
    // state.products.loadedCate.push(cid)
    // state.products.loadedNums.push(productList.length)
    // state.products.loadedProducts.push(productList.length)
    state.productList = productList
  }
}
