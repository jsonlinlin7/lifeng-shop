<template >
  <div id="search">
    <div class="header-container">
      <top-nav></top-nav>
    </div >
    <!--    搜索结果页面-->
    <div  style="margin-top: 3%">
      <div id="search_div">
        <table>
            <tr>
                <td>
                    <select v-model="search.kind" style="font-size: 5mm;">
                        <option value="0">商品类型</option>
                        <option v-for="(item, index) in kinds" :key="index" :value="item.value">{{item.name}}</option>
                    </select>
                </td>
                <td>
                    <select id="" v-model="search.type" style="font-size: 5mm;">
                        <option value="0">交易类型</option>
                        <option value="1">出售商品</option>
                        <option value="2">求购商品</option>
                    </select>
                </td>
                <td>
                    <input type="text" id="search_div_search_input" v-model="search.key">
                </td>
                <td>
                    <button @click="toSearch()">搜索</button>
                </td>
                <td>
                    <button class='number_select_lt_gt' @click="change_pag(current_pag-1)">&lt;</button>

                    <input class="number_select" type="number"
                        min="1" :max="deals_total" v-model="current_pag">

                    <button class='number_select_lt_gt' @click="change_pag(current_pag+1)">&gt;</button>
                </td>
            </tr>
        </table>
        <div id="search_center">
          <!--这里这里这里这里是html -->
          <div class="search_unit" v-for="(item, index) in search_result" :key="index">
              <img :src="item.img" alt="照片不见了，这不是网站的" @click="toGoodsDetails(item.id)">
              <div class="search_unit_name" @click="toGoodsDetails(item.id)">
                  <div class="line_limit">{{item.name}}</div>
                  <div class="search_unit_name_toolong">{{item.name}}</div>
              </div>
              <span class="search_unit_prices" @click="toGoodsDetails(item.id)"></span>

          </div>
        </div>


    </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Search",
    components: {
      "top-nav": () => import("@/components/TopNav"),
    },
    data(){
      return {
        search_result: [
          {
            id:0,
            name: "铁三角",
            img: "https://img10.360buyimg.com/babel/s1180x940_jfs/t1/194382/12/14980/296772/60ff7a8dE3268dd09/c4560a3fc0f6085c.jpg.webp",
            prices: 0,
            type:0
          },
          {
            id:0,
            name: "铁三角",
            img: "https://img10.360buyimg.com/babel/s1180x940_jfs/t1/194382/12/14980/296772/60ff7a8dE3268dd09/c4560a3fc0f6085c.jpg.webp",
            prices: 0,
            type:0
          }
          ,
          {
            id:0,
            name: "铁三角",
            img: "https://img10.360buyimg.com/babel/s1180x940_jfs/t1/194382/12/14980/296772/60ff7a8dE3268dd09/c4560a3fc0f6085c.jpg.webp",
            prices: 0,
            type:0
          }
          ,{
            id:0,
            name: "铁三角",
            img: "https://img10.360buyimg.com/babel/s1180x940_jfs/t1/194382/12/14980/296772/60ff7a8dE3268dd09/c4560a3fc0f6085c.jpg.webp",
            prices: 0,
            type:0
          },
          {
            id:0,
            name: "铁三角",
            img: "https://img10.360buyimg.com/babel/s1180x940_jfs/t1/194382/12/14980/296772/60ff7a8dE3268dd09/c4560a3fc0f6085c.jpg.webp",
            prices: 0,
            type:0
          },
          {
            id:0,
            name: "铁三角",
            img: "https://img10.360buyimg.com/babel/s1180x940_jfs/t1/194382/12/14980/296772/60ff7a8dE3268dd09/c4560a3fc0f6085c.jpg.webp",
            prices: 0,
            type:0
          },
          {
            id:0,
            name: "铁三角",
            img: "https://img10.360buyimg.com/babel/s1180x940_jfs/t1/194382/12/14980/296772/60ff7a8dE3268dd09/c4560a3fc0f6085c.jpg.webp",
            prices: 0,
            type:0
          },
          {
            id:0,
            name: "铁三角",
            img: "https://img10.360buyimg.com/babel/s1180x940_jfs/t1/194382/12/14980/296772/60ff7a8dE3268dd09/c4560a3fc0f6085c.jpg.webp",
            prices: 0,
            type:0
          },
          {
            id:0,
            name: "铁三角",
            img: "https://img10.360buyimg.com/babel/s1180x940_jfs/t1/194382/12/14980/296772/60ff7a8dE3268dd09/c4560a3fc0f6085c.jpg.webp",
            prices: 0,
            type:0
          }]
          ,
          // 页面总数
          deals_total:10,
          // 当前页面序号
          current_pag:1,
          // 搜索关键字
          search:{
              key:"",
              kind:0,
              type:0
          },
          kinds:[
            {
              value:1,
              name:"电子产品"
            },
            {
              value:2,
              name:"虚拟商品"
            },
            {
              value:3,
              name:"家用电器"
            },
            {
              value:4,
              name:"图书文娱"
            },
            {
              value:5,
              name:"生活用品"
            },
            {
              value:6,
              name:"衣服首饰"
            },
            {
              value:7,
              name:"奢侈品"
            },
            {
              value:8,
              name:"户外用品"
            },
            {
              value:9,
              name:"其他商品"
            }
        ]
      }
    }
  }


</script>

<style scoped>
#search_center{
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-between;
}
/* #search_center{
  width: 80%;
  display: flex;
  /* align-items: center; */
  /* justify-content: center; }
  /* #search_div {
    position: relative;
    top: 180px;
    left: 3%;
    min-width: 250px;
    min-height: 500px;
    width: 94%;
    margin: 0px auto;
    background-color: aliceblue;
    border-radius: 50px;
    z-index: -1;
  }


  #search_div table {
    margin: 5px auto;
  }

  #search_div input,
  #search_div button {
    font-size: 7mm;
    border-radius: 20px;
  } */
  /* 给页数选择器设置样式 */
  .number_select{
    width: 65px;
    position: relative;
    left: 50px;
    text-align: center;
  }
  /* 给上下页按钮设置样式 */
  .number_select_lt_gt{
    position: relative;
    left: 50px;
    width: 40px;
  }

  .search_unit {
    border: 2px black solid;
    position: relative;
    border-radius: 25px;
    width: 250px;
    height: 300px;
    /* float: left; */
    margin: 10px;
  }

  .search_unit img {
    position: relative;
    top: 15px;
    left: 15px;
    width: 220px;
    width: 220px;
    margin: 0px auto;
    cursor: pointer;
  }

  .search_unit_name {
    position: absolute;
    top: 240px;
    left: 20px;

  }

  .search_unit_prices {
    position: absolute;
    top: 265px;
    left: 20px;
  }

  .search_unit_name_toolong {
    position: relative;
    background-color: black;
    color: white;
    display: none;
    /* z-index: 20; */
  }

  .search_unit_name:hover {
    cursor: pointer;
  }

  .search_unit_name:hover .search_unit_name_toolong {
    display: block;
  }

  .line_limit {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    max-width: 190px;
  }
</style>
