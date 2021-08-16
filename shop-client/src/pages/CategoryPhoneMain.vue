<template>
  <div id="categoryPhoneMain">
    <!--    编码测试阶段 主页面为phone-->
    <el-row>
      <category-phone-content></category-phone-content>
    </el-row>

    <div class="footer-container" style="margin-top: 3%">
      <NavFooter></NavFooter>
    </div>
  </div>
</template>

<script>
export default {
  name: "CategoryPhoneMain",
  components: {
    categoryPhoneContent: () => import("@/components/CategoryPhoneContent"),
    NavFooter: () => import("@/components/NavFooter"),
  },
};
</script>

<style scoped>
</style>