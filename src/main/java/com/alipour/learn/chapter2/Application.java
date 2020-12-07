package com.alipour.learn.chapter2;

import com.alipour.learn.chapter2.configs.AppConfig;
import com.alipour.learn.chapter2.configs.ShopConfiguration;
import com.alipour.learn.chapter2.senarios.BeanPostProcessorSenario;
import com.alipour.learn.chapter2.senarios.BeanScope;
import com.alipour.learn.chapter2.senarios.Localization;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, ShopConfiguration.class);
        new BeanScope(context).execute();
        new Localization(context).execute();
        new BeanPostProcessorSenario(context).execute();
    }
}
