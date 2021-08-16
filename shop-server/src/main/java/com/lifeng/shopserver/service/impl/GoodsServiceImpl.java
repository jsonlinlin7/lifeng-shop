package com.lifeng.shopserver.service.impl;

import java.util.ArrayList;

import com.lifeng.shopserver.mapper.GoodsMapper;
import com.lifeng.shopserver.pojo.entry.Goods;
import com.lifeng.shopserver.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods selectGoodsByGoodsId(int goodsId) {
        return goodsMapper.selectGoodsByGoodsid(goodsId);
    }

    @Override
    public ArrayList<Goods> selectGoodsByCategory(String category){
        return goodsMapper.selectGoodsByCategory(category);
    }

    @Override
    public ArrayList<Goods> selectGoodsByDetails(String goodsname,String details){
        return goodsMapper.selectGoodsByDetails(goodsname, details);
    }

    @Override
    public ArrayList<Goods> searchGoods(String params){
        return goodsMapper.searchGoods(params);
    }

}
