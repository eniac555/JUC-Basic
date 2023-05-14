package com.juc.a01basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: 通过线程池创建线程
 */
public class A04MyExecutors implements Runnable{

    @Override
    public void run() {
        System.out.println("MyRunnable...run...");
    }

    public static void main(String[] args) {

        // 创建线程池对象
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.submit(new A04MyExecutors()) ;

        // 关闭线程池
        threadPool.shutdown();

    }

}