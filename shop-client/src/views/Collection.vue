<template>
  <div>
    <div class="header-container">
      <top-nav></top-nav>
    </div >
    <div class="main-container" style="margin-top: 3%">
      <div style="margin:0px auto;">
        <h2>我的收藏</h2>
        <el-card class="cardList">
          <div class="container">
            <div class="cart-box">
              <ul class="cart-item-head" >
                <li style="flex: 1;">
              <span
                  class="checkbox"
                  :class="[isSelectAll ? 'checked' : 'checkbox']"
                  @click="selectProduct(isSelectAll)"
              ></span
              >全选
                </li>
                <li style="flex: 0.8;"></li>
                <li style="flex: 3.2;text-align: left;">商品名称</li>
                <li style="flex: 1.5;text-align: left;">单价</li>
                <li style="flex: 1.3;">操作</li>
                <li style="flex: 0.3;"></li>
              </ul>
              <ul class="cart-item-list">
                <li
                    class="cart-item"
                    v-for="(item, index) in goodsList"
                    :key="index"
                >
                  <div class="item-check"  style="flex: 1;">
                <span
                    class="checkbox"
                    :class="[item.select ? 'checked' : 'checkbox']"
                    @click="item.select = !item.select"
                ></span>
                  </div>
                  <div class="item-name"  style="flex: 4;cursor: pointer" @click="toGoodsDetail(item.image,item.price,item.name)">
                    <img :src="item.image" alt="" />
                    <span>{{ item.name }}</span>
                  </div>
                  <div class="item-price" style="flex: 1.5;text-align: left;">￥{{ item.price }}</div>
                  <div class="item-del" style="flex: 0.5;cursor: pointer;color: skyblue;" @click="delOneProduct(index)">取消收藏</div>
                  <div class="item-del" style="flex: 0.8;cursor: pointer;color: skyblue;" @click="addShoppingCart(index)">加入购物车</div>
                  <div style="flex: 0.3;"></div>
                </li>

              </ul>
            </div>
            <div class="order-wrap clearfix">
              <div class="cart-tip fl">
                <a href="javascript:;" @click="delProduct">删除选中商品</a>
              </div>
            </div>
          </div>
        </el-card>
      </div>

    </div>
    <div class="footer-container" style="margin-top: 3%">
      <NavFooter></NavFooter>
    </div>
  </div>
</template>

