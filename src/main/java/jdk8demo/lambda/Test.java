/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package jdk8demo.lambda;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Test
 *
 * @author huangtao
 * @date 2017/10/10
 * desc：
 */
public class Test {

    public static void main(String[] args) {
//        inventory.sort((Apple a1, Apple a2)
//                -> a1.getWeight().compareTo(a2.getWeight())
//        );

        BiFunction<Integer, String, TestBean> testBeanBiFunction = TestBean::new;
        Supplier<List> listSupplier = ArrayList::new;
        List<TestBean> testBeans = listSupplier.get();
        testBeans.add(testBeanBiFunction.apply(10, "name1"));
        testBeans.add(testBeanBiFunction.apply(8, "name2"));
        testBeans.add(testBeanBiFunction.apply(7, "name3"));
        testBeans.add(testBeanBiFunction.apply(9, "name4"));
        testBeans.sort(comparing(TestBean::getWeight).thenComparing(TestBean::getName).reversed());
        System.out.println(listSupplier.get().size());

        //t-> t.getWeight() 为什么不能用 TestBean::getWeight 代替？？？
        List<String> names = testBeans.stream().filter(
                t -> {
                    System.out.println(t.getName());
                    return t.getWeight() > 7;
                }
        ).map(TestBean::getName).limit(2).collect(toList());

        Stream stream = names.stream();
        stream.forEach(System.out::println);
        stream.findFirst();
        stream.findAny();
        System.out.println(names.size());

    }
}

    