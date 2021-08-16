<template>
  <div>
    <el-card id="CategoryPhoneContent" style="margin-top: 10px">
      <el-row class="goodsListMain">
        <div class="header-container">
          <top-nav></top-nav>
        </div>
        <!--   商品    -->
        <el-row>
          <el-col
            :span="6"
            v-for="(item, index) in searchGoods"
            :key="index"
            class="item"
          >
            <el-card class="itemCard" shadow="hover">
              <div class="goodsImg">
                <img
                  :src="item.url"
                  class="image"
                  @click="toGoodsDetail(item)"
                />
              </div>
              <div class="row">
                <div class="goodsPrice">
                  <span>￥{{ item.price }}</span>
                </div>
                <div class="deal-cnt">5000+人付款</div>
              </div>
              <div class="goodsName">
                <span>{{ item.goodsname }}</span>
              </div>
            </el-card>
          </el-col>
        </el-row>

        <!--      分页栏 (elementUI 附加功能)-->
        <el-row style="text-align: right">
          <el-pagination
            :page-size="100"
            layout="prev, pager, next, jumper"
            :total="1000"
          >
          </el-pagination>
        </el-row>
      </el-row>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "CategoryPhoneContent",
  components: {
    "top-nav": () => import("@/components/TopNav"),
  },
  data() {
    return {
      total: null,
      searchGoods: [],
    };
  },
  methods: {
    toGoodsDetail(item) {
      // console.log(item)
      this.$router.push({
        path:'/goodsDetail/${item.goodsname}',
        query: {goodsid:item.goodsid}
      })
    }
  },
  created() {
    const this1 = this;
    console.log(this.$route.params.key);
    this.axios
      .post("http://localhost:8084/goods/search", {
        params: this.$route.params.key,
      })
      .then((res) => {
        //console.log(res.data);
        let resData = res.data.data;
        //console.log(resData);
        this1.searchGoods = resData;
        this.total = res.data.length;
      });
  },

  computed: {},
};
</script>

<style scoped>
.selectKey {
  margin-bottom: 15px;
}

.goodsListMain {
  margin-top: 20px;
  margin-bottom: 40px;
  padding-left: 20px;
}

.item {
  width: 280px;
  height: 390px;
  margin-right: 15px;
}

.itemCard {
  margin-bottom: 20px;
  cursor: pointer;
}

.goodsImg {
  margin: 0 auto;
}

.goodsName {
  margin-top: 6px;
  height: 36px;
  overflow: hidden;
  font-size: 13px;
  font-weight: 400;
  color: #3d3d3d;
}

.row {
  height: 35px;
}

.goodsPrice {
  margin-top: 5px;
  float: left;
  color: red;
  font-weight: 700;
  font-size: 18px;
}

.image {
  width: 250px;
  height: 250px;
  display: block;
}

.deal-cnt {
  margin-top: 10px;
  float: right;
  color: #888;
  font-size: 12px;
}
</style>