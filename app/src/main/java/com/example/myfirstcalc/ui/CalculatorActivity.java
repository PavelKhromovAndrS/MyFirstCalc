package com.example.myfirstcalc.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstcalc.R;
import com.example.myfirstcalc.domain.CalculatorImp;
import com.example.myfirstcalc.domain.Operations;

import java.util.HashMap;
import java.util.Map;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {
    private TextView calcResult;
    CalculatorPresenter calculatorPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculatorPresenter = new CalculatorPresenter(new CalculatorImp(), this);
        setContentView(R.layout.activity_calculator);
        calcResult = findViewById(R.id.calc_result);
        // Выносим метод ClickListener для
        View.OnClickListener DigitsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.keyPressed(((Button) view).getText().toString());
            }
        };

        findViewById(R.id.calc_button_1).setOnClickListener(DigitsClickListener);
        findViewById(R.id.calc_button_2).setOnClickListener(DigitsClickListener);
        findViewById(R.id.calc_button_3).setOnClickListener(DigitsClickListener);
        findViewById(R.id.calc_button_4).setOnClickListener(DigitsClickListener);
        findViewById(R.id.calc_button_5).setOnClickListener(DigitsClickListener);
        findViewById(R.id.calc_button_6).setOnClickListener(DigitsClickListener);
        findViewById(R.id.calc_button_7).setOnClickListener(DigitsClickListener);
        findViewById(R.id.calc_button_8).setOnClickListener(DigitsClickListener);
        findViewById(R.id.calc_button_9).setOnClickListener(DigitsClickListener);
        findViewById(R.id.calc_button_0).setOnClickListener(DigitsClickListener);
        findViewById(R.id.calc_button_dot).setOnClickListener(DigitsClickListener);

        View.OnClickListener OperationsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.calc_button_add) {
                    calculatorPresenter.operationPressed(Operations.ADD);
                }
                if (view.getId() == R.id.calc_button_sub) {
                    calculatorPresenter.operationPressed(Operations.SUB);
                }
                if (view.getId() == R.id.calc_button_div) {
                    calculatorPresenter.operationPressed(Operations.DIV);
                }
                if (view.getId() == R.id.calc_button_mul) {
                    calculatorPresenter.operationPressed(Operations.MUL);
                }
                if (view.getId() == R.id.calc_button_equal) {
                    calculatorPresenter.equalPressed();
                }
                if (view.getId() == R.id.remove_all) {
                    calculatorPresenter.deletePressed();
                }
            }
        };
        findViewById(R.id.calc_button_add).setOnClickListener(OperationsClickListener);
        findViewById(R.id.calc_button_sub).setOnClickListener(OperationsClickListener);
        findViewById(R.id.calc_button_div).setOnClickListener(OperationsClickListener);
        findViewById(R.id.calc_button_mul).setOnClickListener(OperationsClickListener);
        findViewById(R.id.calc_button_equal).setOnClickListener(OperationsClickListener);
        findViewById(R.id.remove_all).setOnClickListener(OperationsClickListener);

        findViewById(R.id.calc_button_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.dotPressed();
            }
        });




    }


    @Override
    public void showResult(String result) {
        calcResult.setText(result);
    }
}
