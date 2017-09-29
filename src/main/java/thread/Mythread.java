/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package thread;

/**
 * Mythread
 *
 * @author huangtao
 * @date 2017/9/27
 * desc：
 */
public class Mythread extends Thread {
    private int ticket = 5;

    public void run() {
        for (int i = 0; i < 10; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "ticket = " + ticket--);
            }
        }
    }


    public static void main(String[] args) {
        new Mythread().start();
        new Mythread().start();
        new Mythread().start();
    }
}

    