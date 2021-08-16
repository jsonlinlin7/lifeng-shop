package com.lifeng.shopserver.pojo.entry;

import lombok.Data;

import java.io.Serializable;

/**
 * @author minishark
 */
@Data
public class Goods implements Serializable {
    private int goodsid;
    private String goodsname;
    private String category;
    private double price;
    private String url;
    private String details;

    @Override
    public String toString() {
        return "Goods{" +
                "goodsid=" + goodsid +
                ", goodsname='" + goodsname + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
