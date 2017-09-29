/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * CallableDemo
 *
 * @author huangtao
 * @date 2017/9/27
 * desc：
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {

            Future<String> future = executorService.submit(new TaskWithResult(i));
            resultList.add(future);
        }
        for (Future<String> fs : resultList) {

            while (!fs.isDone()) ; //future返回如果每亩完成则继续等待，直到future返回
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                //启动一次顺序关闭，执行以前提交对任务，但不接受新任务
                executorService.shutdown();
            }

        }
    }


    static class TaskWithResult implements Callable<String> {
        private int id;

        public TaskWithResult(int id) {
            this.id = id;
        }

        public String call() throws Exception {
            System.out.println("call()方法被自动调用！！！    " + Thread.currentThread().getName());
            //该返回结果将被Future的get方法得到
            return "call()方法被自动调用，任务返回的结果是：" + id + "    " + Thread.currentThread().getName();
        }
    }
}


    