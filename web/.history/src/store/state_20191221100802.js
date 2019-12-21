const state = sessionStorage.getItem('state') ? JSON.parse(sessionStorage.getItem('state')) : {
  count: 1,
  obj: {},
  arr: [1, 2, 3]
}

export default state
