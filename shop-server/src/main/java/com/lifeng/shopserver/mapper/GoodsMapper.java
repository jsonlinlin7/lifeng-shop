package com.lifeng.shopserver.mapper;

import java.util.ArrayList;

import com.lifeng.shopserver.pojo.entry.Goods;
import org.springframework.stereotype.Component;

/**
 * @author minishark
 */
@Component
public interface GoodsMapper {
    /**
     * 给GoodsMapper的selectGoods进行级联查询用。
     * @param goodsid -- 商品id
     * @return goods --对象
     */
    Goods selectGoodsByGoodsid(int goodsid);
    /**
     * 给GoodsMapper的selectGoods进行级联查询用。
     * @param category
     * @return ArrayList --对象
     */
    ArrayList<Goods> selectGoodsByCategory(String category);
    /**
     * 给GoodsMapper的selectGoods进行级联查询用。
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
