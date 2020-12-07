package com.alipour.learn.chapter2.components;

import com.alipour.learn.chapter2.configs.AppConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class AuditCheckBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //-- Selective bean processor
        if (bean instanceof AppConfig) {
            System.out.println("postProcessBeforeInitialization: " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //-- Selective bean processor
        if (bean instanceof AppConfig) {
            System.out.println("postProcessAfterInitialization: " + beanName);
        }
        return bean;
    }
}
