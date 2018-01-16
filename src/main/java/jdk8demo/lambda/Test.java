/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package jdk8demo.lambda;

import com.sun.deploy.util.ArrayUtil;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
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
        testBeans.add(testBeanBiFunction.apply(10, "name10"));
        testBeans.add(testBeanBiFunction.apply(8, "name9"));
        testBeans.add(testBeanBiFunction.apply(7, "name7"));
        testBeans.add(testBeanBiFunction.apply(9, "name9"));
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
        System.out.println(names.size());
        List<Integer> lenths = testBeans.stream().map(TestBean::getName).map(String::length).collect(Collectors.toList());
        System.out.println(lenths);


        List<TestBeans> list = new ArrayList<>();
        BiFunction<Integer, String, TestBeans> testBeansSup = TestBeans::new;

        TestBeans testBeans1 = testBeansSup.apply(11, "test1");
        testBeans1.setTestBean(testBeans);
        list.add(testBeans1);

        TestBeans testBeansList2 = testBeansSup.apply(21, "test2");

        List<TestBean> testBeans2 = listSupplier.get();
        testBeans2.add(testBeanBiFunction.apply(1, "name1"));
        testBeans2.add(testBeanBiFunction.apply(4, "name4"));
        testBeans2.add(testBeanBiFunction.apply(2, "name2"));
        testBeans2.add(testBeanBiFunction.apply(3, "name3"));

        testBeansList2.setTestBean(testBeans2);

        list.add(testBeansList2);

        Set<Integer> sets = list.stream().filter(s -> s.getId() > 2).map(s -> s.getId()).sorted().collect(Collectors.toSet());///???
        System.out.println(sets.size());

        List<Integer> integerList = list.stream().filter(l -> l.getId() > 2).map(l -> l.getId()).collect(Collectors.toList());
        int total = integerList.stream().reduce(0, (a, b) -> a + b);
        System.out.println(total);
    }
}

    