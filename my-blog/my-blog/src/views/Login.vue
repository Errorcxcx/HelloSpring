<!-- 登录注册 -->
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
          <el-form :model="loginForm" status-icon :rules="loginRules" ref="loginForm"
                   class="demo-ruleForm">
            <el-form-item prop="username">
              <el-input placeholder="用户名" type="text" v-model="loginForm.username"></el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input placeholder="密码" type="password" v-model="loginForm.password"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button class="lr-btn tcolors-bg" type="primary" @click="gotoLogin('loginForm')">登录</el-button>
            </el-form-item>
          </el-form>
          <h3><a href="">忘记密码？</a></h3>
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
          <el-form :model="registForm" status-icon :rules="registRoules" ref="registForm"
                   class="demo-ruleForm">
            <el-form-item prop="nusername">
              <el-input placeholder="请输入用户名" type="text" v-model="registForm.nusername"></el-input>
            </el-form-item>
            <el-form-item prop="nemail">
              <el-input placeholder="请输入邮箱" type="text" v-model="registForm.nemail"></el-input>
            </el-form-item>
            <el-form-item prop="npassword1">
              <el-input placeholder="请输入密码" type="password" v-model="registForm.npassword1"></el-input>
            </el-form-item>
            <el-form-item prop="npassword2">
              <el-input placeholder="请再次输入密码" type="password" v-model="registForm.npassword2"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button class="lr-btn tcolors-bg" type="primary" @click="gotoRegist('registForm')">注册</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>

      <!--          注册进度状态-->
<!--      <div v-show="err2005" class="registerSuc">-->
<!--        <div class="sucIcon">-->
<!--          <el-steps :space="100" :active="step" finish-status="success">-->
<!--            <el-step title="注册"></el-step>-->
<!--            <el-step title="验证"></el-step>-->
<!--            <el-step title="登录"></el-step>-->
<!--          </el-steps>-->
<!--        </div>-->
<!--        <div v-show="urlstate === 0" class="sucContent">-->
<!--          账号激活链接已发送至您的邮箱：{{nemail}}-->
<!--          <p>请您在24小时内登录邮箱，按邮件中的提示完成账号激活操作</p>-->
<!--        </div>-->
<!--        <div v-show="urlstate === 'urlInvalid'" class="sucContent">-->
<!--          账号已激活，这就去登录 <span class="tcolors-bg lastbtn" @click="goLogin">登录</span>0-->
<!--        </div>-->
<!--        <div v-show="urlstate === 'urlErr'" class="sucContent">-->
<!--          邮箱激活地址已超时，验证失败，请重新注册 <span class="tcolors-bg lastbtn" @click="goRegister">注册</span>-->
<!--        </div>-->
<!--      </div>-->
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      let checkName = (rule, value, callback) => {
        let reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;

        if (!value) {
          return callback(new Error("邮箱不能为空"))
        }
        setTimeout(() => {
          if (!reg.test(value)) {
            return callback(new Error("邮箱格式不正确"))
          }
          callback();
        }, 1000)
      };
      let checkPsd = (rule, value, callback) => {
        if (!value) {
          return callback(new Error("密码不能为空"))
        }
        callback();
      };
      let checkNname = (rule,value,callback)=>{
        if (!value) {
          return callback(new Error("用户名不能为空"))
        }
        callback();
      };
      let checkNemail =(rule,value,callback)=>{
        if(!value){
          return callback(new Error("用户名不能为空"))
        }
        let reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;

        if(!reg.test(value)){
          return callback(new Error("请输入正确邮箱"))
        }
        callback()
      };
      let checkNpassword1 = (rule,value,callback)=>{
        if(value === ''){
          return callback(new Error("请输入密码"))
        }else{
          if (this.registForm.npassword2 !== '') {
            this.$refs.registForm.validateField('npassword2');
          }
          callback();
        }
      };
      let checkNpassword2 = (rule,value,callback)=>{
        if(value === ''){
          return callback(new Error("请再次输入密码"))
        }
        if(value !== this.registForm.npassword1){
          return callback(new Error('两次输入密码不一致!'));
        }
        callback();
      }

      return {
        name:1,
        loginForm: {
          username: 'ssss',//用户名
          password: 'ssss',//密码
        },
        registForm: {
          nusername: '',
          nemail: '',
          npassword1: '',
          npassword2: ''
        },
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
        loginRules: {
          username: [
            {validator: checkName, trigger: 'blur'}
          ],
          password: [
            {validator: checkPsd, trigger: 'blur'}
          ]
        },
        registRoules:{
          nusername:[
            {validator: checkNname, trigger: 'blur'}
          ],
          nemail:[
            {validator:checkNemail,trigger: 'blur'}
          ],
          npassword1:[
            {validator:checkNpassword1,trigger: 'blur'}
          ],
          npassword2:[
            {validator:checkNpassword2,trigger: 'blur'}
          ]
        }
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
      },
      gotoLogin(formName) {
        console.log(this.loginForm)
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log('success submit!!');

          } else {
            console.log('error submit!!');
            return false;
          }
        })
      },
      gotoRegist(formName){
        console.log(this.registForm);
        this.$refs[formName].validate((valid)=>{
          if(valid){
            console.log('success submit!!');

          }else {
            console.log('error submit!!');
            return false;
          }
        })
      }
    }
  }
</script>

<style>
  .loginTitle {
    text-align: center;
    font-size: 27px;
    padding-top: 50px;
    margin-bottom: 20px;
  }

  .loginBox {
    padding-bottom: 0;
  }

  .loginBox, .registerBox {
    background: #fff;
    padding: 40px;
    max-width: 320px;
    margin: 0 auto;
  }

  .lr-title {
    height: 32px;
    line-height: 32px;
    margin-bottom: 20px;
    position: relative;
  }

  .lr-title h1 {
    font-size: 24px;
    color: #666;
    font-weight: bold;
    /*width:50%;*/
  }

  .lr-title p {
    font-size: 12px;
    color: #999;
    position: absolute;
    right: 0;
    top: 0;
  }

  .lr-btn {
    color: #fff;
    text-align: center;
    letter-spacing: 8px;
    padding: 9px;
    border-radius: 5px;
    cursor: pointer;
    margin-bottom: 15px;
    width: 320px;
  }


  .el-input__inner {
    border-radius: 5px;
  }

  .el-form-item__content {
    margin-bottom: 30px;
  }

  .loginBox h3, .registerBox h3 {
    text-align: right;
    margin-bottom: 20px;
  }

  .el-form-item {
    margin-bottom: 0px;
  }

  /*  登录成功*/
  .registerSuc {
    padding: 40px;
    margin: 0 auto;
  }

  .registerSuc .sucIcon {
    margin-bottom: 30px;
    padding-left: 66px;
  }

  .el-steps--horizontal {
    width: 300px;
    margin: auto;
  }

  .registerSuc .sucContent {
    line-height: 1.5;
    font-size: 15px;
    text-align: center;
  }

  .registerSuc .sucContent p {
    margin-top: 10px;
    font-size: 13px;
    color: #999;
  }

  .registerSuc .sucContent .lastbtn {
    display: inline-block;
    font-size: 14px;
    padding: 3px 10px;
    border-radius: 5px;
    color: #fff;
    cursor: pointer;
  }

  .registerSuc .sucContent .el-icon-close {
    fong-size: 13px;
  }
</style>
