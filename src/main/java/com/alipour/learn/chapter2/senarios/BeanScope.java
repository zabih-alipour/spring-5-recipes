package com.alipour.learn.chapter2.senarios;

import com.alipour.learn.chapter2.components.ShoppingCard;
import com.alipour.learn.chapter2.models.Product;
import org.springframework.context.ApplicationContext;

public class BeanScope extends LearningSubjectExecutor {
    public BeanScope(ApplicationContext context) {
        super(context, SUBJECT.BEAN_SCOPE);
    }

    @Override
    protected void run() {
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
