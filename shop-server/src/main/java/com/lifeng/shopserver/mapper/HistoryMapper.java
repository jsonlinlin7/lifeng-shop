package com.lifeng.shopserver.mapper;

import com.lifeng.shopserver.pojo.entry.History;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author minishark
 */
@Component
public interface HistoryMapper {
    /**
     * 新增浏览记录
     * @param history -- history 实体对象
     * @return int -- 数据库中受影响的行数， 等于1时插入成功。
     */
    int insertHistory(History history);

    /**
     * 该方法用于 查询用户的历史记录。
     * @param userid --用户id
     * @return ArrayList -- 返回一个对象数组类型的结果集合
     *
     */
    ArrayList<History> selectHistory(int userid,int init);

    /**
     * 查询用户的浏览历史条数
     * @param userid -- 用户id
     * @return 总数
     */
    int selectAllCount(int userid);
    /**
     * 根据日期信息删除对应的历史记录。
     * @param userid -- 用户的id
     * @param dateList -- 待删除的日期列表
     * @return int -- 受影响的行数
     */
    int deleteHistoryByDateList(int userid, List<String> dateList);

}
