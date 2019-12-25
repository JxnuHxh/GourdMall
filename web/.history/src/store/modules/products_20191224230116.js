import Vue from 'vue'
import Vuex from 'vuex'
import * as types from '../mutation-types'
import * as api from './../../axios/api'

Vue.use(Vuex)

const state = sessionStorage.getItem('state') ? JSON.parse(sessionStorage.getItem('state')).products : {
  products: {
    loadedCate: [],
    loadedNums: [],
    lodaedProducts: []
  },
  hotSale: [
    {
      pname: '坚果 3 前屏钢化玻璃保护膜',
      pdesc: '超强透光率、耐刮花、防指纹',
      price: '49.00',
      coverImg: 'https://resource.smartisan.com/resource/3a7522290397a9444d7355298248f197.jpg'
    },
    {
      pname: '坚果 3 绒布国旗保护套',
      pdesc: '质感精良、完美贴合、周到防护',
      price: '79.00',
      coverImg: 'https://resource.smartisan.com/resource/63ea40e5c64db1c6b1d480c48fe01272.jpg'
    },
    {
      pname: '坚果 3 TPU 软胶透明保护套',
      pdesc: '轻薄透明、完美贴合、TPU 环保材质',
      price: '29.00',
      coverImg: 'https://resource.smartisan.com/resource/5e4b1feddb13639550849f12f6b2e202.jpg'
    },
    {
      pname: 'Smartisan 半入耳式耳机',
      pdesc: '经典配色、专业调音、高品质麦克风',
      price: '89.00',
      coverImg: 'https://resource.smartisan.com/resource/10525c4b21f039fc8ccb42cd1586f5cd.jpg'
    }
  ],
  productList: {
    cid: 1,
    total: 7,
    data: [
      {
        pid: 1,
        pname: '坚果 3 前屏钢化玻璃保护膜',
        pdesc: '超强透光率、耐刮花、防指纹',
        price: '49.00',
        coverImg: 'https://resource.smartisan.com/resource/3a7522290397a9444d7355298248f197.jpg',
        details: 'https://resource.smartisan.com/resource/5dcbe27f36e1f8f2bfdfabb0b2681879.jpg',
        overView: [
          'src="https://resource.smartisan.com/resource/3a7522290397a9444d7355298248f197.jpg"'
        ]
      },
      {
        pid: 2,
        pname: '坚果 3 绒布国旗保护套',
        pdesc: '质感精良、完美贴合、周到防护',
        price: '79.00',
        coverImg: 'https://resource.smartisan.com/resource/63ea40e5c64db1c6b1d480c48fe01272.jpg',
        details: 'https://resource.smartisan.com/resource/3aa27e8caf798b5e7e3796388190b43b.jpg'
      },
      {
        pid: 3,
        pname: '坚果 3 TPU 软胶透明保护套',
        pdesc: '轻薄透明、完美贴合、TPU 环保材质',
        price: '29.00',
        coverImg: 'https://resource.smartisan.com/resource/5e4b1feddb13639550849f12f6b2e202.jpg',
        details: 'https://resource.smartisan.com/resource/fda5d962cc2b2e579c5df1c3d9e2f2c8.jpg'
      },
      {
        pid: 4,
        pname: 'Smartisan 半入耳式耳机',
        pdesc: '经典配色、专业调音、高品质麦克风',
        price: '89.00',
        coverImg: 'https://resource.smartisan.com/resource/10525c4b21f039fc8ccb42cd1586f5cd.jpg',
        details: 'https://resource.smartisan.com/resource/14497b77e21fc6d0807e57bb9deabe28.jpg'
      },
      {
        pid: 5,
        pname: '坚果 3 TPU 软胶保护套',
        pdesc: 'TPU 环保材质、完美贴合、周到防护',
        price: '49.00',
        coverImg: 'https://resource.smartisan.com/resource/b899d9b82c4bc2710492a26af021d484.jpg',
        details: ''
      },
      {
        pid: 6,
        pname: '坚果 3 "足迹"背贴 乐高创始人出生',
        pdesc: '1891 年 4 月 7 日',
        price: '79.00',
        coverImg: 'https://resource.smartisan.com/resource/abb6986430536cd9365352b434f3c568.jpg',
        details: 'https://resource.smartisan.com/resource/4cbe4a14ab225c9466e16f8c8ef4e29e.jpg'
      },
      {
        pid: 7,
        pname: 'Smartisan 帆布鞋',
        pdesc: '一双踏实、舒适的帆布鞋',
        price: '199.00',
        coverImg: 'https://resource.smartisan.com/resource/abb6986430536cd9365352b434f3c568.jpg',
        details: 'https://resource.smartisan.com/resource/27a054301d8e10c40461443928dccd77.jpg'
      }
    ]
  },
  productInfo: {
    pid: '-1',
    pname: '测试商品',
    pdesc: '这是一个测试商品',
    imgUrl: 'https://fuss10.elemecdn.com/d/e6/c4d93a3805b3ce3f323f7974e6f78jpeg.jpeg',
    marketPrice: 100
  }
}

