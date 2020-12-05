package com.alipour.learn.chapter2.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Disc extends Product {
    private double capacity;

    public Disc(String name, double price) {
        super(name, price);
    }
}
