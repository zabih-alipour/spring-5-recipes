package com.alipour.learn.configs;

import com.alipour.learn.models.BannerLoader;
import com.alipour.learn.models.Battery;
import com.alipour.learn.models.Disc;
import com.alipour.learn.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan(basePackages = "com.alipour.learn")
public class AppConfig {

    @Value("classpath:banner.txt")
    private Resource banner;

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

    @Bean
    public BannerLoader banner() {
        BannerLoader bannerLoader = new BannerLoader();
        bannerLoader.setBanner(banner);
        return bannerLoader;
    }
}
