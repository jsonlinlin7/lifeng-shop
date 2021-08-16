
package com.lifeng.shopserver;

import com.lifeng.shopserver.Tools.TimeTool;
import com.lifeng.shopserver.pojo.entry.History;
import com.lifeng.shopserver.service.HistoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ShopServerApplicationTests {
    @Autowired
    private HistoryService historyService;

    @Test
    void contextLoads() {
    }

    @Test
    void InsertHistoryTest(){
        History history = new History();
        history.setCategory("饮料");
        history.setGoodsid(101);
        history.setUserid(196);
        history.setDate(TimeTool.getTime());
        System.out.println(history.toString());
        System.out.println(historyService.insertHistory(history));
    }

    @Test
    void SelectHistoryTest(){
        ArrayList<History> res = historyService.selectHistoryByUserId(1,0);
        if(res==null){
            System.out.println("未查询到数据");
        }else {
            for (History re : res) {
                System.out.println(re.toString());
            }
        }
    }

    @Test
    void DeleteHistoryByDateListTest(){
        List<String> dateList = new ArrayList<>();
        dateList.add("2021-08-08 10:49:23");
        int userid = 1;
        System.out.println(historyService.deleteHistoryByDateList(userid,dateList));
    }
}
