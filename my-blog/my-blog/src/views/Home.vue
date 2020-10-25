<!--首页-->
<template>
    <div class="">
      <cx-header></cx-header>
      <div class="container">
        <el-col :sm="24" :md="16" style="transition:all .5s ease-out;margin-bottom:30px;">
          <share-list></share-list>
        </el-col>
        <el-col :sm="24"  :md="8">
        </el-col>
      </div>
    </div>
</template>

<script>
  import CxHeader from '../components/CxHeader'
  import ShareList from "../components/ShareList";
    export default {
        name: "Home",
        components:{ShareList, CxHeader,}
    }
</script>

<style>

</style>
