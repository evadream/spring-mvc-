/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package jdk8demo.lambda;

import java.util.List;

/**
 * TestBeans
 *
 * @author huangtao
 * @date 2017/10/17
 * desc：
 */
public class TestBeans {
    private List<TestBean> testBean;
    private int id;
    private String code;


    public TestBeans(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public List<TestBean> getTestBean() {
        return testBean;
    }

    public void setTestBean(List<TestBean> testBean) {
        this.testBean = testBean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

    