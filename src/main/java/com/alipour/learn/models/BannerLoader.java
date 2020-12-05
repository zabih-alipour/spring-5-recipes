package com.alipour.learn.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Getter
@Setter
public class BannerLoader {
    private Resource banner;

    @PostConstruct
    public void showBanner() throws IOException {
        InputStream in = banner.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            System.out.println(line);
        }
        reader.close();
    }
}
