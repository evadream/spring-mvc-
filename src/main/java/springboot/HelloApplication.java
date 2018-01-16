/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * HelloApplication
 *
 * @author huangtao
 * @date 2017/10/9
 * desc：
 */
@Configuration
@PropertySource(value = {"classpath:jdbc.properties", ""}, ignoreResourceNotFound = true)
@ComponentScan(basePackages = "springboot")
@SpringBootApplication
public class HelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class);
    }
}

    