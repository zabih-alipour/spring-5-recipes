package com.alipour.learn.chapter2.models.aop;

import org.springframework.stereotype.Component;

@Component
public class ComplexCalculatorImpl implements ComplexCalculator {
    @Override
    public Complex add(Complex a, Complex b) {
        return new Complex(a.getReal() + b.getReal(), a.getImaginary() + b.getImaginary());
    }

    @Override
    public Complex sub(Complex a, Complex b) {
        return new Complex(a.getReal() - b.getReal(), a.getImaginary() - b.getImaginary());
    }
}
