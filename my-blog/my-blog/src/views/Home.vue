<!--首页-->
<template>
    <div class="">
      <cx-header></cx-header>
      <div class="container">
        <el-col :sm="24" :md="16" style="transition:all .5s ease-out;margin-bottom:30px;">
        </el-col>
        <el-col :sm="24"  :md="8">
        </el-col>
      </div>
    </div>
</template>

<script>
  import CxHeader from '../components/CxHeader'
    export default {
        name: "Home",
        components:{CxHeader}
    }
</script>

<style>

</style>
