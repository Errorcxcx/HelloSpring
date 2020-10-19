<template>
    <div class="">
      <div class="headBack">
      <el-row class="container">
        <el-col :span="24">
          <div  class="headBox">
            <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
              <el-menu-item index="/Home"><i class="fa fa-wa fa-home"></i> 首页</el-menu-item>
              <el-submenu  index="/Share">
                <template slot="title"><i class="fa fa-wa fa-archive"></i> 分类</template>
                <el-menu-item v-for="(item,index) in classListObj" :key="'class1'+index" :index="'/Share?classId='+item.class_id">{{item.cate_name}}</el-menu-item>
              </el-submenu>
              <el-submenu index="/Aboutme">
                <template slot="title"><i class="fa fa-wa fa-flask"></i> 实验室</template>
                <el-menu-item v-for="(item,index) in projectList" :key="'class2'+index" index=""><a :href="item.nav_url" target="_blank">{{item.nav_name}}</a></el-menu-item>
              </el-submenu>
              <el-menu-item index="/Reward"><i class="fa fa-wa fa-cny"></i> 赞赏</el-menu-item>
              <el-menu-item index="/Friendslink"><i class="fa fa-wa fa-users"></i> 伙伴</el-menu-item>
              <el-menu-item index="/Message"><i class="fa fa-wa fa-pencil"></i> 留言板</el-menu-item>
              <el-menu-item index="/Aboutme"><i class="fa fa-wa fa-vcard"></i> 关于</el-menu-item>
            </el-menu>
          </div>
        </el-col>
      </el-row>

      </div>
    </div>
</template>

<script>
    export default {
        name: "CxHeader",
      data(){
          return{
            userInfo: '', //用户信息
            haslogin: false, //是否已登录
            classListObj: [
              {
                class_id:1,
                cate_name:'技术分享'
              },
              {
                class_id:2,
                cate_name:'内功心法'
              }
            ], //技术分类
            activeIndex: '/', //当前选择的路由模块
            state: '', //icon点击状态
            pMenu: true, //手机端菜单打开
            // path:'',//当前打开页面的路径
            input: '', //input输入内容
            headBg: 'url(static/img/headbg05.jpg)', //头部背景图
            headTou: '', //头像
            projectList: [
              {
                nav_url:1,
                nav_name:'武林秘籍'
              },
              {
                nav_url:1,
                nav_name:'奇门遁甲'
              }
            ] //项目列表
          }
      }
    }
</script>

<style>
  .headBack {
    width: 100%;
    background: rgba(40, 42, 44, 0.6);
    /*margin-bottom:30px;*/
    box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .12), 0 0 6px 0 rgba(0, 0, 0, .04);
    position: fixed;
    left: 0;
    top: 0;
    right: 0;
    z-index: 100;
  }
  .headBox li.is-active {
    /*background: #48456C;*/
    background: rgba(73, 69, 107, 0.7);
  }

</style>
