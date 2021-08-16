package com.lifeng.shopserver.pojo.entry;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lxf
 */
@Data
public class ShoppingCart implements Serializable {
    private Long id;
    private Long userid;
    private Long goodsid;
    private Long num;
    private Double totalprice;
    private Goods goods;


}
