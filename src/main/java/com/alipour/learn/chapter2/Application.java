package com.alipour.learn.chapter2;

import com.alipour.learn.chapter2.configs.AppConfig;
import com.alipour.learn.chapter2.configs.ShopConfiguration;
import com.alipour.learn.chapter2.scenarios.BeanPostProcessorScenario;
import com.alipour.learn.chapter2.scenarios.BeanScope;
import com.alipour.learn.chapter2.scenarios.Localization;
import com.alipour.learn.chapter2.scenarios.aop.AOPScenario;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, ShopConfiguration.class);
        new BeanScope(context).execute();
        new Localization(context).execute();
        new BeanPostProcessorScenario(context).execute();
        new AOPScenario(context).execute();
    }
}
