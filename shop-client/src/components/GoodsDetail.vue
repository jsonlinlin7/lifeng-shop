<template>
  <div>
    <div class="header-container">
      <top-nav></top-nav>
    </div>
    <el-card class="one" style="width:960px;margin:10px auto;" v-loading="loading">
      <el-row style="height:100%;">
        <el-col :span="8" align="center" style="height:100%;">
          <el-image :src="goods.url" fit="fit"
                    style="margin-top:50px;width: 200px;height:200px;box-shadow: 0 0 25px #cac6c6;">
            <div slot="error" class="image-slot" style="line-height: 200px">
              <i class="el-icon-loading" style="font-size: 30px"></i>
            </div>
          </el-image>
        </el-col>
        <el-col :span="16" style="height:100%;">
          <div class="detail">
            <div style="text-align: left">
              <h4>{{ goods.goodsname }}</h4>
              <div class="priceimg">
                <p>价格: &ensp;&ensp;<span style="color: red">￥</span><span
                    style="color: red;font-size: 2em">{{keepDecimal(goods.price) }}</span><span></span></p>
              </div>
              <div>
                <p>发货地: &ensp;&ensp;<span>广州</span></p>
              </div>
              <div>
                <ul class="tm-ind-panel">
                  <li class="tm-ind-item tm-ind-sellCount" data-label="月销量">
                    <div><span class="tm-label">月销量</span><span class="tm-count">4万+</span></div>
                  </li>
                  <li class="tm-ind-item tm-ind-emPointCount">
                    <div><a><span class="tm-label">评分</span><span class="tm-count">10</span></a></div>
                  </li>
                </ul>
              </div>
              <div>
                <span>
                  数量
                  <el-input-number size="small" v-model="num" :min="1" :max="15" controls-position="right"></el-input-number>
                  件
                </span>
                <span style="margin-left: 50px">库存2000件</span>
              </div>
              <div>
                <el-button type="danger">立即购买</el-button>
                <el-button type="danger" plain @click="addShoppingCart">加入购物车</el-button>
              </div>
            </div>
          </div>

        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>

import axios from "axios";

export default {
  name: "GoodsDetail",
  components: {
    "top-nav": () => import("@/components/TopNav"),
  },
  computed:{

  },
  methods: {
    //保留两位小数
    keepDecimal(val) {
      return Number(val).toFixed(2);
    },
    get_cookie(key) {
      let name = key + '='
      let ca = document.cookie.split(';')
      for (let i = 0; i < ca.length; i++) {
        let c = ca[i].trim();
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
      }
      return ''
    },
    //加入购物车
    addShoppingCart() {
      this.loading=true;
      var msg="加入购物车失败";
      var type="error";
      let userid = this.get_cookie("userid");
      // let userid = 1;
      // console.log("sasadfagthsr",userid);
      if (userid.length <= 0) {
        // msg="请先登录";
        // type="error";
        this.$message({
          message: "请先登录",
          type: "error",
          duration:1000,
        });
        this.loading=false;
        return null;
        // userid = 1;
      }
      // console.log("sasadfagthsr",userid);
      let goodsid = this.goods.goodsid;
      let num = this.num;
      let totalprice = this.goods.price * num;

      // console.log(this.goods.price); console.log(totalprice);
      axios.post("http://localhost:8084/shoppingcart/insert",
          {id: null, userid: userid, goodsid: goodsid, num: num, totalprice: totalprice})
          .then(res => {
            console.log("成功获取返回数据")
            console.log(res.data)
            this.loading=false;
            if (res.data.code==200){
              msg="成功加入购物车";
              type="success";
            }
            this.$message({
              message: msg,
              type: type,
              duration:1000,
            });
          })
          .catch(err => {
            console.log("获取返回数据失败");
            console.log(err.data());
            this.$message({
              message: msg,
              type: type,
              duration: 1000,
            });
          });
    },

  },

  created() {
    let userid = this.get_cookie("userid");
    let goodsid = this.goods.goodsid;
    if (userid.length <= 0) {
      userid = 1;
    }
    // 新增用户浏览历史。
    axios.post("http://localhost:8084/history/insert", {userid: userid, goodsid: goodsid})
        .then(res => {
          console.log("成功获取返回数据")
          console.log(res.data)
        })
        .catch(err => {
          console.log(err.data())
        });
    // 根据商品id获取商品信息
    axios.post("http://localhost:8084/goods/selectByGoodsId", {goodsid: goodsid})
        .then(res => {
          console.log(res.data)
          if (res.data.code === 200) {
            this.goods = res.data.data;
          }
        }).catch(err => {
          console.log(err.data)
        });
  },
  data() {
    return {
      loading:false,
      num: 1,
      goods: {
        goodsid: this.$route.query.goodsid
      },

    };
  },
}
</script>

<style scoped>
.one {
  /* padding-bottom: 10px; */
  height: 420px;

}

.one .img {
  width: 70%;
  height: 100%;
  margin-left: 20px;
  padding-left: 5%;
  box-shadow: 0 0 25px #cac6c6;
}

.one .detail div {
  margin-top: 10px;
  padding-left: 5px;
  padding-right: 5px;
}

.second {
  margin-top: 20px;
  margin-bottom: 20px;
  padding-bottom: 10px;
}

.tm-ind-panel {
  border: 1px dotted #c9c9c9;
  border-width: 1px 0;
  margin: -1px 20px 0 0;
  padding: 10px 0;
  position: relative;
  overflow: hidden;
  clear: both;
  display: flex;
  list-style-type: none;
}

.tm-ind-item {
  float: left;
  width: 33%;
  text-align: center;
  position: relative;
  left: -1px;
  border-left: 1px solid #e5dfda;
  flex: 1;
  line-height: 16px;

}

</style>
