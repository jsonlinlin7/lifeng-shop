<template>
    <div class="footer" style="border-radius: 30px">
        <div class="footer-logo">
            <!-- <a href=""><img src="" alt=""></a> -->
            <h2>砺锋商城</h2>
        </div>
        <div class="footer-link">
            <a href="">首页</a><span>|</span>
            <a href="">关于我们</a><span>|</span>
            <a href="">团队介绍</a><span>|</span>
            <a href="">配送方式</a><span>|</span>
            <a href="">支付安全</a><span>|</span>
            <a href="">售后政策</a><span>|</span>
            <a href="">退款流程</a>
        </div>
        <div class="copyright">
            Copyright  © 2021 <span>奥特麒麟开拓者小组</span> Rights Reserved.
        </div>
    </div>
</template>

<script>
    export default{
        name:"NavFooter"
    }
</script>

<style scoped>
    .footer {
        height: 180px;
        /*border-top: 4px solid #FF6600;*/
        background-color: #ffffff;
        color: #333333;
        font-size: 16px;
        padding-top: 1px;
        text-align: center;
    }
    .footer-logo {
        margin-top: 46px;
        margin-bottom: 20px;
    }
    .footer-logo img {
        width: 53px;
        height: 36px;
        margin-bottom: 13px;
    }

    .footer-link {
        margin-bottom: 13px;
    }
    .footer-link a {
        color: #333333;
        display: inline-block;
    }
    .footer-link span {
        margin: 0 10px;
    }

    .copyright span {
        color: #ff6600
    }
</style>
