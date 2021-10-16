package com.example.myfirstcalc.ui;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstcalc.domain.Calculator;
import com.example.myfirstcalc.domain.Operations;

public class CalculatorPresenter extends AppCompatActivity {
    public static final int BASE = 10;

    private final Calculator calculator;
    private final CalculatorView calculatorView;

    private Operations operation;

    private Double digit1 = 0.0;
    private Double digit2 = 0.0;

    private Boolean isDotPressed = false;

    private int divider;

    public CalculatorPresenter(Calculator calculator, CalculatorView calculatorView) {
        this.calculator = calculator;
        this.calculatorView = calculatorView;
    }

    public void dotPressed() {
        if (!isDotPressed) {
            isDotPressed = true;
            divider = BASE;
        }
    }

    public void keyPressed(String digit) {
        if (operation == null) {
            if (!isDotPressed) {
                digit1 = digit1 * BASE + Double.parseDouble(digit);
            } else {
                digit1 = digit1 + Double.parseDouble(digit) / (double) divider;
                divider *= BASE;
            }
            showResult(digit1);
        }
        if (operation != null) {
            if (!isDotPressed) {
                digit2 = digit2 * BASE + Double.parseDouble(digit);
            } else {
                digit2 = (digit2 + (Double.parseDouble(digit))) / divider;
                divider *= BASE;
            }
            showResult(digit2);
        }
    }

    public void operationPressed(Operations operations) {
        isDotPressed = false;
        if (operations == Operations.ADD) {
            calculatorView.showResult(showResult(digit1) + "+");
            operation = Operations.ADD;

        }
        if (operations == Operations.SUB) {
            calculatorView.showResult(showResult(digit1) + "-");
            operation = Operations.SUB;

        }
        if (operations == Operations.DIV) {
            calculatorView.showResult(showResult(digit1) + "/");
            operation = Operations.DIV;

        }
        if (operations == Operations.MUL) {
            calculatorView.showResult(showResult(digit1) + "*");
            operation = Operations.MUL;
        }
    }

    public void equalPressed() {
        Double result = calculator.doCalcOperations(digit1, digit2, operation);
        showResult(result);
        digit1 = result;
        digit2 = 0.0;
        operation = null;
    }

    public void deletePressed() {
        digit1 = 0.0;
        digit2 = 0.0;
        operation = null;
        calculatorView.showResult("");
        isDotPressed = false;
    }

    public String showResult(double doubleValue) {
        long longValue = (long) doubleValue;
        if (longValue == doubleValue) {
            calculatorView.showResult(String.valueOf(longValue));
            return String.valueOf(longValue);
        } else {
            calculatorView.showResult(String.valueOf(doubleValue));
            return String.valueOf(doubleValue);
        }
    }
}
