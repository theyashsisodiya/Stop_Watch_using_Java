package com.calculator.Android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    ImageView btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_seven, btn_eight, btn_nine, btn_zero;
    ImageView btn_dot, btn_equal, btn_plus, btn_minus, btn_multiply, btn_divide, btn_ac, btn_del;

    TextView inputTxt, inputOutput;

    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputOutput = findViewById(R.id.inputOutput);
        inputTxt = findViewById(R.id.inputTxt);

        btn_zero = findViewById(R.id.btn_zero);
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);
        btn_four = findViewById(R.id.btn_four);
        btn_five = findViewById(R.id.btn_five);
        btn_six = findViewById(R.id.btn_six);
        btn_seven = findViewById(R.id.btn_seven);
        btn_eight = findViewById(R.id.btn_eight);
        btn_nine = findViewById(R.id.btn_nine);

        btn_dot = findViewById(R.id.btn_dot);
        btn_ac = findViewById(R.id.btn_ac);
        btn_divide = findViewById(R.id.btn_divide);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_equal = findViewById(R.id.btn_equal);


        btn_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"0");
            }
        });
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"1");
            }
        });
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"2");
            }
        });
        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"3");
            }
        });
        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"4");
            }
        });
        btn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"5");
            }
        });
        btn_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"6");
            }
        });
        btn_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"7");
            }
        });
        btn_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"8");
            }
        });
        btn_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"9");
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+".");
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"×");
            }
        });
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"/");
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"+");
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"-");
            }
        });
       btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText("");
                inputOutput.setText("");
            }
        });
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                data=data.replaceAll("×","*");
                data=data.replaceAll("÷","/");

                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);

                String FinalResult="";

                Scriptable scriptable=rhino.initSafeStandardObjects();
                FinalResult=rhino.evaluateString(scriptable,data,"Javascript",1,null).toString();

                inputOutput.setText(FinalResult);
            }
        });
    }
}