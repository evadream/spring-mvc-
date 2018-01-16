/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package jdk8demo;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
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
public class ConstructionDemo {
    private String name;
    private String id;
    private int code;


    public ConstructionDemo() {
    }

    public ConstructionDemo(String name) {
        this.name = name;
    }

    public ConstructionDemo(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public ConstructionDemo(String name, String id, int code) {
        this.name = name;
        this.id = id;
        this.code = code;
    }


    public void test() {
        Function<String, Integer> stringToInteger = Integer::parseInt;
        System.out.println(stringToInteger.apply("688"));
        BiPredicate<List<String>, String> contains = List::contains;

        List<String> as = new ArrayList<>();
        as.add("sd");
        System.out.println(contains.test(as, "sd1"));

        System.out.println("name is :" + this.name + " id is:" + this.id + " code is:" + this.code);
    }

    public static void main(String[] args) {
        Supplier<ConstructionDemo> demoSupplier = ConstructionDemo::new;
        demoSupplier.get().test();

        Function<String, ConstructionDemo> stringDemoFunction = ConstructionDemo::new;
        ConstructionDemo demo = stringDemoFunction.apply("momo");
        demo.test();

        BiFunction<String, String, ConstructionDemo> demoBiFunction = ConstructionDemo::new;
        demoBiFunction.apply("woyo", "2").test();

        TriFunction<String, String, Integer, ConstructionDemo> demoTri = ConstructionDemo::new;
        demoTri.apply("huanbgtao","3",2).test();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

    