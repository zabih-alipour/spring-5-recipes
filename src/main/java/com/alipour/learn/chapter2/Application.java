package com.alipour.learn.chapter2;

import com.alipour.learn.chapter2.components.ShoppingCard;
import com.alipour.learn.chapter2.configs.AppConfig;
import com.alipour.learn.chapter2.models.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        checkBeanScope(context);
    }

    static void checkBeanScope(AnnotationConfigApplicationContext context) {
        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);
        Product dvdrw = context.getBean("dvdrw", Product.class);

        System.out.println("######################## Check Bean Scope Begin ########################");
        ShoppingCard card_1 = context.getBean(ShoppingCard.class);
        card_1.addItem(aaa);
        card_1.addItem(cdrw);
        System.out.println("\tItems in card 1: " + card_1.toString());

        ShoppingCard card_2 = context.getBean(ShoppingCard.class);
        card_2.addItem(dvdrw);
        System.out.println("\tItems in card 2: " + card_2.toString());
        System.out.println("######################## Check Bean Scope End   ########################");
    }
}
