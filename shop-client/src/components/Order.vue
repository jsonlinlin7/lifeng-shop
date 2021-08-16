// 订单页
<template>

  <div class="Order">
    <div class="header-container">
      <top-nav></top-nav>
    </div >
    <el-table
        :data="tableData"
        border
    >
      <el-table-column type="selection" width="55"/>
      <el-table-column width="1" class="box">
        <template slot-scope="scope">
          <div class="item">
            <span style="margin-left:3%">{{ scope.row.date }}</span>
            <span style="margin-left:3%">订单号：{{ scope.row.id }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="商品" width="300" align="center">
        <template slot-scope="scope">
          <div v-for="(item, index) in scope.row.children" :key="index" class="mesSty">
            <img class="imgSty" :src= item.url alt="">
            <div class="mesFont">
              <p class="pb_sty"><span>{{ item.name }}</span></p>
            </div>
          </div>
        </template>
      </el-table-column>
      <el-table-column min-width="100" label="单价/数量" align="center">
        <template slot-scope="scope">
          <div v-for="(item, index) in scope.row.children" :key="index" class="mesSty2">
            <p>{{ item.price }} <span>×{{ item.Number }}</span></p>

          </div>
        </template>
      </el-table-column>
      <el-table-column  min-width="140" label="收货人" align="center">
        <template slot-scope="scope" >
          <div class="mesSty2">
            {{ scope.row.name }}
          </div>
        </template>
      </el-table-column>
      <el-table-column  valign="top" min-width="140" label="金额" align="center">
        <template slot-scope="scope" >
          <div class="mesSty2">
            {{ scope.row.total }}
          </div>
        </template>
      </el-table-column>
      <el-table-column
          label="操作"
          align="center"
          min-width="140">
        <template slot-scope="scope">
          <!-- <el-button type="text" size="small" @click="btnClick(scope.row.id)">退款</el-button> -->
          <div>
            <el-button type="text" size="small" @click="btnClick(scope.row.id)"><div class="mesSty2">订单详情</div></el-button>
          </div>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
export default {
  components: {
    "top-nav": () => import("@/components/TopNav"),
  },
  data() {
    return {
      popSty: false,
      textarea: '',
      tableData: [{
        id: '001',
        date: '2021-07-29 11:27:31',
        name: '张三',
        address: '123',
        total: '￥1503.00',
        children: [
          {
            price: '￥1503.00',
            Number: 1,
            url: 'http://tmall.how2j.cn/productSingle_middle/1302.jpg',
            name: '纳蒂兰卡1066卫浴漩冲虹吸式马桶350'
          }
        ]
      },{
        id: '002',
        date: '2021-07-30 12:37:18',
        name: '张三',
        address: '123',
        total: '￥11337.60',
        children: [
          {
            price: '￥3638.60',
            Number: 2,
            url: 'http://tmall.how2j.cn/productSingle_middle/1884.jpg',
            name: '新款布艺沙发 可拆洗大小户型客厅简约家居'

          },
          {
            price: '￥7699',
            Number: 1,
            url: 'http://tmall.how2j.cn/productSingle_middle/1917.jpg',
            name: '依然美佳欧式布艺沙发组合可拆洗新款实木雕'
          },

        ]
      }]
    }
  },
  methods: {
    btnClick(id) {
      console.log(id)
      this.$router.push('OrderDetails')
    }
  }
}
</script>

<style scoped>
.content {
  padding: 20px;
}
.el-table--enable-row-transition /deep/ .cell {
  padding: 20px 0;
}
.item {
  width: 100vw;
  background: #f1f1f1;
  position: absolute;
  top: 0;
  left: -55px;
  z-index: 1;
  height: 50px;
  line-height: 50px;
}
</style>
<style scoped>
.imgSty {
  width: 100px;
  display: block;
  padding-left: 10px;
}
.mesSty {
  display: flex;
  align-items: center;
  padding: 40px 0;
  border-bottom: 1px solid #ebeef5;
}
.mesSty:last-child {
  padding-top: 20px;
  border-bottom: none;
  padding-bottom: 0px;
}
.mesSty2 {
  padding: 40px 0;
  border-bottom: 1px solid #ebeef5;
}
.mesSty2:last-child {
  padding-top: 20px;
  border-bottom: none;
  padding-bottom: 0px;
}
.content >>> .el-table--border td:nth-child(-n+4) {
  border-right: none!important;
}
.content >>> .el-table--border td:nth-child(2) {
  border-left: 1px solid #ebeef5;
}
.content /deep/ .el-table__row td:nth-child(n+6) .cell {
  position: absolute!important;
  top: 100px!important;
  left: 50%;
  transform: translateX(-50%);
}
.content /deep/ .el-table__row td:nth-child(1) .cell {
  position: absolute!important;
  top: -5px!important;
  left: 50%;
  transform: translateX(-50%);
  z-index: 999;
}
.pb_sty span {
  padding: 2px 0px;
  border-radius: 4px;
}

.mesFont p {
  margin-block-start: 0;
  margin-block-end: 0;
  padding: 0 10px;
}
.mesFont p:nth-child(2) {
  text-overflow: -o-ellipsis-lastline;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  line-clamp: 2;
  -webkit-box-orient: vertical;
}
/* .el-table__row:hover .item {
  background-color: #eaf8ff;
} */
</style>
