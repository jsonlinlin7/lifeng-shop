<template>
  <div id="app">
    <div id="nav">
      <el-row>
        <el-col :span="2">
            <NewBottomNav></NewBottomNav>
        </el-col>
        <el-col :span="20">
          <!--          <router-view/>标签就代表着当前path(路径)所对应的component(组件)-->
          <router-view/>
        </el-col>
        <el-col :span="2"><div class="null"></div></el-col>
      </el-row>
    </div>
  </div>
</template>
<script type="text/javascript">
  import NewBottomNav from "./components/NewBottomNav";

  export default{
    components:{
      NewBottomNav

    }
  }
</script>
<style>
  #app {
    background-color: #ffffff;
    width: 100%;
    height: 100%;
    overflow: hidden;
  }
  .null{
    min-height: 10px;
  }

  .fixed-bottom{
    position:fixed;
    bottom:0;
    right: 400px;
  }

.top-space-small{
  margin-top: 10px;
}
.top-space-middle{
  margin-top: 30px;
}
.top-space-large{
  margin-top: 50px;
}
a {
  text-decoration: none;
}
</style>
