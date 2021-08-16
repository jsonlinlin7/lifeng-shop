<template>
  <div id="category">
    <div class="header-container">
      <top-nav></top-nav>
    </div>
    <div class="main-container top-space-middle">
      <router-view />
    </div>
    <div class="footer-container top-space-middle fixed-bottom">
      <shopping-cart></shopping-cart>
    </div>
  </div>
</template>

<script>
export default {
  name: "Category",
  components: {
    "top-nav": () => import("@/components/TopNav"),
    "shopping-cart": () => import("@/components/ShoppingCart"),
  },
};
</script>

<style scoped>
</style>
