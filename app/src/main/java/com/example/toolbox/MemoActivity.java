package com.example.toolbox;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.toolbox.adapter.MemoAdapter;
import com.example.toolbox.bean.MemoBean;
import com.example.toolbox.database.SQLiteHelper;

import java.util.List;

public class MemoActivity extends AppCompatActivity {

    ListView listView;
    List<MemoBean> list;
    SQLiteHelper mSQLiteHelper;
    MemoAdapter memoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        // 用来显示记录的列表
        listView = (ListView) findViewById(R.id.listview_memo);
        ImageView add_memo = (ImageView) findViewById(R.id.add_memo);
        // 为添加图片设置点击方法
        add_memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击之后跳转到添加记录页面
                Intent intent = new Intent(MemoActivity.this, MemoRecordActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        initData();
    }

    protected void initData() {
        //初始化对象并创建数据库
        mSQLiteHelper = new SQLiteHelper(this);
        showQueryData();
    }

    // 从数据库中查找数据
    private void showQueryData() {
        // 若非空，则清空
        if (list != null) {
            list.clear();
        }
        list = mSQLiteHelper.query();
        memoAdapter = new MemoAdapter(this, list);
        listView.setAdapter(memoAdapter);
    }

    // 重写此方法，当关闭添加记录页面时，程序会回调此方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            // 重新加载数据库中的记录至记录列表
            showQueryData();
        }
    }
}
