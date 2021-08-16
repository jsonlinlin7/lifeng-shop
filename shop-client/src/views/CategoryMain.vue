<template>
  <div id="categoryMain">
    <!-- <p>这里是商品分类页, 需要传入参数</p> -->
    <!-- <p>这里是传入goodsName:{{ goodsName }}</p> -->
    <!-- <p>这里是传入goodsBrand:{{ goodsBrand }}</p> -->
    <category-phone-main></category-phone-main>
  </div>
</template>

<script>
export default {
  name: "CategoryMain",
  props: ["goodsName", "goodsBrand"],
  components: {
    categoryPhoneMain: () => import("@/pages/CategoryPhoneMain"),
  },
};
</script>

<style scoped>
</style>
