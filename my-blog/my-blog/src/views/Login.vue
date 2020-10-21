<template>
  <div>
    <div class="container">
      <h1 class="loginTitle">
        <a href="#/">这是谁的的博客</a>
      </h1>
      <!--      登陆注册-->
      <div v-show="!err2005" class="">
        <div v-if="login === 1" class="loginBox">
          <div class="lr-title">
            <h1>登录</h1>
            <p>
              新用户<a href="#/Login?login=0" class="tcolors">注册</a>
            </p>
          </div>
          <el-alert v-show="loginErr"
                    :title="loginTitle"
                    type="error"
                    show-icon
                    :closable="false">
          </el-alert>
          <el-input type="email"
                    placeholder="邮箱"
                    v-model="email">
          </el-input>

          <el-input
            type="password"
            placeholder="密码"
            @keyup.enter.native="loginEnterFun"
            v-model="password">
          </el-input>
          <el-alert
            v-show="passwordErr"
            title="请输入密码"
            type="error"
            show-icon :closable="false">
          </el-alert>
          <h3><a href="">忘记密码？</a></h3>
          <div class="lr-btn tcolors-bg" @click="gotoHome">登录</div>
          <div class="otherLogin">
            <a href="javascript:void(0)"><i class="fa fa-fw fa-wechat"></i></a>
            <a href="javascript:void(0)"><i class="fa fa-fw fa-qq"></i></a>
            <a href="javascript:void(0)"><i class="fa fa-fw fa-weibo"></i></a>
          </div>
        </div>
        <div v-else class="registerBox">
          <div class="lr-title">
            <h1>注册</h1>
            <p>
              已有账号<a href="#/Login?login=1" class="tcolors">登录</a>
            </p>
          </div>
          <el-alert
            v-show="registerErr"
            :title="registerTitle"
            type="error"
            show-icon :closable="false">
          </el-alert>
          <el-input
            type="text"
            placeholder="用户名"
            v-model="nusername">
          </el-input>
          <el-alert
            v-show="nusernameErr"
            title="用户名错误"
            type="error"
            show-icon :closable="false">
          </el-alert>
          <el-input
            type="email"
            placeholder="邮箱"
            v-model="nemail">
          </el-input>
          <el-alert
            v-show="nemailErr"
            title="邮箱错误"
            type="error"
            show-icon :closable="false">
          </el-alert>
          <el-input
            type="password"
            placeholder="密码:6-12位英文、数字、下划线"
            v-model="npassword">
          </el-input>
          <el-alert
            v-show="npasswordErr"
            title="密码错误"
            type="error"
            show-icon :closable="false">
          </el-alert>
          <el-input
            type="password"
            placeholder="确认密码"
            @keyup.enter.native="registerEnterFun"
            v-model="npassword2">
          </el-input>
          <el-alert
            v-show="npassword2Err"
            title="重复密码有误"
            type="error"
            show-icon :closable="false">
          </el-alert>
          <div class="lr-btn tcolors-bg" @click="newRegister" v-loading.fullscreen.lock="fullscreenLoading"
               element-loading-text="提交中">注册
          </div>
          <!--          注册进度状态-->
          <div v-show="err2005">
            <div class="sucIcon">
              <el-steps :space="100" :active="step" finish-status="success">
                <el-step title="注册"></el-step>
                <el-step title="验证"></el-step>
                <el-step title="登录"></el-step>
              </el-steps>
            </div>
            <div v-show="urlstate === 0" class="sucContent">
              账号激活链接已发送至您的邮箱：{{nemail}}
              <p>请您在24小时内登录邮箱，按邮件中的提示完成账号激活操作</p>
            </div>
            <div v-show="urlstate === 'urlInvalid'" class="sucContent">
              账号已激活，这就去登录  <span class="tcolors-bg lastbtn" @click="goLogin">登录</span>0
            </div>
            <div v-show="urlstate === 'urlErr'" class="sucContent">
              邮箱激活地址已超时，验证失败，请重新注册  <span class="tcolors-bg lastbtn" @click="goRegister">注册</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Login",
    data() {
      return {
        username: '',//用户名
        email: '',//邮箱
        password: '',//密码
        nusername: '',//新用户注册名
        nemail: '',//新用户注册邮箱
        npassword: '',//新用户注册密码
        npassword2: '',//新用户注册重复密码
        login: 0,//是否已经登录
        emailErr: false,//登录邮箱错误
        passwordErr: false,//的轮毂密码错误
        loginErr: false,//登录错误
        loginTitle: '用户名或密码错误',
        nusernameErr: false,//新用户注册用户名错误
        nemailErr: false,//新用户注册邮箱错误
        npasswordErr: false,//新用户注册密码错误
        npassword2Err: false,//新用户注册重复密码错误
        registerErr: false,//已注册错误
        registerTitle: '该邮箱已注册',
        err2005: false,//是否展示注册进度条状态
        step: 1,//注册进度
        fullscreenLoading: false,//全屏loading
        urlstate: 0,//重新注册
      }
    },
    created() {
      this.routeChange();
    },
    methods: {
      routeChange() {
        this.login = this.$route.query.login === undefined ? 1 : parseInt(this.$route.query.login);
        this.urlstate = this.$route.query.urlstate === undefined ? 0 : this.$route.query.urlstate;
        if (this.urlstate === 0) {
          this.err2005 = false;
          this.step = 1;
        } else if (this.urlstate === 'urlInvalid') {
          this.err2005 = true;
          this.step = 2;
        } else if (this.urlstate == 'urlErr') {
          this.err2005 = true;
          this.step = 1;
        }
      }


    }
  }
</script>

<style>
  .loginTitle{
    text-align: center;
    font-size: 27px;
    padding-top: 50px;
    margin-bottom: 20px;
  }
  .loginBox{
    padding-bottom: 0;
  }
  .loginBox,.registerBox{
    background: #fff;
    padding:40px;
    max-width:320px;
    margin:0 auto;
  }
</style>
