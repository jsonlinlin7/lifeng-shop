package com.lifeng.shopserver.service;

import com.lifeng.shopserver.pojo.entry.ShoppingCart;

import java.util.List;
import java.util.Map;

public interface ShoppingCartService {

    List<ShoppingCart> selectShoppingCartByUserId(Long id);
    List<ShoppingCart> selectByUserid_goodsid(Long shoppingcartid,Long goodsid);
    boolean insertShoppingCart(ShoppingCart shoppingCart);
    boolean deleteShoppingCart(Integer[] array);
    boolean updateShoppingCart(Map<String, Object> map);


}
