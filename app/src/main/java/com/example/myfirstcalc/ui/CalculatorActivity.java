package com.example.myfirstcalc.ui;

import android.content.Context;
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
    private CalculatorPresenter calculatorPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculatorPresenter = new CalculatorPresenter(new CalculatorImp(), this);
        setContentView(R.layout.activity_calculator);
        calcResult = findViewById(R.id.calc_result);

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.calc_button_0, 0);
        digits.put(R.id.calc_button_1, 1);
        digits.put(R.id.calc_button_2, 2);
        digits.put(R.id.calc_button_3, 3);
        digits.put(R.id.calc_button_4, 4);
        digits.put(R.id.calc_button_5, 5);
        digits.put(R.id.calc_button_6, 6);
        digits.put(R.id.calc_button_7, 7);
        digits.put(R.id.calc_button_8, 8);
        digits.put(R.id.calc_button_9, 9);

        View.OnClickListener digitsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.keyPressed(String.valueOf(digits.get(view.getId())));
            }
        };

        findViewById(R.id.calc_button_1).setOnClickListener(digitsClickListener);
        findViewById(R.id.calc_button_2).setOnClickListener(digitsClickListener);
        findViewById(R.id.calc_button_3).setOnClickListener(digitsClickListener);
        findViewById(R.id.calc_button_4).setOnClickListener(digitsClickListener);
        findViewById(R.id.calc_button_5).setOnClickListener(digitsClickListener);
        findViewById(R.id.calc_button_6).setOnClickListener(digitsClickListener);
        findViewById(R.id.calc_button_7).setOnClickListener(digitsClickListener);
        findViewById(R.id.calc_button_8).setOnClickListener(digitsClickListener);
        findViewById(R.id.calc_button_9).setOnClickListener(digitsClickListener);
        findViewById(R.id.calc_button_0).setOnClickListener(digitsClickListener);
        findViewById(R.id.calc_button_dot).setOnClickListener(digitsClickListener);

        View.OnClickListener operationsClickListener = new View.OnClickListener() {
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

        findViewById(R.id.calc_button_add).setOnClickListener(operationsClickListener);
        findViewById(R.id.calc_button_sub).setOnClickListener(operationsClickListener);
        findViewById(R.id.calc_button_div).setOnClickListener(operationsClickListener);
        findViewById(R.id.calc_button_mul).setOnClickListener(operationsClickListener);
        findViewById(R.id.calc_button_equal).setOnClickListener(operationsClickListener);
        findViewById(R.id.remove_all).setOnClickListener(operationsClickListener);

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
