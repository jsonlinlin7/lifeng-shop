package com.lifeng.shopserver.service;

import java.util.ArrayList;

import com.lifeng.shopserver.pojo.entry.Goods;

/**
 * 商品服务类的接口
 * @author minishark
 */
public interface GoodsService{
    /**
     * 通过商品id查询商品信息
     * @param goodsId -- 查询的商品的id
     * @return Goods对象 -- 查询的结果
     */
    Goods selectGoodsByGoodsId(int goodsId);

    /**
     * 根据商品catagory字符串分类获取goods对象
     * @param category -- 商品category
     * @return goods --对象
     */
    ArrayList<Goods> selectGoodsByCategory(String category);

    /**
     * 根据商品catagory字符串分类获取goods对象
     * @param goodsname
     * @param details
     * @return ArrayList --对象
     */
    ArrayList<Goods> selectGoodsByDetails(String goodsname,String details);
    /**
     * @param params
     * @return ArrayList
     */
    ArrayList<Goods> searchGoods(String params);

}
