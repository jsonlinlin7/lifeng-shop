<template>
  <div id="shoppingCart">
    <!-- <el-card> -->
    <!-- <el-button class="cart-item" type="primary">查看详情</el-button>
    <span class="cart-item">已选择 {{cartDetail.count}} 件商品</span>
    <el-button class="cart-item" type="info">清空购物车</el-button>
    <span class="cart-item">总价: {{cartDetail.total}}</span>
    <el-button class="cart-item" type="success">结算</el-button>
    <el-button class="cart-item" @click="getUserInfo">测试按钮</el-button> -->
    <!-- </el-card> -->

  </div>
</template>

<script>
  export default {
    name: "ShoppingCart",
    data() {
      return {
        cart: {
          goodsList:[
            {
              name: "Z590A主板",
              price: 2699,
              count: 3,
              image: "https://img20.360buyimg.com/n0/s80x80_jfs/t1/172890/5/2293/465745/606c1607E941b3569/aca4f1fbab113b27.jpg.dpg",
            },
            {
              name: "罗技G933s 无线头戴式游戏耳机",
              price: 999,
              count: 2,
              image: "https://img10.360buyimg.com/n0/s80x80_jfs/t1/55880/30/992/220322/5cebd743Ea10a8abe/766c27b62f5ec959.jpg.dpg",
            }
          ]
        }
      }
    },
    computed: {
      cartDetail() {
        let cartDetail={
          count: 0,
          total: 0
        };
        this.cart.goodsList.forEach(item => {
          cartDetail.count += item.count
          cartDetail.total += item.count*item.price
        })
        return cartDetail
      },

    },
    methods: {
      getUserInfo() {
        console.log(this.$store.getters.user)
      },
    }
  }
</script>

<style scoped>
  .cart-item{
    margin-left: 30px;
  }
</style>
