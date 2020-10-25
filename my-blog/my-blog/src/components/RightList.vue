<!--右侧固定导航栏-->
<template>
  <div class="rightlistBox">
    <section>
      <div class="rl-head">
        <img
          :src="this.$store.state.themeObj.center_smailimg?this.$store.state.themeObj.center_smailimg:'static/img/headtou02.jpg'"
          alt="">
        <h1 v-if="this.$store.state.themeObj.user_start!=0">
          <span>**</span>***
        </h1>
      </div>
      <div class="rl-body">
        <p>你在想啥呢？</p>
        <div class="catch-me">
          <div class="">
            <el-tooltip class="item" content="GitHub" placement="top">
              <a :href="catchMeObj[isAimee].git" target="_blank"><i class="fa fa-fw fa-github"></i></a>
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="QQ" placement="top">
              <a :href="catchMeObj[isAimee].qq" target="_blank"><i class="fa fa-fw fa-qq"></i></a>
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="微博" placement="top">
              <a :href="catchMeObj[isAimee].sina" target="_blank"><i class="fa fa-fw fa-weibo"></i></a>
            </el-tooltip>
          </div>
          <div>
            <el-tooltip class="item" effect="dark" content="微信" placement="top">
              <a :href="catchMeObj[isAimee].wechat" target="_blank"><i class="fa fa-fw fa-wechat"></i></a>
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="CSDN" placement="top">
              <a :href="catchMeObj[isAimee].csdn" target="_blank"><i class="">C</i></a>
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="简历" placement="top">
              <a :href="catchMeObj[isAimee].job" target="_blank"><i class="fa fa-fw fa-file-word-o"></i></a>
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="更多" placement="top">
              <a href="#/Aboutme"><i class="el-icon-more"></i></a>
            </el-tooltip>
          </div>
        </div>
      </div>
    </section>
    <section :class="fixDo?'rs2 fixed':'rs2'" @click="lovemeFun">
      <p>
        Do you *********?
      </p>
      <div class="">
        <i :class="loveme?'heart active':heart"></i>
        <span>{{likeNum}}</span>
      </div>
    </section>
    <section></section>
    <section class="rs3">
      <h2 class="ui label">
        这些人你们说啥呢
      </h2>
      <ul class="rs3-textwidget">
        <li class="rs3-item" v-for="(item,index) in artCommentList" :key="'artCommentList'+index">
          <a :href="'#/DetailShare?aid='+item.id" target="_blank">
            <div class="rs3-photo">
              <img :src="item.avatar"  :onerror="$store.state.errorImg">
            </div>
            <div class="rs3-inner">
              <p class="rs3-author">{{item.nickname}} 在「{{item.title}}」中说:</p>
              <p class="rs3-text">{{item.content}}</p>
            </div>
          </a>
        </li>
      </ul>
    </section>
    <section class="rs4">
      <h2 class="ui label">
        大家都争相恐后来看
      </h2>
      <ul>
        <li v-for="(item,index) in browseList" :key="'browseList'+index">
          <a :href="'#/DetailShare?aid='+item.id "target="_blank">{{item.title}}</a> ----{{item.browse_count}}次膜拜
        </li>
      </ul>
    </section>
    <div v-if="this.$store.state.themeObj.user_start!=0" :class="gotoTop?'toTop hidden':'toTop goTop hidden'" @click="toTopfun">
      <img :src="this.$store.state.themeObj.right_img?this.$store.state.themeObj.right_img:'static/img/scroll.png'" alt="">
    </div>
    <div v-else :class="gotoTop?'toTophui hidden':'toTophui goTophui hidden'" @click="toTopfun">
      <img :src="this.$store.state.themeObj.right_img?this.$store.state.themeObj.right_img:'static/img/scroll.png'" alt="">
    </div>
  </div>
</template>

<script>
  export default {
    name: "RightList",

    data() { //选项 / 数据
      return {
        fixDo: false,
        loveme: false,
        gotoTop: false,//返回顶部
        going: false,//是否正在执行上滑动作
        browseList: '',//浏览量最多
        artCommentList: '',//评论量最多
        likeNum: 0,//do you like me 点击量
        initLikeNum: 0,//初始化喜欢数量
        catchMeObj: {//抓住我 个人信息
          Qinlh: {
            git: 'https://gitee.com/qinlh',
            qq: 'static/img/qinlh/qq.jpg',
            sina: 'https://weibo.com/u/2313631533',
            wechat: 'static/img/qinlh/wechat.jpg',
            csdn: 'http://www.qinlinhui.cn',
            job: 'http://qinlh.mangoya.cn/MyResume/'
          },
          Aimee: {
            git: 'https://github.com/Aimee1608',
            qq: 'static/img/aimee/QQ.jpg',
            sina: 'https://weibo.com/u/2242812941',
            wechat: 'static/img/aimee/erwm.jpg',
            csdn: 'http://blog.csdn.net/Aimee1608',
            job: 'http://aimee.mangoya.cn'
          }
        },
        isAimee: this.$store.state.themeObj.user_start != 0 ? "Aimee" : "Qinlh"//判断是哪个的博客
      }
    },

  }
</script>

<style lang="less">
  .rightlistBox{
    position: relative;
  }
  .rightlistBox section{
    transition: all 0.2s linear;
    position: relative;
    background: #fff;
    padding:15px;
    margin-bottom: 20px;
    border-radius: 5px;
  }

  .rightlistBox section:hover{
    transform: translate(0,-2px);
    box-shadow:0 15px 30px rgba(0,0,0,.1);
  }

  .rightlistBox .r1-head {
    text-align: center;
    border-radius: 4px 4px 0 0 ;
    position: relative;
  }

  .rightlistBox .r1-head h1{
    position: absolute;
    bottom:5px;
    margin:0 0 0 -65px;
    font-size: 20px;
    letter-spacing:0.5px;
    color:#fff;
    text-shadow: 1px 1px 1px rgba(0,0,0,.7);
    font-weight: 700;
    width:130px;
    left:50%;
  }

  .rightlistBox .r1-head h1 span{
    opacity: 0.3;
  }
  .rightlistBox.rl-body p{
    font-size: 14px;
    margin:5px 0 8px 0;
    font-weight: 700;
    text-align: center;

  }

  .rightlistBox .rl-body .catch-me{
    text-align: center;
  }

  .rightlistBox .rl-body .catch-me a{

  }
</style>
