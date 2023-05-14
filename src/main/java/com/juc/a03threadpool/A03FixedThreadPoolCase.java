package com.juc.a03threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author eniac555
 * @date 2023/5/14
 * @description: 创建使用固定线程数的线程池，适用于任务量已知，相对耗时的任务
 */
public class A03FixedThreadPoolCase {

    static class FixedThreadDemo implements Runnable{
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 2; i++) {
                System.out.println(name + ":" + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建一个固定大小的线程池，核心线程数和最大线程数都是3，没有救急线程
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new FixedThreadDemo());
            Thread.sleep(10);
        }

        executorService.shutdown();
    }

}
