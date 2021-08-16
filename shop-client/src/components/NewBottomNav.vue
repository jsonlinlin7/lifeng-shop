<template >
  <div class="NewBottomNav">
    <div class="null"></div>
    <div class="buttondiv">
      <el-button @click="hrefcart('cart')" class="i_img" v-show="showButton">
        <i style="font-size: 50px" class="el-icon-shopping-cart-full"></i>
      </el-button>
      <!-- <div style="display: flex;margin-top:5px;height100px;" class="shopping">
        <transition name="el-zoom-in-bottom">
          <div v-show="showNBN" class="transition-box">
            <el-card>
              <el-button class="cart-item" type="primary">查看详情</el-button>

              <el-button class="cart-item" type="primary">查看详情</el-button>
              <span class="cart-item">已选择 {{cartDetail.count}} 件商品</span>
              <el-button class="cart-item" type="info">清空购物车</el-button>
              <span class="cart-item">总价: {{cartDetail.total}}</span>
              <el-button class="cart-item" type="success">结算</el-button>
              <el-button class="cart-item" @click="getUserInfo">测试按钮</el-button>
            </el-card>
          </div>
        </transition>
      </div> -->
    </div>
  </div>
</template>
<script type="text/javascript">
export default {
  name: "NewBottomNav",
  data() {
    return {
      showButton: true, //显示购物车按钮
      cart: {
        goodsList: [
          {
            name: "Z590A主板",
            price: 2699,
            count: 3,
            image:
              "https://img20.360buyimg.com/n0/s80x80_jfs/t1/172890/5/2293/465745/606c1607E941b3569/aca4f1fbab113b27.jpg.dpg",
          },
          {
            name: "罗技G933s 无线头戴式游戏耳机",
            price: 999,
            count: 2,
            image:
              "https://img10.360buyimg.com/n0/s80x80_jfs/t1/55880/30/992/220322/5cebd743Ea10a8abe/766c27b62f5ec959.jpg.dpg",
          },
        ],
      },
    };
  },
  computed: {
    cartDetail() {
      let cartDetail = {
        count: 0,
        total: 0,
      };
      this.cart.goodsList.forEach((item) => {
        cartDetail.count += item.count;
        cartDetail.total += item.count * item.price;
      });
      return cartDetail;
    },
  },
  methods: {
    getUserInfo() {
      console.log(this.$store.getters.user);
    },
    hrefcart() {
      /* this.$message({
        message: "进入购物车",
        type: "success",
      }); */
      this.$router.push("/cart");
    },
  },
};
</script>

<style media="screen">
.NewBottomNav {
  position: relative;
}
.shopping {
  position: fixed;
  bottom: 1%;
  right: 8%;
}
.i_img {
  font-size: 50px;
}
.buttondiv {
  width: 100%;
  z-index: 100;
  position: fixed;
  bottom: 2%;
  left: 92%;
}
</style>
