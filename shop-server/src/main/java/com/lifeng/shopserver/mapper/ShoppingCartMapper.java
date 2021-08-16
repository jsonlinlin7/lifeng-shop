package com.lifeng.shopserver.mapper;

import com.lifeng.shopserver.pojo.entry.ShoppingCart;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author lxf
 */
@Component
public interface ShoppingCartMapper {

    List<ShoppingCart> selectShoppingCart(Long id);

    List<ShoppingCart> selectByUserid_goodsid(Long userid, Long goodsid);

    int insertShoppingCart(ShoppingCart shoppingCart);

    int deleteShoppingCart(Integer[] array);

    int updateShoppingCart(Map<String, Object> map);
}
