package com.lifeng.shopserver.controller;

import java.util.ArrayList;

import com.lifeng.shopserver.common.R;
import com.lifeng.shopserver.pojo.entry.Goods;
import com.lifeng.shopserver.pojo.entry.Search;
import com.lifeng.shopserver.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品的控制器
 *
 * @author minishark
 */
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/selectByGoodsId", method = RequestMethod.POST)
    public R<Goods> selectGoodsById(@RequestBody Goods resGoods) {
        int code = 500;
        String message = "获取商品信息失败";
        if (resGoods != null && resGoods.getGoodsid() > 0) {
            resGoods = goodsService.selectGoodsByGoodsId(resGoods.getGoodsid());
        } else {
            resGoods = null;
        }
        if (resGoods != null) {
            code = 200;
            message = "获取商品信息成功";
        }
        return new R<>(code, message, resGoods);
    }

    @RequestMapping(value = "/selectByCatagory", method = RequestMethod.POST)
    public R<ArrayList<Goods>> selectGoodsByCatagory(@RequestBody Goods resGoods1) {
        int code = 500;
        System.out.println("测试" + resGoods1.getCategory());
        String message = "获取商品信息失败";
        ArrayList<Goods> resData1 = null;
        resData1 = goodsService.selectGoodsByCategory(resGoods1.getCategory());
        System.out.println(resData1);
        if (resGoods1 != null) {
            code = 200;
            message = "获取商品信息成功";
        }
        return new R<>(code, message, resData1);
    }

    @RequestMapping(value = "/selectByDetails", method = RequestMethod.POST)
    public R<ArrayList<Goods>> selectGoodsByDetails(@RequestBody Goods resGoods2) {
        int code = 500;
        System.out.println("测试" + resGoods2.getDetails());
        String message = "获取商品信息失败";
        ArrayList<Goods> resData2 = null;
        resData2 = goodsService.selectGoodsByDetails(resGoods2.getGoodsname(), resGoods2.getDetails());
        System.out.println(resData2);
        if (resGoods2 != null) {
            code = 200;
            message = "获取商品信息成功";
        }
        return new R<>(code, message, resData2);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public R<ArrayList<Goods>> searchGoods(@RequestBody Search params) {
        int code = 500;
        System.out.println("测试" + params.getParams());
        String message = "获取商品信息失败";
        ArrayList<Goods> resData3 = null;
        resData3 = goodsService.searchGoods(params.getParams());
        System.out.println(resData3);
        if (params != null) {
            code = 200;
            message = "获取商品信息成功";
        }
        return new R<>(code, message, resData3);
    }

}
