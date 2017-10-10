/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package jdk8demo;

/**
 * TriFunction
 *
 * @author huangtao
 * @date 2017/10/9
 * desc：
 */
public interface TriFunction<T, U, V, R> {
    R apply(T t,U u,V v);
}

