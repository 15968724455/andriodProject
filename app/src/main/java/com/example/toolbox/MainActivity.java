package com.example.toolbox;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 定义按钮
    private Button btn_tool_01, btn_tool_02, btn_tool_03, btn_tool_04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化按钮
        btn_tool_01 = (Button) findViewById(R.id.btn_tool_01);
        btn_tool_02 = (Button) findViewById(R.id.btn_tool_02);
        btn_tool_03 = (Button) findViewById(R.id.btn_tool_03);
        btn_tool_04 = (Button) findViewById(R.id.btn_tool_04);

        //设置监听器
        btn_tool_01.setOnClickListener(this);
        btn_tool_02.setOnClickListener(this);
    }

    // 实现这个活动中的按钮的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 按钮1（备忘录的点击事件）
            case R.id.btn_tool_01:
                Intent intent = new Intent(MainActivity.this, MemoActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.btn_tool_02:
                Intent intent2 = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivityForResult(intent2, 1);
                break;
            case R.id.btn_tool_03:
                break;
            case R.id.btn_tool_04:
                break;
        }
    }
}
