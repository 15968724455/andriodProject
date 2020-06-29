package com.example.toolbox;

import android.view.View;
import android.widget.Button;
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
    }

    // 实现这个活动中的按钮的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tool_01:
                break;
            case R.id.btn_tool_02:
                break;
            case R.id.btn_tool_03:
                break;
            case R.id.btn_tool_04:
                break;
        }
    }
}
