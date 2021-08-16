<template>
  <div id="indexContent">

    <el-card id="demo_card">
      <el-carousel :interval="4000" height="380px" direction="vertical" arrow="always" trigger="click">
        <el-carousel-item v-for="(item,index) in images" :key="index">
          <el-tooltip class="item" effect="dark" :content="item.tittle" placement="top">
            <el-image :src="item.url" style="height:500px;width:1000px;"></el-image>
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
          url: "https://imgcps.jd.com/img-cubic/creative_server_cia/v2/2000366/100019141914/FocusFullshop/CkRqZnMvdDEvMTg5NjMyLzE3LzEyMTgzLzUxMTMwMC82MGU2YjA1YUVkNjg4M2FlMy9jZjc5M2RiYWFlOTU2OTI5LnBuZxIJMy10eV8wXzU0MAI47ot6QhAKDOS4gOWKoOaJi-acuhAAQhYKEuW8gOWQr-eyvuiHtOeUn-a0uxABQhAKDOeri-WNs-aKoui0rRACQgoKBuS8mOi0qBAHWJr668z0Ag/cr/s/q.jpg",
          tittle: "开启精致生活 一加手机"
        },
        {
          url: "https://imgcps.jd.com/img-cubic/creative_server_cia/v2/2000366/6576193/FocusFullshop/CkRqZnMvdDEvMTk2MjMwLzI1LzEyMzQ4LzM4ODc1NC82MGU2YzM1MUU1ZjAwZThlZC82MzUzMjIyYjU0MzNiNjkxLnBuZxIJNC10eV8wXzU1MAI47ot6Qh0KGeWMl-m8jueUteawtOWjti_ng63msLTnk7YQAEIPCgs3NeaKmOenkuadgBABQhAKDOeri-WNs-aKoui0rRACQgoKBuenjeiNiRAHWMGwkQM/cr/s/q.jpg",
          tittle: "75折秒杀"
        },
        {
          url: "https://imgcps.jd.com/ling4/3548676/6Ziy6Zuo6Ziy5rGb5b-F5aSH/54iG5qy-5L2O6IezOS455YWD/p-5bd8253082acdd181d02fa55/c86447a0/cr/s/q.jpg",
          tittle: "防雨防汛 必备清单"
        },
        {
          url:"https://img.alicdn.com/imgextra/i1/6000000003348/O1CN01sdQRAo1abQiWtZpKz_!!6000000003348-0-octopus.jpg"
          , tittle:"taobao"
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
