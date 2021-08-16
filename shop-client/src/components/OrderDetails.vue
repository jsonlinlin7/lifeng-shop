<!--订单详情页-->
<template>
  <div id="OrderDetails">
    <div id="header-container">
      <top-nav></top-nav>
    </div>
    <div class="crumbs-mod__container___2OwwW" data-reactid=".0.0">
        <span class="crumbs-mod__label___1uxOQ" data-reactid=".0.0.0">您的位置:
        </span>
      <a class="crumbs-mod__has-sep___1vc6k" href="#" data-reactid=".0.0.1:$crumb-0">首页</a>
      <a class="crumbs-mod__has-sep___1vc6k" href="#" data-reactid=".0.0.1:$crumb-1">我的店铺</a>
      <a class="" href="#" data-reactid=".0.0.1:$crumb-2">已买到的宝贝</a>
    </div>
    <div class="app-mod__trade-status-container___3XC0z" data-reactid=".0.2">
      <div class="app-mod__main-status-container___2l79a" data-reactid=".0.2.1">
        <div class="status-bar-mod__status-bar___38PDP" data-reactid=".0.2.1.0"></div>
        <div class="app-mod__guiding-and-others-container___3AI31" data-reactid=".0.2.1.1">
          <div class="status-desc-mod__status-desc___2Vi38" data-reactid=".0.2.1.1.0">
            <div data-reactid=".0.2.1.1.0.0"><h3 style="display:inline-block;margin-right:1000px;"
                                                 data-reactid=".0.2.1.1.0.0.0">当前订单状态：交易关闭</h3>
              <div style="display:inline-block;font-size:1.17em;font-weight:bold;" data-reactid=".0.2.1.1.0.0.1"></div>
            </div>
            <div class="status-desc-mod__refund-list___1RqGj refund-list-global" id="J_refundList"
                 data-reactid=".0.2.1.1.0.1"></div>
            <div class="status-desc-mod__group-box0___3YGW1" data-reactid=".0.2.1.1.0.2:$0">
              <li class="status-desc-mod__group-box-li___mgxf5" data-reactid=".0.2.1.1.0.2:$0.1:$0">
                <span style="text-align: center;">关闭类型：退款结束</span>
              </li>
              <li class="status-desc-mod__group-box-li___mgxf5 status-desc-mod__group-box-btn-li___1GQeV"
                  data-reactid=".0.2.1.1.0.2:$0.1:$1"></li>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div>
      <nav-footer></nav-footer>
    </div>
  </div>
</template>

<script>
export default {
  name: "OrderDetails",
  components: {
    "top-nav": () => import("@/components/TopNav"),
    "nav-footer": () => import("@/components/NavFooter"),
  }
}
</script>

<style scoped>
.crumbs-mod__container___2OwwW {
  margin-bottom: 10px;
}

.crumbs-mod__label___1uxOQ {
  margin-right: 5px;
}

.crumbs-mod__has-sep___1vc6k {
  background: url(https://assets.alicdn.com/sys/common/img/crumb_bg.gif) 100% 50% no-repeat;
  padding-right: 8px;
  margin-right: 1px;
}

a {
  color: #36c;
  text-decoration: none;
}
.app-mod__main-status-container___2l79a {
  display: table-cell;
  vertical-align: top;
}
.app-mod__guiding-and-others-container___3AI31 {
  padding: 10px 20px 20px 60px;
  background: #FFF7EB;
  border: 1px solid #F58B0F;
}
.status-desc-mod__status-desc___2Vi38 {
  line-height: 25px;
}
li{
  display: inline-block;
  text-align: -webkit-match-parent;
  font-size: 15px;
}
.status-desc-mod__status-desc___2Vi38 h3 {
  margin: 10px 0;
}
.status-desc-mod__refund-list___1RqGj {
  margin-bottom: 10px;
}
h3 {
  font-size: 14px;
}
status-desc-mod__status-desc___2Vi38 .status-desc-mod__group-box0___3YGW1 .status-desc-mod__group-box-li___mgxf5, .status-desc-mod__status-desc___2Vi38 .status-desc-mod__group-box___1ORwU .status-desc-mod__group-box-li___mgxf5 {
  list-style: square;
}
.status-desc-mod__status-desc___2Vi38 .status-desc-mod__group-box0___3YGW1 .status-desc-mod__group-box-li___mgxf5, .status-desc-mod__status-desc___2Vi38 .status-desc-mod__group-box___1ORwU .status-desc-mod__group-box-li___mgxf5 {
  list-style: square;
}
.status-desc-mod__status-desc___2Vi38 .status-desc-mod__group-box0___3YGW1 .status-desc-mod__group-box-btn-li___1GQeV, .status-desc-mod__status-desc___2Vi38 .status-desc-mod__group-box___1ORwU .status-desc-mod__group-box-btn-li___1GQeV {
  list-style: none;
}
.status-desc-mod__status-desc___2Vi38 .status-desc-mod__group-box0___3YGW1 .status-desc-mod__group-box-li___mgxf5, .status-desc-mod__status-desc___2Vi38 .status-desc-mod__group-box___1ORwU .status-desc-mod__group-box-li___mgxf5 {
  list-style: square;
}

</style>