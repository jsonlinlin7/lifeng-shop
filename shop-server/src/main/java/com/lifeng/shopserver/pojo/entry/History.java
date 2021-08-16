package com.lifeng.shopserver.pojo.entry;

import lombok.Data;

import java.io.Serializable;

/**
 * @author minishark
 */
@Data
public class History implements Serializable {
    private String date;
    private String category;
    private int userid;
    private int goodsid;
    private Goods goods;
    private int init ;
    @Override
    public String toString(){
        return "data="+date+
                ", category="+category+
                ", userid="+userid+
                ", goodsid="+goodsid+
                ", goods="+(goods==null?"null":goods.toString());
    }
    public void checkCategory(){
        if(category==null){
            category="未知";
        }
    }
}
