<template xmlns:el-col="http://www.w3.org/1999/html">
  <div id="indexMain">
    <el-row>
      <el-col :span="6">
        <index-category></index-category>
      </el-col>
      <!-- <el-col :span="1" class="null"></el-col> -->
      <el-col :span="18">
        <index-content></index-content>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: "IndexMain",
    components: {
      "index-category": () => import("@/views/IndexCategory"),
      "index-content": () => import("@/views/IndexContent"),
    }
  }
</script>

<style scoped>
  /* #indexMain{z-index: -1;} */
</style>
