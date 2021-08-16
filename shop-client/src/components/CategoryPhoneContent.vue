<template>
  <div>
    <el-card id="categoryPhoneHead">
      <!--   已选选项 tag  -->
      <el-row class="searchTips">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item style="margin-bottom: 5px"
            ><a @click="cleanAddition" class="tip"
              >所有分类</a
            ></el-breadcrumb-item
          >
          <el-breadcrumb-item>
            <el-tag
              v-for="(tag, index) in searchTags"
              :key="index"
              closable
              effect="info"
              :disable-transitions="false"
              @close="closeTag(tag)"
              class="tag"
              >{{ tag.key }}：{{ tag.value }}</el-tag
            >
          </el-breadcrumb-item>
        </el-breadcrumb>
      </el-row>

      <div class="options">
        <el-row
          class="row"
          :class="index != 0 ? 'line' : ''"
          v-for="(condition, index) in conditions"
          :key="index"
        >
          <el-col :span="2">
            <div class="head">
              <span class="additionFactorL">{{ condition.name }}:</span>
            </div>
          </el-col>
          <el-col :span="22" class="content">
            <el-row class="">
              <span
                v-for="(subCondition, index2) in condition.subConditions"
                :key="index2"
              >
                <el-link
                  class="item-tag"
                  :underline="false"
                  @click="toSearch(condition.name, subCondition.name)"
                  >{{ subCondition.name }}</el-link
                >
              </span>
            </el-row>
          </el-col>
        </el-row>
      </div>
    </el-card>
    <el-card id="CategoryPhoneContent" style="margin-top: 10px">
      <el-row class="goodsListMain">
        <!--    筛选条件：综合，销量，新品，价格    -->
        <el-row class="selectKey">
          <el-radio-group>
            <el-radio-button label="all"
              >综合<i class="el-icon-caret-bottom"></i
            ></el-radio-button>
            <el-radio-button label="sale"
              >销量<i class="el-icon-caret-bottom"></i
            ></el-radio-button>
            <el-radio-button label="new"
              >新品<i class="el-icon-caret-bottom"></i
            ></el-radio-button>
            <el-radio-button label="priceU"
              >价格<i class="el-icon-d-caret"></i
            ></el-radio-button>
          </el-radio-group>
        </el-row>
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
  data() {
    return {
      //tag内容
      searchTags: [],
      conditions: [
        //品牌
        {
          id: "1",
          name: "品牌",
          subConditions: [
            {
              id: "1-1",
              name: "小米",
            },
            {
              id: "1-2",
              name: "华为",
            },
            {
              id: "1-3",
              name: "三星",
            },
            {
              id: "1-4",
              name: "OPPO",
            },
            {
              id: "1-5",
              name: "vivo",
            },
            {
              id: "1-6",
              name: "魅族",
            },
            {
              id: "1-7",
              name: "一加",
            },
          ],
        },
        //分类
        // {
        //   id: "2",
        //   name: "分类",
        //   subConditions: [
        //     {
        //       id: "2-1",
        //       name: "手机",
        //     },
        //     {
        //       id: "2-2",
        //       name: "二手手机",
        //     },
        //     {
        //       id: "2-3",
        //       name: "合约机",
        //     },
        //   ],
        // },
        //CPU品牌
        {
          id: "3",
          name: "CPU品牌",
          subConditions: [
            {
              id: "3-1",
              name: "高通",
            },
            {
              id: "3-2",
              name: "联发科",
            },
            {
              id: "3-3",
              name: "展讯",
            },
            {
              id: "3-4",
              name: "MTK",
            },
            {
              id: "3-5",
              name: "海思",
            },
            {
              id: "3-6",
              name: "苹果",
            },
          ],
        },
        //机身存储
        {
          id: "4",
          name: "机身存储",
          subConditions: [
            {
              id: "4-1",
              name: "8G",
            },
            {
              id: "4-2",
              name: "16G",
            },
            {
              id: "4-3",
              name: "32G",
            },
            {
              id: "4-4",
              name: "64G",
            },
            {
              id: "4-5",
              name: "128G",
            },
            {
              id: "4-6",
              name: "256G",
            },
            {
              id: "4-7",
              name: "512G",
            },
          ],
        },
        //运行内存
        {
          id: "5",
          name: "运行内存",
          subConditions: [
            {
              id: "5-1",
              name: "16G",
            },
            {
              id: "5-2",
              name: "12G",
            },
            {
              id: "5-3",
              name: "8G",
            },
            {
              id: "5-4",
              name: "6G",
            },
            {
              id: "5-5",
              name: "4G",
            },
            {
              id: "5-6",
              name: "2G",
            },
            {
              id: "5-7",
              name: "2G以下",
            },
          ],
        },
        //屏幕尺寸
        {
          id: "6",
          name: "屏幕尺寸",
          subConditions: [
            {
              id: "6-1",
              name: "6.95英寸及以上",
            },
            {
              id: "6-2",
              name: "6.0~6.24英寸",
            },
            {
              id: "6-3",
              name: "6.85~6.64英寸",
            },
            {
              id: "6-4",
              name: "6.75~6.84英寸",
            },
            {
              id: "6-5",
              name: "6.65~6.74英寸",
            },
            {
              id: "6-6",
              name: "6.55~6.64英寸",
            },
            {
              id: "6-7",
              name: "6.35~6.44英寸",
            },
          ],
        },
      ],
      total: null,
      searchGoods: [
        // {
        //   url: "https://img14.360buyimg.com/babel/s320x320_jfs/t1/159876/20/15398/91091/605d8789Eb22ccd0d/3bfd6f8a27ca24d8.jpg!cc_320x320.webp",
        //   name: "OPPO Find X3 Pro 骁龙888 5000万双主摄IMX766 10亿色臻彩屏 60倍显微镜 12+256GB 镜黑 5G拍照旗舰手机",
        //   price: "5499",
        //   cnt: "5000+",
        // },
        // {
        //   url: "https://img30.360buyimg.com/babel/s320x320_jfs/t1/171914/6/9351/236088/609ceec3E44a3f1bd/7db00451ced8c177.jpg!cc_320x320.webp",
        //   name: "MIX FOLD 小米折叠屏手机 5G 2K+折叠屏 骁龙888 一亿像素 哈曼卡顿立体声四扬声器 12GB+256GB 黑色游戏手机",
        //   price: "9999",
        //   cnt: "5000+",
        // },
        // {
        //   url: "https://img14.360buyimg.com/babel/s320x320_jfs/t1/194565/25/8782/189675/60cc5ba3Ee379b81d/939fcfebf73789f4.jpg!cc_320x320.webp",
        //   name: "荣耀50 Pro 1亿像素超清影像 5G 6.72英寸超曲屏 100W超级快充 前置视频双摄 全网通版8GB+256GB 初雪水晶",
        //   price: "3699",
        //   cnt: "5000+",
        // },
        // {
        //   url: "https://img12.360buyimg.com/babel/s320x320_jfs/t1/175218/8/4160/342277/6076de00E41370608/212f2e7fdccbd60c.jpg!cc_320x320.webp",
        //   name: "华为 HUAWEI Mate X2 无缝鹰翼折叠 超感知徕卡四摄 256GB釉白色 5G全网通（无充电器和数据线）",
        //   price: "17749",
        //   cnt: "5000+",
        // },
        // {
        //   url: "https://img20.360buyimg.com/babel/s320x320_jfs/t1/186556/34/15124/475516/60fe6e27E1e12be4a/c4b10c1d45b217e5.jpg!cc_320x320.webp",
        //   name: "OPPO Reno5 5G 6400万水光人像四摄 65W超级闪充 12+256GB 星河入梦 全网通手机",
        //   price: "2799",
        //   cnt: "5000+",
        // },
        // {
        //   url: "https://img13.360buyimg.com/seckillcms/s250x250_jfs/t1/187298/14/15748/52224/6103a995E5a2be315/a58d6a9aa6351ec9.jpg",
        //   name: "Redmi Note 9 Pro 5G 一亿像素 骁龙750G 33W快充 120Hz刷新率 静默星空 8GB+128GB 游戏智能手机 小米 红米",
        //   price: "1569",
        //   cnt: "5000+",
        // },
        // {
        //   url: "https://img11.360buyimg.com/jdcms/s300x300_jfs/t1/183740/29/9250/112903/60c8c5f8Ed45044fe/93a9032f07361214.jpg.webp",
        //   name: "荣耀50 SE 1亿像素超清影像 5G 6.78英寸全视屏 66W超级快充 全网通版 8GB+128GB亮黑色",
        //   price: "2389",
        //   cnt: "5000+",
        // },
        // {
        //   url: "https://img20.360buyimg.com/jdcms/s300x300_jfs/t1/181143/28/15781/128206/60fd6fa5E026332f5/5a4ed8f60c1e799a.jpg.webp",
        //   name: "vivo iQOO Z3 8GB+256GB 深空 高通骁龙768G 55W闪充 120Hz高刷竞速屏 6400万三摄 双模5G全网通手机iqooz3",
        //   price: "1899",
        //   cnt: "5000+",
        // },
        // {
        //   url: "https://img12.360buyimg.com/babel/s320x320_jfs/t1/150930/24/6796/69693/5fb1e148Eb8ab4fcd/21cc5f7bd5b38454.jpg!cc_320x320.webp",
        //   name: "Redmi K30S 至尊纪念版 双模5G 骁龙865 144HzLCD旗舰屏幕 8GB+256GB 月光银 游戏手机 小米 红米",
        //   price: "2499",
        //   cnt: "5000+",
        // },
        // {
        //   url: "https://img13.360buyimg.com/babel/s320x320_jfs/t1/153021/14/11977/67298/5fe949d2E2a2e2cbc/f726437882607c3e.jpg!cc_320x320.webp",
        //   name: "小米11 5G 骁龙888 2K AMOLED四曲面柔性屏 1亿像素 55W有线闪充 50W无线闪充 8GB+128GB 蓝色 游戏手机",
        //   price: "3799",
        //   cnt: "5000+",
        // },
        // {
        //   url: "https://img10.360buyimg.com/n7/jfs/t1/1695/39/3482/70556/5b997bf7Ed2d65519/749d8efdff062fb0.jpg",
        //   name: "Apple iPhone 12 Pro Max (A2412) 128GB 海蓝色 支持移动联通电信5G 双卡双待手机",
        //   price: "9299",
        //   cnt: "5000+",
        // },
        // {
        //   url: "https://img13.360buyimg.com/n7/jfs/t1/200171/38/1594/78353/610babc3E77ec1f60/a4d20306d9c2b78e.jpg",
        //   name: "三星 SAMSUNG Galaxy S21 5G（SM-G9910）5G手机 骁龙888 超高清摄像 120Hz护目屏 游戏手机 8G+128G 墨影灰",
        //   price: "4199",
        //   cnt: "5000+",
        // },
      ],
    };
  },
  methods: {
    toGoodsDetail(item) {
      this.$router.push({
        path:'/goodsDetail/${item.goodsname}',
        query: {goodsid:item.goodsid}
      })
    },
    //清空标签
    cleanAddition() {
      this.hasSearchTags = false;
      //清空全部标签
      this.searchTags.splice(0, this.searchTags.length);
      console.log("清空了所有标签");
      console.log(this.searchTags);
      //更新路由
      this.$router.push({
        path: "/category/search",
      });
    },
    //删除标签
    closeTag(tag) {
      this.searchTags.splice(this.searchTags.indexOf(tag), 1);
      console.log("删除了标签");
      console.log(this.searchTags);
      if (this.searchTags.length <= 0) this.hasSearchTags = false;
      this.updateAddress();
    },
    toSearch(key, value) {
      let isAble = true;
      if (this.searchTags !== undefined && this.searchTags.length > 0) {
        for (var i = 0; i < this.searchTags.length; i++) {
          //找到重复，不新增标签，修改该标签的value
          if (this.searchTags[i].key == key) {
            isAble = false;
            //连value也一样，不用修改标签
            if (this.searchTags[i].value == value) {
              break;
            }
            //value不一样，修改标签
            else {
              this.searchTags[i].value = value;
              console.log("修改了标签");
              console.log(this.searchTags);
              this.updateAddress();
              break;
            }
          }
        }
      }
      //没有重复，加标签
      if (isAble) {
        this.addTag(key, value);
        console.log("增加了标签");
        console.log(this.searchTags);
        this.updateAddress();
      }
    },
    //添加标签
    addTag(key, value) {
      let newTag = { key: key, value: value };
      this.searchTags.push(newTag);
      this.hasSearchTags = true;
    },
    //更新路由
    updateAddress() {
      // let routerInfo = "";
      // for (var i = 0; i < this.searchTags.length; i++) {
      //   if (i == this.searchTags.length - 1)
      //     routerInfo += this.searchTags[i].key + "_" + this.searchTags[i].value;
      //   else
      //     routerInfo +=
      //       this.searchTags[i].key + "_" + this.searchTags[i].value + "#";
      // }
      // let query = {};
      if (this.searchTags !== undefined && this.searchTags.length > 1) {
        // query = {
        //   goodsname: this.searchTags[0].value,
        //   details: this.searchTags[1].value,
        //   addition: routerInfo,
        // };
        // console.log(query);
        // this.$router.push({ path: "/category/Search", query: query });
        const this1 = this;
        this.axios
          .post("http://localhost:8084/goods/selectByDetails", {
            goodsname: this.searchTags[0].value,
            details: this.searchTags[1].value,
          })
          .then((res) => {
            let resData = res.data.data;
            this1.searchGoods = resData;
          });
      } else {
        // query = {};
        this.$router.push({ path: "/category/search" });
      }
    },
  },
  created() {
    const this1 = this;
    this.axios
      .post("http://localhost:8084/goods/selectByCatagory", {
        category: "手机",
      })
      .then((res) => {
        console.log(res.data);
        let resData = res.data.data;
        console.log(resData);
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

.tip {
  line-height: 32px;
  font-size: 16px;
}

.tag {
  margin-right: 4px;
}

.options {
  border: 1px solid #e8e8e8;
}

.options .row {
  margin: 0 13px;
  line-height: 35px;
}

.options .line {
  border-top: 1px dashed #dedede;
}

.head {
  padding-left: 14px;
  color: #999;
  font-size: 13px;
}

.item-tag {
  margin-left: 30px;
  margin-right: 30px;
  font-size: 13px;
}
</style>