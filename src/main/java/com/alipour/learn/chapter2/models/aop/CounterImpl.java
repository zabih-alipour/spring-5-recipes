package com.alipour.learn.chapter2.models.aop;

public class CounterImpl implements Counter {
    private int count;

    @Override
    public void increase() {
        count++;
    }

    @Override
    public int count() {
        return count;
    }
}
