/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloControllerTest
 *
 * @author huangtao
 * @date 2017/10/9
 * desc：
 */
@RestController
@RequestMapping("hello")
@SpringBootApplication
public class HelloControllerTest {
    @RequestMapping("momo")
    public String hello() {
        return "hello momo!";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloControllerTest.class);
    }
}

    