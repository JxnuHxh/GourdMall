import {postData} from './request'

export const loginTest = data => {
  return postData('/api/test/code', data)
}
