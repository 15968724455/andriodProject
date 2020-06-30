package com.example.toolbox;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CalculatorActivity extends AppCompatActivity {

    private Button
            btn_calculator_1, btn_calculator_2, btn_calculator_3,
            btn_calculator_4, btn_calculator_5, btn_calculator_6,
            btn_calculator_7, btn_calculator_8, btn_calculator_9,
            btn_calculator_0, btn_calculator_point, btn_calculator_plus,
            btn_calculator_subtract, btn_calculator_multiply, btn_calculator_divide,
            btn_calculator_equal, btn_calculator_clear, btn_calculator_del;
    private TextView tv_calculator_result;
    private EditText ed_calculator_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // 赋值
        btn_calculator_1 = (Button) findViewById(R.id.btn_calculator_1);
        btn_calculator_2 = (Button) findViewById(R.id.btn_calculator_2);
        btn_calculator_3 = (Button) findViewById(R.id.btn_calculator_3);
        btn_calculator_4 = (Button) findViewById(R.id.btn_calculator_4);
        btn_calculator_5 = (Button) findViewById(R.id.btn_calculator_5);
        btn_calculator_6 = (Button) findViewById(R.id.btn_calculator_6);
        btn_calculator_7 = (Button) findViewById(R.id.btn_calculator_7);
        btn_calculator_8 = (Button) findViewById(R.id.btn_calculator_8);
        btn_calculator_9 = (Button) findViewById(R.id.btn_calculator_9);
        btn_calculator_0 = (Button) findViewById(R.id.btn_calculator_0);
        btn_calculator_point = (Button) findViewById(R.id.btn_calculator_point);
        btn_calculator_plus = (Button) findViewById(R.id.btn_calculator_plus);
        btn_calculator_subtract = (Button) findViewById(R.id.btn_calculator_subtract);
        btn_calculator_multiply = (Button) findViewById(R.id.btn_calculator_multiply);
        btn_calculator_divide = (Button) findViewById(R.id.btn_calculator_divide);
        btn_calculator_equal = (Button) findViewById(R.id.btn_calculator_equal);
        btn_calculator_clear = (Button) findViewById(R.id.btn_calculator_clear);
        btn_calculator_del = (Button) findViewById(R.id.btn_calculator_del);
        tv_calculator_result = (TextView) findViewById(R.id.tv_calculator_result);
        ed_calculator_input = (EditText) findViewById(R.id.ed_calculator_input);
        // 监听
        btn_calculator_1.setOnClickListener(this);
        btn_calculator_2.setOnClickListener(this);
        btn_calculator_3.setOnClickListener(this);
        btn_calculator_4.setOnClickListener(this);
        btn_calculator_5.setOnClickListener(this);
        btn_calculator_6.setOnClickListener(this);
        btn_calculator_7.setOnClickListener(this);
        btn_calculator_8.setOnClickListener(this);
        btn_calculator_9.setOnClickListener(this);
        btn_calculator_0.setOnClickListener(this);
        btn_calculator_point.setOnClickListener(this);
        btn_calculator_plus.setOnClickListener(this);
        btn_calculator_subtract.setOnClickListener(this);
        btn_calculator_multiply.setOnClickListener(this);
        btn_calculator_divide.setOnClickListener(this);
        btn_calculator_equal.setOnClickListener(this);
        btn_calculator_clear.setOnClickListener(this);
        btn_calculator_del.setOnClickListener(this);
        tv_calculator_result.setOnClickListener(this);
        ed_calculator_input.setOnClickListener(this);

    }
}
