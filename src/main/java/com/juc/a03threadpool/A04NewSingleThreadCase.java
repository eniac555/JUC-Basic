package com.juc.a03threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author eniac555
 * @date 2023/5/14
 * @description: 单线程化的线程池，只用唯一工作线程来执行任务，保证所有任务按照FIFO执行，适用于按序执行的任务
 */
public class A04NewSingleThreadCase {

    static int count = 0;

    static class Demo implements Runnable {
        @Override
        public void run() {
            count++;
            System.out.println(Thread.currentThread().getName() + ":" + count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //单个线程池，核心线程数和最大线程数都是1
        ExecutorService exec = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            exec.execute(new Demo());
            Thread.sleep(5);
        }
        exec.shutdown();
    }

}
