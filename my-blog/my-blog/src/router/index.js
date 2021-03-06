import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)


const constRoutes =[
  {
    path:'/',
    component: ()=>import('../views/Home'),
    name:'Home'
  },
  {
    path:'/Login',
    component:()=>import('../views/Login'),
    name:'Login'
  },
  {
    path:'/Share',
    component:()=>import('../components/ShareList'),
    name:'Share'
  }
]

const router = new Router({
  routes:constRoutes
})
export default router
