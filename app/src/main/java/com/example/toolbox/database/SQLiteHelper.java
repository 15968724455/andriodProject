package com.example.toolbox.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.toolbox.bean.MemoBean;
import com.example.toolbox.utils.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private SQLiteDatabase sqLiteDatabase;

    // 创建数据库
    public SQLiteHelper(Context context) {
        super(context, DBUtils.DATABASE_NAME, null, DBUtils.DATABASE_VERSION);
        // 使本地硬盘空间出现数据库文件
        sqLiteDatabase = this.getWritableDatabase();
    }

    // 创建表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DBUtils.DATABASE_TABLE_MEMO +
                "(" + DBUtils.MEMO_ID + " integer primary key autoincrement," +
                DBUtils.MEMO_CONTENT + " text," +
                DBUtils.MEMO_TIME + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // 添加数据
    public boolean insertData(String userContent, String userTime) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBUtils.MEMO_CONTENT, userContent);
        contentValues.put(DBUtils.MEMO_TIME, userTime);
        // 添加数据，并根据添加结果返回布尔变量
        return sqLiteDatabase.insert(DBUtils.DATABASE_TABLE_MEMO, null, contentValues) > 0;
    }

    // 删除数据
    public boolean deleteData(String id) {
        /**
         * 根据id删除备忘
         */
        String sql = DBUtils.MEMO_ID + "=?";
        String[] contentValuesArray = new String[]{String.valueOf(id)};
        // 删除数据，并根据删除结果返回布尔变量
        return sqLiteDatabase.delete(DBUtils.DATABASE_TABLE_MEMO, sql, contentValuesArray) > 0;
    }

    // 修改数据
    public boolean updateData(String id, String content, String userYear) {
        /**
         * 根据id修改内容和时间
         */
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBUtils.MEMO_CONTENT, content);
        contentValues.put(DBUtils.MEMO_TIME, userYear);
        String sql = DBUtils.MEMO_ID + "=?";
        String[] strings = new String[]{id};
        return sqLiteDatabase.update(DBUtils.DATABASE_TABLE_MEMO, contentValues, sql, strings) > 0;
    }

    // 查询数据
    public List<MemoBean> query() {
        // 创建一个空列表，用于存放数据
        List<MemoBean> list = new ArrayList<MemoBean>();
        // Cursor 是每行的集合
        Cursor cursor = sqLiteDatabase.query(DBUtils.DATABASE_TABLE_MEMO,
                null, null, null, null, null,
                DBUtils.MEMO_ID + " desc");
        if (cursor != null) {
            //如果返回的不为空，则循环迭代
            while (cursor.moveToNext()) {
                MemoBean memoinfo = new MemoBean();
                String id = String.valueOf(cursor.getInt(cursor.getColumnIndex(DBUtils.MEMO_ID)));
                String content = cursor.getString(cursor.getColumnIndex(DBUtils.MEMO_CONTENT));
                String time = cursor.getString(cursor.getColumnIndex(DBUtils.MEMO_TIME));
                memoinfo.setId(id);
                memoinfo.setMemoContent(content);
                memoinfo.setMemoTime(time);
                list.add(memoinfo);
            }
            cursor.close();
        }
        return list;
    }
}
