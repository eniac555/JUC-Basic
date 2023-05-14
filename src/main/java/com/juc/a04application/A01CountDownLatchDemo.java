package com.juc.a04application;

import java.util.concurrent.CountDownLatch;

/**
 * @author eniac555
 * @date 2023/5/14
 * @description: CountDownLatch（**闭锁/倒计时锁**）用来进行线程同步协作，
 * 等待所有线程完成倒计时（一个或者多个线程，等待其他多个线程完成某件事情之后才能执行）
 */
public class A01CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        //初始化了一个倒计时锁 参数为 3
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-begin...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //count--
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + "-end..." + latch.getCount());
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-begin...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //count--
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + "-end..." + latch.getCount());
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-begin...");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //count--
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + "-end..." + latch.getCount());
        }).start();

        String name = Thread.currentThread().getName();
        System.out.println(name + "-waiting...");
        //等待其他线程完成
        latch.await();
        System.out.println(name + "-wait end...");
    }

}
