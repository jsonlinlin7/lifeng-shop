<template>
  <div id="index">
    <div class="header-container">
      <top-nav></top-nav>
    </div>
    <div class="main-container top-space-middle">
      <router-view/>
    </div>
    <div class="footer-container top-space-middle"><!--  fixed-bottom -->
      <shopping-cart></shopping-cart>
    </div>
    <!--    推荐页面-->
    <div class="footer-container" style="margin-top: 3%">
      <index-recommod></index-recommod>
      <NavFooter></NavFooter>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Index",
    components: {
      "top-nav": () => import("@/components/TopNav"),
      "shopping-cart": () => import("@/components/ShoppingCart"),
      //推荐页面
      "index-recommod":() => import("@/views/RecommendPage"),
      "NavFooter":()=>import("@/components/NavFooter")
    }
  }
</script>

<style scoped>

</style>
