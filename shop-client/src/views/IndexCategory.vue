<template>
  <div id="indexCategory">
    <el-card id="el_card">
      <el-tabs :tab-position="tabPosition" style="height: 380px">
        <el-tab-pane label="电器">
          <el-tree
            class="flow-tree"
            default-expand-all
            :props="defaultProps"
            :data="data1"
          ></el-tree>
        </el-tab-pane>
        <el-tab-pane label="手机">
          <el-tree
            class="flow-tree"
            default-expand-all
            :props="defaultProps"
            :data="data2"
            @node-click="handleNodeClick"
          ></el-tree>
        </el-tab-pane>
        <el-tab-pane label="电脑">
          <el-tree
            :data="data3"
            :props="defaultProps"
            class="flow-tree"
            default-expand-all
          ></el-tree>
        </el-tab-pane>
        <el-tab-pane label="家具">
          <el-tree
            :data="data4"
            :props="defaultProps"
            class="flow-tree"
            default-expand-all
          ></el-tree>
        </el-tab-pane>
        <el-tab-pane label="服装">
          <el-tree
            :data="data5"
            :props="defaultProps"
            class="flow-tree"
            default-expand-all
          ></el-tree>
        </el-tab-pane>
        <el-tab-pane label="鞋包">
          <el-tree
            :data="data6"
            :props="defaultProps"
            class="flow-tree"
            default-expand-all
          ></el-tree>
        </el-tab-pane>
      </el-tabs>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "IndexCategory",
  data() {
    return {
      tabPosition: "left",
      data1: [
        {
          label: "电视",
          children: [
            { label: "全面屏电视" },
            { label: "教育电视" },
            { label: "OLED电视" },
            { label: "智慧屏" },
            { label: "4K超清" },
          ],
        },
        {
          label: "空调",
          children: [
            { label: "空调挂机" },
            { label: "空调柜机" },
            { label: "中央空调" },
            { label: "变频空调" },
            { label: "移动空调" },
          ],
        },
        {
          label: "洗衣机",
          children: [
            { label: "滚筒洗衣机" },
            { label: "洗烘一体机" },
            { label: "波轮洗衣机" },
            { label: "迷你洗衣机" },
            { label: "烘干机" },
            { label: "洗衣机配件" },
          ],
        },
      ],
      data2: [
        {
          label: "手机通讯",
          children: [
            { label: "手机" },
            { label: "游戏手机" },
            { label: "5G手机" },
            { label: "拍照手机" },
            { label: "全面屏手机" },
            { label: "老人机" },
            { label: "对讲机" },
            { label: "手机维修" },
          ],
        },
        {
          label: "运营商",
          children: [
            { label: "电话卡" },
            { label: "花费充值" },
            { label: "流量卡" },
            { label: "中国电信" },
            { label: "中国移动" },
            { label: "中国联通" },
          ],
        },
        {
          label: "手机配件",
          children: [
            { label: "手机壳" },
            { label: "贴膜" },
            { label: "数据线" },
            { label: "充电器" },
            { label: "移动电源" },
          ],
        },
      ],
      data3: [
        { label: "轻薄本" },
        { label: "游戏本" },
        { label: "主机" },
        { label: "显示屏" },
        { label: "处理器" },
        { label: "显卡" },
        { label: "电源" },
        { label: "主版" },
        { label: "内存" },
        { label: "硬盘" },
        { label: "电脑配件" },
      ],
      data4: [
        { label: "沙发" },
        { label: "衣柜" },
        { label: "桌子" },
        { label: "床" },
      ],
      data5: [
        { label: "男装" },
        { label: "女装" },
        { label: "童装" },
        { label: "正装" },
      ],
      data6: [
        { label: "球鞋" },
        { label: "运动鞋" },
        { label: "高跟鞋" },
        { label: "手提包" },
        { label: "单肩包" },
        { label: "背包" },
        { label: "行李箱" },
      ],
      defaultProps: {
        children: "children",
        label: "label",
      },
    };
  },
  methods: {
    handleNodeClick() {
      window.location.href = "/category";
    },
  },
};
</script>

<style scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
.flow-tree {
  overflow: auto;
  height: 380px;
  margin: 5px;
}
</style>
