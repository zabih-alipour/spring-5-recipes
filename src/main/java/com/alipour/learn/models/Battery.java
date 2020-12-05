package com.alipour.learn.models;

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
