package com.alipour.learn.components;

import lombok.Getter;
import com.alipour.learn.models.Product;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
@Getter
@ToString
public class ShoppingCard {

    List<Product> products = new ArrayList<>();

    public void addItem(Product product) {
        products.add(product);
    }
}
