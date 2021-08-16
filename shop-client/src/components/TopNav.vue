<template>
  <div id="TopNav">
    <el-card class="maintop">
      <!--属性default-active，用来设置默认激活的index。-->
      <el-menu
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
      >
        <el-menu-item class="font" @click="toIndex()">LiFengShop</el-menu-item>

        <el-menu-item>
          <div @keyup.enter="toSearch()">
            <el-autocomplete
              v-model="state"
              :fetch-suggestions="querySearchAsync"
              placeholder="搜索好用单品"
              suffix-icon="el-icon-search"
              style="width: 550px"
            >
            </el-autocomplete>
            <!-- <router-link :to="{name:'Search',parms:{key:'state'}}">搜索</router-link> -->
            <el-button
              @click="toSearch()"
              style="margin-left: 3px; margin-top: 3px"
              >搜索</el-button
            >
          </div>
        </el-menu-item>
        <!-- <el-menu-item index="4" @click="drawer = true" >个人中心</el-menu-item> -->
        <el-menu-item index="4" @click="drawer = true" v-show="islogin"
          >个人中心</el-menu-item
        >
        <el-menu-item index="11" @click="toLogin" v-show="!islogin"
          >登陆</el-menu-item
        >
        <el-menu-item index="12" @click="toRegister" v-show="!islogin"
          >注册</el-menu-item
        >
        <el-menu-item>
          <el-dropdown @command="handleCommand">
            <span class="el-dropdown-link"
              >用户服务<i class="el-icon-arrow-down el-icon--right"></i
            ></span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="如需帮助请联系QQ：123456789"
                >帮助</el-dropdown-item
              >
              <el-dropdown-item command="奥特麒麟开拓者制造"
                >关于我们</el-dropdown-item
              >
            </el-dropdown-menu>
          </el-dropdown>
        </el-menu-item>
      </el-menu>
      <el-drawer :visible.sync="drawer" :with-header="false" size="300px">
        <div class="header top-space-large">
          <div class="avatar">
            <el-avatar
              shape="square"
              :size="100"
              :src="userInfo.avatar"
            ></el-avatar>
          </div>
          <div class="username">
            <span>{{ userInfo.username }}</span>
          </div>
        </div>
        <div class="main top-space-large">
          <el-menu
            :default-active="activeIndex"
            class="el-menu-vertical-demo"
            mode="vertical"
          >
            <el-menu-item
              class="top-space-small"
              index="1"
              @click="openInfoDiv()"
              >个人资料</el-menu-item
            >
            <el-menu-item class="top-space-small" index="2" @click="toOrder"
              >我的订单</el-menu-item
            >
            <el-menu-item
              class="top-space-small"
              index="3"
              @click="toCollection"
              >我的收藏</el-menu-item
            >
            <el-menu-item class="top-space-small" index="4" @click="toHistory()"
              >浏览历史</el-menu-item
            >
            <!-- <el-menu-item class="top-space-small" index="5" @click="updateUser">修改用户信息</el-menu-item> -->
            <el-menu-item
              class="top-space-small"
              index="6"
              @click="logout()"
              style="margin-top: 80px; color: red"
              >注销</el-menu-item
            >
          </el-menu>
        </div>
      </el-drawer>
    </el-card>
    <!-- 弹窗显示个人资料窗口 -->
    <el-dialog title="个人资料" :visible.sync="showInfoDiv" width="30%">
      <el-form ref="infoForm" :model="infoForm" label-width="80px">
        <el-form-item label="手机号码">
          <el-input type="number" v-model="infoForm.userPhone"></el-input>
        </el-form-item>
        <el-form-item label="用户名">
          <el-input v-model="infoForm.username" readonly="readonly"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input type="password" v-model="infoForm.userpwd"></el-input>
        </el-form-item>
        <el-form-item label="地址">
          <el-input type="text" v-model="infoForm.userAddress"></el-input>
        </el-form-item>
        <el-form-item label="">
          <el-button type="primary" @click="updataUserInfo()">修改</el-button>
          <el-button @click="noUpdateInfo()">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import { loginByUsername } from "@/api/user";
