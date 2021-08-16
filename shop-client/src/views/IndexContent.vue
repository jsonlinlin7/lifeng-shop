<template>
  <div id="indexContent">

    <el-card id="demo_card">
      <el-carousel :interval="3000" height="380px" direction="vertical" arrow="always" trigger="click">
        <el-carousel-item v-for="(item,index) in images" :key="index">
          <el-tooltip class="item" effect="light" :content="item.tittle" placement="top">
            <el-image :src="item.url" style="height:100%;width:100%;"></el-image>
          </el-tooltip>
        </el-carousel-item>
      </el-carousel>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: "IndexContent",
    data() {
      return {
        images: [
          {
            url: "https://img.alicdn.com/imgextra/i3/6000000003731/O1CN016VwHel1dQqPXjgJIt_!!6000000003731-0-octopus.jpg",
            tittle: "手艺人原创 产地直供"
          },
          {
            url: "https://gtms03.alicdn.com/tps/i3/TB1gXd1JXXXXXapXpXXvKyzTVXX-520-280.jpg",
            tittle: "邂逅潮流名品店"
          },
          {
            url: "https://gtms01.alicdn.com/tps/i1/TB1r4h8JXXXXXXoXXXXvKyzTVXX-520-280.jpg",
            tittle: "特卖专场"
          },
          {
            url:"https://gtms02.alicdn.com/tps/i2/TB10vPXKpXXXXacXXXXvKyzTVXX-520-280.jpg"
            , tittle:"潮货特辑"
          }
        ]
      }
    }
  }
</script>

<style scoped>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>
