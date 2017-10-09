/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package jdk8demo;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Demo
 *
 * @author huangtao
 * @date 2017/10/9
 * desc：
 */
public class Demo {
    public void test() {
        Function<String, Integer> stringToInteger = Integer::parseInt;
        System.out.println(stringToInteger.apply("688"));
        BiPredicate<List<String>, String> contains = List::contains;

        List<String> as = new ArrayList<>();
        as.add("sd");
        System.out.println(contains.test(as, "sd1"));
    }

    public static void main(String[] args) {
        Supplier<Demo> demoSupplier = Demo::new;
        demoSupplier.get().test();
    }
}

    