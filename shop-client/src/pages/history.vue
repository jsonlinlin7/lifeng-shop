
<template >
  <div>
    <div class="header-container">
      <top-nav></top-nav>
    </div >
    <div class="footer-container main-container top-space-middle" style="margin-top: 3%">
      <div style="margin:0px auto;">
        <el-button type="danger" round @click="deleteHistory()">
          删除
        </el-button>
        <el-pagination
            style="float: right"
            background
            layout="prev, pager, next"
            :page-size="30"
            :total="totalPage"
            @current-change="changePage"
        >
        </el-pagination>
        <el-table
          ref="multipleTable"
          :data="history"
          @selection-change="handleSelectionChange"
          :default-sort = "{prop:'data',order:'descending'}"
        >
          <el-table-column
            type="selection"
            width="55">
          </el-table-column>
          <el-table-column
            prop='date'
            label='日期'
            sortable
            width='180'
          >
        </el-table-column>
          <el-table-column
            prop='category'
            label='类型'
            sortable
            width='180'
          >
        </el-table-column>
          <el-table-column
            label='商品名称(点击跳转)'
          >
            <template v-slot="scope">
              <b class="goodsName" @click="toGoodsDetail(scope.row.goodsid)">{{scope.row.goodsname}}</b>
            </template>
        </el-table-column>
        </el-table>
      </div>

    </div>

  </div>
</template>
<script type="text/javascript">
import axios from "axios";

export default{
  name:"History",
  created() {
    axios.post("http://localhost:8084/history/selectAll",{
      userid:"1"
    }).then(res=>{
      this.history=[];
      console.log(res.data)
      this.totalPage=parseInt(res.data.message);
      let resData = res.data.data
      for (let item of resData) {
        if(item.goods!=null){
          // console.log(item.date)
          item.goods.date=item.date
          this.history.push(item.goods)
        }
      }
      // console.log(this.history)
    })
  },
  components: {
    "top-nav": () => import("@/components/TopNav"),
  },
  data(){
    return {
      multipleSelection: [],
      history:[

      ],
      totalPage:0,
      currentPage:0
    }
  },
  methods:{
    changePage(currentpage){
      this.currentPage = currentpage;
      axios.post("http://localhost:8084/history/selectAll",{
        userid:"1",init:currentpage-1
      }).then(res=>{
        this.history=[];
        console.log(res.data)
        this.totalPage=parseInt(res.data.message);
        let resData = res.data.data
        for (let item of resData) {
          if(item.goods!=null){
            // console.log(item.date)
            item.goods.date=item.date
            this.history.push(item.goods)
          }
        }
        // console.log(this.history)
      })
    },
    toGoodsDetail(id){
      this.$router.push({path:"/goodsDetail/${name}"
      ,query:{goodsid:id}})
    },
    //删除浏览记录
    deleteHistory(){
      let dateList = [];
      for (var i = 0; i < this.multipleSelection.length; i++) {
        dateList.push(this.multipleSelection[i].date);
      }
      axios.post("http://localhost:8084/history/deleteByDateList",{userid:1,dateList:dateList})
      .then(res=>{
        console.log(res.data)
      })
      axios.post("http://localhost:8084/history/selectAll",{
        userid:"1",init:this.currentPage
      }).then(res=>{
        this.history=[];
        console.log(res.data)
        this.totalPage=parseInt(res.data.message);
        let resData = res.data.data
        for (let item of resData) {
          if(item.goods!=null){
            // console.log(item.date)
            item.goods.date=item.date
            this.history.push(item.goods)
          }
        }
        // console.log(this.history)
      })
    },
    // 手动更新选择
    toggleSelection(rows) {
        if (rows) {
          rows.forEach(row => {
            this.$refs.multipleTable.toggleRowSelection(row);
          });
        } else {
          this.$refs.multipleTable.clearSelection();
        }
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      }
    }

}
</script>
<style scoped="scoped">
  .goodsName{cursor: pointer}
</style>
