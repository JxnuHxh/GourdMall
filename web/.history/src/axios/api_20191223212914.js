import {postData, getData, deleteData, putData} from './request'

export const loginTest = data => {
  return postData('/api/test/code', data)
}

export const sendCheckCode = data => {
  // console.log(data)
  return getData('/api/sendCheckCode', data)
}

export const confirmCheckCode = data => {
  // console.log(data)
  return postData('/api/confirmCheckCode', data)
}

export const setPassword = data => {
  // console.log(data)
  return postData('/api/setPassword', data)
}

export const accountLogin = data => {
  // console.log(data)
  return postData('/api/login', data)
}

export const getCategories = data => {
  // console.log(data)
  return getData('/api/category/listCategory', data)
}

export const addCategory = data => {
  return postData('/api/category/addCategory', data)
}

export const deleteCategory = data => {
  return deleteData('/api/category/deleteCategoryById?cid=' + data.cid)
}

export const updateCategory = data => {
  return putData('/api/category/updateCategory', data)
}

export const productByCate = data => {
  // console.log(data)
  return getData('/api/category/productBycid', data)
}

export const productById = data => {
  // console.log(data)
  return getData('/api/product/' + data.pid, data)
}

export const getUserMessage = data => {
  // console.log(data)
  return getData('/api/selectUser', data)
}
