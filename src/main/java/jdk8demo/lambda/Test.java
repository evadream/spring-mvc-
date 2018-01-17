/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package jdk8demo.lambda;

import com.sun.deploy.util.ArrayUtil;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.reducing;
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

        Set<Integer> sets = list.stream().filter(s -> s.getId() > 2).map(s -> s.getId()).sorted().collect(Collectors.toSet());
        System.out.println(sets.size());

        List<Integer> integerList = list.stream().filter(l -> l.getId() > 2).map(l -> l.getId()).collect(Collectors.toList());
        int total = integerList.stream().reduce(0, (a, b) -> a + b);
        System.out.println(total);
        Optional<Integer> max = testBeans2.stream().map(TestBean::getWeight).reduce(Integer::max);
        System.out.println(max.get());

        Optional<Integer> min = testBeans2.stream().map(TestBean::getWeight).reduce(Integer::min);
        System.out.println(min.get());
        Optional<TestBean> minBean = testBeans2.stream().min(comparing(TestBean::getWeight));
        System.out.println(minBean.get().getName());

        //勾股数 赞
        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0));
        pythagoreanTriples2.forEach(j -> System.out.println(j[0] + "  " + j[1] + "  " + j[2]));

        //斐波纳契元组序列
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));


        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);


        //todo 为啥是错误的？？？
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);


        //todo 为啥是错误的？？？
        Stream<Integer> streamArry = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers = streamArry.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l;
                },
                (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    return l1;
                });
        System.out.println(numbers);


    }
}

