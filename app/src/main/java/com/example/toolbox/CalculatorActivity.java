package com.example.toolbox;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button
            btn_calculator_1, btn_calculator_2, btn_calculator_3,
            btn_calculator_4, btn_calculator_5, btn_calculator_6,
            btn_calculator_7, btn_calculator_8, btn_calculator_9,
            btn_calculator_0, btn_calculator_point, btn_calculator_plus,
            btn_calculator_subtract, btn_calculator_multiply, btn_calculator_divide,
            btn_calculator_equal, btn_calculator_clear, btn_calculator_del;
    private TextView tv_calculator_result;
    private EditText ed_calculator_input;
    //是否以及计算过
    private boolean al;
    //出结果之后按的数字键次数
    private int countnum;

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
        //设置输入框不能由键盘输入
        ed_calculator_input.setKeyListener(null);
        // 设置是否已经计算过了（即当前页面是否显示的是结果）初始默认未计算
        al = false;
        countnum = 0;
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

    @Override
    public void onClick(View v) {
        String str = ed_calculator_input.getText().toString();
        switch (v.getId()) {
            case R.id.btn_calculator_1:
            case R.id.btn_calculator_2:
            case R.id.btn_calculator_3:
            case R.id.btn_calculator_4:
            case R.id.btn_calculator_5:
            case R.id.btn_calculator_6:
            case R.id.btn_calculator_7:
            case R.id.btn_calculator_8:
            case R.id.btn_calculator_9:
            case R.id.btn_calculator_0:
            case R.id.btn_calculator_point:
                // 如果已经计算过了，且是直接第一次按数字键，就舍弃掉已有的内容。因为不能把结果放在要计算的内容上
                if (al && countnum == 0) {
                    str = "";
                }
                // 按键次数+1；
                countnum += 1;
                //将文本内容忠实的输入编辑框
                ed_calculator_input.setText(str + ((Button) v).getText());
                break;
            case R.id.btn_calculator_plus: //+
            case R.id.btn_calculator_subtract: //-
            case R.id.btn_calculator_multiply: //*
            case R.id.btn_calculator_divide: //÷
                ed_calculator_input.setText(str + " " + ((Button) v).getText() + " ");
                // 按符等号键相当于重新开始计算
                al = false;
                break;
            case R.id.btn_calculator_clear: //清空
                // 按完清空键相当于重新开始计算
                al = false;
                ed_calculator_input.setText("");
                break;
            case R.id.btn_calculator_del: //退格键
                // 如果不为空
                if (str != null && !str.equals("")) {
                    // 则删除最后一个字符
                    ed_calculator_input.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.btn_calculator_equal:
                getResult();
                break;
        }
    }

    public void getResult() {
        // 设置为已经计算
        al = true;
        // 按键次数清零
        countnum = 0;
        // 结果变量
        double r = 0;
        String exp = ed_calculator_input.getText().toString();
        if (exp == null) {
            return;
        }
        try {
            // 找空格的位置索引
            int space = exp.indexOf(" ");
            // 返回空格之前的字符串
            String s1 = exp.substring(0, space);
            // 返回空格之后+1位的字符串
            String op = exp.substring(space + 1, space + 2);
            // 返回空格之后+2位到最后的字符串
            String s2 = exp.substring(space + 3);
            // 转为双精度小数
            double arg1 = Double.parseDouble(s1);
            double arg2 = Double.parseDouble(s2);
            System.out.println("exp" + exp + "，spaceindex" + space + ",s1：" + s1 + "，op：" + op + "，s2：" + s2);

            if (op.equals("＋")) {
                r = arg1 + arg2;
            }
            if (op.equals("－")) {
                r = arg1 - arg2;
            }
            if (op.equals("×")) {
                r = arg1 * arg2;
            }
            if (op.equals("÷")) {
                if (arg2 == 0) {
                    r = 0;
                } else {
                    r = arg1 / arg2;
                }
            }
            ed_calculator_input.setText(r + "");
        } catch (StringIndexOutOfBoundsException e1) {
            Log.i("Calculator", "无运算，纯数字");
        } catch (NumberFormatException e2) {
            Log.i("Calculator", "计算出现问题");
            ed_calculator_input.setText("出错了");
        } catch (Exception e3){
            Log.i("Calculator", "出现位置问题");
            ed_calculator_input.setText("未知错误");
        }
    }
}
