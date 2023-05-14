package com.juc.a04application;

import java.util.concurrent.Semaphore;

/**
 * @author eniac555
 * @date 2023/5/14
 * @description: Semaphore:信号量，是JUC包下的一个工具类，我们可以通过其限制执行的线程数量，达到限流的效果
 */
public class A02SemaphoreCase {
    public static void main(String[] args) {
        // 1. 创建 semaphore 对象
        Semaphore semaphore = new Semaphore(3);
        // 2. 10个线程同时运行
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    // 3. 获取许可，计数-1
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println("running...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end...");
                } finally {
                    // 4. 释放许可  计数+1
                    semaphore.release();
                }
            }).start();
        }
    }

}