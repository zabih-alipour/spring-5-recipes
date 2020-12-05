package com.alipour.learn.chapter2;

import com.alipour.learn.chapter2.components.ShoppingCard;
import com.alipour.learn.chapter2.configs.AppConfig;
import com.alipour.learn.chapter2.configs.ShopConfiguration;
import com.alipour.learn.chapter2.models.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, ShopConfiguration.class);
        checkBeanScope(context);
        checkLocalization(context);
    }

    private static void checkLocalization(AnnotationConfigApplicationContext context) {
        System.out.println("\n\n######################## Check Localization ########################");

        System.out.println("Message picked from us file: " + context.getMessage("alert.checkout", null, Locale.US));
        System.out.println("Message picked from fa file: " + context.getMessage("alert.checkout", null, new Locale("fa", "IR")));

        //--- Pick the default message
        System.out.println("Message picked from messages.properties file: " + context.getMessage("alert.inventory.checkout", null, Locale.US));
        System.out.println("Message picked from messages.properties file: " +context.getMessage("alert.inventory.checkout", null, new Locale("fa", "IR")));
    }

    private static void checkBeanScope(AnnotationConfigApplicationContext context) {
        System.out.println("\n\n######################## Check Bean Scope ########################");
        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);
        Product dvdrw = context.getBean("dvdrw", Product.class);

        ShoppingCard card_1 = context.getBean(ShoppingCard.class);
        card_1.addItem(aaa);
        card_1.addItem(cdrw);
        System.out.println("\tItems in card 1: " + card_1.toString());

        ShoppingCard card_2 = context.getBean(ShoppingCard.class);
        card_2.addItem(dvdrw);
        System.out.println("\tItems in card 2: " + card_2.toString());

    }
}
