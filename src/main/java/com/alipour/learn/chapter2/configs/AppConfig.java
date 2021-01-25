package com.alipour.learn.chapter2.configs;

import com.alipour.learn.chapter2.models.BannerLoader;
import com.alipour.learn.chapter2.models.Battery;
import com.alipour.learn.chapter2.models.Disc;
import com.alipour.learn.chapter2.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.core.io.Resource;

@Configuration
@EnableAspectJAutoProxy
@EnableSpringConfigured
@ComponentScan(basePackages = "com.alipour.learn")
public class AppConfig {
    @Bean
    public Product aaa() {
        Battery p1 = new Battery("AAA", 2.5);
        p1.setRechargeable(true);
        return p1;
    }

    @Bean
    public Product cdrw() {
        Disc p2 = new Disc("CD-RW", 1.5);
        p2.setCapacity(700L);
        return p2;
    }

    @Bean
    public Product dvdrw() {
        Disc p2 = new Disc("DVD-RW", 3.0);
        p2.setCapacity(700L);
        return p2;
    }

    //--- This bean is only for print a custom banner on output
    @Bean
    public BannerLoader banner(@Value("classpath:banner.txt") Resource banner) {
        BannerLoader bannerLoader = new BannerLoader();
        bannerLoader.setBanner(banner);
        return bannerLoader;
    }
}
