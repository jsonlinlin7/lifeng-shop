<template>
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
                class="item"
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
</template>

<script>
export default {
  name: "CategoryPhoneHead",
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
        {
          id: "2",
          name: "分类",
          subConditions: [
            {
              id: "2-1",
              name: "手机",
            },
            {
              id: "2-2",
              name: "二手手机",
            },
            {
              id: "2-3",
              name: "合约机",
            },
          ],
        },
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
    };
  },
  methods: {
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
        query: { keyword: this.searchKey },
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
  },
};
</script>

<style scoped>
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

.item {
  margin-left: 30px;
  margin-right: 30px;
  font-size: 13px;
}
</style>