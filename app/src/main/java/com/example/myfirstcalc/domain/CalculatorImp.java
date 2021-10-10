package com.example.myfirstcalc.domain;

public class CalculatorImp implements Calculator {


    @Override
    public Double doCalcOperations(Double value1, Double value2, Operations operations) {
        if (operations == Operations.ADD) {
            return value1 + value2;
        }
        if (operations == Operations.SUB) {
            return value1 - value2;
        }
        if (operations == Operations.DIV) {
            return value1 / value2;
        }
        if (operations == Operations.MUL) {
            return value1 * value2;
        }
        return 0.0;
    }
}
