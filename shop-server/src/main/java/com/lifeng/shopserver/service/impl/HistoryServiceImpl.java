package com.lifeng.shopserver.service.impl;

import com.lifeng.shopserver.mapper.HistoryMapper;
import com.lifeng.shopserver.pojo.entry.History;
import com.lifeng.shopserver.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 浏览历史服务类的实现
 * @author minishark
 */
@Service
@Component
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryMapper historyMapper;
    @Override
    public boolean insertHistory(History history) {
        return historyMapper.insertHistory(history)==1;
    }

    @Override
    public ArrayList<History> selectHistoryByUserId(int userId,int init) {
        return historyMapper.selectHistory(userId,init);
    }

    @Override
    public int selectAllCount (int userId){
        return historyMapper.selectAllCount(userId);
    }

    @Override
    public int deleteHistoryByDateList(int userId, List<String> dateList){
        return historyMapper.deleteHistoryByDateList(userId,dateList);
    }
}
