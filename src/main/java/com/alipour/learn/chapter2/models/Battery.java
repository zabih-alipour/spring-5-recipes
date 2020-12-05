package com.alipour.learn.chapter2.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Battery extends Product {
    private Boolean rechargeable;

    public Battery(String name, Double price) {
        super(name, price);
    }
}
