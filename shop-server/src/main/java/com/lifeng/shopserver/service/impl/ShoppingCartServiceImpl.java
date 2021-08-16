package com.lifeng.shopserver.service.impl;

import com.lifeng.shopserver.mapper.ShoppingCartMapper;
import com.lifeng.shopserver.pojo.entry.ShoppingCart;
import com.lifeng.shopserver.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Override
    public List<ShoppingCart> selectShoppingCartByUserId(Long id) {
//        System.out.println(id+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasssssssss");
        return shoppingCartMapper.selectShoppingCart(id);
    }

    @Override
    public List<ShoppingCart> selectByUserid_goodsid(Long userid, Long goodsid) {
        return shoppingCartMapper.selectByUserid_goodsid(userid,goodsid);
    }

    @Override
    public boolean insertShoppingCart(ShoppingCart shoppingCart) {
//        System.out.println("购物车调试信息");
        return shoppingCartMapper.insertShoppingCart(shoppingCart)==1;
    }

    @Override
    public boolean deleteShoppingCart(Integer[] array) {

        return shoppingCartMapper.deleteShoppingCart(array)>=1;
    }
    @Override
    public boolean updateShoppingCart(Map<String, Object> map) {
//        System.out.println(map.toString());
        return shoppingCartMapper.updateShoppingCart(map)>=1;
    }

}
