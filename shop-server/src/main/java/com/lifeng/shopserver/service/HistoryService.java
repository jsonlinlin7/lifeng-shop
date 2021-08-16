package com.lifeng.shopserver.service;

import com.lifeng.shopserver.pojo.entry.History;

import java.util.ArrayList;
import java.util.List;

/**
 * 浏览历史的服务类接口
 * @author minishark
 */
public interface HistoryService {
    /**
     * 新增注解的方法接口
     * @param history -- 历史的实体对象
     * @return boolean 返回布尔值
     */
    boolean insertHistory(History history);

    /**
     * 查询用户的所有浏览历史
     * @param userId -- 用户的id
     * @return ArrayList -- 返回一个对象数据集，里面的类型是History
     */
    ArrayList<History> selectHistoryByUserId(int userId, int init);

    /**
     * 查询用户的浏览历史条数
     * @param userId -- -- 用户的id
     * @return 历史总条数
     */
    int selectAllCount (int userId);
    /**
     * 批量删除历史记录
     * @param userId -- 用户的id
     * @param dateList -- 历史的id
     * @return int -- 受影响的行数
     */
    int deleteHistoryByDateList(int userId, List<String> dateList);
}
