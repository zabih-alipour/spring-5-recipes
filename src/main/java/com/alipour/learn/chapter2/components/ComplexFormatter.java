package com.alipour.learn.chapter2.components;

import com.alipour.learn.chapter2.models.aop.Complex2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ComplexFormatter {
    @Value("(a+bi)")
    private String pattern;

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String format(Complex2 complex){
        return pattern.replaceAll("a", Integer.toString(complex.getReal()))
                .replaceAll("b", Integer.toString(complex.getImaginary()));
    }
}
