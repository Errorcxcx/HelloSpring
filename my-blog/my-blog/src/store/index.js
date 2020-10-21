import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export const state={
  loading: false,
  UserList: [111,222,333], //用户列表
  themeObj: 0,//主题
  aboutmeObj:'',//关于我的信息
  host:"http://"+window.location.host+"/port/",//接口路径
  keywords:'',//关键词
  // errorImg: 'this.onerror=null;this.src="' + require('../../static/img/tou.jpg') +'"'
}

const store =  new Vuex.Store({
  state
})

export default store
