/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package thread;

/**
 * PendingInterrupter
 *
 * @author huangtao
 * @date 2017/9/28
 * desc：
 */
public class PendingInterrupter {
    public static void main(String[] args) {
        if (args.length == 0) {
            Thread.currentThread().interrupt();
        }

        long time = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
            System.out.println("was nnot interrupted");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("was interrupted");
        }

        System.out.println("elapsedTime=" + (System.currentTimeMillis() - time));
    }
}

    