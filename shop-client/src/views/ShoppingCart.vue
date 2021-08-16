<template>
  <div class="cart" >
    <h2>我的购物车</h2>
    <el-card class="cardList"
             v-loading="loading"
             >
    <el-table
        ref="multipleTable"
        :data="goodsList"
        tooltip-effect="dark"
        style="width: 100%;padding-left:10px;font-size: 16px"
        @selection-change="handleSelectionChange">
      <el-table-column
          type="selection"
          min-width="55"
          align="center">
      </el-table-column>
      <el-table-column
          min-width="100"

          align="center">
        <template slot-scope="scope" >
          <el-image
              @click="toGoodsDetail(scope.row.goods.goodsname,scope.row.goodsid)"
              style="height: 80px;width: 80px;cursor: pointer"
              :src="scope.row.goods.url"
              fit="fit"></el-image>
          </template>
      </el-table-column>
      <el-table-column
          label="商品名称"
          min-width="300"
          show-overflow-tooltip>
        <template slot-scope="scope" >{{ scope.row.goods.goodsname }}</template>
      </el-table-column>
      <el-table-column
          label="单价"
          min-width="100"
          align="center">
        <template slot-scope="scope" >￥{{  keepDecimal(scope.row.goods.price)}}</template>
      </el-table-column>
      <el-table-column
          label="数量"
          min-width="180"
          align="center">
        <template slot-scope="scope" >
          <el-input-number
            v-model="scope.row.num"
            size="mini"
            :min="1"
            :max="10"
            @change="handleChange(scope.$index,scope.row.num)"
          ></el-input-number>
        </template>
      </el-table-column>
      <el-table-column
          label="小计"
          min-width="100"
          align="center">
        <template slot-scope="scope">
          <span style="color: #ff6600">￥{{  keepDecimal(scope.row.totalprice)}}</span>
        </template>
      </el-table-column>
      <el-table-column
          label="操作"
          min-width="80"
          align="center">
        <template slot-scope="scope">
          <el-button
              size="medium"
              type="text"
              @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
      <div style="margin: 20px 0px 0px 20px;display: inline-block">
        <el-button type="text" @click="batchDelete()">删除选中的物品</el-button>
      </div>
      <div class="total fr" style="margin-top: 20px">
        已选择 <span>{{ getTotal.totalNum }}</span> 件商品总计（不含运费）
        合计：<span style="font-size: 22px">{{ getTotal.totalPrice }}</span>
        元
        <a href="javascript:;" class="btn" @click="order">去结算</a>
      </div>
      </el-card>

  </div>
</template>

<script>
import axios from "axios";

export default {
  components: {},
  name: "cart",
  data() {
    return {
      loading:false,
      multipleSelection:[],
      goodsList: [],
    };
  },
  // beforeCreate() {
  //   console.log(购物车)
  // },
  computed: {

    // 获取总价和产品总件数
    getTotal: function () {
      var totalPrice = 0;
      var totalNum = 0;
      this.multipleSelection.forEach(function (item) {
        totalPrice+=item.totalprice;
        totalNum+=item.num;
      });
      return { totalNum: totalNum, totalPrice: totalPrice.toFixed(2) };
    },
    // aaa (ss) {
    //   return ss;
    // }
  },
  methods: {
    //保留两位小数
    keepDecimal(val) {
      return Number(val).toFixed(2);
    },
    //点击列表中商品图片跳转到商品详情页
    toGoodsDetail(name,id) {
      this.$router.push({
        path:'/goodsDetail/${name}',
        query: {goodsid:id}
      })
    },
    //多选按钮事件
    handleSelectionChange(val) {
      this.multipleSelection=val;
    },
    //删除单条
    handleDelete(index, row) {
      this.goodsList.splice(index, 1);
      var arr=[row.id];
      this.delShoppingcart(arr);//调用后端接口
    },
    //批量删除
    batchDelete(){
      let a=this.multipleSelection;
      this.goodsList = this.goodsList.filter(function (item) {
        return a.indexOf(item)<0;
      });
      var arr=[];
      this.multipleSelection.forEach(function (item) {
        arr.push(item.id);       // 添加所有需要删除数据的id到一个数组
      });
      this.delShoppingcart(arr);//调用后端接口
    },
    //连接后端删除接口
    delShoppingcart(array){
      console.log(array);
      this.loading=true;
      axios.post("http://localhost:8084/shoppingcart/delete",array)
          .then(res=>{
            this.loading=false;
            console.log("删除购物车成功");
            console.log(res.data);

          })
          .catch(err=>{
            console.log("删除失败")
            console.log(err.data)
          });

    },
    //数量选择器事件
    handleChange(value,num) {

      this.loading=true;

      // console.log(num);
      this.goodsList[value].totalprice=this.goodsList[value].goods.price*num;
      // console.log(this.goodsList[value].num);
      // console.log(this.goodsList[value].totalprice);
      // console.log(this.goodsList[value].id);
      axios.post("http://localhost:8084/shoppingcart/update",
          {num:this.goodsList[value].num,totalprice:this.goodsList[value].totalprice,id:this.goodsList[value].id})
          .then(res=>{
            this.loading=false;
            console.log("更新购物车成功");
            console.log(res.data);
          })
          .catch(err=>{
            console.log("更新购物车失败")
            console.log(err.data)
          });

    },

    // 购物车结算
    order() {
      // let isCheck = this.list.every(item=>!item.productSelected);
      // if(isCheck){
      this.$message.success("结算成功");
      // }else{
      // this.$router.push('/order/confirm');
      // }
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

  },


  created() {
    var userid = this.get_cookie("userid");
    if(userid.length<=0){
      userid=0;
    }
    //获取购物车列表
    var that = this;
    axios.post("http://localhost:8084/shoppingcart/oneuser?id="+userid,{})
        .then(res=>{
          console.log("购物车列表成功获取返回数据");
          console.log(res.data.data);
          that.goodsList=res.data.data;
        })
        .catch(err=>{
          console.log("商品获取返回数据失败")
          console.log(err.data)
        });

  },
};
</script>

<style>
.btn {
  display: inline-block;
  width: 90px;
  line-height: 30px;
  text-align: center;
  background-color: #ff9900;
  color: #ffffff;
  border: none;
  cursor: pointer;
}

.fl {
  float: left;
}

.fr {
  float: right;
}

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

.wrapper {
  background-color: #f5f5f5;
  padding-top: 10px;
  padding-bottom: 114px;
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
}

.col-1 {
  flex: 1;
}

.col-2 {
  flex: 2;
}

.col-3 {
  flex: 3;
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
  flex: 1;
  color: #333333;
}

.cart-item-list .item-num {
  flex: 2;
}

.item-num .num-box {
  display: inline-block;
  width: 150px;
  height: 40px;
  line-height: 40px;
  border: 1px solid #e5e5e5;
  font-size: 14px;
}

.num-box a {
  display: inline-block;
  width: 50px;
  color: #333333;
}

.num-box span {
  display: inline-block;
  width: 50px;
  color: #333333;
}

.cart-item-list .item-total {
  flex: 1;
  color: #ff6600;
}

.cart-item-list .item-del {
  flex: 1;
  width: 14px;
  height: 17px;
  /* background: url('../assets/img/icon-close.png') no-repeat center; */
  background-size: contain;
  cursor: pointer;
}

.item-del {
  color: skyblue;
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

.order-wrap .total {
  font-size: 14px;
}

.total span {
  color: #ff6600;
}

.total a {
  width: 202px;
  height: 50px;
  line-height: 50px;
  font-size: 18px;
  margin-left: 37px;
}
</style>
