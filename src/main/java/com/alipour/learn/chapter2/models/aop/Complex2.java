package com.alipour.learn.chapter2.models.aop;

import com.alipour.learn.chapter2.components.ComplexFormatter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Configurable
@Component
@Scope("prototype")
public class Complex2 {
    private int real;
    private int imaginary;
    private ComplexFormatter complexFormatter;

    public Complex2() {

    }

    public Complex2(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;

    }

    @Autowired
    public void setComplexFormatter(ComplexFormatter complexFormatter) {
        this.complexFormatter = complexFormatter;
    }

    @Override
    public String toString() {
        return complexFormatter.format(this);
    }
}
