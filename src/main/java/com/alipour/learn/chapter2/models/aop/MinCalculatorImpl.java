package com.alipour.learn.chapter2.models.aop;

public class MinCalculatorImpl implements MinCalculator {
    @Override
    public double min(double a, double b) {
        return Math.min(a, b);
    }
}
