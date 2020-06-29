package com.example.toolbox;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.toolbox.database.SQLiteHelper;
import com.example.toolbox.utils.DBUtils;

public class MemoRecordActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView save_memo, delete_memo;
    EditText content;
    TextView memo_time;
    SQLiteHelper mSqLiteHelper;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_record);
        save_memo = (ImageView) findViewById(R.id.save_memo);
        delete_memo = (ImageView) findViewById(R.id.delete_memo);
        content = (EditText) findViewById(R.id.memo_content);
        memo_time = (TextView) findViewById(R.id.tv_time);
        // 设置监听
        save_memo.setOnClickListener(this);
        delete_memo.setOnClickListener(this);
        initData();
    }

    protected void initData() {
        mSqLiteHelper = new SQLiteHelper(this);
        setTitle("添加记录");
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getStringExtra("id");
            if (id != null) {
                setTitle("修改记录");
                // 设置显示的正文和时间
                content.setText(intent.getStringExtra("content"));
                memo_time.setText(intent.getStringExtra("time"));
                // 修改是否可见
                memo_time.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delete_memo:
                // 点击情况按钮
                content.setText("");
                showToast("内容已清空");
                break;
            case R.id.save_memo:
                // 点击保存按钮
                // 获取输入的内容
                String memoContent = content.getText().toString().trim();
                // 像数据库中添加数据
                if (memoContent.length() > 0) {
                    if (mSqLiteHelper.insertData(memoContent, DBUtils.getTime())) {
                        showToast("保存成功");
                        // 设置回调参数值
                        setResult(2);
                        finish();
                    } else {
                        showToast("保存失败");
                    }
                } else {
                    showToast("修改内容不能为空");
                }
                break;
        }
    }

    public void showToast(String content) {
        Toast.makeText(this, content, 200).show();
    }
}
