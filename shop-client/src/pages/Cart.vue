<template>
  <div>
    <div class="header-container">
      <top-nav></top-nav>
    </div>
    <div class="main-container top-space-middle">
      <router-view />
    </div>
    <div class="footer-container" style="margin-top: 3%">
      <NavFooter></NavFooter>
    </div>
  </div>
</template>

<script>
export default {
  name: "Cart",
  components: {
    "top-nav": () => import("@/components/TopNav"),
    NavFooter: () => import("@/components/NavFooter"),
  },
};
</script>

<style scoped>
body {
  height: 10vh;
}
</style>
