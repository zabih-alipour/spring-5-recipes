package com.alipour.learn.chapter2;

import com.alipour.learn.chapter2.configs.AppConfig;
import com.alipour.learn.chapter2.configs.ShopConfiguration;
import com.alipour.learn.chapter2.scenarios.BeanPostProcessorScenario;
import com.alipour.learn.chapter2.scenarios.BeanScope;
import com.alipour.learn.chapter2.scenarios.Localization;
import com.alipour.learn.chapter2.scenarios.aop.AOPScenario;
import com.alipour.learn.chapter2.scenarios.aop.AspectJScenario;
import com.alipour.learn.chapter2.scenarios.concurrency.ConcurrencyScenario;

import com.alipour.learn.chapter2.scenarios.aop.DomainInjectionScenario;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, ShopConfiguration.class);
        new ConcurrencyScenario(context).execute();
        new BeanScope(context).execute();
        new Localization(context).execute();
        new BeanPostProcessorScenario(context).execute();
        new AOPScenario(context).execute();
        new DomainInjectionScenario(context).execute();
        new AspectJScenario(context).execute();
    }
}
