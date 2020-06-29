package com.example.toolbox.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DBUtils {
    // 定义数据库名、表明等信息
    public static final String DATABASE_NAME = "ToolBox";
    public static final String DATABASE_TABLE_MEMO = "Memo";
    public static final int DATABASE_VERSION = 1;
    // 备忘录(MEMO)数据库中的列名
    public static final String MEMO_ID = "id";
    public static final String MEMO_CONTENT = "content";
    public static final String MEMO_TIME = "memotime";

    public static final String getTime() {
        // 定义日期的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        // 获取时间
        Date data = new Date(System.currentTimeMillis());
        // 讲获取的时候格式化并返回
        return simpleDateFormat.format(data);
    }

}
