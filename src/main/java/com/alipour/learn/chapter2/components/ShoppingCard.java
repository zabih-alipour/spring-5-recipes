package com.alipour.learn.chapter2.components;

import lombok.Getter;
import com.alipour.learn.chapter2.models.Product;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype") // Change the scope to understand @Scope strategies
@Getter
@ToString
public class ShoppingCard {

    List<Product> products = new ArrayList<>();

    public void addItem(Product product) {
        products.add(product);
    }
}