// import {getUser} from "@/api/user"
export default {
  name: "TopNav",
  data() {
    return {
      islogin: false,
      showInfoDiv: false,
      infoForm: {
        userPhone: 123,
        username: "demo",
        userpwd: "demo",
        userAddress: "demo",
      },

      activeIndex: "1", //设置标记
      restaurants: [],
      state: "",
      timeout: null,
      drawer: false,
      userInfo: {
        avatar:
          "http://img.wxcha.com/m00/06/ba/a28f280598ccc65d5dc9b7cdc2603d25.jpg",
        username: "迪迦在线购物",
        userpwd: "",
        userPhone: "110",
        userAddress: "仲恺农业工程学院白云校区",
      },
    };
  },
  created() {
    if (this.get_cookie("userid") > 0) {
      console.log(this.get_cookie("userid") > 0);
      this.islogin = true;
    }
    if (this.$route.query.islogin === "true") {
      this.islogin = true;
      this.set_cookie("userid", 1);
    }else{
      this.islogin=false;
    }
  },
  methods: {
    handleCommand(command) {
      this.$message(command);
    },
    //跳转到登录页面
    toLogin() {
      this.$router.replace("/login");
    },
    //跳转到注册页面
    toRegister() {
      this.$router.replace("/register");
    },

    //跳转到收藏页面
    toCollection() {
      this.$router.push({ name: "collection" });
    },
    //跳转到浏览历史界面
    toHistory() {
      this.$router.push({ name: "History" });
    },
    //修改个人资料
    updataUserInfo() {
      this.userInfo.userpwd = this.infoForm.userpwd;
      this.userInfo.userPhone = this.infoForm.userPhone;
      this.userInfo.userAddress = this.infoForm.userAddress;
      console.log("模拟修改个人资料");
      this.noUpdateInfo();
    },
    //不修改个人资料
    noUpdateInfo() {
      this.showInfoDiv = false;
    },
    //打开个人资料弹窗
    openInfoDiv() {
      this.showInfoDiv = true;
      this.infoForm.username = this.userInfo.username;
      this.infoForm.userpwd = this.userInfo.userpwd;
      this.infoForm.userPhone = this.userInfo.userPhone;
      this.infoForm.userAddress = this.userInfo.userAddress;
    },
    toIndex() {
      this.$router.push({ name: "toIndex" });
    },
    logout() {
      this.set_cookie("userid", "");
      this.drawer = false;
      this.islogin = false;
    },

    getUserInfo() {
      console.log(this.$store.getters.user);
    },
    setPassword() {
      //commit就是告诉mutations使用哪一个方法
      //commit第一个参数是方法名, 其他参数都是给这个方法传递的实参
      this.$store.commit("updatePassword", "zxcv");
    },
    updateUser() {
      let user = {
        username: "admin",
        password: "root",
      };
      this.$store.dispatch("setUser", user);
    },
    toOrder() {
      this.$router.push({ path: "/order" });
    },
    requestData() {
      let user = {
        username: "admin",
        password: "root",
      };
      loginByUsername(user).then((res) => {
        console.log(res.data.data);
      });
    },
    set_cookie(key, val) {
      let d = new Date();
      d.setTime(d.getTime() + 24 * 60 * 60 * 1000);
      let expires = "expires=" + d.toGMTString();
      console.log(expires);
      document.cookie = key + "=" + val;
    },
    get_cookie(key) {
      let name = key + "=";
      let ca = document.cookie.split(";");
      for (let i = 0; i < ca.length; i++) {
        let c = ca[i].trim();
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
      }
      return "";
    },
    toSearch() {
      // console.log(this.state+" 搜索");;
      this.$router.push({
        name: "CategorySearchContent",
        params: { key: this.state },
      });
    },

    loadAll() {
      return [
        // { value: "三全鲜食（北新泾店）", address: "长宁区新渔路144号" },
        // {
        //   value: "Hot honey 首尔炸鸡（仙霞路）",
        //   address: "上海市长宁区淞虹路661号",
        // },
        // {
        //   value: "新旺角茶餐厅",
        //   address: "上海市普陀区真北路988号创邑金沙谷6号楼113",
        // },
        // { value: "泷千家(天山西路店)", address: "天山西路438号" },
        // {
        //   value: "胖仙女纸杯蛋糕（上海凌空店）",
        //   address: "上海市长宁区金钟路968号1幢18号楼一层商铺18-101",
        // },
        // { value: "贡茶", address: "上海市长宁区金钟路633号" },
        // {
        //   value: "豪大大香鸡排超级奶爸",
        //   address: "上海市嘉定区曹安公路曹安路1685号",
        // },
        // {
        //   value: "茶芝兰（奶茶，手抓饼）",
        //   address: "上海市普陀区同普路1435号",
        // },
        // { value: "十二泷町", address: "上海市北翟路1444弄81号B幢-107" },
        // { value: "星移浓缩咖啡", address: "上海市嘉定区新郁路817号" },
        // { value: "阿姨奶茶/豪大大", address: "嘉定区曹安路1611号" },
        // { value: "新麦甜四季甜品炸鸡", address: "嘉定区曹安公路2383弄55号" },
        // {
        //   value: "Monica摩托主题咖啡店",
        //   address: "嘉定区江桥镇曹安公路2409号1F，2383弄62号1F",
        // },
        // {
        //   value: "浮生若茶（凌空soho店）",
        //   address: "上海长宁区金钟路968号9号楼地下一层",
        // },
        // { value: "NONO JUICE  鲜榨果汁", address: "上海市长宁区天山西路119号" },
        // { value: "CoCo都可(北新泾店）", address: "上海市长宁区仙霞西路" },
        // {
        //   value: "快乐柠檬（神州智慧店）",
        //   address: "上海市长宁区天山西路567号1层R117号店铺",
        // },
        // {
        //   value: "Merci Paul cafe",
        //   address: "上海市普陀区光复西路丹巴路28弄6号楼819",
        // },
        // {
        //   value: "猫山王（西郊百联店）",
        //   address: "上海市长宁区仙霞西路88号第一层G05-F01-1-306",
        // },
        // { value: "枪会山", address: "上海市普陀区棕榈路" },
        // { value: "纵食", address: "元丰天山花园(东门) 双流路267号" },
        // { value: "钱记", address: "上海市长宁区天山西路" },
        // { value: "壹杯加", address: "上海市长宁区通协路" },
        // {
        //   value: "唦哇嘀咖",
        //   address: "上海市长宁区新泾镇金钟路999号2幢（B幢）第01层第1-02A单元",
        // },
        // { value: "爱茜茜里(西郊百联)", address: "长宁区仙霞西路88号1305室" },
        // {
        //   value: "爱茜茜里(近铁广场)",
        //   address:
        //     "上海市普陀区真北路818号近铁城市广场北区地下二楼N-B2-O2-C商铺",
        // },
        // {
        //   value: "鲜果榨汁（金沙江路和美广店）",
        //   address: "普陀区金沙江路2239号金沙和美广场B1-10-6",
        // },
        // {
        //   value: "开心丽果（缤谷店）",
        //   address: "上海市长宁区威宁路天山路341号",
        // },
        // { value: "超级鸡车（丰庄路店）", address: "上海市嘉定区丰庄路240号" },
        // { value: "妙生活果园（北新泾店）", address: "长宁区新渔路144号" },
        // { value: "香宜度麻辣香锅", address: "长宁区淞虹路148号" },
        // {
        //   value: "凡仔汉堡（老真北路店）",
        //   address: "上海市普陀区老真北路160号",
        // },
        // { value: "港式小铺", address: "上海市长宁区金钟路968号15楼15-105室" },
        // { value: "蜀香源麻辣香锅（剑河路店）", address: "剑河路443-1" },
        // { value: "北京饺子馆", address: "长宁区北新泾街道天山西路490-1号" },
        // {
        //   value: "饭典*新简餐（凌空SOHO店）",
        //   address: "上海市长宁区金钟路968号9号楼地下一层9-83室",
        // },
        // {
        //   value: "焦耳·川式快餐（金钟路店）",
        //   address: "上海市金钟路633号地下一层甲部",
        // },
        // { value: "动力鸡车", address: "长宁区仙霞西路299弄3号101B" },
        // { value: "浏阳蒸菜", address: "天山西路430号" },
        // { value: "四海游龙（天山西路店）", address: "上海市长宁区天山西路" },
        // {
        //   value: "樱花食堂（凌空店）",
        //   address: "上海市长宁区金钟路968号15楼15-105室",
        // },
        // { value: "壹分米客家传统调制米粉(天山店)", address: "天山西路428号" },
        // {
        //   value: "福荣祥烧腊（平溪路店）",
        //   address: "上海市长宁区协和路福泉路255弄57-73号",
        // },
        // {
        //   value: "速记黄焖鸡米饭",
        //   address: "上海市长宁区北新泾街道金钟路180号1层01号摊位",
        // },
        // { value: "红辣椒麻辣烫", address: "上海市长宁区天山西路492号" },
        // {
        //   value: "(小杨生煎)西郊百联餐厅",
        //   address: "长宁区仙霞西路88号百联2楼",
        // },
        // { value: "阳阳麻辣烫", address: "天山西路389号" },
        // {
        //   value: "南拳妈妈龙虾盖浇饭",
        //   address: "普陀区金沙江路1699号鑫乐惠美食广场A13",
        // },
      ];
    },
    querySearchAsync(queryString, cb) {
      var restaurants = this.restaurants;
      var results = queryString
        ? restaurants.filter(this.createStateFilter(queryString))
        : restaurants;

      clearTimeout(this.timeout);
      this.timeout = setTimeout(() => {
        cb(results);
      }, 3000 * Math.random());
      // console.log("点击了搜索按钮。");
    },
    createStateFilter(queryString) {
      return (state) => {
        return (
          state.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0
        );
      };
    },
  },
  mounted() {
    this.restaurants = this.loadAll();
  },
};
</script>

<style scoped>
.header {
  text-align: center;
}

.main {
  text-align: center;
}
.maintop {
  border-radius: 20px;
}

.username {
  margin-top: 20px;
}
/*顶部菜单栏*/
.el-dropdown-link {
  cursor: pointer;
}
.el-icon-arrow-down {
  font-size: 12px;
  font-color: #909399;
}
.font {
  font-size: 40px;
  font-family: 华文隶书;
  color: red;
}
</style>