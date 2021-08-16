package com.lifeng.shopserver.controller;

import com.lifeng.shopserver.Tools.TimeTool;
import com.lifeng.shopserver.common.R;
import com.lifeng.shopserver.pojo.entry.History;
import com.lifeng.shopserver.service.HistoryService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author minishark
 */
@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public R<String> testPost(@RequestBody Map<String, Object> body){
        System.out.println(body.values());
        return new R<>(200,"成功连接后端服务器，接收到数据如下："+body.entrySet());
    }
    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    public R<String> insertHistory(@RequestBody History history){
        System.out.println(history.toString());
        int code = 500;
        String message = "插入浏览历史失败";
        history.setDate(TimeTool.getTime());
        history.checkCategory();
        if(historyService.insertHistory(history)){
            code=200;
            message="插入历史成功";
        }else {
            System.out.println("插入浏览历史失败。");
        }
        return new R<>(code, message);
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public R<ArrayList<History>> selectAllHistoryByUserId(@RequestBody History history){
        System.out.println(history.toString());
        int code = 500;
        String message = "查询用户浏览历史失败。";
        ArrayList<History> resData = null;
        if(history.getUserid()>0){
            resData = historyService.selectHistoryByUserId(history.getUserid(),history.getInit()*30);
            code=200;
            message=""+historyService.selectAllCount(history.getUserid());
        }
        return new R<>(code,message,resData);
    }

    @RequestMapping(value = "/deleteByDateList",method = RequestMethod.POST)
    public R<String> deleteHistoryByDateList (@RequestBody Map<String,Object> params){
        System.out.println(params.entrySet());
        int code = 500;
        String message = "删除用户浏览历史失败。";
        if(!params.containsKey("userid")||!params.containsKey("dateList")){
            message="缺少关键参数";
        }else {
            Object date = params.get("dateList");
            int userid =(int) params.get("userid");
            List<String> dateList = new ArrayList<>();
            if(date instanceof List<?>){
                for (Object o : (List<?>) date) {
                    dateList.add((String) o);
                }
                if (dateList.size()<=0){
                    message="用户未选择要删除的历史。";
                }else if(historyService.deleteHistoryByDateList(userid,dateList)!=dateList.size()){
                    message="所选的浏览历史未完全删除。";
                }else {
                    message="删除成功";
                }
                code=200;
            }
        }
        return new R<>(code,message);
    }
}
