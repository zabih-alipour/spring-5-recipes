package com.alipour.learn.chapter2.models.aop;

public class MaxCalculatorImpl implements MaxCalculator {
    @Override
    public double max(double a, double b) {
        return Math.max(a, b);
    }
}
