package com.alipour.learn.chapter2.models.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UnitCalculatorImpl implements UnitCalculator {
    @Override
    public double kilogramToPound(double kilogram) {
        return kilogram * 2.2;
    }

    @Override
    public double kilometerToMile(double kilometer) {
        return kilometer * 0.62;
    }
}
