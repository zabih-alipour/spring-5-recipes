package com.alipour.learn.chapter2.models.aop;

public interface ArithmeticCalculator {

    public double add(double a, double b);

    public double sub(double a, double b);

    public double mul(double a, double b);

    public double div(double a, double b);

    default double throwException(double a, double b){
//        throw new NullPointerException("NullPointer, Again!!!!");
        return 0;
    }
}
