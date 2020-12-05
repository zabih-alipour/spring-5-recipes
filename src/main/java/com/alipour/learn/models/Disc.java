package com.alipour.learn.models;

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