const mutations = {
  [types.SET_PRODUCT_LIST] (state, productList) {
    state.productList = productList
  },
  [types.SET_PRODUCT_INFO] (state, productInfo) {
    state.productInfo = productInfo
  }
}

const getters = {
  getProductList: (state) => {
    return state.productList
  },
  getProductInfo: (state) => {
    return state.productInfo
  }
}

const actions = {
  addProduct ({commit}, {data}) {
    let params = {
      pid: '300',
      cid: '3',
      pname: '周鹏武',
      shopPrice: 200,
      isHot: 0,
      marketPrice: 200,
      pdate: '2015-11-02T00:00:00.000+0000',
      pdesc: 'https://resource.smartisan.com/resource/a1f3fbf662376e8684e528f05721b286.jpg',
      pflag: 0,
      pimg: 'https://resource.smartisan.com/resource/7ac3af5a92ad791c2b38bfe1e38ee334.jpg'

    }
    console.log('添加商品')
    return api.addProduct(params).then(
      (res) => {
        console.log('添加结果')
        console.log(res)
      })
  },
  flashAllProduct ({commit}, pageNum = 100, pageSize = 1) {
    // let data = {
    //   pageNum: pageNum,
    //   pageSize: pageSize
    // }
    // // console.log('获取所有商品')
    // return api.allProduct(data).then(
    //   (res) => {
    //     if (res.code === 2400) {
    //       // console.log(res.data)
    //       let params = {
    //         pageNum: res.data.total
    //       }
    //       api.allProduct(params).then(
    //         (res) => {
    //           if (res.code === 2400) {
    //             commit('SET_PRODUCT_LIST', res.data)
    //           }
    //         }
    //       )
    //     }
    //   }
    // )
  },
  flashProductList ({commit}, {cid = 1, pageNum = 1, pageSize = 10}) {
    // for ()
    // console.log('cid' + cid)
    // let data = {
    //   cid: cid,
    //   pageNum: pageNum,
    //   pageSize: pageSize

    // }
    // // console.log(data)
    // return api.productByCate(data).then(
    //   res => {
    //     // console.log('商品查询结果')
    //     // console.log(res)
    //     if (res.code === 2600) {
    //       // console.log('商品查询成功')
    //       commit('SET_PRODUCT_LIST', [cid, res.data])
    //       // console.log(res.data)
    //     }
    //   }
    // )
  },
  flashProductInfo ({commit}, pid) {
    let data = {
      pid: pid
    }
    console.log(data)
    return api.productById(data).then(
      (res) => {
        console.log(res)
        if (res.code === 2400) {
          commit('SET_PRODUCT_INFO', res.data.data)
        }
      }
    )
    // commit('SET_PRODUCT_INFO', {
    //   pid: '-1',
    //   pname: '测试商品',
    //   pdesc: '这是一个测试商品',
    //   imgUrl: 'https://fuss10.elemecdn.com/d/e6/c4d93a3805b3ce3f323f7974e6f78jpeg.jpeg',
    //   marketPrice: 100
    // })
  }
}

export default {
  state,
  actions,
  getters,
  mutations
}