<script>
export default {
  name: "collection",
  components: {
    "top-nav": () => import("@/components/TopNav"),
    "NavFooter": () => import("@/components/NavFooter"),
  },
  data() {
    return {
      goodsList: [
        {
          goodID: "",
          name: "REDMI K40 PRO+",
          image:
              "https://img14.360buyimg.com/seckillcms/s280x280_jfs/t1/173489/16/18773/49934/60e57e74Ee08a4681/643817bf2895b427.jpg.webp",
          price: "3369.00",
        },
        {
          goodID: "",
          name: "Bose无线耳机",
          image:
              "https://img10.360buyimg.com/seckillcms/s280x280_jfs/t1/179854/3/16039/143853/60fe73b1E9057f363/b0188fc56b781a0c.png.webp",
          price: "1559.00",
        },
        {
          goodID: "",
          name: "Apple MacBook Air/Pro",
          image:
              "https://img14.360buyimg.com/seckillcms/s280x280_jfs/t1/172765/20/21081/47478/60fa67bfE27c26c7b/902c20a8b2c1160a.jpg.webp",
          price: "2499.00",
        },
        {
          goodID: "",
          name: "坚果投影仪",
          image:
              "https://img12.360buyimg.com/seckillcms/s280x280_jfs/t1/173043/6/20718/172408/60fe6153E889bf164/aab2305367c1f990.jpg.webp",
          price: "3899.00",
        },
        {
          goodID: "",
          name: "山水骨传导耳机",
          image:
              "https://img30.360buyimg.com/seckillcms/s280x280_jfs/t1/199870/5/455/83131/6103639bE35cf1a2a/636cb982c7b14f41.jpg.webp",
          price: "149.00",
        },
        {
          goodID: "",
          name: "格力晶弘412升双开门冰箱",
          image:
              "https://img11.360buyimg.com/seckillcms/s500x500_jfs/t1/189875/35/16205/22896/610747beEce8f8a39/db989f0f4e7c8333.jpg",
          price: "3169.00",
        },
        {
          goodID: "",
          name: "鸿星尔克跑鞋",
          image:
              "https://img12.360buyimg.com/n7/jfs/t1/103406/38/17931/164668/5e8c2895Ef0388f2a/7c7501de7ff1a336.jpg",
          price: "209.00",
        },
      ],
    };
  },
  mounted: function () {
    var _this = this;
    //为goodsList添加select（是否选中）字段，初始值为true
    this.goodsList.map(function (item) {
      _this.$set(item, "select", true);
    });
  },
  computed: {
    // 检测是否全选
    isSelectAll: function () {
      if (this.goodsList.length === 0) {
        return false;
      }
      return this.goodsList.every(function (val) {
        return val.select;
      });
    },

  },
  methods: {

    // 全选与取消全选
    selectProduct: function (_isSelect) {
      console.log(_isSelect);
      //遍历goodsList，全部取反
      for (var i = 0, len = this.goodsList.length; i < len; i++) {
        this.goodsList[i].select = !_isSelect;
      }
    },

    // 删除已经选中(select=true)的产品
    delProduct: function () {
      this.goodsList = this.goodsList.filter(function (item) {
        return !item.select;
      });
    },

    // 删除单条产品
    delOneProduct: function (index) {
      //根据索引删除productList的记录
      console.log(index);
      this.goodsList.splice(index, 1);
    },
    //添加到购物车
    addShoppingCart(index){
      // console.log('sjsjsjjs');
      this.goodsList.splice(index, 1);
      this.$message({
        message: '成功加入购物车',
        type: 'success',
        showClose: true,
      });
    },
    toGoodsDetail(url,price,name) {
      this.$router.push({
        path:'/goodsDetail/${name}',
        query: {goodsurl: url,goodsprice:price,goodsname:name}
      })
    }
  },
};
</script>

<style>

.fl {
  float: left;
}

/*.fr {*/
/*  float: right;*/
/*}*/

.clearfix:before,
.clearfix:after {
  content: " ";
  display: table;
}

.clearfix:after {
  clear: both;
}

.cardList {
  background-color: white;
  padding: 0;
}

.cart-box {
  background-color: #fff;
  font-size: 14px;
  color: #999999;
  text-align: center;
}

.checkbox {
  display: inline-block;
  width: 18px;
  height: 18px;
  border: 1px solid #e5e5e5;
  vertical-align: middle;
  margin-right: 17px;
  cursor: pointer;
}

.checked {
  display: inline-block;
  width: 18px;
  height: 18px;
  border: 1px solid #e5e5e5;
  vertical-align: middle;
  margin-right: 17px;
  cursor: pointer;
  background: url("../assets/icon-gou.png") #ff6600 no-repeat center;
  background-size: 16px 12px;
  border: none;
}

.cart-item-head {
  display: flex;
  height: 79px;
  line-height: 79px;
  list-style: none;
}


.cart-item-list .cart-item {
  display: flex;
  align-items: center;
  height: 125px;
  border-top: 1px solid #e5e5e5;
  font-size: 16px;
}

.cart-item-list .item-check {
  flex: 1;
}

.cart-item-list .item-name {
  flex: 3;
  font-size: 18px;
  color: #333333;
  display: flex;
  align-items: center;
}

.item-name img {
  width: 80px;
  height: 80px;
  vertical-align: middle;
}

.item-name span {
  margin-left: 30px;
}

.cart-item-list .item-price {
  flex: 2;
  color: #333333;
}

.order-wrap {
  font-size: 14px;
  color: #666666;
  margin-top: 20px;
  height: 50px;
  line-height: 50px;
}

.order-wrap .cart-tip {
  margin-left: 29px;
}

.cart-tip a {
  color: #666666;
  margin-right: 37px;
}

.cart-tip span {
  color: #ff6600;
  margin: 0 5px;
}


</style>
