<!--文章列表-->
<template>
  <el-row class="sharelistbox">
    <div v-if="this.$route.name ==='Share'&&!this.$route.query.keywords" class="shareTitle">
      <div class="ui label">
        <a :href="'#/Share?classId='+classId">{{className}}</a>
      </div>
      <ul v-if="sonclassList" class="shareclassTwo">
        <li v-for="(citem,index) in sonclassList">
          <a :href="'#/Share?classId='+classId+'&classtwoId='+citem.class_id" :class="citem.class_id==classtwoId?'active':''">{{citem.cate_name}}</a>
        </li>
      </ul>
    </div>
    <el-clo :span="24" class="s-item tcommonBox" v-for="(item,index) in articleList" :key="'article'+index">
      <span class="s-round-date">
        <span class="month" v-html="showInitDate(item.create_time,'month')+'月'"></span>
        <span class="day" v-html="showInitDate(item.create_time,'date')"></span>
      </span>
      <header>
        <h1>
          <a :href="'#/DetailShare?aid='+item.id" target="_blank">
            {{item.title}}
          </a>
        </h1>
        <h2>
          <i class="fa fa-fw fa-user"></i>发表于
          <i class="fa fa-fw fa-clock-o"></i><span v-html="showInitDate(item.create_time,'all')">{{showInitDate(item.create_time,'all')}}</span> •
          <i class="fa fa-fw fa-eye"></i>{{item.browse_count}} 次围观 •
          <i class="fa fa-fw fa-comments"></i>活捉 {{item.comment_count}} 条 •
          <span class="rateBox">
            <i class="fa fa-fw fa-heart"></i>{{item.like_count?item.like_count:0}}点赞 •
            <i class="fa fa-fw fa-star"></i>{{item.collect_count?item.collect_count:0}}收藏
          </span>
        </h2>
        <div class="ui label">
          <a :href="'#/share?classId='+item.class_id">{{item.cate_name}}</a>
        </div>
      </header>
      <div class="article-content">
        <p style="text-indent:2em;">
          {{item.description}}
        </p>
        <p style="max-height: 300px;overflow:hidden;text-align: center;">
          <img :src="item.image" alt="" class="maxW">
        </p>
      </div>
      <div class="viewdetail">
        <a class="tcolors-bg" :href="'#/DetailShare?aid='+item.id" target="_blank">
          阅读全文>>
        </a>
      </div>
    </el-clo>
    <el-col class="viewmore">
      <a v-show="hasMore" class="tcolors-bg" href="javascript:void(0)" @click="addMoreFun">点击加载更多</a>
      <a v-show="!hasMore" class="tcolors-bg" href="javascript:void(0)">暂无更多数据</a>
    </el-col>
  </el-row>
</template>

<script>
  export default {
    name: "Share",
    data() {
      return {
        artId: 0,
        classId: 0,
        sendId: '',
        className: '',
        sonclassList: '',//二级分类
        classtwoId: 5,
        keywords: '',
        hasMore: true,
        level: 1,
        shareClass: [
          {
            classId: 1, name: '技术分享', detshare: [
              {classId: 5, name: '移动端H5', pid: 1},
              {classId: 6, name: 'pc端web', pid: 1},
              {classId: 7, name: '小程序', pid: 1},
              {classId: 8, name: 'php', pid: 1},
              {classId: 9, name: 'nodejs', pid: 1},
              {classId: 10, name: '软件', pid: 1},
              {classId: 11, name: '其他', pid: 1}
            ]
          },
          {classId: 2, name: '闲言碎语'},
          {classId: 3, name: '事件簿'},
          {classId: 4, name: '创作集'}
        ],
        queryClass: 1,
        articleList: '',
      }
    },
    methods:{

    }
  }
</script>

<style scoped>

</style>
