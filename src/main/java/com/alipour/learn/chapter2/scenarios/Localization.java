package com.alipour.learn.chapter2.scenarios;

import org.springframework.context.ApplicationContext;

import java.util.Locale;

public class Localization extends LearningSubjectExecutor {
    public Localization(ApplicationContext context) {
        super(context, SUBJECT.LOCALIZATION);
    }

    @Override
    protected void run() {
        System.out.println("Message picked from us file: " + context.getMessage("alert.checkout", null, Locale.US));
        System.out.println("Message picked from fa file: " + context.getMessage("alert.checkout", null, new Locale("fa", "IR")));

        //--- Pick the default message
        System.out.println("Message picked from messages.properties file: " + context.getMessage("alert.inventory.checkout", null, Locale.US));
        System.out.println("Message picked from messages.properties file: " +context.getMessage("alert.inventory.checkout", null, new Locale("fa", "IR")));

    }
}
