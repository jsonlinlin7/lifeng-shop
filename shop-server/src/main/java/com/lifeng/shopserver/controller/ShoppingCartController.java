package com.lifeng.shopserver.controller;

import com.lifeng.shopserver.common.R;
import com.lifeng.shopserver.pojo.entry.ShoppingCart;
import com.lifeng.shopserver.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @RequestMapping("/oneuser")
    public R getShoppingCart(@RequestParam("id") Long id){
//        System.out.println(userid);
        return new R(200,"查询成功",shoppingCartService.selectShoppingCartByUserId(id));
    }

    @RequestMapping(value = "/insert")
    public R<String> insertShoppingCart(@RequestBody ShoppingCart shoppingCart){
//        System.out.println(shoppingCart.getId()+"sssssssssssssssssssssssssssssss");
//        System.out.println(shoppingCart.getUserid()+"sssssssssssssssssssssssssssssss");
//        System.out.println(shoppingCart.getGoodsid()+"sssssssssssssssssssssssssssssss");
//        System.out.println(shoppingCart.getNum()+"sssssssssssssssssssssssssssssss");
//        System.out.println(shoppingCart.getTotalprice()+"sssssssssssssssssssssssssssssss");
        int code=500;
        String message="插入购物车失败";
        List<ShoppingCart> list=shoppingCartService.selectByUserid_goodsid(
                shoppingCart.getUserid(),shoppingCart.getGoodsid());
        if (!list.isEmpty()){
//            System.out.println(list);
//            System.out.println(list);
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("num",list.get(0).getNum()+shoppingCart.getNum());
            map.put("totalprice",list.get(0).getTotalprice()+shoppingCart.getTotalprice());
            map.put("id",list.get(0).getId());
            if (shoppingCartService.updateShoppingCart(map)){
                code=200;
                message="插入购物车成功";
            }
            return new R<>(code, message);
        }
        if(shoppingCartService.insertShoppingCart(shoppingCart)){
            code=200;
            message="插入购物车成功";
        }else {
            System.out.println("插入购物车失败。");
        }
        return new R<>(code, message);
    }
    @RequestMapping("/delete")
    public R<String> deleteShoppingCart(@RequestBody Integer[] array){
        int code = 500;
        String message = "删除失败";
        if(shoppingCartService.deleteShoppingCart(array)){
            code=200;
            message="删除成功";
        }else {
            System.out.println("删除失败。");
        }
        return new R<>(code, message);
    }
    @RequestMapping("/update")
    public R<String> updateShoppingCart(@RequestBody Map<String, Object> map){
        int code = 500;
        String message = "更新失败";
        if(shoppingCartService.updateShoppingCart(map)){
            code=200;
            message="更新成功";
        }else {
            System.out.println("更新失败。");
        }
        return new R<>(code, message);
    }
}
