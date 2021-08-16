<template>
    <div id="RecommendPage" >
        <el-card class="back">
            <div><h3>为您推荐</h3></div>
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">沙发</span>
                <br>
                <el-row >
                    <el-col :span="4" v-for="(item, index) in shafa" :key="index" :offset="index%5 == 0 ? 0 : 1">
                        <el-card class="itemCard" shadow="hover" >
                            <img :src="item.url" class="image" @click="toGoodsDetail(item.name,item.id)">
                            <span class="productPrice">￥{{item.price }} </span>
                            <span class="productItemDesc">{{item.name}}</span>
                        </el-card>
                    </el-col>
                </el-row>
            </div>

            <!--      马桶-->
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">马桶</span>
                <br>
                <el-row >
                    <el-col :span="4" v-for="(item, index) in stinkpot" :key="index" :offset="index%5 == 0 ? 0 : 1">
                        <el-card class="itemCard" shadow="hover" >
                            <img :src="item.url" class="image" @click="toGoodsDetail(item.url,item.price,item.name,item.id)">
                            <span class="productPrice">￥{{item.price }} </span>
                            <span class="productItemDesc">{{item.name}}</span>
                        </el-card>
                    </el-col>
                </el-row>

            </div>

            <!-- 电热水器-->
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">电热水器</span>
                <br>
                <el-row >
                    <el-col :span="4" v-for="(item, index) in calorifier" :key="index" :offset="index%5 == 0 ? 0 : 1">
                        <el-card class="itemCard" shadow="hover" >
                            <img :src="item.url" class="image" @click="toGoodsDetail(item.url,item.price,item.name,item.id)">
                            <span class="productPrice">￥{{item.price }} </span>
                            <span class="productItemDesc">{{item.name}}</span>
                        </el-card>
                    </el-col>
                </el-row>
            </div>
            <!--      扫地机器人-->
            <div class="eachHomepageCategoryProducts">
                <div class="left-mark"></div>
                <span class="categoryTitle">扫地机器人 </span>
                <br>
                <el-row >
                    <el-col :span="4" v-for="(item, index) in robot" :key="index" :offset="index%5 == 0 ? 0 : 1">
                        <el-card class="itemCard" shadow="hover" >
                            <img :src="item.url" class="image" @click="toGoodsDetail(item.name,item.id)">
                            <span class="productPrice">￥{{item.price }} </span>
                            <span class="productItemDesc">{{item.name}}</span>
                        </el-card>
                    </el-col>
                </el-row>
                <div style="clear:both"></div>
            </div >
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "RecommendPage",
        data() {
            return {
                shafa: [
                    {
                        url: "http://tmall.how2j.cn/productSingle_middle/1895.jpg",
                        name: "[热销]凯米蒂亚欧式真皮沙发组合客厅奢华转角皮艺",
                        price: "11038.80",
                        id:1
                    },
                    {
                        url: "http://tmall.how2j.cn/productSingle_middle/1928.jpg",
                        name: "[热销]雅居汇欧式沙发组合实木雕花客厅高档奢华大",
                        price: "22,715.00",
                        id:2
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/1884.jpg",
                        name: "[热销]新款布艺沙发 可拆洗大小户型客厅简约家居",
                        price: "3638.60",
                        id:3
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/1928.jpg",
                        name: "[热销]雅居汇欧式沙发组合实木雕花客厅高档奢华大",
                        price: "22,715.00",
                        id:4
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/1906.jpg",
                        name: "[热销]南台布艺沙发组合可拆洗简约现代客厅整装家",
                        price: "4274.40",
                        id:5
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/1895.jpg",
                        name: "[热销]凯米蒂亚欧式真皮沙发组合客厅奢华转角皮艺",
                        price: "11038.80",
                        id:6
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/1917.jpg",
                        name: "[热销]依然美佳欧式布艺沙发组合可拆洗新款实木雕",
                        price: "7008.40",
                        id:7
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/1884.jpg",
                        name: "[热销]新款布艺沙发 可拆洗大小户型客厅简约家居",
                        price: "3638.60",
                        id:8
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/1895.jpg",
                        name: "[热销]凯米蒂亚欧式真皮沙发组合客厅奢华转角皮艺",
                        price: "11038.80",
                        id:9
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/1928.jpg",
                        name: "[热销]雅居汇欧式沙发组合实木雕花客厅高档奢华大",
                        price: "22,715.00",
                        id:10
                    },

                ],

                stinkpot: [
                    {
                        url: "http://tmall.how2j.cn/productSingle_middle/1291.jpg",
                        name: "[热销]箭牌马桶/ARROW AB1118脲醛盖",
                        price: "1,482.00",
                        id:11
                    },
                    {
                        url: "http://tmall.how2j.cn/productSingle_middle/1324.jpg",
                        name: "[热销]纳蒂兰卡 1082卫浴洁具钻石切边",
                        price: "1,710.00",
                        id:12
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/1313.jpg",
                        name: "[热销]德国DGPOSY超漩式彩色马桶缓降坐便器",
                        price: "1,799.25",
                        id:13
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/1302.jpg",
                        name: "[热销]纳蒂兰卡1066卫浴漩冲虹吸式马桶350",
                        price: "1,503.00",
                        id:14
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/1291.jpg",
                        name: "[热销]箭牌马桶/ARROW AB1118脲醛盖",
                        price: "1482.40",
                        id:15
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/1280.jpg",
                        name: "[热销]乐洁士智能马桶高品质全自动遥控感应一体式",
                        price: "8512.00",
                        id:16
                    },
                ],
                calorifier: [
                    {
                        url: "http://tmall.how2j.cn/productSingle_middle/2581.jpg",
                        name: "[热销]Haier/海尔 EC8003-I/80",
                        price: "1,169.35",
                        id:17
                    },
                    {
                        url: "http://tmall.how2j.cn/productSingle_middle/2570.jpg",
                        name: "[热销]Vanward/万和 DSCF50-C3",
                        price: "699.30",
                        id:18
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/2559.jpg",
                        name: "[热销]哆啦A梦weber I2-80 威博电热",
                        price: "1,079.40",
                        id:19
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/2548.jpg",
                        name: "[热销]Haier/海尔 EC6005-T+",
                        price: "1,299.35",
                        id:20
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/2537.jpg",
                        name: "[热销]Vatti/华帝 DDF60-i1400",
                        price: "1,439.40",
                        id:21
                    },
                ],
                robot: [
                    {
                        url: "http://tmall.how2j.cn/productSingle_middle/3796.jpg",
                        name: "[热销]公众智能扫地机器人家用全自动电动清洁地毯",
                        price: "2,124.15",
                        id:22
                    },
                    {
                        url: "http://tmall.how2j.cn/productSingle_middle/3785.jpg",
                        name: "[热销]莱克扫地吸尘器 家用超薄拖地机器人WR1",
                        price: "974.25",
                        id:23
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/3774.jpg",
                        name: "[热销]海尔拖地机器人家用全自动擦地机湿拖扫洗地",
                        price: "2,999.25",
                        id:24
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/3763.jpg",
                        name: "[热销]Proscenic Swan天鹅扫地机器",
                        price: "4,935.00",
                        id:25
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/3752.jpg",
                        name: "[热销]洁霸BF522多功能洗地机刷地机酒店家用",
                        price: "1,235.00",
                        id:26
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/3763.jpg",
                        name: "[热销]Proscenic Swan天鹅扫地机器",
                        price: "4,935.00",
                        id:27
                    },{
                        url: "http://tmall.how2j.cn/productSingle_middle/3752.jpg",
                        name: "[热销]洁霸BF522多功能洗地机刷地机酒店家用",
                        price: " 1,235.00",
                        id:28
                    },
                ]

            }
        },

        methods: {
            toGoodsDetail(name,id) {
                this.$router.push({
                    path:'/goodsDetail/${name}',
                    query: {goodsid:id}
                })
            }
        }
    }

</script>

<style scoped>
    #cent{
        margin:0 25px;
    }
    .left-mark {
        display: inline-block;
        height: 20px;
        vertical-align: top;
        width: 5px;
        margin:0px 25px;
        background-color: #19C8A9;
    }

    .productItem {
        width: 189px;
        height: 285px;
        border: 1px solid blanchedalmond;
        background-color: white;
        margin: 8px 4px;
        float: left;
        cursor: pointer;
    }

    .productItem span.productPrice {
        font-size: 16px;
        color: #FF003A;
        display: block;
        padding-left: 16px;
        margin-top: -10px;
    }

    div.eachHomepageCategoryProducts {
        /*width: 100%;*/
        margin: 0px 0px 40px 0px;
    }

    img {
        width: 187px;
        height: 200px;
    }
    .image{
        width: 100%;
        height: 90px;
    }
    span.productItemDesc {
        font-size: 12px;
        color: #666666;
        display: block;
    }
    span.productPrice {
        font-size: 16px;
        color: #FF003A;
        display: block;
        padding-left: 16px;
    }


    /*设置推荐列表背景*/
    .back {
        background-color: #ffffff;
    }

</style>
