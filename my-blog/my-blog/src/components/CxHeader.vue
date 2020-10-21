<template>
  <div class="">
    <div class="headBack">
      <el-row class="container">
        <el-col :span="24">
          <div class="headBox">
            <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
              <el-menu-item index="/Home"><i class="fa fa-wa fa-home"></i> 首页</el-menu-item>
              <el-submenu index="/Share">
                <template slot="title"><i class="fa fa-wa fa-archive"></i> 分类</template>
                <el-menu-item v-for="(item,index) in classListObj" :key="'class1'+index"
                              :index="'/Share?classId='+item.class_id">{{item.cate_name}}
                </el-menu-item>
              </el-submenu>
              <el-submenu index="/Aboutme">
                <template slot="title"><i class="fa fa-wa fa-flask"></i> 实验室</template>
                <el-menu-item v-for="(item,index) in projectList" :key="'class2'+index" index=""><a :href="item.nav_url"
                                                                                                    target="_blank">{{item.nav_name}}</a>
                </el-menu-item>
              </el-submenu>
              <el-menu-item index="/Reward"><i class="fa fa-wa fa-cny"></i> 赞赏</el-menu-item>
              <el-menu-item index="/Friendslink"><i class="fa fa-wa fa-users"></i> 伙伴</el-menu-item>
              <el-menu-item index="/Message"><i class="fa fa-wa fa-pencil"></i> 留言板</el-menu-item>
              <el-menu-item index="/Aboutme"><i class="fa fa-wa fa-vcard"></i> 关于</el-menu-item>
              <div index="" class="pcsearchbox">
                <i class="el-icon-search pcsearchicon"></i>
                <div class="pcsearchinput" :class="input?'hasSerached':''">
                  <el-input placeholder="搜索" v-model="input" @keyup.enter.native="searchEnterFun">
                    <i slot="suffix" class="el-input__icon el-icon-search" @click="searchEnterFun"></i>
                  </el-input>
                </div>
              </div>
              <dv class="userInfo">
                <div v-show="!haslogin" class="nologin">
                  <a href="javascript:void(0)" @click="loginFun(1)">登录</a>|<a href="javascript:void(0)"
                                                                              @click="loginFun(0)">注册</a>
                </div>
              </dv>
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
    data() {
      return {
        userInfo: '', //用户信息
        haslogin: false, //是否已登录
        classListObj: [
          {
            class_id: 1,
            cate_name: '技术分享'
          },
          {
            class_id: 2,
            cate_name: '内功心法'
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
            nav_url: 1,
            nav_name: '武林秘籍'
          },
          {
            nav_url: 1,
            nav_name: '奇门遁甲'
          }
        ] //项目列表
      }
    },
    created() {
    },
    watch: {},
    methods: {
      handleOpen(key, keyPath) { //分组菜单打开
        // console.log(key, keyPath);
      },
      handleClose(key, keyPath) { //分组菜单关闭
        // console.log(key, keyPath);
      },
      handleSelect(key, keyPath) {
        // console.log(key, keyPath);

      },
      searchChangeFun(e) { //input change 事件
        // console.log(e)
        if (this.input == '') {
          this.$store.state.keywords = '';
          this.$router.push({path: '/'});
        }
        console.log('ssssssss')
      },
      searchEnterFun: function (e) {
        if (this.input) {
          this.$store.state.keywords = this.input;
          this.$router.push({path: '/Share?keywords=' + this.input})
        }
        console.log('nbbbbbb')
      },
      loginFun(msg) {
        localStorage.setItem('logUrl', this.$route.fullPath);

        if (msg === 0) {
          this.$router.push({
            path: '/Login?login=0'
          })
        } else {
          this.$router.push({
            path: '/Login?login=1'
          })
        }
      },
      userlogout() {
        this.$confirm('是否确认退出?', '退出提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(()=>{
          console.log(this.$route.path);

        })
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

  .el-menu--horizontal .el-menu .el-menu-item.is-active,
  .el-menu--horizontal > .el-submenu:focus .el-submenu__title {
    color: white;

  }

  .el-menu--horizontal > .el-submenu.is-active .el-submenu__title {
    border-bottom: none !important;
  }

  .headBox .el-menu-demo {
    background: transparent;
    border-bottom: none !important;
  }

  .headBox .el-menu-demo li.el-menu-item,
  .headBox .el-menu--horizontal .el-submenu .el-submenu__title {
    height: 38px;
    line-height: 38px;
    border-bottom: none !important;

  }

  .headBox .el-submenu li.el-menu-item {
    height: 600px;
    line-height: 38px;
  }

  .el-menu--horizontal .el-menu .el-menu-item,
  .el-menu--horizontal .el-menu .el-submenu__title {
    background: #48456C;
    border-bottom: none;
    height: 38px;
    line-height: 38px;
    color: #fff;
  }

  .el-menu--popup-bottom-start {
    margin-top: 0px;
  }

  .el-menu--popup {
    padding: 0px 0;
    min-width: 100%;
  }

  .headBox ul li.el-menu-item,
  .headBox .el-submenu div.el-submenu__title,
  .headBox .el-submenu__title i.el-submenu__icon-arrow,
  .el-menu-item a {
    color: #fff;
  }

  .headBox .el-menu-demo li.el-menu-item:hover,
  .el-menu-item a {
    background: #48456C;
    border-bottom: none;
    color: #fff;
  }

  .headBox li.is-active,
  .el-menu--horizontal > .el-menu-item.is-active,
  .el-menu--horizontal > .el-submenu.is-active .el-submenu__title,
  .el-menu--horizontal > .el-menu-item:not(.is-disabled):focus, .el-menu--horizontal > .el-menu-item:not(.is-disabled):hover {
    /*background: #48456C;*/
    background: rgba(73, 69, 107, 0.7);
    color: white;
  }

  .el-menu--horizontal > .el-submenu:hover,
  .headBox .el-menu--horizontal .el-submenu .el-submenu__title:hover {
    background: #48456C;
    color: #fff;
  }

  .el-menu--horizontal .el-menu .el-menu-item:hover {
    background: #64609E;
    color: #fff;
  }

  .el-menu-item a {
    background: transparent;
  }

  /*  pc搜索框*/
  .pcsearchbox {
    padding: 0;
    max-width: 170px;
    height: 100%;
    line-height: 38px;
    position: absolute;
    top: 0;
    right: 0;
    cursor: pointer;
  }

  .headBox .pcsearchbox:hover .pcsearchinput {
    opacity: 1;
    /*transform: scaleX(1);*/
    visibility: visible;
  }

  .headBox .pcsearchbox i.pcsearchicon {
    color: #fff;
    padding-left: 10px;
  }

  .headBox .pcsearchbox .pcsearchinput {
    width: 180px;
    padding: 10px 20px 10px 20px;
    background: rgba(40, 42, 44, 0.6);
    border-radius: 0 0 2px 2px;
    position: absolute;
    right: 0;
    top: 38px;
    opacity: 0;
    visibility: hidden;
    /*transform: scaleX(0);*/
    transform-origin: right;
    transition: all 0.3s ease-out;
  }

  .headBox .el-input__inner {
    height: 30px;
    border: none;
    background: #fff;
    /*border: 1px solid #333;*/
    border-radius: 2px;
    padding-right: 10px;
  }

  .headBox .nologin {
    text-align: right;
  }

  .userInfo {
    height: 100%;
    line-height: 38px;
    position: absolute;
    right: 30px;
    top: 0;
    color: #fff;
  }

  .userInfo a {
    color: #fff;
    font-size: 13px;
    transition: all 0.2s ease-out;
  }

</style>
