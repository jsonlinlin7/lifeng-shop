package com.lifeng.shopserver.Tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 提供获取时间相关的工具类
 * @author minishark
 */
public class TimeTool {
    /**
     * 获取当前时间
     * @return 格式化的当前时间
     */
    public static String getTime(){
        Date now = new Date();
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(now);
    }
}
